package com.Project.backend;

import com.Project.backend.resources.NumericResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LaplaceTest {

    @Test
    void testLaplaceNoise() {
        double sensitivity = 1.0;
        double epsilon = 0.01;

        ArrayList<Double> content = new ArrayList<>(Arrays.asList(12.4, 10.2, 22.1, 9.9, 18.2, 26.2));

        NumericResult result = new NumericResult(content);
        ArrayList<Double> perturbed = result.addLaplaceNoise(sensitivity, epsilon);

        for (int i = 0; i < perturbed.size(); i++) {
            System.out.println(perturbed.get(i));
        }
    }

}
