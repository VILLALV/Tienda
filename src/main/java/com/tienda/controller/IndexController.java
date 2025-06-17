
package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
    
    @RequestMapping("/") //Url al que responde
    public String index() {
        return "index"; // nombre de la vista en templates a mostrar
    }
    
    @RequestMapping("/informacion") //Url al que responde
    public String info() {
        return "info"; // nombre de la vista en templates a mostrar
    }   
    
}
