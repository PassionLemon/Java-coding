package com.example.strategyMode.demo1;
import lombok.Data;

import java.util.Map;

/**
 * @Author: lyh
 * @Date: 2021/09/02  23:16
 * @Description: 表单提交的请求
 */
@Data
public class FormSubmitRequest {

    /**
     * 提交类型
     */
    private String submitType;

    /**
     * 用户 id
     */
    private Long userId;

    /**
     * 表单提交的值
     */
    private Map<String, Object> formInput;
}
