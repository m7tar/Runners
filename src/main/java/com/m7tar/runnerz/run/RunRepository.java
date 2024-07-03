package com.m7tar.runnerz.run;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface RunRepository extends ListCrudRepository<Run, Integer> {
    //@Query("SELECT ......") custom query
    List<Run> findByLocation(Location location);
}
