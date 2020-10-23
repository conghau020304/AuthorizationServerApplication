package com.okta.spring.AuthorizationServerApplication.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ChiDinhDTO {
    private String bacSiThucHien;
    private BenhNhanDTO benhNhan;
    private String benhPhu;
    private int bhytKChi;
    private int capCuu;
    private String chanDoan;
    private int daChanDoan;
    private int daThanhToan;
    private CdhaDTO dichVu;
    private Double donGia;
    private String dvtt;
    private String icd;
    private String ketLuan;
    private String ketQua;
    private String loiDan;
    private int maBacSiThucHien;
    private int maMauSieuAm;
    private String ngayChiDinhCt;
    private LocalDate ngayChiDinhCt2;
    private String ngayThucHien;
    private NhanVienDTO nguoiChiDinh;
    private int noiTru;
    private PhongDTO phongChiDinh;
    private PhongDTO phongThucHien;
    private String pic1;
    private Double soLuong;
    private String soTheBaoHiem;
    private Integer sttHangNgay;
    private Integer sttMayCdha;
    private String tenIcd;
    private int trangThaiPacs;
    private int uuTien;
    private String uuid;

    private Integer maKyThuatVien;

    private Integer maThietBiThucHien;

    private LocalDateTime thoiGianChanDoan;
}

