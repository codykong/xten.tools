package com.blog.common.utils;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-9-29
 * Time: 上午10:40
 * To change this template use File | Settings | File Templates.
 */
public class ResultUtil<T> {

    private T result;//成功消息
    private int code;
    private String message;

    public ResultUtil(){
        super();
    }

    public ResultUtil(T result) {
        this.result = result;
    }

    public ResultUtil(Exception e) {
        setMessage(e.getMessage());
    }

    public ResultUtil(int errorCode,String message){
        this.code=errorCode;
        this.message=message;

    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public void setException(Exception e){
        setMessage("内部异常："+e.getMessage());
    }
}
