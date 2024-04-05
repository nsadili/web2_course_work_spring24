package az.edu.ada.wm2.validationexceptiondemoincomplete.service;


import az.edu.ada.wm2.validationexceptiondemoincomplete.entity.UserData;
import az.edu.ada.wm2.validationexceptiondemoincomplete.exceptions.UserNotFoundException;
import az.edu.ada.wm2.validationexceptiondemoincomplete.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepo userRepo;

    public UserData save(UserData user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepo.save(user);
    }

    public List<UserData> list() {
        return userRepo.findAll();
    }

    public UserData findById(Long id) throws UserNotFoundException {

//        if(id == 1) throw new RuntimeException("Dummy exception");

        return userRepo.findById(id).orElseThrow(
                () -> new UserNotFoundException(String.format("User with id %s not found.", id)));
    }
}
