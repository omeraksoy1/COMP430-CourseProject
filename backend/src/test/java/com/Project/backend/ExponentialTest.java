package com.Project.backend;

import com.Project.backend.resources.DiscreteResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ExponentialTest {

    @Test
    void testLaplaceNoise() {
        double sensitivity = 1.0;
        double epsilon = 0.01;

        ArrayList<String> content = new ArrayList<>(Arrays.asList("this", "is", "a", "test", "dataset", "for",
                                                                "exponential", "mechanism"));

        DiscreteResult result = new DiscreteResult(content);
        ArrayList<String> perturbed = result.addExponentialNoise(sensitivity, epsilon);

        for (int i = 0; i < perturbed.size(); i++) {
            System.out.println(perturbed.get(i));
        }
    }

}
