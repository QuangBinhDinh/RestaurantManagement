package com.mangement.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.mangement.demo.DAO.*;
import com.mangement.demo.entity.NHANVIEN;

@Service
public class EmpService {
	@Autowired
    private EmpManagement empManagement;
	
	@Autowired
	//private AccManagement accManagement;
	public List<NHANVIEN> getAllEmp(){
		 return this.empManagement.findAll();
	 }
	
	public Optional<NHANVIEN> getEmpByName (String id){
		 return this.empManagement.findById(id);
		 //tra ve 1 nhanvien theo id tra ve null neu k tim thay
	 }
	
	
	 
	 public void addEmp (NHANVIEN nv) {
                 empManagement.save(nv); 
	 }
	 
	

	 public boolean modifyEmpInfo(NHANVIEN nv, String id) {
		 Optional<NHANVIEN> onv = empManagement.findById(id);
		 if(onv.isPresent()) {
			empManagement.save(nv); return true;
		 }else return false;
		  
	 }
	 public boolean modifyEmpByUsername(NHANVIEN nv, String username) {
		 List<NHANVIEN> emp = empManagement.findByUserName(username);
		 if(emp.size() == 1) {
			 empManagement.save(nv);
			 return true;
		 }else return false;
	 }
	 public boolean deleteEmp(String id) {
		 Optional<NHANVIEN> otk = empManagement.findById(id);
		 if(otk.isPresent()) {
			 empManagement.deleteById(id);return true;
		 }else {
			 return false;
		 }
	 }
  
          public boolean deleteEmpByName(String name) {
		 Optional<NHANVIEN> otk = empManagement.findByName(name);
		 if(otk.isPresent()) {
			 empManagement.deleteByName(name);return true;
		 }else {
			 return false;
		 }
	 }

}
