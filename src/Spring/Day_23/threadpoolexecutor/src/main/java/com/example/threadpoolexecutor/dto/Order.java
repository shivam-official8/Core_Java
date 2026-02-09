package com.example.threadpoolexecutor.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {
    private Long orderId;
    private String name;
    private String trackingId;
}
