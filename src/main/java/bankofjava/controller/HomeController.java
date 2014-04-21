package bankofjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/noix")
	public String teste(Model model){
		model.addAttribute("ople","badaui");
		
		return "nozes";
	}
}
