package com.example.strategyMode.demo1;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;

import java.io.Serializable;

/**
 * @Author: lyh
 * @Date: 2021/09/02  23:47
 * @Description:
 */
public interface FormService {
    ResponseEntity submitForm(FormSubmitRequest request);
}
