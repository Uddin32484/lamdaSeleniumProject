Selenium 101 - LambdaTest Certification Assignment
This project contains automated test scenarios for the LambdaTest Selenium 101 certification assignment, implemented using Java, Selenium WebDriver, TestNG, and Maven.
📋 Test Scenarios
Test Scenario 1: Simple Form Demo

Navigate to LambdaTest Selenium Playground
Click "Simple Form Demo"
Validate URL contains "simple-form-demo"
Enter message and validate display

Test Scenario 2: Drag & Drop Sliders

Navigate to "Drag & Drop Sliders"
Drag slider from default value 15 to 95
Validate range value shows 95

Test Scenario 3: Input Form Submit

Navigate to "Input Form Submit"
Test form validation without filling fields
Fill all required fields and submit
Validate success message

🛠️ Technology Stack

Java - Programming language
Selenium WebDriver - Browser automation
TestNG - Testing framework
Maven - Build and dependency management
LambdaTest Cloud Grid - Cross-browser testing platform

📁 Project Structure
selenium-101-assignment/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── utils/
│   │           ├── ConfigReader.java
│   │           └── WebDriverManager.java
│   └── test/
│       └── java/
│           ├── base/
│           │   └── BaseTest.java
│           ├── pages/
│           │   ├── SeleniumPlaygroundPage.java
│           │   ├── SimpleFormDemoPage.java
│           │   ├── DragDropSlidersPage.java
│           │   └── InputFormSubmitPage.java
│           └── tests/
│               ├── SimpleFormDemoTest.java
│               ├── DragDropSlidersTest.java
│               └── InputFormSubmitTest.java
├── src/test/resources/
│   ├── config.properties
│   └── testng.xml
├── .gitpod.yml
├── pom.xml
└── README.md
⚙️ Prerequisites

Java 11 or higher
Maven 3.6 or higher
LambdaTest account with automation access
Git

🚀 Setup Instructions
Local Development

Clone the repository:
bashgit clone <repository-url>
cd selenium-101-assignment

Configure LambdaTest credentials:

Update src/test/resources/config.properties with your LambdaTest credentials:

propertieslambdatest.username=your_username
lambdatest.accesskey=your_access_key
lambdatest.hub.url=https://hub.lambdatest.com/wd/hub

Install dependencies:
bashmvn clean install


Gitpod Environment
This project is configured for one-click setup with Gitpod:

Click the Gitpod button or visit: https://gitpod.io/#<repository-url>
The environment will automatically set up with all dependencies
Configure your LambdaTest credentials in the config file
Run tests directly in the cloud IDE

🏃‍♂️ Running Tests
Run All Tests in Parallel
bashmvn clean test
Run Specific Test Suite
bashmvn clean test -DsuiteXmlFile=testng.xml
Run Individual Test Classes
bash# Simple Form Demo Test
mvn clean test -Dtest=SimpleFormDemoTest

# Drag Drop Sliders Test
mvn clean test -Dtest=DragDropSlidersTest

# Input Form Submit Test
mvn clean test -Dtest=InputFormSubmitTest
🌐 Cross-Browser Testing
Tests are configured to run in parallel on multiple browser/OS combinations:

Windows 10 + Chrome Latest
macOS Catalina + Safari Latest
Windows 11 + Firefox Latest
macOS Big Sur + Edge Latest