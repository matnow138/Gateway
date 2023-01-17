package com.kodilla.gateway;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletResponse response) {
        int status = response.getStatus();
        if ( status == HttpStatus.NOT_FOUND.value()) {
            System.out.println("Error with code " + status + " Happened!");
            return new ModelAndView("error-404");
        } else if (status == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            System.out.println("Error with code " + status + " Happened!");
            return new ModelAndView("error-500");
        }
        System.out.println(status);
        return new ModelAndView("error");
    }
}