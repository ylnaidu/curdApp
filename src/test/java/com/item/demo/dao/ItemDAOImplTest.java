package com.item.demo.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.item.demo.entiry.Item;

@SpringBootTest
class ItemDAOImplTest {

	@Mock
	JdbcTemplate jdbcTemplate;
	
	@Mock
	ItemDAO dao;
		
	@InjectMocks
	ItemDAOImpl daoImp;
	
	@BeforeEach
	public void setUp() {
		
	}
	
	@Test
	void test_findAll() {
		List<Item> list=new ArrayList<Item>();
		list.add(new Item(1L,"test",300f));
		when(jdbcTemplate.query("SELECT * FROM item ", new BeanPropertyRowMapper<Item>(Item.class))).thenReturn(list);
		daoImp.findAll();
	}
	
	@Test
	void test_deleteById() {
		List<Item> list=new ArrayList<Item>();
		list.add(new Item(1L,"test",300f));
		daoImp.deleteById(list.get(0).getId());
	}
	
	@Test
	void test_save() {
		Item it=new Item(1L,"test",300f);
		daoImp.save(it);
	}
	
	@Test
	void test_findBy() {
		List<Item> list=new ArrayList<Item>();
		list.add(new Item(1L,"test",300f));
		daoImp.findById(list.get(0).getId());
	}
	
	@Test
	void test_update() {
		Item it=new Item(1L,"test",300f);
		daoImp.update(it,it.getId());
	}
	
	@Test
	void test_findwithFilter() {
		daoImp.findAll("test");
	}

}
