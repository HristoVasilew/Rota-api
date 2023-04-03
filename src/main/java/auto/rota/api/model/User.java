package auto.rota.api.model;

import auto.rota.api.validation.anotation.ValidEmail;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static auto.rota.api.constant.GlobalConstants.ONE_MEGABYTE;


@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @NotNull
    @Size(min = 2, max = 256)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @ValidEmail
    @Size(min = 6, max = 100)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull
    @Size(min = 8, max = 60)
    @Column(name = "password", nullable = false)
    private String password;

    @Size(min = 8, max = 10)
    @Column(name = "driver_licence_media_type")
    private String driverLicenceMediaType;

    @Size(max = ONE_MEGABYTE)
    @Column(name = "driver_licence_image")
    private byte[] driverLicenceImage;

    @NotNull
    @Column(name = "is_admin")
    private Boolean isAdmin;
}
