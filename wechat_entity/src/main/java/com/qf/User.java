package com.qf;

  /*
    @author: LMFeng
    @date: 2019-07-30 19:13
    @desc:
  */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String header;
    private String headerCrm;
    private String card;
    private Date createtime;

}
