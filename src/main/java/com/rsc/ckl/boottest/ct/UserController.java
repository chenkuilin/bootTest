package com.rsc.ckl.boottest.ct;

import com.rsc.ckl.boottest.domain.User;
import com.rsc.ckl.boottest.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenkuilin
 * @date 2022/1/18
 * @desc
 */

@RestController
@RequestMapping("/rsc/user")
public class UserController  {

    @Resource
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }

}
