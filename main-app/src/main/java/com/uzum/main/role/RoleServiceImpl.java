package com.uzum.main.role;

import com.uzum.main.exceptions.NotFoundException;
import com.uzum.main.user.User;
import com.uzum.main.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public RoleServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long roleId) {
        return roleRepository.findById(roleId);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public void updateRole(Long roleId, Role roleDetails) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new NotFoundException("Role with id: " + roleId + " not found"));

        role.setRoleName(roleDetails.getRoleName());

        roleRepository.save(role);
    }

    @Transactional
    public void deleteRole(Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new NotFoundException("Role with id: " + roleId + " not found"));

        List<User> usersWithRole = userRepository.findUsersByRolesContains(role);

        for (User user : usersWithRole) {
            user.getRoles().remove(role);
            userRepository.save(user);
        }

        roleRepository.deleteUserRolesByRoleId(roleId);
        roleRepository.delete(role);
    }
}