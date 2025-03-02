package com.nkcreation.jobapp.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    /*

    GET /jobs : Get All Jobs
    GET /jobs/{id} : Get specific job by id
    POST /jobs: Create a new job (request body should contain the job details)
    DELETE /jobs/{id} : delete specific job by id
    PUT /jobs/{id}: Update job by specific id
     */
    List<Job> jobs=new  ArrayList();
    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobs;
    }

}
