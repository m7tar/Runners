package com.m7tar.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {
    private final RunRepository RunRepo;
    private RunController(RunRepository runRepo) {
        RunRepo = runRepo;
    }


    @GetMapping("")
    List<Run> findAll() {
        return RunRepo.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable int id) {
        Optional<Run> run = RunRepo.findById(id);
        if(run.isEmpty()){
            throw new RunNotFoundException()        ;
        } else {
            return run.get();
        }
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    void create(@RequestBody Run run){
        RunRepo.create(run);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping ("/{id}")
    void update(@RequestBody Run run, @PathVariable Integer id){
        RunRepo.update(run, id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable int id){
        RunRepo.delete(id);
    }
}
