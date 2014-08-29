package bankofjava.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bankofjava.domain.Account;



@Controller
@RequestMapping(value = "/account")
public class AccountController{


	@RequestMapping(value = "/index")
	public Account index(){
		return new Account("test name", "test@email.com", "123");
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public void login(@RequestParam String email, @RequestParam String password,
					  HttpServletRequest request, HttpSession session){

		Account account = new Account(name,email,""); //todo login to get this account
		
		session.setAttribute("user", account);
	}
	
	@RequestMapping(value = "/create", method=RequestMethod.POST)
	public void create(HttpServletRequest request, HttpSession session){
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Account account = new Account("","",""); //todo create account
		
		session.setAttribute("user", account);
		
	}
	
	@RequestMapping(value = "/create", method=RequestMethod.POST)
	public void create(){
	}


}

