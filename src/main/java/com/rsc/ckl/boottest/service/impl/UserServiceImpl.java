package com.rsc.ckl.boottest.service.impl;

import com.getui.push.v2.sdk.ApiHelper;
import com.getui.push.v2.sdk.GtApiConfiguration;
import com.getui.push.v2.sdk.api.PushApi;
import com.getui.push.v2.sdk.common.ApiResult;
import com.getui.push.v2.sdk.dto.req.Audience;
import com.getui.push.v2.sdk.dto.req.message.PushDTO;
import com.getui.push.v2.sdk.dto.req.message.PushMessage;
import com.getui.push.v2.sdk.dto.req.message.android.GTNotification;
import com.rsc.ckl.boottest.domain.User;
import com.rsc.ckl.boottest.event.DemoEvent;
import com.rsc.ckl.boottest.event.DemoEvent2;
import com.rsc.ckl.boottest.event.DemoPublisher;
import com.rsc.ckl.boottest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;

/**
 * @author chenkuilin
 * @date 2022/1/18
 * @desc
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    DemoPublisher demoPublisher;

    @Override
    public User findUserById(Integer uid) {
        if (uid == 0){
            return null;
        }
        User build = User.builder().username("ckl").nickname("奎").password("123").build();

        demoPublisher.publish(new DemoEvent2(this,"1",build.getUsername()));

        System.out.println("消息发送成功返回");
        return build;
    }


//    public static void main(String[] args) {
//        List<Pair<String,Object>> pairList = new ArrayList<>(3);
//        pairList.add(new Pair<>("version",1));
//        pairList.add(new Pair<>("version",2));
//        pairList.add(new Pair<>("version",null));
//
//        Map<String, Object> stringMap = pairList.stream().filter(p -> Objects.nonNull(p.getValue())).collect(Collectors.toMap(Pair::getKey, Pair::getValue,(v1, v2) -> v2));
//
//        for (String s : stringMap.keySet()) {
//            System.out.println("1key is :" + s + "value is :" + stringMap.get(s));
//        }
//
//        User u1 = User.builder().username("ckl").nickname("ccc").build();
//        User u2 = User.builder().username("ckl").nickname("ccc").build();
//        User u3 = User.builder().username("ckl").nickname("ccc").build();
//
//
//        List<User> userList = new ArrayList<>();
//        userList.add(u1);
//        userList.add(u2);
//        userList.add(u3);
//
//        Map<String, User> collect = userList.stream().collect(Collectors.toMap(User::getUsername, Function.identity(),(v1,v2) -> v2));
//
//        for (String s : collect.keySet()) {
//            System.out.println("2key is :" + s + "value is :" + collect.get(s));
//        }
//
//    }

    public static void main(String[] args) {

        GtApiConfiguration apiConfiguration = new GtApiConfiguration();
        //填写应用配置
        apiConfiguration.setAppId("qOsmpaH0Jb6m9WuHQOHGe5");
        apiConfiguration.setAppKey("1COOWKhsoc9Je778JpF9L2");
        apiConfiguration.setMasterSecret("QsGeyPwQCJ94TC4CvenKl2");
        // 接口调用前缀，请查看文档: 接口调用规范 -> 接口前缀, 可不填写appId
        apiConfiguration.setDomain("https://restapi.getui.com/v2/");
        // 实例化ApiHelper对象，用于创建接口对象
        ApiHelper apiHelper = ApiHelper.build(apiConfiguration);
        // 创建对象，建议复用。目前有PushApi、StatisticApi、UserApi
        PushApi pushApi = apiHelper.creatApi(PushApi.class);


        pushMsg(getHashString("501220", null),"黄测-发送数据","鸡哥，来打篮球啊",pushApi);

    }

    /**
     * 单点推送（离线不推送）
     *
     * @param cid 目标
     * @param title 标题
     * @param content 内容
     */
    public static void pushMsg(String cid, String title, String content,PushApi myPushApi) {
        //根据cid进行单推
        PushDTO<Audience> pushDTO = new PushDTO<>();
        // 设置推送参数
        pushDTO.setRequestId(System.currentTimeMillis() + "");
        PushMessage pushMessage = new PushMessage();
        pushDTO.setPushMessage(pushMessage);
        /** 带跳转url*/
        GTNotification notification = new GTNotification();
        pushMessage.setNotification(notification);
        notification.setTitle(title + new Date());
        notification.setBody(content);
        notification.setClickType("url");
        notification.setUrl("https://www.baidu.com");// 跳转地址
        /** 不带跳转url*/
//        pushMessage.setTransmission(" {title:\"" + title + "\",content:\"" + content + "\",payload:\"自定义数据\"}");
        pushMessage.setNotification(notification);
        pushDTO.setPushMessage(pushMessage);
        // 设置接收人信息
        Audience audience = new Audience();
        pushDTO.setAudience(audience);
        audience.addAlias(cid);
        // 进行cid单推
        ApiResult<Map<String, Map<String, String>>> apiResult = myPushApi.pushToSingleByAlias(pushDTO);
        if (apiResult.isSuccess()) {
            // success
            System.out.println(apiResult.getData());
        } else {
            // failed
            System.out.println("code:" + apiResult.getCode() + ", msg: " + apiResult.getMsg());
        }
    }

    public static String getHashString(String src, String encoding) {
        if (encoding == null) {
            encoding = "utf-8";
        }

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src.getBytes(encoding));
            return toHex(md.digest());
        } catch (NoSuchAlgorithmException var4) {
            throw new RuntimeException("不能生成MD5摘要", var4);
        } catch (UnsupportedEncodingException var5) {
            throw new RuntimeException(String.format("密码[%s]不能使用[%s]编码", src, encoding), var5);
        }
    }

    private static String toHex(byte[] buffer) {
        StringBuilder sb = new StringBuilder(buffer.length * 2);
        byte[] var2 = buffer;
        int var3 = buffer.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            byte b = var2[var4];
            sb.append(Character.forDigit((b & 240) >> 4, 16));
            sb.append(Character.forDigit(b & 15, 16));
        }

        return sb.toString();
    }

}
