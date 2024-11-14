package com.orage.clientservice.service;

import com.orage.clientservice.dto.CompanyDTO;
import com.orage.clientservice.model.Profile;
import com.orage.clientservice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository profileRepository) {

        this.companyRepository = profileRepository;
    }

    public void saveCompany(CompanyDTO companyDTO) {
        Profile profile = new Profile();
        
        // Decode Base64 logo to byte[] if provided
        if (companyDTO.getLogo() != null) {
            profile.setLogo(Base64.getDecoder().decode(companyDTO.getLogo()));
        }

        // Map other fields from CompanyDTO to Profile entity
        profile.setCompanyName(companyDTO.getCompanyName());
        profile.setCurrency(companyDTO.getCurrency());
        profile.setCountry(companyDTO.getCountry());
        profile.setState(companyDTO.getState());
        profile.setCity(companyDTO.getCity());
        profile.setAddress(companyDTO.getAddress());
        profile.setEmail(companyDTO.getEmail());
        profile.setPhone(companyDTO.getPhone());
        profile.setGstin(companyDTO.getGstin());
        profile.setContactName(companyDTO.getContactName());
        profile.setPinCode(companyDTO.getPinCode());
        profile.setWebsite(companyDTO.getWebsite());
        profile.setTaxationType(companyDTO.getTaxationType());
        profile.setServiceTaxNo(companyDTO.getServiceTaxNo());
        profile.setBankName(companyDTO.getBankName());
        profile.setBranchName(companyDTO.getBranchName());
        profile.setAdCode(companyDTO.getAdCode());
        profile.setUpiId(companyDTO.getUpiId());
        profile.setAccountNumber(companyDTO.getAccountNumber());
        profile.setIfscCode(companyDTO.getIfscCode());
        profile.setSwiftCode(companyDTO.getSwiftCode());
        profile.setAccountHolderName(companyDTO.getAccountHolderName());
        profile.setTinNo(companyDTO.getTinNo());
        profile.setLst(companyDTO.getLst());
        profile.setPan(companyDTO.getPan());
        profile.setFassaiNo(companyDTO.getFassaiNo());
        profile.setDlNo(companyDTO.getDlNo());
        profile.setCst(companyDTO.getCst());
        profile.setTan(companyDTO.getTan());

        // Save Profile entity to database
        companyRepository.save(profile);
    }
}
