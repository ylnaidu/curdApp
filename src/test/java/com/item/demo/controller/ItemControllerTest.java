package com.item.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import com.item.demo.entiry.Item;
import com.item.demo.service.ItemService;

@SpringBootTest
class ItemControllerTest {

	@Mock
	ItemService service;
	
	@Mock
	Model model;
	
	@InjectMocks
	ItemController itemController;
	
	@BeforeEach
	public void setUp() {
		
	}
	
	@Test
	void test_viewIndexPage() {
		itemController.viewIndexPage(model,"Test");
	}
	
	@Test
	void test_viewIndexPage_without_Searh() {
		itemController.viewIndexPage(model,null);
	}
	
	@Test
	void test_addNewItem() {
		itemController.addNewItem(model);
	}
	
	@Test
	void test_addItem() {
		Item item=new Item();
		itemController.addItem(item);
	}
	
	@Test
	void test_updateItem() {
		itemController.updateItem(1L);
	}
	
	@Test
	void test_updateItemValue() {
		Item item=new Item(1L,"Test",100f);
		itemController.updateItemValue(item);
	}
	
	@Test
	void test_deleteItem() {
		Item item=new Item(1L,"Test",100f);
		itemController.deleteItem(item.getId());
	}

}
