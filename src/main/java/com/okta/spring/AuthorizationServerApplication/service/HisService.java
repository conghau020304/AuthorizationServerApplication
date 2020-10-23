package com.okta.spring.AuthorizationServerApplication.service;

import com.okta.spring.AuthorizationServerApplication.dto.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class HisService {
    private static final String DATE_TIME_FORMATT = "dd/MM/yyyy";
    private static final String DATE_TIME_FORMATT2 = "dd/MM/yyyy HH:mm";
    public List<Phong> mockDataDsPhong(){
        List<Phong> dsPhong = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Khoa khoa = new Khoa();
            khoa.setMaPhongBan(100+i);
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
        String [] roles = {"BS", "BM", "KTV", "KTV", "KTV", "KTV", "KTV", "KTV", "KTV"};
        for(int i = 0; i < 5; i++){
            ChucDanh chucDanh = new ChucDanh();
            chucDanh.setMaChucDanh(i);
            chucDanh.setTenChucDanh("Chuc vu " + i);
            chucDanh.setMoTaChucDanh(roles[i]);

            Khoa khoa = new Khoa();
            khoa.setMaPhongBan(i);
            khoa.setTenPhongBan("Phong ban " + i);

            NhanVien nhanVien = new NhanVien();
            nhanVien.setChucDanh(chucDanh);
            nhanVien.setKhoa(khoa);
            nhanVien.setMaNhanVien(i);
            nhanVien.setTenNhanVien("Ten Nhan Vien " + i);
            nhanVien.setUserName("User Name " + i);

            dsNhanVien.add(nhanVien);
        }
        return dsNhanVien;
    }

    public List<Cdha> mockDataDanhMucDichVu(){
        String [] conceptGroup = {"XQUANG","CTSCN", "SA", "NSTMH", "XQMRI", "DT"};
        List<Cdha> dsDichVu = new ArrayList<>();
        for(int i = 0 ; i < 5; i++) {
            LoaiCdha loaiCdha = new LoaiCdha();
            loaiCdha.setDvtt("DVTT_LoaiCDHA " + i);
            loaiCdha.setMaLoaiCdha(i);
            loaiCdha.setMoTaText("Mô tả Text " + i);
            loaiCdha.setMoTaLoaiCdha(conceptGroup[i]);
            loaiCdha.setTenLoaiCdha("Ten loaiCDHA " + i);

            Cdha cdha = new Cdha();
            cdha.setDonViTinh("don vi tinh" + i);
            cdha.setDvtt("dvtt " + i);
           // cdha.setGiaCdha(1000 + i);
            cdha.setLoaiCdha(loaiCdha);
            cdha.setMaCdha(i);
            cdha.setTenCdha("TenCDHAe UpdateLan2 " + i);
            cdha.setTrangThaiBhyt(i % 2 == 0 ? 0 : 1);

            dsDichVu.add(cdha);
        }
        dsDichVu.add(null);
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
        String []ds = {"1111111", "2222222", "3333333", "4444444", "5555555", "6666666"};
        for(int i = 0; i < 5 ; i++){
            ChiDinhDTO chiDinh = new ChiDinhDTO();
            chiDinh.setBacSiThucHien("Bac si thuc hien " + i);

            BenhNhanDTO benhNhanDTO = new BenhNhanDTO();
            benhNhanDTO.setCmnd("Cmnd_" + i);
            benhNhanDTO.setDiaChi("Dia Chi_" + i);
            benhNhanDTO.setGioiTinh(0);
            benhNhanDTO.setMaBenhNhan(i);
            benhNhanDTO.setNgaySinh(LocalDate.now().minusYears(20).format(DateTimeFormatter.ofPattern(DATE_TIME_FORMATT)));
            benhNhanDTO.setSoDienThoai("0901001100"+i);
            benhNhanDTO.setTenBenhNhan("Ten benh Nhan " + i);
            chiDinh.setBenhNhan(benhNhanDTO);
            chiDinh.setBenhPhu("Benh phu " + i);
            chiDinh.setBhytKChi(11111+i);
            chiDinh.setCapCuu(0);
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
            cdhaDTO.setMaCdha(i+"");
            cdhaDTO.setTenCdha("TenCDHA " + i);
            cdhaDTO.setTrangThaiBhyt(i % 2 == 0 ? 0 : 1);

            chiDinh.setDichVu(cdhaDTO);
            chiDinh.setDonGia(100000D+i);
            chiDinh.setDvtt("dvtt " + i);
            chiDinh.setIcd("icd" + i);
            chiDinh.setKetLuan("Ket luan" + i);
            chiDinh.setKetQua("Ket qua " + i);
            chiDinh.setLoiDan("Loi dan " + i);
            chiDinh.setMaBacSiThucHien(1);
            chiDinh.setMaMauSieuAm(i);
            DateTimeFormatter dt = DateTimeFormatter.ofPattern(DATE_TIME_FORMATT);
            if(i%2==0) {
                chiDinh.setNgayChiDinhCt2(LocalDate.parse(LocalDate.now().format(dt), dt));
            }else{
                chiDinh.setNgayChiDinhCt2(LocalDate.parse(LocalDate.now().plusDays(1).format(dt), dt));
            }
            chiDinh.setNgayChiDinhCt(chiDinh.getNgayChiDinhCt2().format(dt));
            NhanVienDTO nhanVienDTO = new NhanVienDTO();
            nhanVienDTO.setMaNhanVien(2);
            nhanVienDTO.setTenNhanVien("Ten Nhan Vien " + i);
            chiDinh.setNguoiChiDinh(nhanVienDTO);

            chiDinh.setNoiTru(0);
            PhongDTO phongChiDinh = new PhongDTO();

            KhoaDTO khoaChiDinh = new KhoaDTO();
            khoaChiDinh.setMaPhongBan(100);
            khoaChiDinh.setTenPhongBan("Khoa Chi Dinh");

            phongChiDinh.setMaPhongBenh(2);
            phongChiDinh.setTenPhongBenh("PHong Chi Dinh");
            phongChiDinh.setKhoa(khoaChiDinh);

            chiDinh.setPhongChiDinh(phongChiDinh);

            KhoaDTO khoaThucHien = new KhoaDTO();
            PhongDTO phongThucHien = new PhongDTO();

            khoaThucHien.setMaPhongBan(103);
            khoaThucHien.setTenPhongBan("Khoa Thuc Hien");

            phongThucHien.setMaPhongBenh(3);
            phongThucHien.setTenPhongBenh("Phong Thuc Hien");
            phongThucHien.setKhoa(khoaThucHien);

            chiDinh.setPhongThucHien(phongThucHien);
            chiDinh.setPic1("PIC1");
            chiDinh.setSoLuong(3.D);
            chiDinh.setSoTheBaoHiem("BHYT___" + i);
            chiDinh.setSttHangNgay(i);
            chiDinh.setSttMayCdha(i+2);
            chiDinh.setTenIcd("TenICD " + i);
            chiDinh.setTrangThaiPacs(0);
            chiDinh.setUuTien(2);
            chiDinh.setUuid(ds[i]);

            dsChiDinh.add(chiDinh);
            ///chiDi
        }
        return dsChiDinh;
    }


    public List<ThietBi> mockDataThietBi(){
        List<ThietBi> dsThietBi = new ArrayList<>();
        String [] dsGroup = {"SA", "XQ", "NS", "CL", "DT", "DN", "MR"};
        for(int i = 0; i < 5; i++){
            NhomThietBi nhomThietBi = new NhomThietBi();
            nhomThietBi.setDvtt("nhomThietBi DVTT " + i);
            nhomThietBi.setStt(String.valueOf(i));
            nhomThietBi.setTenNhomMay("Ten nhom may " + i);
            nhomThietBi.setTrangThai(i%2==0?0:1);
           // nhomThietBi.setMaNhomMay(dsGroup[i]);

            ThietBi thietBi = new ThietBi();
            thietBi.setDvtt("");
            thietBi.setLoaiMay("");
            thietBi.setMaMay(String.valueOf(i));
            thietBi.setMaQl(String.valueOf(i));
            thietBi.setMaSoSerial("111--"+ i);
            thietBi.setNhomThietBi(nhomThietBi);
            thietBi.setTenHt("Ten HT" + i);
            thietBi.setTenMay("Ten May " + i);
            thietBi.setTrangThai(i%2==0?0:1);
            dsThietBi.add(thietBi);
        }
        return dsThietBi;
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
