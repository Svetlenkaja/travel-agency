package by.svetlenkaja.travelagency.service.impl;

import by.svetlenkaja.travelagency.exception.UserServiceException;
import by.svetlenkaja.travelagency.model.entity.User;
import by.svetlenkaja.travelagency.model.repository.UserRepository;
import by.svetlenkaja.travelagency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(TourServiceImpl.class);

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        if (user.getUsername().equals("")|| user.getSurname().equals("") || user.getPassword().equals("")) {
            throw new UserServiceException("errorEmpty");
        }
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());
        if (!userOptional.isEmpty()) {
            throw new UserServiceException("errorDuplicate");
        }

        if (!user.getPassword().equals(user.getPasswordConfirm())){
            throw new UserServiceException("errorConfirmPassword");
        }

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        try {
            return userRepository.save(user);
        } catch (RuntimeException e){
            LOGGER.error("Error save user with data: {}", user.toString());
            throw new UserServiceException("userNotSaved");

        }
    }

    @Override
    public void lockedUser(long idUser) {
        User user = userRepository.getById(idUser);
        user.setAccountNonLocked(false);
        userRepository.saveAndFlush(user);
    }

}
