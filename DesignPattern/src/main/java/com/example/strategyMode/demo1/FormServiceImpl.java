package com.example.strategyMode.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @Author: lyh
 * @Date: 2021/09/02  23:42
 * @Description:
 */
@Service
public class FormServiceImpl implements FormService{

    @Autowired
    private FormSubmitHandlerFactory submitHandlerFactory;

    @Override
    public ResponseEntity submitForm(@NonNull FormSubmitRequest request) {
        String submitType = request.getSubmitType();

        //根据submitType找到对应的提交处理器
        FormSubmitHandler<Serializable> submitHandler = submitHandlerFactory.getHandler(submitType);

        //判断submitType对应的handler是否存在
        if (submitHandler == null) {
            return ResponseEntity.ok("非法的提交类型：" + submitType);
        }

        //处理提交
        return submitHandler.handleSubmit(request);
    }
}
