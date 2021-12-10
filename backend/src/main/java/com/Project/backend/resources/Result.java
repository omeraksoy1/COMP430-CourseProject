package com.Project.backend.resources;

import java.util.ArrayList;

public abstract class Result {

    public ArrayList content; // json - string dönüşümleri?
    int size;

    public ArrayList getContent() {
        return this.content;
    }

    void setContent(ArrayList content) {
        this.content = content;
    }

}
