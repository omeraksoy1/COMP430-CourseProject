package com.Project.backend.resources;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import org.apache.commons.math3.distribution.LaplaceDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;


public class NumericResult {

    public ArrayList<Double> content;

    public NumericResult() {
    }

    public NumericResult(ArrayList<Double> content) {
        this.content = new ArrayList<Double>(content);
    }

    public ArrayList<Double> getContent() {
        return this.content;
    }

    public void setContent(ArrayList content) {
        this.content = content;
    }

    public void addLaplaceNoise(double sensitivity, double epsilon) {

        ArrayList<Double> perturbed = new ArrayList<Double>();
        LaplaceDistribution laplaceDistribution = new LaplaceDistribution(0, sensitivity / epsilon);

        double noise[] = new double[content.size()];
        noise = laplaceDistribution.sample(noise.length);

        for (int i = 0; i < noise.length; i++) {
            perturbed.add(i,(Double) this.content.get(i) + noise[i]);
        }

        this.setContent(perturbed);

    }

    public ArrayList<Double> addGaussianNoise(double sensitivity, double epsilon) {

//        delta = 10e-5
//        sigma = np.sqrt(2 * np.log(1.25 / delta)) * 1 / epsilon
//        vals_gauss = [np.random.normal(loc=0, scale=sigma) for x in range(100000)]
//        def gaussian_mech_RDP_vec(vec, sensitivity, alpha, epsilon):
//        sigma = np.sqrt((sensitivity**2 * alpha) / (2 * epsilon))
//        return [v + np.random.normal(loc=0, scale=sigma) for v in vec]
        ArrayList<Double> perturbed = new ArrayList<Double>();
        LaplaceDistribution laplaceDistribution = new LaplaceDistribution(0, sensitivity / epsilon);

        double noise[] = new double[content.size()];
        noise = laplaceDistribution.sample(noise.length);

        for (int i = 0; i < noise.length; i++) {
            perturbed.add(i, (Double) this.content.get(i) + noise[i]);
        }

        return perturbed;
    }

    public void round(int places) {
        if (places < 0) throw new IllegalArgumentException();

        for (int i = 0; i < this.content.size(); i++) {
            BigDecimal bd = BigDecimal.valueOf(this.getContent().get(i));
            bd = bd.setScale(places, RoundingMode.HALF_UP);

            this.getContent().set(i, bd.doubleValue());
        }
    }

}
