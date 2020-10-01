package com.okta.spring.AuthorizationServerApplication.dto;

import lombok.Data;

@Data
public class CdhaDTO {
    private String donViTinh;
    private String dvtt;
    private Number giaCdha;
    private LoaiCdhaDTO loaiCdha;
    private String maCdha;
    private String tenCdha;
    private Integer trangThaiBhyt;
}
