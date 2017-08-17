package com.allinpay.bigdata.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengsen on 2017/8/17.
 *
 * @Description: [一句话描述该类的功能]
 * @UpdateUser: mengsen on 2017/8/17.
 */
public class SauRonClient {

    public static final String charset = "utf-8";
    public static Map<String, String> headerMap = new HashMap<>();
    public static void putHeader(){
        headerMap.put("Accept", "*/*");
        headerMap.put("Accept-Encoding", "gzip, deflate");
        headerMap.put("Accept-Language", "zh-CN,zh;q=0.8");
        headerMap.put("Connection", "keep-alive");
        headerMap.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headerMap.put("Host", "qy.rencailu.com");
        headerMap.put("Origin", "http://qy.rencailu.com");
        headerMap.put("Referer", "http://qy.rencailu.com/");
        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36");
        headerMap.put("X-Requested-With", "XMLHttpRequest");
    }

    /**
     * 获取数据令牌access_token
     * @param get_access_token_url
     * @return
     */
    public static String getAccessToken(String get_access_token_url){

       return HttpClientUtil.doGet(get_access_token_url,charset);

    }

    /**
     * 根据姓名手机号身份证获取索伦数据
     * 根据姓名以及md5处理后的手机号身份证获取索伦数据
     * @param getdataby_phone_idcard_url
     * @param param
     * @return
     */
    public static String getDataByPhoneAndIdcard(String getdataby_phone_idcard_url,Map<String ,Object> param){

        return HttpClientUtil.doGet(getdataby_phone_idcard_url,param,charset,headerMap,null);
    }




}
