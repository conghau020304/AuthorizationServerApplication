package com.okta.spring.AuthorizationServerApplication.dto;

import lombok.Data;

@Data
public class NhanVien {
    private ChucVu chucvu;
    private Integer maNhanVien;
    private String tenNhanVien;
    private String userName;
}
