package com.item.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.demo.dao.ItemDAO;
import com.item.demo.entiry.Item;

@Service
public class ItemServiceImp implements ItemService{

	@Autowired
	private ItemDAO dao;

	@Override
	public List<Item> findAll() {
		return dao.findAll();
	}

	@Override
	public Item findById(float id) {
		return dao.findById(id);
	}

	@Override
	public int deleteById(float id) {
		return dao.deleteById(id);
	}

	@Override
	public int save(Item i) {
		return dao.save(i);
	}

	@Override
	public int update(Item i, float id) {
		
		return dao.update(i, id);
	}
	
	@Override
	public List<Item> findAll(String keyword) {
		return dao.findAll(keyword);
	}
	
}
