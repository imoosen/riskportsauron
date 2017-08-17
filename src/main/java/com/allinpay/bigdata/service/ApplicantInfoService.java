package com.allinpay.bigdata.service;

import com.allinpay.bigdata.model.ApplicantInfo;
import com.allinpay.bigdata.model.Response;
import com.allinpay.bigdata.util.CheckUtils;
import com.allinpay.bigdata.util.CommonParams;
import com.allinpay.bigdata.util.ParseMD5;
import com.allinpay.bigdata.util.SauRonClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengsen on 2017/8/17.
 *
 * @Description: [一句话描述该类的功能]
 * @UpdateUser: mengsen on 2017/8/17.
 */
@Slf4j
@Service
public class ApplicantInfoService {

    @Autowired
    private CommonParams commonParams;

    @Resource
    ObjectMapper objectMapper;

    /**
     * 获取数据令牌access_token
     * @return
     */
    public Response getAccessToken(){
        String httpResult = SauRonClient.getAccessToken(commonParams.getGet_access_token_url());
        try {
            return objectMapper.readValue(httpResult, Response.class);
        } catch (IOException e) {
            throw new RuntimeException(MessageFormat.format("获取数据令牌access_token接口失败,httpResult:{0},applicantInfo:{1}", httpResult, null), e);
        }
    }

    /**
     * 根据姓名手机号身份证获取索伦数据
     * @param applicantInfo
     * @return
     */
    public Response getDataByPhoneAndIdcard(ApplicantInfo applicantInfo){
        Map<String,Object> param = new HashMap<>();
        String companyAccount = applicantInfo.getCompanyAccount();
        param.put("companyAccount",companyAccount);
        String accessToken =applicantInfo.getAccessToken();
        param.put("accessToken",accessToken);
        String name =applicantInfo.getName();
        CheckUtils.checkName(name);
        param.put("name",name);
        String phone = applicantInfo.getPhone();
        CheckUtils.checkPhone(phone);
        param.put("phone",phone);
        String idCard = applicantInfo.getIdCard();
        CheckUtils.checkIccard(idCard);
        param.put("idCard",idCard);
        String httpResult =SauRonClient.getDataByPhoneAndIdcard(commonParams.getGetdataby_phone_idcard_url(),param);
        try {
            return objectMapper.readValue(httpResult, Response.class);
        } catch (IOException e) {
            throw new RuntimeException(MessageFormat.format("根据姓名手机号身份证获取索伦数据失败,httpResult:{0},applicantInfo:{1}", httpResult, applicantInfo), e);
        }
    }

    /**
     * 根据姓名以及md5处理后的手机号身份证获取索伦数据
     * @param applicantInfo
     * @return
     */
    public Response getDataBymd5PhoneAndmd5Idcard(ApplicantInfo applicantInfo){
        Map<String,Object> param = new HashMap<>();
        String companyAccount = applicantInfo.getCompanyAccount();
        param.put("companyAccount",companyAccount);
        String accessToken =applicantInfo.getAccessToken();
        param.put("accessToken",accessToken);
        String name =applicantInfo.getName();
        CheckUtils.checkName(name);
        param.put("name",name);
        String phone = applicantInfo.getPhone();
        CheckUtils.checkPhone(phone);
        param.put("md5Phone", ParseMD5.parseStrToMd5L32(phone));
        String idCard = applicantInfo.getIdCard();
        CheckUtils.checkIccard(idCard);
        param.put("md5IdCard",ParseMD5.parseStrToMd5L32(idCard));
        String httpResult =SauRonClient.getDataByPhoneAndIdcard(commonParams.getGetdataby_md5phone_md5idcard_url(),param);
        try {
            return objectMapper.readValue(httpResult, Response.class);
        } catch (IOException e) {
            throw new RuntimeException(MessageFormat.format("根据姓名手机号身份证获取索伦数据失败,httpResult:{0},applicantInfo:{1}", httpResult, applicantInfo), e);
        }
    }

    /**
     * 根据姓名以及md5处理后的手机号身份证获取索伦数据 K-V形式
     * @param param
     * @return
     */
    public Response getDataBymd5PhoneAndmd5Idcard(Map<String,Object> param){

        String companyAccount = (String) param.get("companyAccount");

        String accessToken =(String) param.get("accessToken");

        if(Strings.isNullOrEmpty(companyAccount)||Strings.isNullOrEmpty(accessToken)){
            return null;
        }
        String name =(String) param.get("name");
        CheckUtils.checkName(name);

        String phone = (String) param.get("phone");
        CheckUtils.checkPhone(phone);
        param.put("md5Phone", ParseMD5.parseStrToMd5L32(phone));
        String idCard = (String) param.get("idCard");
        CheckUtils.checkIccard(idCard);
        param.put("md5IdCard",ParseMD5.parseStrToMd5L32(idCard));
        String httpResult =SauRonClient.getDataByPhoneAndIdcard(commonParams.getGetdataby_md5phone_md5idcard_url(),param);
        try {
            return objectMapper.readValue(httpResult, Response.class);
        } catch (IOException e) {
            throw new RuntimeException(MessageFormat.format("根据姓名手机号身份证获取索伦数据失败,httpResult:{0},applicantInfo:{1}", httpResult, null), e);
        }

    }

    /**
     * 根据姓名手机号身份证获取索伦数据 K-V形式
     * @param param
     * @return
     */
    public Response getDataByPhoneAndIdcard(Map<String,Object> param){
        String companyAccount = (String) param.get("companyAccount");

        String accessToken =(String) param.get("accessToken");

        if(Strings.isNullOrEmpty(companyAccount)||Strings.isNullOrEmpty(accessToken)){
            return null;
        }
        String name =(String) param.get("name");
        CheckUtils.checkName(name);

        String phone = (String) param.get("phone");
        CheckUtils.checkPhone(phone);

        String idCard = (String) param.get("idCard");
        CheckUtils.checkIccard(idCard);

        String httpResult =SauRonClient.getDataByPhoneAndIdcard(commonParams.getGetdataby_phone_idcard_url(),param);
        try {
            return objectMapper.readValue(httpResult, Response.class);
        } catch (IOException e) {
            throw new RuntimeException(MessageFormat.format("根据姓名手机号身份证获取索伦数据失败,httpResult:{0},applicantInfo:{1}", httpResult, null), e);
        }
    }

}
