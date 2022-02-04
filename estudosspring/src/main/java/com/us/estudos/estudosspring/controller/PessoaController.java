package com.us.estudos.estudosspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.us.estudos.estudosspring.entity.Pessoa;
import com.us.estudos.estudosspring.repository.PessoaRepository;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class PessoaController {
    @Autowired
    private PessoaRepository _pessoaRepository;

    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public List<Pessoa> get() {
        return _pessoaRepository.findAll();
    }

    @RequestMapping(value="/pessoa/{id}", method=RequestMethod.GET)
    public ResponseEntity<Pessoa> getById(@PathVariable(value = "id") long id) {

        Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
        if (pessoa.isPresent())
            return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

}
