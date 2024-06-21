**Selenium Java Project**
This repository contains a Selenium Java project for automated testing. It includes instructions on how to clone the repository, install dependencies, and run the tests.

**Getting Started**
**Prerequisites**
Before you begin, ensure you have the following installed:

Java Development Kit (JDK) (version 1.8 or higher)
Google Chrome browser

**Clone the Repository**
To clone this repository, run the following command in your terminal:

git clone https://github.com/your-username/automation-selenium.git
cd run-selenium-tests

Install Dependencies
Navigate to the project directory and install the required dependencies using Maven:

mvn install

**Run Selenium Tests**
Execute the following command to run the Selenium tests (specifically the login_test profile):

mvn test -P login_test

**Environment Variables**
Make sure to set the following environment variables:

SAUCE_USERNAME: Your Sauce Labs username
SAUCE_PASSWORD: Your Sauce Labs access key
SAUCE_URL: The Sauce Labs URL (e.g., https://saucelabs.com)
