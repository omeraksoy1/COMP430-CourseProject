package com.Project.backend.resources;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class DiscreteResult {

    public ArrayList<String> content;

    public DiscreteResult() {

    }

    public DiscreteResult(ArrayList<String> content) {
        this.content = new ArrayList<>(content);
    }

    public ArrayList<String> getContent() {
        return this.content;
    }

    void setContent(ArrayList<String> content) {
        this.content = content;
    }

    public ArrayList<String> addExponentialNoise(double sensitivity, double epsilon) {
        //ArrayList<String> content = this.getContent();
        Map<String, Long> occurences = this.getContent().stream().collect(Collectors
                                            .groupingBy(e -> e, Collectors.counting()));
        ArrayList<String> res = new ArrayList<>();
        for (var entry : occurences.entrySet()) {
            res.add(entry.getKey());
        }
        return res;
    }
}
