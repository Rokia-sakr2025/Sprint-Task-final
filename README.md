#SPRINT Task UI Automation
# Table of Contents

1[Project Overview](#project-overview)
2-KEY Feature
3 [Technologies Used](#technologies-used)
4. [Installation](#installation)
5. [Allure Report](#allure-report)

## Project Overview

This is an automation framework for web application testing using **Selenium WebDriver**. It integrates with **TestNG** for test execution,
**Allure** for generating attractive test reports, and **Maven** for project management. **Log4j** is used to log test execution details.

Key features:
- **Selenium WebDriver** for browser automation.
- **TestNG** for test execution and reporting.
- **Allure Reports** for beautiful test reports.
- **Maven** for dependency management.
- **log4j** for logging during test execution.

# Technologies Used

- **Java 11 or higher**
- **Selenium WebDriver**: For automating browser interactions.
- **TestNG**: For test execution, configuration, and reporting.
- **Allure Report**: For generating visually appealing test reports.
- **Maven**: For managing project dependencies and building the project.
- **log4j**: For logging during test execution.

   [Installation](#installation)
  Prerequisites
  **Java**: Ensure that you have **Java 11 or higher** installed. You can check your Java version with the command:
   java -version
  Maven: Ensure that Maven is installed. You can verify the installation by running:
   mvn -version
  Git: Ensure that Git is installed to clone the repository. You can check this by running:
   git --version

  
   get clone the project from repo
   git clone https://github.com/Rokia-sakr2025/Sprint-Task-final.git
   Use Inteliji IDE with selenuim ,Java ,testng,selenuim web driver ,POM.xml ,LOGS ,Allure report 
   first make sure that you install testng in intellij from marketplace
  
   [Allure Report](#allure-report)
  
   To generate Allure reports, you first need to install the Allure command-line tool. Here's how to install it on different systems:
   Windows (Using Scoop )
   first install Scoop
   
   Open PowerShell as Administrator:
   Right-click the Start button, and select Windows PowerShell (Admin).
  Allow running scripts (if necessary): By default, PowerShell restricts script execution for security reasons. You'll need to set the execution policy to allow running scripts:
run this comment in windows powershell
   Set-ExecutionPolicy RemoteSigned -scope CurrentUser
Confirm the change when prompted by typing Y and pressing Enter.
Install Scoop using PowerShell: To install Scoop, run the following command in PowerShell:
iex (new-object net.webclient).downloadstring('https://get.scoop.sh')
This command will download and install Scoop.
then Verify the Installation: After the installation is complete, verify that Scoop was installed correctly by typing:
scoop --version
This should output the version of Scoop that was installed.
 to install Allure using Scoop, you can run the following command:
scoop install allure
to Integrate Allure with  Testing Framework
For TestNG (Java) Add Allure Dependencies to Your Project
<dependencies>
    <dependency>
        <groupId>io.qameta.allure</groupId>
        <artifactId>allure-testng</artifactId>
        <version>2.13.9</version>
        <scope>test</scope>
    </dependency>
</dependencies>
.....
   After running your tests, you'll have a folder containing the results (allure-results). To generate the Allure report, use the following commandin terminal of id 
   allure serve
This command:

Starts a web server and serves the Allure report on your browser.
The generated report can be accessed at http://localhost:port.
to View the Report
Once the report generation is complete, it will open automatically in your default web browser.
