package com.Project.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "heartDisease")
public class heartDisease {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer age;
    private String sex;
    private String ChestPainType;
    private Integer RestingBP;
    private Integer Cholestrol;
    private Integer FastingBS;
    private String RestingECG;
    private Integer MaxHR;
    private String ExerciseAngina;
    private Integer Oldpeak;
    private String ST_Slope;
    private Integer HeartDisease;
}
