package az.edu.ada.wm2.validationexceptiondemoincomplete.repo;

import az.edu.ada.wm2.validationexceptiondemoincomplete.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserData, Long> {
}
