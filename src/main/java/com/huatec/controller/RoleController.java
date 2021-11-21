package com.huatec.controller;

import com.huatec.domain.Role;
import com.huatec.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;//
    @RequestMapping("/roleList")
    public ModelAndView showList(ModelAndView modelAndView){
       List<Role> roleList = roleService.roleList();
       modelAndView.addObject("roleList",roleList);
       modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/saveRole")
    public String saveRole(Role role){
       roleService.saveRole(role);
        return "redirect:/role/roleList";
    }
}
