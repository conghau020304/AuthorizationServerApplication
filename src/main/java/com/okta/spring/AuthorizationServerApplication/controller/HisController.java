package com.okta.spring.AuthorizationServerApplication.controller;

import com.okta.spring.AuthorizationServerApplication.dto.*;
import com.okta.spring.AuthorizationServerApplication.service.HisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class HisController {

    private static Logger logger = LoggerFactory.getLogger(HisController.class);
    private static final String DATE_TIME_FORMATT = "yyyy/MM/dd HH:mm:ss";
    private static final String DATE_TIME_FORMAT2 = "dd/MM/yyyy HH:mm";
    @Autowired
    private HisService hisService;

    private static List<ChiDinhDTO> dsCD = new ArrayList<>();


    @GetMapping("/chi-dinh/{uuid}")
    @ResponseBody
    public ResponseEntity<ChiDinhDTO> getDsChiDinh(@PathVariable String uuid) {
        List<ChiDinhDTO> ds = dsCD
                .stream()
                .filter(item -> item.getUuid().equals(uuid))
                .collect(Collectors.toList());
        if (ObjectUtils.isEmpty(ds)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(ds.get(0));
    }

    @GetMapping("/chi-dinh")
    @ResponseBody
    public ResponseEntity<List<ChiDinhDTO>> getDsChiDinhByDate(@RequestParam String startTime, @RequestParam String endTime) {
        logger.info("startDate: {}, endDate: {}", startTime, endTime);
        LocalDateTime time = LocalDateTime.parse(startTime, DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime time2 = LocalDateTime.parse(endTime, DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(time);
        System.out.println(time2);
        boolean check = time.equals(time2);
        if (ObjectUtils.isEmpty(dsCD)) {
            dsCD = hisService.mockDataDsChiDinh();

        }
        System.out.println(dsCD);
        List<ChiDinhDTO> ds = dsCD.stream()
                .filter(item -> {
                   // if (!check) {
                        return item.getNgayChiDinhCt2().isAfter(time) && item.getNgayChiDinhCt2().isBefore(time2); //&& item.getTrangThaiPacs() == Integer.parseInt(trangThaiPacs);
                   // } else {
                   //     return item.getNgayChiDinhCt2().isEqual(time) && item.getTrangThaiPacs() == Integer.parseInt(trangThaiPacs);
                   // }
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(ds);
    }

//    @PutMapping("/chi-dinh")
//    @ResponseBody
//    public ResponseEntity<?> updateStatusDsChiDinh(@RequestBody List<String> uuids) {
//        logger.info("updateStatusDsChiDinh uuids: {}", uuids.toString());
//        dsCD = dsCD.stream().peek(c -> {
//            if (uuids.contains(c.getUuid())) {
//                c.setTrangThaiPacs(1);
//            }
//        }).collect(Collectors.toList());
//        String[] xx = dsCD.stream().filter(c -> uuids.contains(c.getUuid())).map(ChiDinhDTO::getUuid).toArray(String[]::new);
//        return ResponseEntity.ok().body(Arrays.toString(xx));
//    }

    @PutMapping("/chi-dinh")
    @ResponseBody
    public ResponseEntity<?> updateStatusDsChiDinh(@RequestBody ReceiveStatus receiveStatus) {
        List<String> uuids = receiveStatus.getUuids();
        logger.info("updateStatusDsChiDinh uuids: {}", uuids.toString());
        dsCD = dsCD.stream().peek(c -> {
            if (uuids.contains(c.getUuid())) {
                c.setTrangThaiPacs(1);
            }
        }).collect(Collectors.toList());
        String[] xx = dsCD.stream().filter(c -> uuids.contains(c.getUuid())).map(ChiDinhDTO::getUuid).toArray(String[]::new);
        return ResponseEntity.ok().body(Arrays.toString(xx));
    }

    @PutMapping("/chi-dinh/{uuid}/ket-qua")
    @ResponseBody
    public ResponseEntity<ChiDinhDTO> updateRadiologyResult(@PathVariable("uuid") String uuid, @RequestBody KetQuaChiDinhDTO ketQuaChiDinhDTO) {
        logger.info("updateRadiologyResult uuids: {}", uuid);
        logger.info("updateRadiologyResult ketQuaChiDinhDTO: {}", ketQuaChiDinhDTO);
        dsCD = dsCD.stream().peek(c -> {
            if (uuid.equals(c.getUuid())) {
                c.setBacSiThucHien(ketQuaChiDinhDTO.getBacSiThucHien());
                c.setKetQua(ketQuaChiDinhDTO.getKetQua());
                c.setKetLuan(ketQuaChiDinhDTO.getKetLuan());
                c.setLoiDan(ketQuaChiDinhDTO.getLoiDan());
                try {
                    c.setMaBacSiThucHien(Integer.parseInt(ketQuaChiDinhDTO.getMaThietBiThucHien()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    c.setMaKyThuatVien(Integer.parseInt(ketQuaChiDinhDTO.getMaKyThuatVien()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    c.setMaThietBiThucHien(Integer.parseInt(ketQuaChiDinhDTO.getMaThietBiThucHien()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    c.setThoiGianChanDoan(LocalDateTime.parse(ketQuaChiDinhDTO.getThoiGianChanDoan(), DateTimeFormatter.ofPattern(DATE_TIME_FORMAT2)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).collect(Collectors.toList());
        ChiDinhDTO cd = dsCD.stream().filter(c -> c.getUuid().equals(uuid)).findFirst().orElse(new ChiDinhDTO());
        return ResponseEntity.ok().body(cd);
    }

    @GetMapping("/chi-dinh/{uuid}/dich-vu")
    @ResponseBody
    public ResponseEntity<List<ChiDinhDTO>> getRadiologyListByUuidRequest(@PathVariable("uuid") String uuid) {
        logger.info("uuid: {}", uuid);
        List<ChiDinhDTO> dsChiDinh = hisService.mockDataDsChiDinh()
                .stream()
                .filter(item -> item.getUuid().equals(uuid))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(dsChiDinh);
    }

    @GetMapping("/phong")
    @ResponseBody
    public ResponseEntity<List<Phong>> getDsPhong() {
        logger.info("getDsPhong");
        return ResponseEntity.ok().body(hisService.mockDataDsPhong());
    }

    @GetMapping("/nhan-vien")
    @ResponseBody
    public ResponseEntity<List<NhanVien>> getDsNhanVien(@RequestParam(required = false, name = "maPhongBan") String maPhongBan) {
        logger.info("getDsNhanVien maPhongBan {}", maPhongBan);
        if (StringUtils.isEmpty(maPhongBan)) {
            return ResponseEntity.ok().body(hisService.mockDataNhanVien());
        } else {
            return ResponseEntity.ok().body(hisService.mockDataNhanVien().stream().filter(item -> item.getKhoa().getMaPhongBan().toString().equals(maPhongBan)).collect(Collectors.toList()));
        }
    }

    @GetMapping("/dich-vu")
    @ResponseBody
    public ResponseEntity<?> getDsDanhMucDichVu(@RequestParam(required = false, name = "maCdha") String maDC) {
        logger.info("getDsDanhMucDichVu maDC = {}", maDC);
        if (StringUtils.hasText(maDC)) {
            Cdha ds = hisService.mockDataDanhMucDichVu()
                    .stream().filter(p ->
                            !ObjectUtils.isEmpty(p) && Integer.parseInt(maDC) == p.getMaCdha())
                    .findFirst().orElse(new Cdha());


            return ResponseEntity.ok().body(ds);
        }
        return ResponseEntity.ok().body(hisService.mockDataDanhMucDichVu());
    }

    @GetMapping("/dich-vu/{maCdha}")
    @ResponseBody
    public ResponseEntity<Cdha> getOneDanhMucDanhVu(@PathVariable String maCdha) {
        logger.info("get One Danh muc dich vu {} ", maCdha);
        Cdha cdha = new Cdha();
        try {
            cdha = hisService.mockDataDanhMucDichVu()
                    .stream()
                    .filter(item -> item.getMaCdha() == Integer.parseInt(maCdha))
                    .findFirst().orElseThrow(() -> new RuntimeException("not found"));
        } catch (NullPointerException e) {
            logger.error("Null poiter ", e.getMessage());
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cdha);

    }

    @GetMapping("/khoa")
    @ResponseBody
    public ResponseEntity<List<Khoa>> getDsKhoa() {
        logger.info("getDsKhoa");
        return ResponseEntity.ok().body(hisService.mockDataKhoa());
    }

    @GetMapping("/thiet-bi")
    @ResponseBody
    public ResponseEntity<List<ThietBi>> getDsThietBi() {
        logger.info("getDsThietbi");
        return ResponseEntity.ok().body(hisService.mockDataThietBi());
    }

//    @GetMapping("/thiet-bi")
//    @ResponseBody
//    public ResponseEntity<List<ThietBi>> getDsThietBiById(@RequestBody ThietBi thietBi){
//        logger.info("getDsThietbi, {}", thietBi);
//        return ResponseEntity.ok().body(hisService.mockDataThietBi().stream().filter(item -> item.getTenMay().contains(thietBi.getTenMay())).collect(Collectors.toList()));
//    }

//    @PutMapping("/thiet-bi")
//    @ResponseBody
//    public ResponseEntity<List<ThietBi>> getDsThietBiBy(@RequestBody ThietBi thietBi){
//        logger.info("getDsThietbi, {}", thietBi);
//        return ResponseEntity.ok().body(hisService.mockDataThietBi().stream().filter(item -> item.getTenMay().contains(thietBi.getTenMay())).collect(Collectors.toList()));
//    }

//    @GetMapping("/dich-vu")
//    @ResponseBody
//    public ResponseEntity<List<Cdha>> getDsDanhMucDichVuByID(@RequestParam int id, @RequestParam String name){
//        logger.info("getDsDanhMucDichVu {}, {}",id, name);
//        return ResponseEntity.ok().body(hisService.mockDataDanhMucDichVu().stream().filter(item -> item.getMaCdha().equals(id) && item.getTenCdha().contains(name)).collect(Collectors.toList()));
//    }

    @DeleteMapping("/chi-dinh/{uuid}")
    @ResponseBody
    public ResponseEntity<ChiDinhDTO> testRejectRequestOrder(@PathVariable String uuid,  @RequestBody ChiDinhDTO chiDinhDTO){
        logger.info("testRejectRequestOrder {}", chiDinhDTO);
        dsCD.forEach(item -> {
            if(item.getUuid().equals(uuid)){
                item.setLyDoTuChoi(chiDinhDTO.getLyDoTuChoi());
                item.setTrangThaiPacs(8);
            }
        });
        return ResponseEntity.ok().body(dsCD.stream().filter(i -> i.getUuid().equals(uuid)).findFirst().orElse(new ChiDinhDTO()));
    }

}
