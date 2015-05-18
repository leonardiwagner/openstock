package bankofjava.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bankofjava.domain.Stock;

@RestController
@RequestMapping("/stocks")
public class StockRestController {

	@RequestMapping(method = RequestMethod.GET)
	public HomeRestData get(){
		return new HomeRestData();
	}
}
