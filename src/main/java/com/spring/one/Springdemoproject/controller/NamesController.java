package com.spring.one.Springdemoproject.controller;

import com.spring.one.Springdemoproject.models.Names;
import com.spring.one.Springdemoproject.repository.MongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class NamesController {

    @Autowired
    private MongoDbService dataBase;

    @RequestMapping("/")
    public String showMainPage() {
        return "index";
    }
    @RequestMapping (value = "/names", method= RequestMethod.POST)
    String createObject(@RequestParam("name") String theName,
                        @RequestParam("idNumber") int theIdNumber,
                        @RequestParam(name = "status", defaultValue = "unchecked") String status,
                        Model model) {

        boolean theStatus = status.equals("on");
        Names createdName = new Names(theName, theStatus, theIdNumber);
        dataBase.create(createdName);
        model.addAttribute("names", dataBase.findAll());
        return "dataFromDb";
    }

    @GetMapping(value = "/PostNewName")
    String openForm() {
        return "PostNewName";
    }

    @RequestMapping(value = "/names/delete/{id}")//DELETE
    public String deleteObejct(@PathVariable("id") String id, Model model) {
         dataBase.deleteById(id);
         model.addAttribute("names", dataBase.findAll());
         return "dataFromDb";
    }

    @RequestMapping(value = "/names" , method = RequestMethod.GET)
    public String showNames(Model model) {
        model.addAttribute("names", dataBase.findAll());
        return "dataFromDb";
    }

    @RequestMapping(value = "names/{id}", method = RequestMethod.GET)
    public String findById (@PathVariable("id") String id, Model model) {
        model.addAttribute("name", dataBase.findById(id));
        return "name";
    }

    @RequestMapping(value = "names/{id}", method = RequestMethod.PUT)
    Names update(@RequestBody Names name, @PathVariable String id) {
        dataBase.update(name, id);
        return name;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound() {
    }

}
