package com.MPFE.PracticaTendenciaSoftware.controller;

import java.util.List;

import com.MPFE.PracticaTendenciaSoftware.model.EmailTemplates;
import com.MPFE.PracticaTendenciaSoftware.repository.emailTempletesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmailTemplatesController {

    @Autowired
    private emailTempletesRepository repository;

    @GetMapping("/emailTemp")
    public List<EmailTemplates> getEmailTempletes() {
        return repository.findAll();
    }

    @RequestMapping(value = "/emailTemp/id/{id}", method = RequestMethod.GET)
    public EmailTemplates getEmailTempById(@PathVariable("id") long id) {
        return repository.findById(id).orElse(new EmailTemplates());
    }

}
