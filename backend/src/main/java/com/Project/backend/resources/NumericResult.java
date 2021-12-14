package com.Project.backend.resources;

import java.util.ArrayList;
import org.apache.commons.math3.distribution.LaplaceDistribution;

public class NumericResult {

    public ArrayList<Double> content;

    public NumericResult() {

    }

    public NumericResult(ArrayList<Double> content) {
        this.content = new ArrayList<Double>(content);
    }

    public ArrayList getContent() {
        return this.content;
    }

    void setContent(ArrayList content) {
        this.content = content;
    }

    public ArrayList<Double> addLaplaceNoise(double sensitivity, double epsilon) {

        ArrayList<Double> perturbed = new ArrayList<Double>();
        LaplaceDistribution laplaceDistribution = new LaplaceDistribution(0, sensitivity / epsilon);

        double noise[] = new double[content.size()];
        noise = laplaceDistribution.sample(noise.length);

        for (int i = 0; i < noise.length; i++) {
            perturbed.add(i,(Double) this.content.get(i) + noise[i]);
        }

        return perturbed;

    }

}
