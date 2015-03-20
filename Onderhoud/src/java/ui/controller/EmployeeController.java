/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import Entity.EmployeeEntity;
import dao.EmployeeDao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import ui.model.EmployeeListDetailDto;
import ui.model.EmployeePageDto;

/**
 *
 * @author jasper
 */
@Named(value = "Employee")
@RequestScoped
public class EmployeeController {
    private EmployeePageDto dto;

    @EJB
    private EmployeeDao employeeDao;

    @PostConstruct
    public void init() {

        dto = new EmployeePageDto();

        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String editId = req.getParameter("edit");


        EmployeeEntity sbe = employeeDao.findById(editId);
        if (sbe != null) {
            dto.getDetail().setId(sbe.getId());
            dto.getDetail().setFirstName(sbe.getFirstName());
            dto.getDetail().setLastName(sbe.getLastName());
            dto.getDetail().setEmail(sbe.getEmail());
            dto.getDetail().setStarthr(sbe.getStarthr());
            dto.getDetail().setEndhr(sbe.getEndhr());
            dto.getDetail().setJob(sbe.getJob());
            dto.getDetail().setAddress(sbe.getAddress());
            dto.getDetail().setPhone(sbe.getPhone());
 
        }

        List<EmployeeEntity> employees = employeeDao.listAll();

        for (EmployeeEntity employee : employees) {
            EmployeeListDetailDto listDetail = new EmployeeListDetailDto();
            listDetail.setId(employee.getId());
            listDetail.setFirstName(employee.getFirstName());
            listDetail.setLastName(employee.getLastName());
            listDetail.setEmail(employee.getEmail());
            listDetail.setStarthr(employee.getStarthr());
            listDetail.setEndhr(employee.getEndhr());
            listDetail.setJob(employee.getJob());
            listDetail.setAddress(employee.getAddress());
            listDetail.setPhone(employee.getPhone());
            dto.getList().add(listDetail);
        }

    }

    public String save() {
        String id = dto.getDetail().getId();
        EmployeeEntity sbe = null;
        if (id != null) {
            sbe = employeeDao.findById(id);
        }
        if (sbe == null) {
            sbe = new EmployeeEntity();
        }
        sbe.setFirstName(dto.getDetail().getFirstName());
        sbe.setLastName(dto.getDetail().getLastName());
        sbe.setEmail(dto.getDetail().getEmail());
        sbe.setStarthr(dto.getDetail().getStarthr());
        sbe.setEndhr(dto.getDetail().getEndhr());
        sbe.setJob(dto.getDetail().getJob());
        sbe.setAddress(dto.getDetail().getAddress());
        sbe.setPhone(dto.getDetail().getPhone());

       

        employeeDao.edit(sbe);

        // Forces page refresh
        return "Index.xhtml?faces-redirect=true";
    }
    public String delete(){
         String id = dto.getDetail().getId();
         employeeDao.deleteById(id);
        return"Index.xhtml?faces-redirect=true";
    }

    public EmployeePageDto getDto() {
        return dto;
    }

    public void setDto(EmployeePageDto dto) {
        this.dto = dto;
    }

}

