package com.uzum.main.user;

import com.uzum.main.role.RoleDTO;

import java.util.List;

public record UserDTO(
        Long userId,
        String firstName,
        String surname,
        String email,
        Status status,
        String username,
        List<RoleDTO> roles
) {
}
