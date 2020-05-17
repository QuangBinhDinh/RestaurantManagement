package com.mangement.demo.entity;

import java.io.Serializable;
import java.util.Objects;

import com.mangement.demo.entity.*;
import javax.persistence.*;
@Embeddable
public class Table_Dish_ID implements Serializable {
	@ManyToOne
	@JoinColumn(name = "ten_ban")
    private BAN_AN table;
	
	@ManyToOne
	@JoinColumn(name = "ten_mon")
    private MON_AN dish;
     
	public void setTable(BAN_AN table) {
		this.table = table;
	}

	public void setDish(MON_AN dish) {
		this.dish = dish;
	}
	
	public BAN_AN getTable() {
		return table;
	}

	public MON_AN getDish() {
		return dish;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Table_Dish_ID)) return false;
		Table_Dish_ID that = (Table_Dish_ID) o;
		return Objects.equals(that.getTable(), getTable()) &&  Objects.equals(that.getDish(), getDish());
	}

	
}
