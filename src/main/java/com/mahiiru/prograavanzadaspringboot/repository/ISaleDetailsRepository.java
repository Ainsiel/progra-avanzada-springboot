package com.mahiiru.prograavanzadaspringboot.repository;

import com.mahiiru.prograavanzadaspringboot.model.SaleDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleDetailsRepository extends JpaRepository<SaleDetails, Long> {
}
