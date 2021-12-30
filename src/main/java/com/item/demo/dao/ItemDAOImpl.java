package com.item.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.item.demo.entiry.Item;

@Repository
public class ItemDAOImpl implements ItemDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Item> findAll() {
		return jdbcTemplate.query("SELECT * FROM item ", new BeanPropertyRowMapper<Item>(Item.class));
	}

	@Override
	public Item findById(float id) {
		return jdbcTemplate.queryForObject("SELECT * FROM item WHERE id=?", new BeanPropertyRowMapper<Item>(Item.class), id);
	}

	@Override
	public int deleteById(float id) {
		return jdbcTemplate.update("DELETE FROM item WHERE id=?", id);
	}

	@Override
	public int save(Item i) {
		return jdbcTemplate.update("INSERT INTO item (name, price) VALUES (?, ?)", new Object[] {i.getName(), i.getPrice()});
	}

	@Override
	public int update(Item i, float id) {
		return jdbcTemplate.update("UPDATE item SET name = ?, price = ? WHERE id = ?", new Object[] {i.getName(), i.getPrice(), id});
	}
	
	@Override
	public List<Item> findAll(String keyword) {
		StringBuilder sb=new StringBuilder();
		sb.append("%");
		sb.append(keyword);
		sb.append("%");
		return jdbcTemplate.query("SELECT * FROM item WHERE id like ? or name like ? or price like ?", new BeanPropertyRowMapper<Item>(Item.class), sb.toString(),sb.toString(),sb.toString());
	}
}
