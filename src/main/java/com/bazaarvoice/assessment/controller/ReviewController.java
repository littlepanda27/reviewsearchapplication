package com.bazaarvoice.assessment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by teje0687 on 8/11/19.
 */
@Controller
public class ReviewController {
    @RequestMapping(path="/", method= RequestMethod.GET)
    public String goHome(){
        return "index";
    }
}
