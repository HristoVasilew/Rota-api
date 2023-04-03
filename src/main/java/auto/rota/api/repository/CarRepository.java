package auto.rota.api.repository;


import auto.rota.api.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    boolean existsByRegistrationNumber(String registrationNumber);

    Car findByRegistrationNumber(String registrationNumber);
}