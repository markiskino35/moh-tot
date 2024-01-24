package org.mysj;

import org.mysj.domain.PatientEntity;
import org.mysj.domain.PatientRepo;
import org.mysj.dto.PatientDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    private final PatientRepo patientRepo;

    //constructor to use in other method below
    public PatientController(PatientRepo patientRepo){
        this.patientRepo = patientRepo;
    }

    //POST
    @PostMapping("/patient")
    public Long createPatient(@RequestBody PatientDto patient){
        var entity = new PatientEntity();
        entity.setPatientID(patient.getPatientId());
        entity.setAge(patient.getAge());
        entity.setName(patient.getName());
        return patientRepo.save(entity).getId();
    }

    //GET
    @GetMapping("/patient/{id}")
    public PatientDto getPatient(@PathVariable("id") Long id){
        var entity = patientRepo.findById(id).orElseThrow();
        var patient = new PatientDto();
        patient.setPatientId(entity.getPatientID());
        patient.setName(entity.getName());
        patient.setAge(entity.getAge());
        return patient;
    }

    //DELETE
    @DeleteMapping("/patient/{id}")
    public void deletePatient(@PathVariable("id") Long id){
        patientRepo.deleteById(id);
    }

    //UPDATE
    @PutMapping("/patient/{id}")
    public void updatePatient(@PathVariable("id") Long id, @RequestBody PatientDto patient){

        var entity = patientRepo.findById(id).orElseThrow();

        entity.setPatientID(patient.getPatientId());
        entity.setAge(patient.getAge());
        entity.setName(patient.getName());

        patientRepo.save(entity);

    }
}
