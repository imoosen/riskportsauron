package com.allinpay.bigdata.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by mengsen on 2017/8/17.
 *
 * @Description: [这是一个配置类,接收application.yml中的commonparams下面的属性]
 * @UpdateUser: mengsen on 2017/8/17.
 */

@Component
@ConfigurationProperties(prefix="commonparams") //接收application.yml中的commonparams下面的属性
public class CommonParams {

    //公司账号
    private String companyAccount;
    //公司签名
    private String signature;

    //获取数据令牌access_token接口url
    private String get_access_token_url;

    //根据姓名手机号身份证获取索伦数据接口url
    private  String getdataby_phone_idcard_url;

    //根据姓名以及md5处理后的手机号身份证获取索伦数据接口url
    private String getdataby_md5phone_md5idcard_url;

    public String getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getGet_access_token_url() {
        return get_access_token_url;
    }

    public void setGet_access_token_url(String get_access_token_url) {
        this.get_access_token_url = get_access_token_url;
    }

    public String getGetdataby_phone_idcard_url() {
        return getdataby_phone_idcard_url;
    }

    public void setGetdataby_phone_idcard_url(String getdataby_phone_idcard_url) {
        this.getdataby_phone_idcard_url = getdataby_phone_idcard_url;
    }

    public String getGetdataby_md5phone_md5idcard_url() {
        return getdataby_md5phone_md5idcard_url;
    }

    public void setGetdataby_md5phone_md5idcard_url(String getdataby_md5phone_md5idcard_url) {
        this.getdataby_md5phone_md5idcard_url = getdataby_md5phone_md5idcard_url;
    }
}
