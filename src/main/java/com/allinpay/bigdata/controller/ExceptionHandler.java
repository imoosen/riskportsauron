package com.allinpay.bigdata.controller;

import com.allinpay.bigdata.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mengsen on 2017/8/17.
 *
 * @Description: [一句话描述该类的功能]
 * @UpdateUser: mengsen on 2017/8/17.
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {RuntimeException.class, NullPointerException.class, IllegalArgumentException.class})
    @ResponseBody
    public Response applicantException(Exception e) {
        log.error(e.getMessage(), e);
        return Response.COMPANY_ACCESS_TOKEN_EXCEPTION_RESPONSE;
    }
}
