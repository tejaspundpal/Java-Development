package controller;

@Controller
public class MyController {
	
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public String about() {
		System.out.println("inside about handler");
		return "about";
		//about.html
	}
}
