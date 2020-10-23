package com.okta.spring.AuthorizationServerApplication.dto;

import lombok.Data;

@Data
public class ThietBi {
    private String dvtt;
    private String loaiMay;
    private String maCskcbMay;
    private String maMay;
    private String maQl;
    private String maSoSerial;
    private String moTaLoai;
    private String nguonMay;
    private NhomThietBi nhomThietBi;
    private String tenHt;
    private String tenMay;
    private int trangThai;
}
