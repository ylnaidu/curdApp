package com.item.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.item.demo.entiry.Item;
import com.item.demo.service.ItemService;


//@RestController
@Controller
public class ItemController {
	Logger logger=LoggerFactory.getLogger(ItemController.class);
	/*
	 * @Autowired private ItemDAO dao;
	 */
	@Autowired
	private ItemService service;
	
	//Fronted Integration Start
	/**
	 * Display
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String viewIndexPage(Model model, @Param("keyword") String keyword) {
		logger.error("error");
		logger.warn("warning");
		logger.debug("debug");
		logger.trace("trace");
		
		List<Item> itemList;
		if (keyword != null) {
			itemList=service.findAll(keyword);
        }else {
        	itemList=service.findAll();
        }
		
		System.out.println(itemList);
		System.out.println("==========="+keyword);
		model.addAttribute("getAllItems",itemList);
		model.addAttribute("keyword", keyword);
		return "index";
	}
	
	/**
	 * Add Item Form
	 * @param model
	 * @return
	 */
	@RequestMapping("/new_item")
	public String addNewItem(Model model) {
		Item item=new Item();
		model.addAttribute("item",item);
		return "addItem";
	}
	
	/**
	 * Save the item by Form data
	 * @param item
	 * @return
	 */
	@RequestMapping(value="save_item",method=RequestMethod.POST)
	public String addItem(@ModelAttribute("item") Item item) {
		service.save(item);
		return "redirect:/";
	}
	
	
	/**
	 * Update the Item Form Data
	 * @param id
	 * @return
	 */
	@RequestMapping("/edit/{id}")
	public ModelAndView updateItem(@PathVariable(name="id") float id) {
		ModelAndView mv=new ModelAndView("updateItem");
		Item item=service.findById(id);
		mv.addObject("item",item);
		return mv;
	}
	
	@RequestMapping(value="update_item",method=RequestMethod.POST)
	public String updateItemValue(@ModelAttribute("item") Item item) {
		service.update(item,item.getId());
		return "redirect:/";
	}
	
	
	/**
	 * Delete the Item
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	public String deleteItem(@PathVariable(name="id") float id) {
		service.deleteById(id);
		return "redirect:/";
	}
	
	/*@RequestMapping("search_item")
	public String searchIndexPage(@ModelAttribute("item") Item item) {
		List<Item> itemList=service.findAll(item);
		System.out.println(itemList);
		//model.addAttribute("getAllItems",itemList);
		return "redirect:/";
	}*/
	//Fronted Integration End
	
	/*Rest Api Testing*/
	/*
	@GetMapping("/items")
	public List<Item> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/items/{id}")
	public Item findById(@PathVariable(name ="id") float id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/items/{id}")
	public String deleteById(@PathVariable int id) {
		return service.deleteById(id)+" Item(s) delete from the database";
	}
	
	@PostMapping("/items")
	public String save(@RequestBody Item i) {
		return service.save(i)+" Item(s) saved successfully";
	}
	
	@PutMapping("/items/{id}")
	public String update(@RequestBody Item i, @PathVariable float id) {
		return service.update(i, id)+" Item(s) updated successfully";
	}*/
}
