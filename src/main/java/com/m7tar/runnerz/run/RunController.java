package com.m7tar.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {
    /*this code is for using JdbcClient
    private final JdbcClientRunRepository RunRepo;
    private RunController(JdbcClientRunRepository runRepo) {
        RunRepo = runRepo;
    }*/
    private final RunRepository RunRepo;
    private final RunRepository runRepository;

    private RunController(RunRepository runRepo, RunRepository runRepository) {
        this.RunRepo = runRepo;
        this.runRepository = runRepository;
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
        //RunRepo.create(run);  JdbcClient
        RunRepo.save(run);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping ("/{id}")
    void update(@RequestBody Run run, @PathVariable Integer id){
        //RunRepo.update(run, id);  JdbcClient
        RunRepo.save(run);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable int id){
        //RunRepo.delete(id);   JdbcClient
        RunRepo.delete(runRepository.findById(id).get());
    }
    @GetMapping("/location/{location}")
    List<Run> findByLocation(@PathVariable Location location) {
        return RunRepo.findByLocation(location);
    }
}
