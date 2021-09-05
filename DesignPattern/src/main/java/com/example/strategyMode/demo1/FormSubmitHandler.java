package com.example.strategyMode.demo1;

import org.springframework.http.ResponseEntity;

import java.io.Serializable;

/**
 * @Author: lyh
 * @Date: 2021/09/02  23:13
 * @Description: 表单提交处理器
 */
public interface FormSubmitHandler <R extends Serializable> {
    /**
     * 获得提交类型（返回值也可以使用已经存在的枚举类）
     *
     * @return 提交类型
     */
    String getSubmitType();

    /**
     * 处理表单提交请求
     *
     * @param request 请求
     * @return 响应，left 为返回给前端的提示信息，right 为业务值
     */
    ResponseEntity handleSubmit(FormSubmitRequest request);
}
