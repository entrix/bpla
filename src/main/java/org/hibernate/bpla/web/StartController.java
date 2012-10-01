package org.hibernate.bpla.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.bpla.Service;
import org.hibernate.bpla.domain.DelDetails;
import org.hibernate.bpla.domain.DetType;
import org.hibernate.bpla.domain.Detail;
import org.hibernate.bpla.persistence.HibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller
public class StartController {

    protected final Log logger = LogFactory.getLog(getClass());

    private Service service;

    @Autowired
    public StartController(Service service) {
        this.service = service;
    }

    @RequestMapping("/start")
    public ModelAndView startHandler() {

        String now = (new Date()).toString();

        logger.info("Returning hello view");

        return new ModelAndView("start", "now", now);
    }

    @RequestMapping("/")
    public String welcomeHandler() {
        return "welcome";
    }
//
//    @RequestMapping(value="/rsmcs.all")
//    public ModelMap rsmcsHandler() {
//        return new ModelMap("rsmcs", this.meteo.getRsmcs());
//    }
//
//    @RequestMapping("/rsmcs/{rsmcId}")
//    public ModelAndView rsmcHandler(@PathVariable("rsmcId") long rsmcId) {
//        ModelAndView mav = new ModelAndView("rsmcs/show");
//        mav.addObject(this.meteo.loadRsmc(rsmcId));
//        return mav;
//    }
//
////    @RequestMapping(value="/views.htm")
////    public ModelMap viewsHandler() {
////        Views views = new Views();
////        views.getViewList().addAll(this.meteo.getViews());
////        return new ModelMap(views);
////    }
//
    @RequestMapping(value="/details.all")
    public ModelMap detailsHandler() {
        return new ModelMap("details", this.service.getAllDetails());
    }

    @RequestMapping("/details/list/{detTypeId}")
    public ModelAndView listOfViewsHandler(@PathVariable("detTypeId") long detTypeId) {
        ModelAndView mav = new ModelAndView("views/list");
        DetType detType = this.service.getDetTypelById(detTypeId);
        mav.addObject(detType);
        mav.addObject("details", detType.getDetails());
//        mav.addObject("delViews", new DelViews());
        //logger.info("size=" + this.meteo.getViewsById(pointId).size());
        return mav;
    }

    @RequestMapping("/details/{id}")
    public ModelAndView viewHandler(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("details/show");
        mav.addObject("detail", this.service.getDetailById(id));
        return mav;
    }
//
//    @RequestMapping(value="/views.form1", method=RequestMethod.GET)
//    public String viewsForm1Handler(Model model) {
//        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        System.out.println(model);
//        if (model != null) {
//            for (Map.Entry<String, Object> entry : model.asMap().entrySet()) {
//                System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
//            }
//        }
//        logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//        return "welcome";
//    }
//
    @RequestMapping(value="/details.delete/{detTypeId}", method=RequestMethod.POST)
    public String viewsDeleteHandler(@PathVariable("detTypeId") long detTypeId, @RequestParam("submit") String submit, @ModelAttribute("delVievs") DelDetails delDetails) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

////        for (DelView delView : delViews.getDelViews()) {
////            System.out.println(delView.getDelete());
////            System.out.println(delView.getView());
////        }

        System.out.println(submit);

        for (Long l : delDetails.getDeletes())
            System.out.println(l);
//
//        for (Long l : delViews.getPointIds())
//            System.out.println(l);
//
//        for (Double d : delViews.getForces())
//            System.out.println(d);

        List<Detail> views = new ArrayList<Detail>();
        for (Long l : delDetails.getDeletes()) {
            int ind = delDetails.getIds().indexOf(l);
            Detail detail = new Detail();

            detail.setId(detail.getId());
            detail.setDetTypeId(detTypeId);
            detail.setState(detail.getState());
            detail.setRaids(detail.getRaids());

            if (submit.equals("Delete"))
                this.service.deleteDetail(detail);
            else
                this.service.saveOrUpdateDetail(detail);
        }

        logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return "redirect:/views/list/" + detTypeId;
    }

    @RequestMapping(value = "/details/search", method = RequestMethod.GET)
    public String setup1Form(@RequestParam("id") long id) {
        System.out.println("pointId -------> " + id);
//        model.addAttribute("view", new View());
        return "views/search";
    }
//
//    @RequestMapping(value = "/views/search", method = RequestMethod.POST)
//    public String setup2Form(@RequestParam("pointId") String pointId) {
//        System.out.println("pointId -------> " + pointId);
////        model.addAttribute("view", new View());
//        return "redirect:/views/list/" + pointId;
//    }
}
