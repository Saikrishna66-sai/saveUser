package com.validation;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;

import com.database.hibernate.ItemDao;
import com.userpojo.Itempo;

public class ItemService {
	
	final static Logger logger=Logger.getLogger(ItemService.class); 
	ItemDao dao=new ItemDao();
	
	
	public  String addItems(Itempo item,Model m) {
		
		
		dao.addItems(item);
		logger.info("item is added successfully");
		m.addAttribute("msg","your item is added successfully");
		return "additems";
	}
	public String menu(Itempo item,Model m) {
		List<Itempo> menu = dao.menu(item);
		m.addAttribute("msg", menu);
		return "showmenu";
	}
	
	public String edit(String id,Model m) {
		Itempo edit=dao.edit(id);
		
		m.addAttribute("edititem", edit);
		
		return "edititem";
	}
	public String saveEdit(Itempo item,Model m) {
		dao.saveEdit(item);
		
		m.addAttribute("message", "item is successfully added");
		logger.info("item is edited successfully");
		List<Itempo> menu = dao.menu(item);
		m.addAttribute("msg", menu);
		return "showmenu";
	}
	
	public String deleteItem(String id,Model m, Itempo item,Integer res) {
		Integer result = dao.deleteItem(id);
		
		if(result==1) {
		String message= id + "item is successfully deleted";
		logger.warn("item is successfully deleted");
		 m.addAttribute("message", message);
		}else {
			String message= id + "item is not deleted";
			 m.addAttribute("message", message);
			 logger.error("item is not deleted ");
		}
		
		
		List<Itempo> menu = dao.menu(item);
		m.addAttribute("msg", menu);
		return "showmenu";
	}
}
