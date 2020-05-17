package com.mangement.demo.service;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.mangement.demo.DAO.*;
import com.mangement.demo.entity.*;

@Service
@Transactional
public class Table_Dish_Service {
	@Autowired
    private Table_Dish_Management table_Dish_Management;
	
	@Autowired
	private DishManagement dishManagement;
	
	@Autowired 
	private TableManagement tableManagement;
	
	public List<BANAN_MONAN> getAllList(){
		return table_Dish_Management.findAll();
	}
	
	public List<BANAN_MONAN> getListByTable(String tableName){
		return table_Dish_Management.findTableByTableName(tableName);
	}
	
	public void addOrder(BANAN_MONAN order, String tableName, String dishName) {
		
	}
}
