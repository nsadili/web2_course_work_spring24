package az.edu.ada.wm2.validationexceptiondemoincomplete.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @Size(min = 5, max = 20, message = "Username must be of length [5-20]")
    private String username;

    @NotBlank
    @Email(regexp = "^(.+)@(.+)\\.(.+)$", message = "Email should follow a standard abc@def.xyz")
    private String email;

    private String mobile;

    @CreditCardNumber
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])(/)([2-9][0-9])$", message = "Expiration date should be MM/YY")
    private String ccExpiration;

    @NotBlank
    @Digits(integer = 3, fraction = 0, message = "CVV number must be 3 digit long")
    private String ccCVV;

    private LocalDateTime createdAt;
}
