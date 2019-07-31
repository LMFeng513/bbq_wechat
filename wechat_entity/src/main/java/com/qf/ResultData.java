package com.qf;

  /*
    @author: LMFeng
    @date: 2019-07-31 11:41
    @desc:
  */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData<T> {

    private Integer code;

    private String msg;

    private T data;


    //返回一个成功的ResultData对象
    public static <S> ResultData<S> cresteSuccResult(S data){
        ResultData<S>resultData =new ResultData<>();
        resultData.setCode(ResultCode.RESULT_SUCC);
        resultData.setMsg("success!");
        resultData.setData(data);
        return resultData;

    }

    //返回一个失败的ResuletData 对象
    public static <S> ResultData<S> createFaileResult(Integer code,String msg,S data){
        ResultData<S>resultData=new ResultData<>();
        resultData.setCode(code);
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

}
