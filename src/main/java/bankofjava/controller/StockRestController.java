package bankofjava.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bankofjava.domain.Stock;

@RestController
public class StockRestController {

	@RequestMapping("/stocks")
	public HomeRestData get(){
		return new HomeRestData();
	}
}
