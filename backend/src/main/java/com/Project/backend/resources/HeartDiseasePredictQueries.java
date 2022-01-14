package com.Project.backend.resources;

public class HeartDiseasePredictQueries {
    public static final String AverageAgeQuery = "SELECT AVG(age) FROM heartdiseasepredict;";
    public static final String NumRecordsBySexQuery = "SELECT case when male = 0 then 'M' when male = 1 then 'F' " +
                                        "end as sex, COUNT(1) as `COUNT` FROM heartdiseasepredict GROUP BY `sex`;";
    public static final String EducationGroupsByHDPositiveQuery = "SELECT education, COUNT(*) FROM heartdiseasepredict " +
                                "WHERE TenYearCHD = 1 GROUP BY education ORDER BY education;";
    public static final String CurrentSmokerByHDPositiveQuery = "SELECT currentSmoker, COUNT(*) FROM heartdiseasepredict " +
                                "WHERE TenYearCHD = 1 GROUP BY currentSmoker;";
}
