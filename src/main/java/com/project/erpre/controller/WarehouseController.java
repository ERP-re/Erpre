package com.project.erpre.controller;

import com.project.erpre.model.dto.WarehouseDTO;
import com.project.erpre.service.WarehouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseController.class); // Logger 선언

    @Autowired
    private WarehouseService warehouseService;

    //창고 출고 지시 모달
    @PostMapping("/warehouseAssignment")
    public ResponseEntity<String> warehouseAssignment(@RequestBody WarehouseDTO warehouseDTO) {
        warehouseService.warehouseAssignment(warehouseDTO);
        return ResponseEntity.ok("출고 지시가 완료되었습니다.");
    }

    //창고명과 창고담당자명 수정(프론트에서 순서 보장 로직 구현 필요)
    @PostMapping("/updateWarehouse/{warehouseNo}")
    public ResponseEntity<String> updateWarehouse(@PathVariable Integer warehouseNo, @RequestBody WarehouseDTO warehouseDTO) {
        warehouseService.updateWarehouse(warehouseNo, warehouseDTO);
        return ResponseEntity.ok("창고 정보가 수정되었습니다.");
    }
}
