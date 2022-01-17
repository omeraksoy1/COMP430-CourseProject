package com.Project.backend.queries;

public class HeartDiseaseIndicatorQueries {
    public static final String HighBloodPressureByHDPositiveQuery = "SELECT HighBP, COUNT(*) FROM heartdiseaseindicators " +
                                "WHERE HeartDiseaseorAttack = 1 GROUP BY HighBP;";
    public static final String HighCholesterolByHDPositiveQuery = "SELECT HighChol, COUNT(*) FROM heartdiseaseindicators " +
                                "WHERE HeartDiseaseorAttack = 1 GROUP BY HighChol;";
    public static final String BMIGroupsByHDPositiveQuery = "SELECT case when BMI between 0 and 18.5 then 'Underweight' " +
                                "when BMI between 18.5 and 25 then 'Healthy' when BMI between 25 and 30 then 'Overweight' " +
                                "else 'Obese' end AS `Range`, count(1) AS `Count` FROM heartdiseaseindicators " +
                                "WHERE HeartDiseaseorAttack = 1 GROUP BY `Range` ORDER BY `Range` asc;";
    public static final String SmokerByHDPositiveQuery = "SELECT Smoker, COUNT(*) FROM heartdiseaseindicators " +
                                "WHERE HeartDiseaseorAttack = 1 GROUP BY Smoker;";
    public static final String StrokeByHDPositiveQuery = "SELECT Stroke, COUNT(*) FROM heartdiseaseindicators " +
                                "WHERE HeartDiseaseorAttack = 1 GROUP BY Stroke;";
    public static final String DiabetesByHDPositiveQuery = "SELECT Diabetes, COUNT(*) FROM heartdiseaseindicators " +
                                "WHERE HeartDiseaseorAttack = 1 GROUP BY Diabetes;";
    public static final String PhysActivityByHDPositiveQuery = "SELECT PhysActivity, COUNT(*) FROM heartdiseaseindicators " +
                                "WHERE HeartDiseaseorAttack = 1 GROUP BY PhysActivity;";
    public static final String FruitsByHDPositiveQuery = "SELECT Fruits, COUNT(*) FROM heartdiseaseindicators " +
                                "WHERE HeartDiseaseorAttack = 1 GROUP BY Fruits;";
    public static final String VeggiesByHDPositiveQuery = "SELECT Veggies, COUNT(*) FROM heartdiseaseindicators " +
                                "WHERE HeartDiseaseorAttack = 1 GROUP BY Veggies;";
    public static final String HeavyAlcoholConsumptionByHDPositiveQuery = "SELECT HvyAlcoholConsump, COUNT(*) FROM heartdiseaseindicators " +
                                "WHERE HeartDiseaseorAttack = 1 GROUP BY HvyAlcoholConsump;";
    public static final String AnyHealthcareByHDPositiveQuery = "SELECT AnyHealthcare, COUNT(*) FROM heartdiseaseindicators " +
            "WHERE HeartDiseaseorAttack = 1 GROUP BY AnyHealthcare;";
    public static final String NoDoctorBCofCostByHDPositiveQuery = "SELECT NoDocbcCost, COUNT(*) FROM heartdiseaseindicators " +
            "WHERE HeartDiseaseorAttack = 1 GROUP BY NoDocbcCost;";
}
