package com.okta.spring.AuthorizationServerApplication.dto;

import lombok.Data;

@Data
public class BenhNhanDTO {
    private String cmnd;
    private String diaChi;
    private int gioiTinh;
    private int maBenhNhan;
    private String ngaySinh;
    private String soDienThoai;
    private String tenBenhNhan;
}
