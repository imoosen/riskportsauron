package com.allinpay.bigdata.model;

import com.google.common.base.MoreObjects;

import java.util.Map;

/**
 * Created by mengsen on 2017/8/17.
 *
 * @Description: [接口返回对象]
 * @UpdateUser: mengsen on 2017/8/17.
 */
public class Response {

    /**
     * {
     "code": 0,
     "code_description": "SUCCESS",
     "data": {
     "access_token": "96483b64575c4fc48431636e6deb750f",
     "account": "cevi",
     "expire_in": 1469292118057
     },
     "message": "请求成功"
     }
     */
    private Map data;
    private Integer code;
    private String message;
    private String codeDescription;


    public Response(Integer code, String message, String codeDescription) {
        this.code = code;
        this.message = message;
        this.codeDescription = codeDescription;
    }

    public Response() {
    }

    //4352	公司帐号不存在异常 	请检查companyAccount的值是否正确
    public static final Response COMPANY_ACCOUNT_NOT_EXISTED_RESPONSE = new Response(4352, "公司帐号不存在..", "COMPANY_ACCOUNT_NOT_EXISTED");

    //4353	公司帐号已锁定异常	公司帐号可能由于破坏性调用接口或欠费被锁定，请联系销售
    public static final Response COMPANY_ACCOUNT_LOCKED_RESPONSE = new Response(4353, " 公司帐号已锁定", "COMPANY_ACCOUNT_LOCKED");

    //4355	公司签名错误异常	申请公司帐号时提供的密钥,获取原始数据和报告数据令牌时必填参数,如有泄漏或遗失请联系更换
    public static final Response COMPANY_SIGNATURE_INVALID_RESPONSE = new Response(4355, "公司签名错误", "COMPANY_SIGNATURE_INVALID");

    //4357	获取机构访问数据令牌异常	申请公司帐号时提供的密钥,获取原始数据和报告数据令牌时必填参数,如有泄漏或遗失请联系更换
    public static final Response COMPANY_ACCESS_TOKEN_EXCEPTION_RESPONSE = new Response(4357, "获取机构访问数据令牌异常", "COMPANY_ACCESS_TOKEN_EXCEPTION");

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

    public String getCodeDescription() {
        return codeDescription;
    }

    public void setCodeDescription(String codeDescription) {
        this.codeDescription = codeDescription;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("data", data)
                .add("code", code)
                .add("message", message)
                .add("codeDescription", codeDescription)
                .toString();
    }
}
