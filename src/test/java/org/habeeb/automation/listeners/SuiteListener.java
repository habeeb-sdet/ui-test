package org.habeeb.automation.listeners;

import org.testng.Assert;
import org.testng.IAlterSuiteListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuiteListener implements ISuiteListener, IAlterSuiteListener {

    @Override
    public void alter(List<XmlSuite> suites) {
//        modifySuiteBasedOnFeatureFile(suites);
        modifySuiteBasedOnXmlTests(suites);
    }

    @Override
    public void onStart(ISuite suite) {

    }

    @Override
    public void onFinish(ISuite suite) {
    }

    private void modifySuiteBasedOnFeatureFile(List<XmlSuite> suites){
        XmlSuite suite = suites.get(0);
        suite.setDataProviderThreadCount(Integer.parseInt(System.getProperty("threadCount")));
        XmlTest xmlTest = suite.getTests().get(0);


        String basePath = "C:\\Users\\habeeb_mohamed\\Desktop\\Habeeb\\Frameworks\\UiTest\\UiTest\\src\\test\\resources\\features";
        String[] features = System.getProperty("features").split(",");
        if(features[0].equals("all")){
            features = new File(basePath).list();
        }


        StringBuilder featureList = new StringBuilder();
        for(int i=0; i< features.length; i++){
            featureList.append(basePath).append("\\").append(features[i]);
            if(i != features.length-1){
                featureList.append(",");
            }
        }

        xmlTest.addParameter("feature", featureList.toString());

        IAlterSuiteListener.super.alter(suites);
    }

    private void modifySuiteBasedOnXmlTests(List<XmlSuite> suites){
        XmlSuite suite = suites.get(0);
        suite.setParallel(XmlSuite.ParallelMode.TESTS);
        suite.setThreadCount(Integer.parseInt(System.getProperty("threadCount")));



        String basePath = "C:\\Users\\habeeb_mohamed\\Desktop\\Habeeb\\Frameworks\\UiTest\\UiTest\\src\\test\\resources\\features";
        String[] features = System.getProperty("features").split(",");
        if(features[0].equals("all")){
            features = new File(basePath).list();
        }


        for (String feature : features) {
            String featurePath = basePath + "\\" + feature;
            XmlTest xmlTest = (XmlTest) suite.getTests().get(0).clone();
            xmlTest.setName(feature.split("\\.")[0]);
            xmlTest.addParameter("cucumber.features", featurePath);
            xmlTest.addParameter("cucumber.glue", getStepDefinitionClass(feature));
//            suite.addTest(xmlTest);
        }
        suite.getTests().remove(0);

        IAlterSuiteListener.super.alter(suites);
    }

    private String getStepDefinitionClass(String feature){
        feature = feature.split("\\.")[0];
        String commonStepDefnitions = "org.habeeb.automation.stepdefinitions";
        String glueBasePackage = "org.habeeb.automation.pages";
        String stepDefinitions = null;
        if(feature.contains("sauce")){
            stepDefinitions = glueBasePackage + ".saucelab";
        }else if(feature.contains("herokuapp")){
            stepDefinitions = glueBasePackage + ".herokuapp";
        }

        Assert.assertNotNull(stepDefinitions, "Invalid feature : " + feature);
        return commonStepDefnitions + "," + stepDefinitions;
    }
}
