# Automated Testing Project with Selenium and Cucumber

This project is an automated testing suite for a full-stack web application. Using **Java**, **Selenium**, and 
**Cucumber** for Behaviour-Driven Development (BDD), it ensures consistent, high-quality testing of the System Under
Test (SUT).

## About the SUT
 - Repository: https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-keszegroland
   The System Under Test is an instagram-like social platform where you can upload pictures, you can like 
   others pictures, and you can comment the posts.
   After you successfully installed the SUT (you can find install guide in the README of the SUT)
   open the login page (it should be http://localhost:5173/login) and make a new user
   with the name "asd" and password "12345".
   When you made the test user change the username in makeAdmin.http file from src/test/resources and run it.
   This is needed for the tests to run properly.

## Table of Contents

- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running Tests](#running-tests)
- [Additional Information](#additional-information)

## Project Structure

- **src/test/java**: Contains all test cases and step definitions.
- **src/test/resources**: Holds all the .feature files.

## Prerequisites

Ensure you have the following installed:

1. **Java** (version 11 or higher)
2. **Maven** (for managing dependencies and running tests)
3. **ChromeDriver** or the WebDriver for your preferred browser
4. **SUT** (system under test)

## Setup

1. **Clone the Repository**:
   ```bash
   git clone git@github.com:Tavirutyutyu/Strings-Automated-Tests.git
   ```
2. **Navigate to the repository**:
   ```bash
   cd  Strings-Automated-Tests
   ```
3. **Install dependencies**:
   ```bash
   mvn clean install
   ```
4. **Set up the test account**:

   When you installed and started SUT (you can find install guide in the README of the SUT) open login page 
   (should be http://localhost:5173/login). Make a new account with the username "asd" and password "12345".
   After you made your account run the makeAdmin.http file in the src/test/resources in this project.

## Run the tests:
   **Make sure your SUT is running and you did the setup successfully.**
   ```bash
   mvn test 
   ```
