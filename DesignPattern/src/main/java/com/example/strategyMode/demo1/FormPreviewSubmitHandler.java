package com.example.strategyMode.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author: lyh
 * @Date: 2021/09/02  23:23
 * @Description:预览表单时的提交
 */
@Slf4j
@Component
public class FormPreviewSubmitHandler implements FormSubmitHandler<Serializable> {
    @Override
    public String getSubmitType() {
        return "preview";
    }

    @Override
    public ResponseEntity handleSubmit(FormSubmitRequest request) {
        log.info("预览模式提交: userId={}, formInput={}", request.getUserId(), request.getFormInput());
        return ResponseEntity.ok("预览模式提交数据成功!");
    }
}
