package com.okta.spring.AuthorizationServerApplication.dto;

import lombok.Data;

@Data
public class NhanVien {
    private ChucDanh chucDanh;
    private Khoa khoa;
    private Integer maNhanVien;
    private String tenNhanVien;
    private String userName;
}
