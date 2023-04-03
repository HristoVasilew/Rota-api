#!/usr/bin/env groovy
@Library('pliant')
import io.pliant.jenkins.*
def dep = new deployment()

def mvn_version = 'Maven 3.5.2'
def api_jdk = 'openjdk-8'

def dockerhub_user = "pliantinternship2022"
def app_name = "rota-api"

try {
	node {

		stage("Clone repository") {
			dep.clone(app_name, false, "master")
			dep.setDockerRepository(dockerhub_user)
		}
		if (dep.isCancelled()) return

		stage ("Compile") {
			withEnv( ["PATH+MAVEN=${tool mvn_version}/bin", "JAVA_HOME=${tool name: api_jdk}"] ) {
				sh "mvn -Djava.net.preferIPv4Stack=true clean package"
			}
		}
		
		stage("Build image") {
			dep.build()
		}

		stage("Push image") {
			def imageName = "${dockerhub_user}/${app_name}-${dep.getBranch()}:${dep.getTag()}"

			docker.withRegistry("", "${dockerhub_user}") {
				dep.pushImage(imageName)

				if ( dep.getBranch() != "feature" ) {
					imageName = "${dockerhub_user}/${app_name}-${dep.getBranch()}:v${dep.getVersion()}"
					dep.pushImage(imageName)
				}
			}
			dep.setImageMessage(imageName.split('/')[1])
		}
	}
} catch (error) {
	dep.handle(error)
} finally {
	dep.notifyBuild(currentBuild.result)
}
