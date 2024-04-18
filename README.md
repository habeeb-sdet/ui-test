# Ui Test Framework


## About

Ui Test Framework designed to collaboratively automate the UI test cases

Powered with
- Selenium
- BDD Cucumber for easy collaboration
- Selenium Grid capability

Sauce Lab Demo app is used as a test application

## How to Run the Tests?

# Pre-Requisites:
- Java JDK Version >= 11 should be installed
- Maven version >= 3.9.6 should be installed
- Download selenium grid server jar and chrome driver
- Execute selenium grid command(Eg: java -jar selenium-server-4.19.1.jar standalone) to bring up the browser sessions

Since this is a maven project, this project is designed to run using mvn commands.
```
mvn clean verify
```
Scenarios to executed & No.of.Threads can be controlled by passing the feature file name  and thread count.



Eg :
```
mvn clean verify -Dfeatures=feature1,feature2 -DthreadCount=2
mvn clean verify -Dfeatures=all -DthreadCount=3
```
