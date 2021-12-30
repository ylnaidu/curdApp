package com.item.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.item.demo.dao.ItemDAO;
import com.item.demo.entiry.Item;

@SpringBootTest
class ItemServiceImpTest {

	@Mock
	ItemDAO dao;
	@Mock	
	ItemService itemService;
	
	@InjectMocks
	ItemServiceImp imp;
	
	@BeforeEach
	public void setUp() {
		
	}
	
	@Test
	void test_findAll() {
		imp.findAll();
	}
	
	@Test
	void test_findById() {
		imp.findById(1L);
	}
	
	@Test
	void test_deleteById() {
		imp.deleteById(1L);
	}
	
	@Test
	void test_save() {
		Item it=new Item(1L,"test",300f);
		imp.save(it);
	}
	
	@Test
	void test_Update() {
		Item it=new Item(1L,"test",300f);
		imp.update(it,it.getId());
	}
	
	@Test
	void test_Search() {
		imp.findAll("test");
	}

}
