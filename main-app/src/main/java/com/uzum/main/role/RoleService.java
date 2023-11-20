package com.uzum.main.role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> getAllRoles();

    Optional<Role> getRoleById(Long roleId);

    Role createRole(Role role);

    void updateRole(Long roleId, Role roleDetails);

    void deleteRole(Long roleId);
}
