package org.hibernate.bpla.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.bpla.Service;
import org.hibernate.bpla.domain.CrossDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.util.Map;

/**
 * JavaBean form controller that is used to add a new <code>Owner</code> to the
 * system.
 * 
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
@RequestMapping("/details/insert")
@SessionAttributes(types = CrossDetail.class)
public class AddDetailForm {

    protected final Log logger = LogFactory.getLog(getClass());

    private Service service;

	@Autowired
	public AddDetailForm(Service service) {
		this.service = service;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
        for (Map.Entry<String, Object> entry : model.asMap().entrySet()) {
            System.out.printf("+%s: %s+\n", entry.getKey(), entry.getValue());
        }
		CrossDetail crossDetail = new CrossDetail();
		model.addAttribute(crossDetail);
		return "details/insert";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSubmit(@ModelAttribute CrossDetail crossDetail, BindingResult result, SessionStatus status) {
//		new OwnerValidator().validate(owner, result);
//		if (result.hasErrors()) {
//			return "owners/form";
//		}
//		else {
            System.out.println("+" + crossDetail + "|");
            this.service.saveOrUpdateDetail(crossDetail);
//            for (Map.Entry<String, Object> entry : result.getModel().entrySet()) {
//                System.out.printf("-%s: %s-\n", entry.getKey(), entry.getValue());
//            }
			//this.meteo.storeView(view);
			//status.setComplete();
            ModelAndView mav = new ModelAndView("redirect:/details/list/" + crossDetail.getDetTypeId());
//            mav.addObject()
//            mav.addObject("details", this.service.getAllDetails());
			return mav;///" + view.getId();
//		}
	}
}
