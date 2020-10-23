package com.okta.spring.AuthorizationServerApplication.dto;

import lombok.Data;

@Data
public class PhongDTO {
    private KhoaDTO khoa;
    private int maPhongBenh;
    private String tenPhongBenh;
}
