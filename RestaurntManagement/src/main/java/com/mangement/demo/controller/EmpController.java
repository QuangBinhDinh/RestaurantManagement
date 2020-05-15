package com.mangement.demo.controller;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mangement.demo.entity.NHANVIEN;
import com.mangement.demo.service.EmpService;
import java.util. *;

@RestController
@RequestMapping("/employee")
public class EmpController {
	@Autowired
    private EmpService empService;
	
	@GetMapping("/get")
	public ResponseEntity<List<NHANVIEN>> getAllEmployees() {
		return new ResponseEntity<List<NHANVIEN>>(empService.getAllEmp(),HttpStatus.OK);
	}
	
	/**
	 @PostMapping("/add/{user}")//ham nay them thong tin 1 nhan vien gan voi 1 account trc do
	 public ResponseEntity<String> addEmployee(@RequestBody NHANVIEN nv, @PathVariable("user")String username){
		if(empService.addEmployee(nv, username)) {
			return new ResponseEntity<String>("Account added!",HttpStatus.OK);	
		}else return new ResponseEntity<String>("Not found username",HttpStatus.NOT_FOUND);
		
	}
	 */
	
	
	@PutMapping("/modify/{name}")
	public ResponseEntity<?> updateEmpInfo(@RequestBody NHANVIEN nv, @PathVariable("name")String username){
		if(empService.modifyEmpByUsername(nv, username)) {
			return new ResponseEntity<String>("Info modified !", HttpStatus.OK);
		}else return new ResponseEntity<String>("Employee not found !", HttpStatus.NOT_FOUND);
	}
}
