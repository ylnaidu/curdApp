package com.item.demo.dao;

import java.util.List;

import com.item.demo.entiry.Item;

public interface ItemDAO {
	
	public List<Item> findAll();
	
	public Item findById(float id);
	
	public int deleteById(float id);
	
	public int save(Item e);
	
	public int update(Item e, float id);
	
	public List<Item> findAll(String e);
}
