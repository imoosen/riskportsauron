package com.allinpay.bigdata.service;

import com.allinpay.bigdata.model.ApplicantInfo;
import com.allinpay.bigdata.model.Response;
import com.allinpay.bigdata.util.CommonParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by mengsen on 2017/8/17.
 *
 * @Description: [一句话描述该类的功能]
 * @UpdateUser: mengsen on 2017/8/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicantInfoServiceTest {
    @Autowired
    private ApplicantInfoService applicantInfoService;
    @Autowired
    private CommonParams commonParams;


    @Test
    public void getDataByPhoneAndIdcard() throws Exception {
        Response rs = applicantInfoService.getAccessToken();
        Map<String,String> data = rs.getData();
        String accessToken = data.get("access_token");
        ApplicantInfo applicantInfo = new ApplicantInfo();
        applicantInfo.setCompanyAccount(commonParams.getCompanyAccount());
        applicantInfo.setAccessToken(accessToken);
        applicantInfo.setName("施佳涣");
        applicantInfo.setIdCard("330106198105254012");
        applicantInfo.setPhone("13989464516");

        Response result = applicantInfoService.getDataByPhoneAndIdcard(applicantInfo);

        System.out.println(result);

        Response md5Result = applicantInfoService.getDataBymd5PhoneAndmd5Idcard(applicantInfo);

        System.out.println(md5Result);
    }


    @Test
    public void testMap() throws Exception {
        Response rs = applicantInfoService.getAccessToken();
        Map<String,String> data = rs.getData();
        String accessToken = data.get("access_token");
        Map<String,Object> param = new HashMap<>();
        param.put("accessToken",accessToken);
        param.put("companyAccount",commonParams.getCompanyAccount());
        param.put("name","施佳涣");
        param.put("phone","13989464516");
        param.put("idCard","330106198105254012");

        Response result = applicantInfoService.getDataByPhoneAndIdcard(param);

        System.out.println(result);

        Response md5Result = applicantInfoService.getDataBymd5PhoneAndmd5Idcard(param);

        System.out.println(md5Result);
    }




}