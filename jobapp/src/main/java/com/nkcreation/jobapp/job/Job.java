package com.nkcreation.jobapp.job;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nkcreation.jobapp.company.Company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobName;
    private String jobDescription;
    private String maxSalary;
    private String minSalary;
    private String location;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)  // Foreign key
    private Company company;

    public Job() {
    }

    public Job( String jobName, String jobDescription, String maxSalary, String minSalary, String location) {
       
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
