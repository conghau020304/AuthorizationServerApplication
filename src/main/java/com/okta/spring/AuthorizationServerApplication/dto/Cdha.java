package com.okta.spring.AuthorizationServerApplication.dto;

import lombok.Data;

@Data
public class Cdha {
    private String donViTinh;
    private String dvtt;
    private Number giaCdha;
    private LoaiCdha loaiCdha;
    private Integer maCdha;
    private String tenCdha;
    private Integer trangThaiBhyt;
}
