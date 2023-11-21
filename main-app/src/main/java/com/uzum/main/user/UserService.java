package com.uzum.main.user;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAllUsers();

    Optional<UserDTO> getUserById(Long userId);

    User createUser(User user);

    void updateUser(Long userId, User userDetails);

    void deleteUser(Long userId);
}
