package com.jave_practice.family.service;

import com.jave_practice.family.entity.Child;
import com.jave_practice.family.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChildService {

    private final ChildRepository childRepository;

    public List<Child> getAllChildren() {
        return childRepository.findAll();
    }

    public Child createChild(Child child) {
        return childRepository.save(child);
    }

    public Child getChildById(Long id) {
        return childRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Child not found with id: " + id));
    }

    public void deleteChild(Long id) {
        childRepository.deleteById(id);
    }
}
