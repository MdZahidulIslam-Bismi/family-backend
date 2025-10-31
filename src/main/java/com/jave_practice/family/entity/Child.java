package com.jave_practice.family.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "children")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "family_id")
    @JsonBackReference("family-child-ref")
    private Family family;

    // Virtual property for JSON
    @Transient
    @JsonProperty("parentsName")
    public String getParentsName() {
        if (family != null) return family.getName();
        return null;
    }



    // Standard getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Family getFamily() { return family; }
    public void setFamily(Family family) { this.family = family; }
}
