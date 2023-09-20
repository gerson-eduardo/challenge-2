package com.springmasters.msauthandauto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmasters.msauthandauto.DTO.RoleDTO;
import com.springmasters.msauthandauto.model.Role.userRole;
import com.springmasters.msauthandauto.service.RoleService;

@RestController
@RequestMapping(value = "api/roles/")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping("/{id_user}/microsservice/{id_microsservice}")
    public ResponseEntity<RoleDTO>getRoleByUserAndMicrosservice(@PathVariable Integer id_user,@PathVariable Integer id_microsservice){
        return roleService.findByUserAndMicrosservice(id_user, id_microsservice);
    }
}
