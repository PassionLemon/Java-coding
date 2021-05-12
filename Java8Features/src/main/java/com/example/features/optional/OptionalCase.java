package com.example.features.optional;

import com.example.features.optional.entity.Consumer;
import com.example.features.optional.entity.Order;
import com.example.features.optional.entity.Product;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

/**
 * @Author: lyh
 * @Date: 2021/05/12  11:54
 * @Description: 使用Optional的小案例
 */
public class OptionalCase {
    @Test
    public void test1() {
        String consumerId = UUID.randomUUID().toString();
        String orderId = UUID.randomUUID().toString();
        String productId = UUID.randomUUID().toString();

        Product product = new Product();
        product.setId(productId);
        product.setName("timLi");
        product.setOrderId(orderId);

        Order order = new Order();
        order.setId(orderId);
        order.setAge("11");
        order.setConsumerId(consumerId);
        order.setProduct(product);

        Consumer consumer = new Consumer();
        consumer.setId(consumerId);
        consumer.setOrder(order);

        String name = Optional.ofNullable(consumer).map(consumer1 -> consumer1.getOrder()).map(order1 -> order1.getProduct())
                .map(product1 -> product1.getName()).orElse("value is null");
        System.out.println("name = " + name);
    }

    @Test
    public void test2() {
        String consumerId = UUID.randomUUID().toString();
        String orderId = UUID.randomUUID().toString();
        String productId = UUID.randomUUID().toString();

        Product product = new Product();
        product.setId(productId);
        product.setName("timLi");
        product.setOrderId(orderId);

        Order order = new Order();
        order.setId(orderId);
        order.setAge("11");
        order.setConsumerId(consumerId);
        order.setProduct(null);

        Consumer consumer = new Consumer();
        consumer.setId(consumerId);
        consumer.setOrder(order);

        String name = Optional.ofNullable(consumer).map(consumer1 -> consumer1.getOrder()).map(order1 -> order1.getProduct())
                .map(product1 -> product1.getName()).orElse("value is null");
        System.out.println("name = " + name);
    }
}
