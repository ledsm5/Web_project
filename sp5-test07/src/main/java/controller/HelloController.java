package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//servlet이 컨트롤러로 인식하게 해준다
@Controller
public class HelloController {
	@RequestMapping("/testHello")
	public String test() {
		return "main";
		//컨텍스트에서 생략한다고 다 선언했으므로 이렇게만 써도된다 
		// ==>  main으로 가라  
		
	}
}
