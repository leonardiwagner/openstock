package bankofjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

	@RequestMapping(value = "/index")
	public void index(){
	}
	
	@RequestMapping(value = "/create")
	public void create(){
	}
}
