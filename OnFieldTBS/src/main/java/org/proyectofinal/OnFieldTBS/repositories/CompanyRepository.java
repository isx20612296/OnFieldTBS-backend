package org.proyectofinal.OnFieldTBS.repositories;

import org.proyectofinal.OnFieldTBS.domains.models.Company;
import org.proyectofinal.OnFieldTBS.domains.models.projections.CompanyStandard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
    Company findByNif(String email);
    Optional<CompanyStandard> getCompanyById(UUID id);
    List<CompanyStandard>findBy();

}
