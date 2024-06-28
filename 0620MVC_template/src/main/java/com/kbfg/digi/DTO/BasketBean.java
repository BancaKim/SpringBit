package com.kbfg.digi.DTO;

import org.springframework.stereotype.Component;

@Component
public class BasketBean {
	private int basket_num;
	private String user_id;
	private String item_name;
	private int item_num;
	
	public int getBasket_num() {
		return basket_num;
	}
	public void setBasket_num(int basket_num) {
		this.basket_num = basket_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
}
