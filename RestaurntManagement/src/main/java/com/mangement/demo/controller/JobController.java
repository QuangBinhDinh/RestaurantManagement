package com.mangement.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mangement.demo.service.*;
import com.mangement.demo.entity.*;
import java.util.*;
@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;
    
    @GetMapping("/all")
    public ResponseEntity<List<CHUCVU>> getAllJob(){
    	return new ResponseEntity<List<CHUCVU>>(jobService.getAllJob(),HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<?> getJobByNamme(@PathVariable("name") String name){
    	Optional<CHUCVU> ojob = jobService.getJobByNamme(name);
        if(ojob.isPresent()) {
        	return new ResponseEntity<CHUCVU> (ojob.get(),HttpStatus.OK);
        }else return new ResponseEntity<String>("No job found", HttpStatus.NOT_FOUND);
    }
}
