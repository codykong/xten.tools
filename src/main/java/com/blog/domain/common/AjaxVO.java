package com.blog.domain.common;

import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-10-23
 * Time: 上午11:13
 * To change this template use File | Settings | File Templates.
 */
public class AjaxVO<T> {

    private final static int SUCCESS_CODE=0;
    private final static int FAIL_CODE=-1;
    /**
     * ajax返回的业务对象
     */
    private T content;
    /**
     * ajax业务码,默认0：成功，-1：失败，其他值为特殊业务代码
     */
    private int code=SUCCESS_CODE;
    /**
     * 具体内容
     */
    private String message;

    /**
     * 返回业务成功对象
     * @param content
     * @return
     */
    public static AjaxVO success(Object content){
        AjaxVO vo=new AjaxVO();
        vo.setCode(SUCCESS_CODE);
        vo.setContent(content);
        return vo;
    }

    public static AjaxVO fail(String message){
        AjaxVO vo=new AjaxVO();
        vo.setCode(FAIL_CODE);
        vo.setMessage(message);
        return vo;
    }

    public static AjaxVO setCode(int code,String message){
        AjaxVO vo=new AjaxVO();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
