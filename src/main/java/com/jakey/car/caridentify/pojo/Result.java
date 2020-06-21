package com.jakey.car.caridentify.pojo;

/**
 * Created by Jakey on 2020/6/18.
 * desc:
 */
public class Result {

    private boolean success;
    private String resultString;
    private String imgUrl;

    public Result(boolean success, String resultString, String imgUrl) {
        this.success = success;
        this.resultString = resultString;
        this.imgUrl = imgUrl;
    }



    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }





    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResultString() {
        return resultString;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }
}