package com.Project.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "heartdiseaseindicator")
public class heartDiseaseIndicator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer HeartDiseaseorAttack;
    private Integer HighBP;
    private Integer HighChol;
    private Integer CholCheck;
    private Double BMI;
    private Integer Smoker;
    private Integer Stroke;
    private Integer Diabetes;
    private Integer PhysActivity;
    private Integer Fruits;
    private Integer Veggies;
    private Integer HvyAlcoholConsump;
    private Integer AnyHealthcare;
    private Integer NoDocbcCost;
    private Integer GenHlth;
    private Integer MentHlth;
    private Integer PhysHlth;
    private Integer DiffWalk;
    private Integer Sex;
    private Integer Age;
    private Integer Education;
    private Integer Income;
}
