package org.proyectofinal.OnFieldTBS.services;

import org.proyectofinal.OnFieldTBS.domains.dtos.RequestCompany;
import org.proyectofinal.OnFieldTBS.domains.models.Company;
import org.proyectofinal.OnFieldTBS.domains.models.Employee;
import org.proyectofinal.OnFieldTBS.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CompanyService {

    private final CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public List<Company> getAllCompanies(){
        return repository.findAll();
    }

    public Optional<Company> getCompanyById(UUID id){
        return repository.findById(id);
    }

    public RequestCompany updateEmployees(String nif, RequestCompany requestCompany){
        Company companyUpdate = repository.findByNif(nif);
        companyUpdate.setName(requestCompany.name); // TODO : preguntar Gerald
        companyUpdate.setPhone(requestCompany.phone);
        companyUpdate.setEmail(requestCompany.email);
        repository.save(companyUpdate);

        return requestCompany;
    }

    public boolean deleteCompany(UUID id){
        if (getCompanyById(id).isPresent()){
            repository.deleteById(getCompanyById(id).get().getId());
            return true;
        }
        return false;
    }


}
