/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jasper
 */
public class EmployeePageDto {
    private EmployeeDetailDto detail = new EmployeeDetailDto();

    private List<EmployeeListDetailDto> list = new LinkedList<>();

    public EmployeeDetailDto getDetail() {
        return detail;
    }

    public void setDetail(EmployeeDetailDto detail) {
        this.detail = detail;
    }

    public List<EmployeeListDetailDto> getList() {
        return list;
    }

    public void setList(List<EmployeeListDetailDto> list) {
        this.list = list;
    }
    
}

