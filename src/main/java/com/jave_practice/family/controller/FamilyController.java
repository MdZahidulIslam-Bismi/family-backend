package com.jave_practice.family.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.jave_practice.family.entity.Family;
import com.jave_practice.family.service.FamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FamilyController {

    private final FamilyService familyService;

//    @PostMapping("/family")
//    public Family postFamily(@RequestBody Family family){
//        return  familyService.postFamily(family);
//    }


    @PostMapping(value = "/family", consumes = "application/json", produces = "application/json")
    public Family postFamily(@RequestBody Family family) {
        return familyService.postFamily(family);
    }

    @GetMapping("/family")
    public List<Family> getAllFamily(){
        return familyService.getAllfamily();
    }


    //NEW: Get a family by ID (needed for edit page)
    @GetMapping("/family/{id}")
    public Family getFamilyById(@PathVariable Long id) {
        return familyService.getFamilyById(id);
    }

    @PutMapping("/family/{id}")
    public Family updateFamily(@PathVariable Long id, @RequestBody Family family) {
        return familyService.updateFamily(id, family);
    }

    @DeleteMapping("/family/{id}")
    public ResponseEntity<String> deleteFamily(@PathVariable Long id) {
        try {
            familyService.deleteById(id);
            return ResponseEntity.ok("Family member deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Family member not found!");
        }
    }


}
