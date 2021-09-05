package com.example.strategyMode.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author: lyh
 * @Date: 2021/09/05  23:39
 * @Description:
 */
@Slf4j
@Component
public class FormFaasSubmitHandler implements FormSubmitHandler<Serializable> {
    @Override
    public String getSubmitType() {
        return "fass";
    }

    @Override
    public ResponseEntity handleSubmit(FormSubmitRequest request) {
        log.info("FaaS 模式的提交：userId={}, formInput={}", request.getUserId(), request.getFormInput());
        // 进行 FaaS 函数调用，并获得业务方返回的提示信息和业务数据
        //CommonPairResponse<String, Serializable> response = faasSubmitData(request);

        return  ResponseEntity.ok("fass");
    }
}
