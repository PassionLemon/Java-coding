package com.example.strategyMode.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author: lyh
 * @Date: 2021/09/02  23:33
 * @Description:HSF 模式的提交
 */
@Slf4j
@Component
public class FormHsfSubmitHandler implements FormSubmitHandler<Serializable> {
    @Override
    public String getSubmitType() { return "hsf"; }

    @Override
    public ResponseEntity handleSubmit(FormSubmitRequest request) {
        log.info("HSF 模式提交：userId={}, formInput={}", request.getUserId(), request.getFormInput());

        // 进行 HSF 泛化调用，获得业务方返回的提示信息和业务数据
        //ResponseEntity response = hsfSubmitData(request);

        return  ResponseEntity.ok("hsf");
    }
}
