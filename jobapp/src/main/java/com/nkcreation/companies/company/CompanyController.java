package com.nkcreation.companies.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService service;

    @GetMapping
    public ResponseEntity<List<Company>> findAllCompanies(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        service.createCompany(company);
        return new ResponseEntity<>("Company Create Successfully",HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
          var company=  service.findById(id);
          return new ResponseEntity<>(company,HttpStatus.OK);
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){

       var isDeleted= service.deleteCompany(id);
       if(isDeleted){
           return new ResponseEntity<>("Deleted Successfylly",HttpStatus.OK);
       }
       else{
           return  new ResponseEntity<>("Can not be delete with this id"+id,HttpStatus.NOT_FOUND);
       }
    }

    @PutMapping
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company company){

        var isUpdated=service.updateCompany(id,company);

        if(isUpdated){
            return new ResponseEntity<>("Company Updated successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Can not update company with id"+id,HttpStatus.NOT_FOUND);
        }
    }
}
