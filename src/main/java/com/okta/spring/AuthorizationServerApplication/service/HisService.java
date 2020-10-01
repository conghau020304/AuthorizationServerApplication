package com.okta.spring.AuthorizationServerApplication.service;

import com.okta.spring.AuthorizationServerApplication.dto.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class HisService {

    public List<Phong> mockDataDsPhong(){
        List<Phong> dsPhong = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Khoa khoa = new Khoa();
            khoa.setMaPhongBan(i);
            khoa.setTenPhongBan("Phong Ban" + i);

            Phong phong = new Phong();
            phong.setKhoa(khoa);
            phong.setMaPhongBenh(i);
            phong.setTenPhongBenh("Phong Benh"+i);

            dsPhong.add(phong);
        }
        return dsPhong;
    }

    public List<NhanVien> mockDataNhanVien(){
        List<NhanVien> dsNhanVien = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            ChucVu chucVu = new ChucVu();
            chucVu.setMaChucVu(i);
            chucVu.setTenChucVu("Chuc vu " + i);
            NhanVien nhanVien = new NhanVien();
            nhanVien.setChucvu(chucVu);
            nhanVien.setMaNhanVien(i);
            nhanVien.setTenNhanVien("Ten Nhan Vien " + i);
            nhanVien.setUserName("User Name " + i);

            dsNhanVien.add(nhanVien);
        }
        return dsNhanVien;
    }

    public List<Cdha> mockDataDanhMucDichVu(){
        List<Cdha> dsDichVu = new ArrayList<>();
        for(int i = 0 ; i < 5; i++) {
            LoaiCdha loaiCdha = new LoaiCdha();
            loaiCdha.setDvtt("DVTT_LoaiCDHA " + i);
            loaiCdha.setMaLoaiCdha(i);
            loaiCdha.setMotaLoaiCdha("Mô tả LoaiCDHA " + i);
            loaiCdha.setMoTaText("Mô tả text " + i);
            loaiCdha.setTenLoaiCdha("Ten loaiCDHA " + i);

            Cdha cdha = new Cdha();
            cdha.setDonViTinh("don vi tinh" + i);
            cdha.setDvtt("dvtt " + i);
            cdha.setGiaCdha(1000 + i);
            cdha.setLoaiCdha(loaiCdha);
            cdha.setMaCdha("MACDHA " + i);
            cdha.setTenCdha("TenCDHA " + i);
            cdha.setTrangThaiBhyt(i % 2 == 0 ? 0 : 1);

            dsDichVu.add(cdha);
        }
        return dsDichVu;
    }

    public List<Khoa> mockDataKhoa(){
        List<Khoa> dsKhoa = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Khoa khoa = new Khoa();
            khoa.setMaPhongBan(100+i);
            khoa.setTenPhongBan("Phong ban " + 100 + i);
            dsKhoa.add(khoa);
        }
        return dsKhoa;
    }

    public List<ChiDinhDTO> mockDataDsChiDinh(){
        List<ChiDinhDTO> dsChiDinh = new ArrayList<>();
        for(int i = 0; i < 5 ; i++){
            ChiDinhDTO chiDinh = new ChiDinhDTO();
            chiDinh.setBacSiThucHien("Bac si thuc hien " + i);
            chiDinh.setBhytKChi(11111+i);
            chiDinh.setChanDoan("Chan doan " + i);
            chiDinh.setDaChanDoan(i % 2 == 0 ? 0 : 1);
            chiDinh.setDaThanhToan(i % 2 == 0 ? 0 : 1);

            LoaiCdhaDTO loaiCdhaDTO = new LoaiCdhaDTO();
            loaiCdhaDTO.setDvtt("DVTT_LoaiCDHA " + i);
            loaiCdhaDTO.setMaLoaiCdha(i);
            loaiCdhaDTO.setMotaLoaiCdha("Mô tả LoaiCDHA " + i);
            loaiCdhaDTO.setMoTaText("Mô tả text " + i);
            loaiCdhaDTO.setTenLoaiCdha("Ten loaiCDHA " + i);

            CdhaDTO cdhaDTO = new CdhaDTO();
            cdhaDTO.setDonViTinh("don vi tinh" + i);
            cdhaDTO.setDvtt("dvtt " + i);
            cdhaDTO.setGiaCdha(1000 + i);
            cdhaDTO.setLoaiCdha(loaiCdhaDTO);
            cdhaDTO.setMaCdha("MACDHA " + i);
            cdhaDTO.setTenCdha("TenCDHA " + i);
            cdhaDTO.setTrangThaiBhyt(i % 2 == 0 ? 0 : 1);

            chiDinh.setDichVu(cdhaDTO);
            chiDinh.setDonGia(100000+i);
            chiDinh.setDvtt("DVTT " + i);
            chiDinh.setIdDieuTri(200+i);
            chiDinh.setKetLuan("Khởi tạo");
            chiDinh.setKetQua("Khởi tạo");
            chiDinh.setLoiDan("Lời dặn " + i);
            chiDinh.setMaBacSiThucHien(100+i);
            chiDinh.setMaCdha(1000+i);
            chiDinh.setNgayChiDinhCt(getDateTimeFormat());
            chiDinh.setNgayTao(getDateFormat());
            chiDinh.setNgayThucHien(getDateTimeFormat());
            chiDinh.setSoLuong(3D);
            chiDinh.setSoPhieuCdha("SOPHIEU_" + 1000 + i);
            //chiDinh.
        }
        return dsChiDinh;
    }


    public static String getDateTimeFormat(){
        String fm = "dd/mm/yyyy hh:mm:ss";
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(fm);
        return now.format(dateTimeFormatter);
    }

    public String getDateFormat(){
        String fm = "dd/mm/yyyy";
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(fm);
        return now.format(dateTimeFormatter);
    }
}
