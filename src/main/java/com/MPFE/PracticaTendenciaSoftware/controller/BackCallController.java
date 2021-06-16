package com.MPFE.PracticaTendenciaSoftware.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.MPFE.PracticaTendenciaSoftware.model.BackCall;
import com.MPFE.PracticaTendenciaSoftware.repository.backCallRepository;

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
public class BackCallController {

    @Autowired
    private backCallRepository repository;

    @GetMapping("/backcall")
    public List<BackCall> getBackCall() {
        return repository.findAll();
    }

    @PostMapping("/save-backcall")
    @ResponseBody
    public BackCall saveBackcall(@RequestBody BackCall backcall) {
        return repository.save(backcall);
    }

    @RequestMapping(value = "/backcall/id/{id}", method = RequestMethod.GET)
    public BackCall getBackCallById(@PathVariable("id") long id) {
        return repository.findById(id).orElse(new BackCall());
    }

    // Metodo no existente en Repositorio
    /*
     * @RequestMapping(value = "/backcall/name/{name}", method = RequestMethod.GET)
     * public List<BackCall> getBackCallByName(@PathVariable("name") String name) {
     * return repository.findByName(name); }
     */

}
