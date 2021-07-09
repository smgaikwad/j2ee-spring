package com.jpa.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.jpa.demo.entities.Student.ENTITY_NAME;

@Entity(name = ENTITY_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Student extends GeneralEntity {

    public static final String ENTITY_NAME = "student_data";
    public static final String STUDENT_ID = "student_id";
    public static final String STUDENT_NAME = "student_name";


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = STUDENT_ID)
    private Integer studentId;

    @Column(name = STUDENT_NAME)
    private String studentName;

    @PrePersist
    public void prePersist(){
        System.out.println("Your Entity "+ this +" is starting...!");
    }

    @PreUpdate
    public void preUpdate(){
        System.out.println("Your Entity "+ this +" is updating..!");
    }

    @PreRemove
    public void preRemove(){
        System.out.println("Your Entity "+ this +" is removing..!");
    }

    @PostLoad
    public void postLoad(){
        System.out.println("Your Entity "+ this +" is loaded successfully....");
    }

    @PostPersist
    public void postPersist(){
        this.setRegistrationDate(LocalDateTime.now());
        System.out.println("Your Entity "+ this +" is persisted successfully....");
    }

    @PostUpdate
    public void postUpdate(){
        this.setLastModifiedDate(LocalDateTime.now());
        System.out.println("Your Entity "+ this +" is updated successfully....");
    }

    @PostRemove
    public void postRemove(){
        System.out.println("Your Entity "+ this +" is removed successfully....");
    }
}
