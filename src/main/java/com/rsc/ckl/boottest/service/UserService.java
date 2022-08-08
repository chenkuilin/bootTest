package com.rsc.ckl.boottest.service;

import com.rsc.ckl.boottest.domain.User;

/**
 * @author chenkuilin
 * @date 2022/1/18
 */
public interface UserService {

    User findUserById(Integer uid);
}
