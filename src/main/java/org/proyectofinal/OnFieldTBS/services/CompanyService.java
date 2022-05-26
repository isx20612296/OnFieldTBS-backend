package org.proyectofinal.OnFieldTBS.services;

import org.proyectofinal.OnFieldTBS.domains.dtos.RequestCompany;
import org.proyectofinal.OnFieldTBS.domains.dtos.RequestLocation;
import org.proyectofinal.OnFieldTBS.domains.dtos.ResponseLocation;
import org.proyectofinal.OnFieldTBS.domains.models.Company;
import org.proyectofinal.OnFieldTBS.domains.models.projections.CompanyStandard;
import org.proyectofinal.OnFieldTBS.exceptions.NotFoundException;
import org.proyectofinal.OnFieldTBS.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    private final LocationService locationService;

    @Autowired
    public CompanyService(CompanyRepository repository, LocationService locationService) {
        this.repository = repository;
        this.locationService = locationService;
    }

    public List<CompanyStandard> getAllCompanies(){
        return repository.findBy();
    }

    public Optional<CompanyStandard> getCompanyById(UUID id){
        String errorMessage = String.format("The company with %s does not exist", id);
        return Optional.ofNullable(repository.getCompanyById(id).orElseThrow(() -> new NotFoundException(errorMessage)));
    }

    public Optional<CompanyStandard> getCompanyByName(String name){
        String errorMessage = String.format("The company with %s does not exist", name);
        return Optional.ofNullable(repository.getCompanyByName(name).orElseThrow(() -> new NotFoundException(errorMessage)));
    }


    public List<ResponseLocation>getLocation(List<RequestLocation> addresses){
        Predicate<RequestLocation> existCompany = c -> repository.getCompanyByName(c.companyName).isEmpty();
        addresses.stream()
                .filter(existCompany)
                .findAny()
                .ifPresent(company -> {
                    String errorMessage = String.format("The company %s does not exist", company.companyName);
                    throw new NotFoundException(errorMessage);
                });
        return locationService.getLocation(addresses);
    }


    public RequestCompany updateCompany(String nif, RequestCompany requestCompany){
        Company companyUpdate = repository.findByNif(nif);
        companyUpdate.setName(requestCompany.name);
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
