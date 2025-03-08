package com.nkcreation.jobapp.job;

import jakarta.validation.constraints.NotBlank;

public class JobDTO {

	@NotBlank(message="Job Title can not be blank.")
	private String title;
	
	@NotBlank(message="Job Description can not be blank")
	private String description;
	
	@NotBlank(message="Job Max Salary can not be blank")
	private String maxSalary;
	
	@NotBlank(message="Job Min Salary can not be blank")
	private String minSalary;

	@NotBlank(message="Job Location can not be blank")
	private String location;
	
	@NotBlank(message="Company id is required to create job")
	
	private Long company_id;
	
	
	public Long getCompany_id() {
		return company_id;
	}

	public void setCompany_id(Long company_id) {
		this.company_id = company_id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
