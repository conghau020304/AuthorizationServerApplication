package com.okta.spring.AuthorizationServerApplication.dto;

import lombok.Data;

@Data
public class Phong {
    private Khoa khoa;
    private Integer maPhongBenh;
    private String tenPhongBenh;
}
