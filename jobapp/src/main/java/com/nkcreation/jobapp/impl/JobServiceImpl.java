package com.nkcreation.jobapp.impl;

import com.nkcreation.jobapp.company.CompanyRepository;
import com.nkcreation.jobapp.job.Job;
import com.nkcreation.jobapp.job.JobDTO;
import com.nkcreation.jobapp.job.JobRepository;
import com.nkcreation.jobapp.job.JobService;
import com.nkcreation.jobapp.job.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

//    List<Job> jobs=new ArrayList<>();
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public List<Job> findAll() {
		return jobRepository.findAll();
	}

	@Override
	public void createJob(JobDTO jobDTO) {
		
		
		var isExist=companyRepository.existsById(jobDTO.getCompany_id());
		if(isExist) {
			Job job=new Job(jobDTO.getTitle(),jobDTO.getDescription(),jobDTO.getMaxSalary(),jobDTO.getMinSalary(),jobDTO.getLocation());
			
			jobRepository.save(job);
		}else {
			throw new ResourceNotFoundException("Company not found with this id"+jobDTO.getCompany_id());
		}

		
	}

	@Override
	public Job findById(Long id) {

		return jobRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteJob(Long id) {
		try {
			var isExist = jobRepository.existsById(id);

			if (isExist) {
				jobRepository.deleteById(id);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
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
				jobRepository.save(jobs);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
