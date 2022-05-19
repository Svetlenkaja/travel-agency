package by.svetlenkaja.travelagency.service.impl;

import by.svetlenkaja.travelagency.model.entity.User;
import by.svetlenkaja.travelagency.model.repository.UserRepository;
import by.svetlenkaja.travelagency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
