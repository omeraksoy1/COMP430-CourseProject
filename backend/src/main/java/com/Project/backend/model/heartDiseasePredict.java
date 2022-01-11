package com.Project.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "heartdiseasepredict")
public class heartDiseasePredict {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer male;
    private Integer age;
    private Integer education;
    private Integer currentSmoker;
    private Integer cigsPerDay;
    private Integer BPMeds;
    private Integer prevalentStroke;
    private Integer prevalentHyp;
    private Integer diabetes;
    private Integer totChol;
    private Integer sysBP;
    private Integer diaBP;
    private Integer BMI;
    private Integer heartRate;
    private Integer glucose;
    private Integer TenYearCHD;

}
