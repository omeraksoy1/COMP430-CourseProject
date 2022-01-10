package com.Project.backend.resources;

public class HeartDiseaseQueries {

    public static final String AverageAgeQuery = "SELECT AVG(age) FROM heartdisease";
    public static final String NumRecordsBySexQuery = "SELECT COUNT(*) FROM heartdisease h WHERE h.Sex = :sex";
    public static final String ChestPainTypeByHDPositiveQuery = "SELECT COUNT(*), ChestPainType FROM heartdisease h GROUP BY ChestPainType";
    public static final String AgeGroupsByHDPositiveQuery = "SELECT case when Age between 25 and 30 then '25-30' " +
                                "when Age between 30 and 35 then '30-35' when Age between 35 and 40 then '35-40' " +
                                "when Age between 40 and 45 then '40-45' when Age between 45 and 50 then '45-50' " +
                                "when Age between 50 and 55 then '50-55' when Age between 55 and 60 then '55-60' " +
                                "when Age between 60 and 65 then '60-65' when Age between 65 and 70 then '65-70' " +
                                "when Age between 70 and 75 then '70-75' when Age between 75 and 80 then '75-80' " +
                                "end AS `Range`, count(1) AS `Count` FROM heartdisease " +
                                "GROUP BY `Range` ORDER BY `Range` asc;";
    public static final String BPGroupsByHDPositiveQuery = "SELECT case " +
                                "when RestingBP between 70 and 80 then '70-80' when RestingBP between 80 and 90 then '80-90' " +
                                "when RestingBP between 90 and 100 then '90-100' when RestingBP between 100 and 110 then '100-110' " +
                                "when RestingBP between 110 and 120 then '110-120' when RestingBP between 120 and 130 then '120-130' " +
                                "when RestingBP between 130 and 140 then '130-140' when RestingBP between 140 and 150 then '140-150' " +
                                "when RestingBP between 150 and 160 then '150-160' when RestingBP between 160 and 170 then '160-170' " +
                                "when RestingBP between 170 and 180 then '170-180' when RestingBP between 180 and 190 then '180-190' " +
                                "when RestingBP between 190 and 200 then '190-200' else 'Unknown' end AS `Range`, " +
                                "count(1) AS `Count` FROM heartdisease GROUP BY `Range` ORDER BY `Range` asc;";
    public static final String STSlopeGroupsByHDPositiveQuery = "SELECT ST_slope, COUNT(*) FROM heartdisease " +
                                                                "WHERE HeartDisease = 1 GROUP BY ST_slope;";

}
