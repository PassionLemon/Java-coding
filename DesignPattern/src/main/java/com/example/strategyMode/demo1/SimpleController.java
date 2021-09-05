package com.example.strategyMode.demo1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @Author: lyh
 * @Date: 2021/09/02  23:47
 * @Description:
 */
@RestController
public class SimpleController {

    @Autowired
    private FormService formService;

    @PostMapping("/form/submit")
    public ResponseEntity submitForm(@RequestParam String submitType,
                                                           @RequestParam String formInputJson){
        JSONObject formInput = JSON.parseObject(formInputJson);
        FormSubmitRequest request = new FormSubmitRequest();
        request.setUserId(123456L);
        request.setSubmitType(submitType);
        request.setFormInput(formInput);

        return formService.submitForm(request);
    }
}
