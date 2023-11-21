package com.uzum.main.user;

import com.uzum.main.role.RoleDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getFirstName(),
                user.getSurname(),
                user.getEmail(),
                user.getStatus(),
                user.getUsername(),
                user.getRoles().stream()
                        .map(role -> new RoleDTO(role.getRoleId(), role.getRoleName()))
                        .collect(Collectors.toList()));
    }
}
