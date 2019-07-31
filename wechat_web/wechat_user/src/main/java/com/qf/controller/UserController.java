package com.qf.controller;

  /*
    @author: LMFeng
    @date: 2019-07-30 19:30
    @desc:
  */

import com.qf.ResultCode;
import com.qf.ResultData;
import com.qf.User;
import com.qf.server.IUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserServer userServer;

    @RequestMapping("/register")
    public ResultData<String> register(User user){

        int result =userServer.registerUser(user);

        ResultData<String>resultData=null;

        if (result > 0){
            //成功
            resultData = ResultData.cresteSuccResult(null);

        }else if (result ==-1){
            resultData =ResultData.createFaileResult(ResultCode.USERNAME_ISEXTRA,"用户名已经存在",null);
        }else {
            //其他错误
            resultData =ResultData.createFaileResult(ResultCode.SERVER_EXCEPTION,"服务端异常！",null);
        }

        return resultData;
    }




    @RequestMapping("/login")
    public ResultData<User>login(String usernam,String password){

        //根据用户查询用户信息
        User user =userServer.queryByUsername(usernam);

        if (user==null){
            return ResultData.createFaileResult(ResultCode.USERNAME_ERROR,"用户不存在",null);
        }else if(!user.getPassword().equals(password)){
            return ResultData.createFaileResult(ResultCode.PASSWORD_ERROR,"密码错误",null);
        }
        user.setPassword(null);
        return ResultData.cresteSuccResult(user);
    }

}
