package com.rsc.ckl.boottest.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author chenkuilin
 * @date 2022/1/18
 * @desc
 */

@Data
@Builder
public class User {

    private String username;

    private String password;

    private String nickname;

}
