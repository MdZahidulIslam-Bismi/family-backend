package com.jave_practice.family.service;
import com.jave_practice.family.entity.Family;
import com.jave_practice.family.repository.FamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FamilyService {
    private final FamilyRepository  familyRepository;

    public Family postFamily(Family family){
        return familyRepository.save(family);
    }

    public List<Family> getAllfamily(){
        return familyRepository.findAll();
    }

    public Family getFamilyById(Long id) {
        return familyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Family not found with id: " + id));
    }

    // NEW: Update existing family
    public Family updateFamily(Long id, Family updatedFamily) {
        Family existingFamily = familyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Family not found with id: " + id));

        existingFamily.setName(updatedFamily.getName());
        existingFamily.setStreet(updatedFamily.getStreet());
        existingFamily.setCity(updatedFamily.getCity());
        existingFamily.setState(updatedFamily.getState());
        existingFamily.setZip(updatedFamily.getZip());

        return familyRepository.save(existingFamily);
    }

    public void deleteById(Long id) {
        familyRepository.deleteById(id);
    }

}