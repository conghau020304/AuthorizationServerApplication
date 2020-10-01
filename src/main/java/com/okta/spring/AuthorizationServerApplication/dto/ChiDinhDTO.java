package com.okta.spring.AuthorizationServerApplication.dto;

import lombok.Data;

@Data
public class ChiDinhDTO {
    private String bacSiThucHien;
    private Integer bhytKChi;
    private String chanDoan;
    private Integer daChanDoan;
    private Integer daThanhToan;
    private CdhaDTO dichVu;
    private Number donGia;
    private String dvtt;
    private Integer idDieuTri;
    private String ketLuan;
    private String ketQua;
    private String loiDan;
    private Integer maBacSiThucHien;
    private Integer maCdha;
    private String ngayChiDinhCt; // date-time
    private String ngayTao; // date
    private String  ngayThucHien; //date-time
    private Double soLuong;
    private String soPhieuCdha;
    private Integer soVaoVien;
    private Integer soVaoVienDieuTri;
    private Integer trangThaiPacs;
    private String uuid;
    private String uuidPhieu;
}

