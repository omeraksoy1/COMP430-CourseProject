package com.Project.backend.model;

import com.Project.backend.Enums.*;

import javax.persistence.*;

@Entity
@Table(name = "heartDisease")
public class heartDisease {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer age;
    private Sex sex;
    private String ChestPainType;
    private Integer RestingBP;
    private Integer Cholestrol;
    private Integer FastingBS;
    private String RestingECG;
    private Integer MaxHR;
    private String ExerciseAngina;
    private Integer Oldpeak;
    private ST_Slope ST_Slope;
    private Integer HeartDisease;

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public String getChestPainType() {
        return ChestPainType;
    }

    public Integer getRestingBP() {
        return RestingBP;
    }

    public Integer getCholestrol() {
        return Cholestrol;
    }

    public Integer getFastingBS() {
        return FastingBS;
    }

    public String getRestingECG() {
        return RestingECG;
    }

    public Integer getMaxHR() {
        return MaxHR;
    }

    public String getExerciseAngina() {
        return ExerciseAngina;
    }

    public Integer getOldpeak() {
        return Oldpeak;
    }

    public com.Project.backend.Enums.ST_Slope getST_Slope() {
        return ST_Slope;
    }

    public Integer getHeartDisease() {
        return HeartDisease;
    }
}
