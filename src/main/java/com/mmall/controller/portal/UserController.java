 /*
  * Copyright (C), 2015-2018
  * FileName: UserController
  * Author:   Administrator
  * Date:     2018/3/8 0008 16:30
  * Description: 用户管理控制
  */

 package com.mmall.controller.portal;

 import com.mmall.common.Const;
 import com.mmall.common.ServerResponse;
 import com.mmall.pojo.User;
 import com.mmall.service.IUserService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.bind.annotation.ResponseBody;

 import javax.servlet.http.HttpSession;

 /**
  * 〈一句话功能简述〉<br>
  * 〈用户管理控制〉
  *
  * @author Administrator
  * @create 2018/3/8 0008
  * @since 1.0.0
  */
 @Controller
 @RequestMapping("/user/")
 public class UserController {

     @Autowired
     private IUserService iUserService;

     /**
      * 用户登陆
      *
      * @param username  username
      * @param password password
      * @param session  session
      * @return ServerResponse<User>
      */
     @RequestMapping(value = "login.do", method = RequestMethod.POST)
     @ResponseBody // 自动将返回的值序列化成json对象
     public ServerResponse<User> login(String username, String password, HttpSession session) {
        // service-mybatis-dao
         ServerResponse<User> response = iUserService.login(username, password);
         if (response.isSuccess()) {
             session.setAttribute(Const.CURRENT_USER, response.getData());
         }
         return response;
         // service
     }

     @RequestMapping(value = "logout.do",method = RequestMethod.POST)
     @ResponseBody
     public ServerResponse<String> logout(HttpSession session){
         session.removeAttribute(Const.CURRENT_USER);
         return ServerResponse.createBySuccess();
     }

     @RequestMapping(value = "register.do",method = RequestMethod.POST)
     @ResponseBody
     public ServerResponse<String> register(User user) {
         return iUserService.register(user);
     }

     public ServerResponse<String> checkValid(String str, String type) {
         return null;
     }
 }
