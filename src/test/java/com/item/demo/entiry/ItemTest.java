package com.item.demo.entiry;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemTest {

	@Test
	void test() {
		Item it=new Item();
		it.setId(1L);
		it.setName("Mouse");
		it.setPrice(300f);
		
		assertEquals(1L, it.getId());
		assertEquals("Mouse", it.getName());
		assertEquals(300f, it.getPrice());
	}
	
	@Test
	public void test1() {
		Item it=new Item(1L, "Mouse", 300f);
		Item it1=new Item("Mouse", 300f);
		assertNotNull(it);
		assertNotNull(it1);
	}

}
