package com.controllers;


import org.hibernate.StaleObjectStateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.userpojo.Itempo;
import com.validation.ItemService;

@Controller
public class ItemControll {
		
	ItemService serve=new ItemService();
	
	@RequestMapping(value="/add")
	public String items() {
		System.out.println("moving to additems.jsp");
		
		return "additems";
	}
	
	@RequestMapping(value="/saveitem")
	public  String addItems(Itempo item,Model m) {
		String addItems = serve.addItems(item, m);
		return addItems;
	}
	
	@RequestMapping(value="/menu")
	public String menu(Itempo item,Model m) {
		String menu = serve.menu(item, m);
		
		return menu;
	}
	
	@RequestMapping(value="/editItem")
	public String edit(@RequestParam("editform") String id,Model m) {
		String edit = serve.edit(id,m);
		return edit;
	}
	
	@RequestMapping(value="/edited")
	public String saveEdit(Itempo item,Model m) {
			String saveEdit=null;
		try {
			 saveEdit = serve.saveEdit(item, m);
		}catch(StaleObjectStateException e) {
			
			m.addAttribute("message", "item is already updated or deleted by other user please update again");
			return "showmenu";
		}
		return saveEdit;
	}
	
	@RequestMapping(value="deleteItem")
	public String deleteItem(@RequestParam("itemform") String id,Model m,Itempo item,Integer res) {
		String deleteItem = serve.deleteItem(id,m,item,res);
		
		return deleteItem;
	}
}
