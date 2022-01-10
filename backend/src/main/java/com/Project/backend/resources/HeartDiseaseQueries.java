package com.Project.backend.resources;

public class HeartDiseaseQueries {

    public static final String AverageAgeQuery = "SELECT AVG(age) FROM heartdisease";
    public static final String NumRecordsBySexQuery = "SELECT COUNT(*) FROM heartdisease h WHERE h.Sex = :sex";
    public static final String ChestPainTypeByHDPositiveQuery = "SELECT COUNT(*), ChestPainType FROM heartdisease h GROUP BY ChestPainType";
    public static final String AgeGroupsByHDPositiveQuery = "select case when Age between 25 and 30 then '25-30' " +
                                "when Age between 30 and 35 then '30-35' when Age between 35 and 40 then '35-40' " +
                                "when Age between 40 and 45 then '40-45' when Age between 45 and 50 then '45-50' " +
                                "when Age between 50 and 55 then '50-55' when Age between 55 and 60 then '55-60' " +
                                "when Age between 60 and 65 then '60-65' when Age between 65 and 70 then '65-70' " +
                                "when Age between 70 and 75 then '70-75' when Age between 75 and 80 then '75-80' " +
                                "end as `Range`, count(1) as `Count` from heartdisease " +
                                "group by `Range` order by `Range` asc;";

}
