package org.mysj.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "PATIENT")
public class PatientEntity extends AbstractJpaAuditable<Long>{

    @Column(name = "PATIENT_ID")
    private String patientID;
    @Column(name = "AGE")
    private Integer age;
    @Column(name= "NAME")
    private String name;



    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
