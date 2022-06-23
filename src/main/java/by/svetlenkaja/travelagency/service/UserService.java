package by.svetlenkaja.travelagency.service;

import by.svetlenkaja.travelagency.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User addUser(User user);
    void lockedUser(long idUser);
}
