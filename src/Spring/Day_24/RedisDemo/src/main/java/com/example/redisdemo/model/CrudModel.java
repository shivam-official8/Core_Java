package com.example.redisdemo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.stereotype.Service;

@RedisHash(value="CrudModel")
@Setter
@Getter
@ToString
public class CrudModel {
    @Id
    private Long userId;
    private String name;
    private String email;
    private long phone;

   @TimeToLive
    private long ttl;

}
