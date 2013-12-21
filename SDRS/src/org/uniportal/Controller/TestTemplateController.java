package org.uniportal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uniportal.utils.ViewNameConstants;

@Controller
public class TestTemplateController {

	@RequestMapping(value = ViewNameConstants.TEMPLATE)
	public void Viewtemplate() {
		// just show the Template.
	}

	@RequestMapping(value = ViewNameConstants.TEMPLATEBS)
	public void ViewtemplateBS() {
		// just show the Template.
	}
}
