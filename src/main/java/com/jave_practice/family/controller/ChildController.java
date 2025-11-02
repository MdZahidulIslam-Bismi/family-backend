package com.jave_practice.family.controller;

import com.jave_practice.family.entity.Child;
import com.jave_practice.family.entity.Family;
import org.springframework.http.HttpStatus;
import com.jave_practice.family.service.ChildService;
import com.jave_practice.family.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/children")
@CrossOrigin(origins = "*")
public class ChildController {

    @Autowired
    private ChildService childService;

    @Autowired
    private FamilyService familyService;

    // Get all children (with dynamic parentsName)
    @GetMapping
    public List<Child> getAllChildren() {
        return childService.getAllChildren();
    }

    // Create a new child
//    @PostMapping(consumes = "application/json", produces = "application/json")
//    public Child createChild(@RequestBody Child child) {
//        // Ensure the child is linked to an existing family
//        if (child.getFamily() != null && child.getFamily().getId() != null) {
//            Family family = familyService.getFamilyById(child.getFamily().getId());
//            child.setFamily(family);
//        }
//        return childService.createChild(child);
//    }



    @PostMapping(consumes = "application/json", produces = "application/json")
    public Child createChild(@RequestBody Child child) {
        if (child.getFamily() != null && child.getFamily().getId() != null) {
            Family family = familyService.getFamilyById(child.getFamily().getId());
            System.out.println("Linking child to family: " + family.getName());
            child.setFamily(family);
        } else {
            System.out.println("No family ID provided");
        }
        return childService.createChild(child);
    }


    // Get a single child by ID
    @GetMapping("/{id}")
    public Child getChildById(@PathVariable Long id) {
        return childService.getChildById(id);
    }

    // Delete a child by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChild(@PathVariable Long id) {
        try {
            childService.deleteChild(id);
            return ResponseEntity.ok("Child deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Child not found with ID: " + id);
        }
    }

}