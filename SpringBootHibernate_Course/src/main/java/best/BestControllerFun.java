package best;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BestControllerFun {
	
	@GetMapping("/hello")
	public String saySomething() {
		return "Hello my friend!";
	}
	

}
