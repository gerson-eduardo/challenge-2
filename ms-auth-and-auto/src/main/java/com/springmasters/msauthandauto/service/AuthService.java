package com.springmasters.msauthandauto.service;

import org.springframework.stereotype.Service;
import com.springmasters.msauthandauto.model.User;
import com.springmasters.msauthandauto.model.Role;
import com.springmasters.msauthandauto.model.Microservice;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class AuthService {
    private Map<String, User> usersDatabase = new HashMap<>();
    private Map<String, Role> rolesDatabase = new HashMap<>();

    public AuthService () {
        User user1 = new User(1, "nome de usuario","usuario1@example.com", "senha123");
        User user2 = new User(2, "nome de usuario", "usuario2@example.com", "senha456");

        Role.userRole adminUserRole = Role.userRole.ADMIN;
        Role.userRole userUserRole = Role.userRole.USER;

        Microservice microservice1 = new Microservice(1, "NomeDoMicroservice1");
        Microservice microservice2 = new Microservice(2, "NomeDoMicroservice2");

        Role adminRole = new Role(1, user1, microservice1, adminUserRole);
        Role userRole = new Role (2, user2, microservice2, userUserRole);

        usersDatabase.put("usuario1@example.com", user1);
        usersDatabase.put("usuario2@example.com",user2);

        rolesDatabase.put("Admin", adminRole);
        rolesDatabase.put("User", userRole);
    }

    public boolean authenticateUser(String email, String password){
        if (!usersDatabase.containsKey(email)) {
            return false;
        }

        User user = usersDatabase.get(email);
        return user.getPassword().equals(password);
    }

    public boolean authorizeUserByRole(String email, String role) {
        if (!usersDatabase.containsKey(email)) {
            return false;
        }

        User user = usersDatabase.get(email);
        if (!rolesDatabase.containsKey(role)) {
            return false;
        }

        Role requiredRole = rolesDatabase.get(role);


        List<Role> userRoles = user.getUserRoles();
        return userRoles.contains(requiredRole);
    }
}
