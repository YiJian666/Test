package com.huatec.controller;

import com.huatec.domain.Role;
import com.huatec.domain.User;
import com.huatec.service.RoleService;
import com.huatec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
//用户列表
    @RequestMapping("/userList")
    public ModelAndView userList(ModelAndView modelAndView){
        System.out.println(userService);
        List<User> userList = userService.userList();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
//    跳转用户新增界面
    @RequestMapping("/saveUI")
    public ModelAndView saveUI(ModelAndView modelAndView){
        List<Role> roleList = roleService.roleList();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }
    //新增用户
    @RequestMapping("/saveUser")
    public String saveUser(User user,Long[] roleId){
        userService.saveUser(user,roleId);
        return "redirect:/user/userList";
    }
    //用户登录
    @RequestMapping("/login")
    public String login(String username,String password, HttpSession session){
        User user = userService.login(username,password);
        System.out.println(user);
        if(user!=null){
            session.setAttribute("user",user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";

    }

}
