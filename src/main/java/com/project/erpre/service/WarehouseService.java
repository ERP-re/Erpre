package com.project.erpre.service;

import com.project.erpre.model.dto.EmployeeDTO;
import com.project.erpre.model.dto.WarehouseDTO;
import com.project.erpre.model.entity.Employee;
import com.project.erpre.model.entity.Warehouse;
import com.project.erpre.repository.EmployeeRepository;
import com.project.erpre.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    //WarehouseDTO -> Warehouse 엔티티로 변환하는 메서드
    private Warehouse convertToEntity(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseNo(warehouseDTO.getWarehouseNo());
        warehouse.setWarehouseName(warehouseDTO.getWarehouseName());
        warehouse.setWarehouseTel(warehouseDTO.getWarehouseTel());
        warehouse.setWarehouseAddr(warehouseDTO.getWarehouseAddr());
        warehouse.setWarehouseManagerName(warehouseDTO.getWarehouseManagerName());
        return warehouse;
    }

    // Warehouse 엔티티 -> WarehouseDTO로 변환하는 메서드
    private WarehouseDTO convertToDTO(Warehouse warehouse) {
        return WarehouseDTO.builder()
                .warehouseNo(warehouse.getWarehouseNo())
                .warehouseName(warehouse.getWarehouseName())
                .warehouseTel(warehouse.getWarehouseTel())
                .warehouseAddr(warehouse.getWarehouseAddr())
                .warehouseManagerName(warehouse.getWarehouseManagerName())
                .build();
    }

    //Employee 엔티티 -> EmployeeDTO로 변환하는 메서드(현재 로그인한 직원 조회 필요)
    private EmployeeDTO convertToEmployeeDTO(Employee employee) {
        return EmployeeDTO.builder()
                .employeeId(employee.getEmployeeId())
                .employeeName(employee.getEmployeeName())
                .build();
    }

    //창고 출고 지시 모달
    public void warehouseAssignment(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = convertToEntity(warehouseDTO);
        warehouseRepository.save(warehouse);
    }

    //창고명과 창고담당자명 수정(프론트에서 순서 보장 로직 구현 필요)
    public void updateWarehouse(Integer warehouseNo, WarehouseDTO warehouseDTO) {
        Warehouse warehouse = warehouseRepository.findById(warehouseNo).orElse(null);
        if (warehouse != null) {
            warehouse.setWarehouseName(warehouseDTO.getWarehouseName());
            warehouse.setWarehouseManagerName(warehouseDTO.getWarehouseManagerName());

            warehouseRepository.save(warehouse);
        }
    }

    //현재 로그인한 직원 조회
    public EmployeeDTO getLoginEmployee(String employeeId) {
        Employee employee = employeeRepository.getLoginEmployee(employeeId);
        return convertToEmployeeDTO(employee);
    }

}
