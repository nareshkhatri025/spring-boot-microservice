package com.nkcreation.jobapp.impl;

import com.nkcreation.jobapp.job.Job;
import com.nkcreation.jobapp.job.JobRepository;
import com.nkcreation.jobapp.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

//    List<Job> jobs=new ArrayList<>();
    @Autowired
private JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
       return  jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {

     jobRepository.save(job);
    }

    @Override
    public Job findById(Long id) {

       return  jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job job) {

        try {
            Optional<Job> optionalJob = jobRepository.findById(id);

            if (optionalJob.isPresent()) {
                var jobs = optionalJob.get();
                jobs.setJobName(job.getJobName());
                jobs.setJobDescription(job.getJobDescription());
                jobs.setLocation(job.getLocation());
                jobs.setMaxSalary(job.getMaxSalary());
                jobs.setMinSalary(job.getMinSalary());
                jobRepository.save(job);
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
