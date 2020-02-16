package com.singletontest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.userpojo.TestPo;

@Controller
public class Test {

	@Autowired
	TestPo stu1;
	@Autowired
	TestPo stu2;
	
	
	
	@RequestMapping(value="/heep")
	public String testIoc() {
		
		stu1.setName("chiranjevi");
		stu1.setId("6565");
		stu1.getPprt().setPassid(56);
		stu1.getPprt().setIssuedate("6-5-2016");
		stu1.getPprt().setIssuecity("hyd");
        
		
		
		stu2.setName("ramcharan");
		stu2.setId("5656");
		stu2.getPprt().setPassid(85);
		stu2.getPprt().setIssuedate("6-5-2016");
		stu2.getPprt().setIssuecity("hyd");
        
		
		System.out.println(stu1.getId()+stu1.getName()+stu1.getBranch()+stu1.getClg()+stu1.getPprt().getPassid());
		System.out.println(stu2.getId()+stu1.getName()+stu1.getBranch()+stu1.getClg()+stu2.getPprt().getPassid());
		
		List<String> list = stu1.getSubject();
		for (String sub : list) {
			System.out.println(sub);
		}
		return "register";
	}
}
