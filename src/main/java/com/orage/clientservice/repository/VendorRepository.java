package com.orage.clientservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.orage.clientservice.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

	boolean existsByVendorCode(String valueOf);

	Page<Vendor> findByCompanyNameContainingIgnoreCase(String companyName, Pageable pageable);
}
