package com.orage.clientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orage.clientservice.model.Profile;

public interface CompanyRepository extends JpaRepository<Profile, Long>{

}
