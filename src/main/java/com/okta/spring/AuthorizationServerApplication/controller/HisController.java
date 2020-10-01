package com.okta.spring.AuthorizationServerApplication.controller;

import com.okta.spring.AuthorizationServerApplication.dto.Cdha;
import com.okta.spring.AuthorizationServerApplication.dto.Khoa;
import com.okta.spring.AuthorizationServerApplication.dto.NhanVien;
import com.okta.spring.AuthorizationServerApplication.dto.Phong;
import com.okta.spring.AuthorizationServerApplication.service.HisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HisController {

    private static Logger logger = LoggerFactory.getLogger(HisController.class);

    @Autowired
    private HisService hisService;

    @GetMapping("/phong")
    @ResponseBody
    public ResponseEntity<List<Phong>> getDsPhong(){
        logger.info("getDsPhong");
        return ResponseEntity.ok().body(hisService.mockDataDsPhong());
    }

    @GetMapping("/nhan-vien")
    @ResponseBody
    public ResponseEntity<List<NhanVien>> getDsNhanVien(){
        logger.info("getDsNhanVien");
        return ResponseEntity.ok().body(hisService.mockDataNhanVien());
    }

    @GetMapping("/dich-vu")
    @ResponseBody
    public ResponseEntity<List<Cdha>> getDsDanhMucDichVu(){
        logger.info("getDsDanhMucDichVu");
        return ResponseEntity.ok().body(hisService.mockDataDanhMucDichVu());
    }

    @GetMapping("/khoa")
    @ResponseBody
    public ResponseEntity<List<Khoa>> getDsKhoa(){
        logger.info("getDsKhoa");
        return ResponseEntity.ok().body(hisService.mockDataKhoa());
    }

}
