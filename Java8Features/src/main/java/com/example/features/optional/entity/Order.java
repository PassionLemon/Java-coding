package com.example.features.optional.entity;

import lombok.Data;

/**
 * @Author: lyh
 * @Date: 2021/05/12  11:51
 * @Description:
 */
@Data
public class Order {
    private String id;
    private String ConsumerId;
    private String age;
    private Product product;
}
