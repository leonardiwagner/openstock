package bankofjava.controller;

import java.lang.annotation.Annotation;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.Controller;

import bankofjava.domain.Account;
import bankofjava.service.IAccountService;

@RequestMapping(value = "/account")
public class AccountController implements Controller{

	@RequestMapping(value = "/index")
	public void index(){
	}
	
	@RequestMapping(value = "/create")
	public void create(){
	}


}
