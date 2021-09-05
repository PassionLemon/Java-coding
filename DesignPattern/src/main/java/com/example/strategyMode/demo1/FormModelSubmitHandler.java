package com.example.strategyMode.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @Author: lyh
 * @Date: 2021/09/02  23:30
 * @Description:模型输入时的提交
 */
@Slf4j
@Component
public class FormModelSubmitHandler implements FormSubmitHandler<Long> {
    @Override
    public String getSubmitType() {
        return "model";
    }

    @Override
    public ResponseEntity handleSubmit(FormSubmitRequest request) {
        log.info("模型提交: userId={}, formInput={}", request.getUserId(), request.getFormInput());
        //模型创建成功后获得模型的id
        Long modelId = createModel(request);
        return ResponseEntity.ok("模型提交成功!");
    }

    private Long createModel(FormSubmitRequest request) {
        // 创建模型的逻辑
        return 123L;
    }
}
