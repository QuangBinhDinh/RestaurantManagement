package com.mangement.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mangement.demo.service.*;
import com.mangement.demo.entity.*;
import java.util.*;

@RestController
@RequestMapping("/dish")
public class DishController {
	@Autowired
    private DishService dishService;
	
	@GetMapping("/all")
    public ResponseEntity<List<MON_AN>> getAllDish(){
    	return new ResponseEntity<List<MON_AN>>(dishService.getAllDish(),HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<?> getDishByName(@PathVariable("name") String name){
    	Optional<MON_AN> odish = dishService.getDish(name);
        if(odish.isPresent()) {
        	return new ResponseEntity<MON_AN> (odish.get(),HttpStatus.OK);
        }else return new ResponseEntity<String>("No job found", HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/add")//ham nay them thong tin 1 nhan vien gan voi 1 account trc do
	 public ResponseEntity<?>  addDish(@RequestBody MON_AN dish){
   	     dishService.addDish(dish);
		return new ResponseEntity<String>("Dish added",HttpStatus.OK);
		
	}
   
   @PutMapping("/modify/{name}")
   public ResponseEntity<?> modifyDish(@PathVariable("name") String name, @RequestBody MON_AN dish){
   	
       if(dishService.modifyDish(dish, name)) {
       	return new ResponseEntity<String> ("Dish updated",HttpStatus.OK);
       }else return new ResponseEntity<String>("No dish found", HttpStatus.NOT_FOUND);
   }
   
   @DeleteMapping("/delete/{name}")
   public ResponseEntity<?> deleteDish(@PathVariable("name") String name){
   	
       if(dishService.deleteDish( name)) {
       	return new ResponseEntity<String> ("Dish deleted",HttpStatus.OK);
       }else return new ResponseEntity<String>("No dish found", HttpStatus.NOT_FOUND);
   }
}
