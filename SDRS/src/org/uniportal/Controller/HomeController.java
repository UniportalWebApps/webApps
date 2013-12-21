package org.uniportal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uniportal.utils.ViewNameConstants;

@Controller
public class HomeController {

	@RequestMapping(value = ViewNameConstants.HOME)
	public void simplyShowHomePage() {
		// just show the Home page.
	}

}
