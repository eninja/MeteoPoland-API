package pl.eninja.meteo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class WelcomeController {

    @RequestMapping("/")
    public ModelAndView redirectToSwagger() {
        return new ModelAndView("redirect:/swagger-ui.html#/");
    }
}
