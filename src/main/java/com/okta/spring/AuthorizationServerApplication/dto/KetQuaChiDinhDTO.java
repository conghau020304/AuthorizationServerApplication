package com.okta.spring.AuthorizationServerApplication.dto;

import lombok.Data;

@Data
public class KetQuaChiDinhDTO {
    private String bacSiThucHien;
    private String ketLuan;
    private String ketQua;
    private String loiDan;
    private Integer maBacSiThucHien;
    private Integer maKyThuatVien;
}
