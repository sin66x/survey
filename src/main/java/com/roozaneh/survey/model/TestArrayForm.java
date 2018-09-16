package com.roozaneh.survey.model;

import java.util.ArrayList;
import java.util.List;

public class TestArrayForm {
    List<TestModel> testModelList = new ArrayList<TestModel>();

    public List<TestModel> getTestModelList() {
        return testModelList;
    }

    public void setTestModelList(List<TestModel> testModelList) {
        this.testModelList = testModelList;
    }

    @Override
    public String toString() {
        return "TestArrayForm{" +
                "testModelList=" + testModelList +
                '}';
    }
}
