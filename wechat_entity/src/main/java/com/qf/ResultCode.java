package com.qf;

  /*
    @author: LMFeng
    @date: 2019-07-31 11:41
    @desc:
  */

public interface ResultCode {
    Integer RESULT_SUCC =1000;
    Integer SERVER_EXCEPTION =1100;//服务器异常
    Integer USERNAME_ISEXTRA =2001;//用户名已经存在
    Integer USERNAME_ERROR=2002;//用户名错误
    Integer PASSWORD_ERROR =2003;//密码错误


}
