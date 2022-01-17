package com.Project.backend.queries;

public class HeartDiseasePredictQueries {
    public static final String AverageAgeQuery = "SELECT AVG(age) FROM heartdiseasepredict;";
    public static final String NumRecordsBySexQuery = "SELECT case when male = 0 then 'M' when male = 1 then 'F' " +
                                        "end as sex, COUNT(1) as `COUNT` FROM heartdiseasepredict GROUP BY `sex`;";
    public static final String EducationGroupsByHDPositiveQuery = "SELECT education, COUNT(*) FROM heartdiseasepredict " +
                                "WHERE TenYearCHD = 1 GROUP BY education ORDER BY education;";
    public static final String CurrentSmokerByHDPositiveQuery = "SELECT currentSmoker, COUNT(*) FROM heartdiseasepredict " +
                                "WHERE TenYearCHD = 1 GROUP BY currentSmoker;";
    public static final String CigsPerDayGroupsByHDPositiveQuery = "SELECT case when cigsPerDay between 0 and 10 then '0-10'" +
                                "when cigsPerDay between 10 and 20 then '10-20' when cigsPerDay between 20 and 30 then '20-30' " +
                                "when cigsPerDay between 30 and 40 then '30-40' when cigsPerDay between 40 and 50 then '40-50' " +
                                "when cigsPerDay between 50 and 60 then '50-60' else '60+' end AS `Range`, count(1) AS `Count` " +
                                "FROM heartdiseasepredict WHERE TenYearCHD = 1 GROUP BY `Range` ORDER BY `Range` asc;";
    public static final String BPMedsGroupsByHDPositiveQuery = "SELECT BPMeds, COUNT(*) FROM heartdiseasepredict " +
                                "WHERE TenYearCHD = 1 GROUP BY BPMeds;";
    public static final String PrevalentStrokeByHDPositiveQuery = "SELECT prevalentStroke, COUNT(*) FROM heartdiseasepredict " +
                                "WHERE TenYearCHD = 1 GROUP BY prevalentStroke;";
    public static final String PrevalentHypertensionBinaryByHDPositiveQuery = "SELECT prevalentHyp, COUNT(*) " +
                                "FROM heartdiseasepredict WHERE TenYearCHD = 1 GROUP BY prevalentHyp;";
    public static final String DiabetesByHDPositiveQuery = "SELECT diabetes, COUNT(*) FROM heartdiseasepredict " +
                                "WHERE TenYearCHD = 1 GROUP BY diabetes;";
    public static final String CholesterolGroupsByHDPositiveQuery = "SELECT case when totChol between 0 and 100 then '0-100' " +
                                "when totChol between 100 and 200 then '100-200' when totChol between 200 and 300 then '200-300' " +
                                "when totChol between 300 and 400 then '300-400' when totChol between 400 and 500 then '400-500' " +
                                "when totChol between 500 and 600 then '500-600' else '600+' end AS `Range`, count(1) AS `Count` " +
                                "FROM heartdiseasepredict WHERE TenYearCHD = 1 GROUP BY `Range` ORDER BY `Range` asc;";
    public static final String BMIGroupsByHDPositiveQuery = "SELECT case when BMI between 0 and 18.5 then 'Underweight' " +
                                "when BMI between 18.5 and 25 then 'Healthy' when BMI between 25 and 30 then 'Overweight' " +
                                "else 'Obese' end AS `Range`, count(1) AS `Count` FROM heartdiseasepredict " +
                                "WHERE TenYearCHD = 1 GROUP BY `Range` ORDER BY `Range` asc;";
}
