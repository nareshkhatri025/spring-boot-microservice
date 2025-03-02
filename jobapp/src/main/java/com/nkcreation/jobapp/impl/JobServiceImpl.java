package com.nkcreation.jobapp.impl;

import com.nkcreation.jobapp.job.Job;
import com.nkcreation.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class JobServiceImpl implements JobService {

    List<Job> jobs=new ArrayList<>();

    @Override
    public List<Job> findAll() {
       return  jobs;
    }

    @Override
    public void createJob(Job job) {

        Long jobId= (long) jobs.size()+1;
        job.setId(jobId);
        jobs.add(job);
    }

    @Override
    public Job findById(Long id) {
        for(Job job:jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJob(Long id) {
        return jobs.removeIf(job -> job.getId().equals(id));
    }

    @Override
    public boolean updateJob(Long id, Job job) {


        for(int i=0; i<jobs.size();i++){

            if(jobs.get(i).getId().equals(id)){
               jobs.get(i).setJobName(job.getJobName());
                jobs.get(i).setJobDescription(job.getJobDescription());
                jobs.get(i).setLocation(job.getLocation());
                jobs.get(i).setMaxSalary(job.getMaxSalary());
                jobs.get(i).setMinSalary(job.getMinSalary());
            return  true;
            }
        }


        return false;
    }
}
