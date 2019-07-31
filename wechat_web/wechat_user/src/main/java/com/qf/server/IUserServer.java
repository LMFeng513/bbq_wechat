package com.qf.server;

  /*
    @author: LMFeng
    @date: 2019-07-31 11:05
    @desc:
  */

import com.qf.User;

public interface IUserServer {

    int registerUser(User user);

    User queryByUsername(String username);

    int updateHeader(String header,String headerCrm, Integer uid);

}
