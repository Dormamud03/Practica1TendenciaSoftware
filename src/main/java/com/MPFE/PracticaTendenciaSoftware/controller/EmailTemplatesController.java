package com.MPFE.PracticaTendenciaSoftware.controller;

import java.util.List;

import com.MPFE.PracticaTendenciaSoftware.model.EmailTemplates;
import com.MPFE.PracticaTendenciaSoftware.repository.emailTemplates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmailTemplatesController {

    @Autowired
    private emailTemplates repository;

    @GetMapping("/backcall")
    public List<EmailTemplates> getBackCall() {
        return repository.findAll();
    }

    @PostMapping("/save-backcall")
    @ResponseBody
    public EmailTemplates saveBackcall(@RequestBody EmailTemplates backcall) {
        return repository.save(backcall);
    }

    @RequestMapping(value = "/backcall/id/{id}", method = RequestMethod.GET)
    public EmailTemplates getBackCallById(@PathVariable("id") long id) {
        return repository.findById(id).orElse(new EmailTemplates());
    }

    // Metodo no existente en Repositorio
    /*
     * @RequestMapping(value = "/backcall/name/{name}", method = RequestMethod.GET)
     * public List<BackCall> getBackCallByName(@PathVariable("name") String name) {
     * return repository.findByName(name); }
     */

}
