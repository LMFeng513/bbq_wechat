package com.qf.server.impl;

  /*
    @author: LMFeng
    @date: 2019-07-31 11:06
    @desc:
  */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.User;
import com.qf.dao.UserMapper;
import com.qf.server.IUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServerImpl implements IUserServer {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int registerUser(User user) {
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("username",user.getUsername());
        Integer count = userMapper.selectCount(queryWrapper);

       if (count>0){
           //用户名存在
           return -1;
       }

       int result =userMapper.insert(user);



        return result;
    }

    @Override
    public User queryByUsername(String username) {
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("username",username);

        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public int updateHeader(String header, String headerCrm, Integer uid) {
        User user = userMapper.selectById(uid);
        if (user!=null){
            user.setHeader(header);
            user.setHeaderCrm(headerCrm);
            return userMapper.updateById(user);


        }


        return 0;
    }
}
