package com.allinpay.bigdata.model;

import com.allinpay.bigdata.util.ParseMD5;
import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.Validate.matchesPattern;

/**
 * Created by mengsen on 2017/8/17.
 *
 * @Description: [一句话描述该类的功能]
 * @UpdateUser: mengsen on 2017/8/17.
 */
public class ApplicantInfo {

    private String companyAccount;//机构账号 《必填》

    private String accessToken;//调用认证接口获取《必填》

    private String name;//姓名《必填》

    private String phone;//查询人手机号码《必填》

    private String idCard;//身份证号码《必填》

    private String md5Phone;//md5加密后的手机号码

    private String md5IdCard;//md5算法处理后的身份证号码




    public String getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMd5Phone() {
        return md5Phone;
    }

    public void setMd5Phone(String md5Phone) {
        this.md5Phone = md5Phone;
    }

    public String getMd5IdCard() {
        return md5IdCard;
    }

    public void setMd5IdCard(String md5IdCard) {
        this.md5IdCard = md5IdCard;
    }
}
