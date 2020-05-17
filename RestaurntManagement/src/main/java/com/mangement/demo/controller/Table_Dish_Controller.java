package com.mangement.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mangement.demo.entity.*;
import com.mangement.demo.service.*;

@RestController
@RequestMapping("/table_dish")
public class Table_Dish_Controller {
	 @Autowired
	 private Table_Dish_Service table_Dish_Service;
	 
	 @Autowired
	 private DishService dishService;
	 
	 @Autowired
	 private TableService tableService;
	    
	 @GetMapping("/all")
	 public ResponseEntity<List<BANAN_MONAN>> getAllJob(){
	    return new ResponseEntity<List<BANAN_MONAN>>( table_Dish_Service.getAllList(),HttpStatus.OK);
	 }	
	 
	 @GetMapping("/table/{name}")
	 public ResponseEntity<?> getTableByName(@PathVariable("name") String tableName){
		 List<BANAN_MONAN> tableList = table_Dish_Service.getListByTable(tableName);
		 if(tableList.size() > 0) {
			 return new ResponseEntity<List<BANAN_MONAN>>( tableList,HttpStatus.OK);
		 }else return new ResponseEntity<String>("Table not found !!",HttpStatus.NOT_FOUND);
		   
	}
	 
	 @PostMapping("/add/{table}/{dish}")
	 public ResponseEntity<String> addOrder(@RequestBody BANAN_MONAN order, @PathVariable("table") String tableName, @PathVariable("dish") String dishName){
		 
		 return new ResponseEntity<String>("Order added",HttpStatus.OK);
	 }
}
