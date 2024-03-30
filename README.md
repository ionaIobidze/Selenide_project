# Selenide Project N1

## Overview
This project uses Selenium WebDriver, TestNG, and SQL for test implementation and database interactions.

## Skills Demonstrated
- Test Automation: Implemented automated test cases using Selenide.
- TestNG: Used TestNG for managing and executing test cases.
- Data-Driven Testing: Applied data providers for parameterized testing.
- Database Interaction: Executed SQL scripts and interacted with a database to manage test data.
- Continuous Integration: Structured tests for integration into a CI pipeline.

## Tools and Libraries Used
- Selenide: For browser automation.
- TestNG: For test management and execution.
- Java: Programming language for writing test scripts.
- SQL Express: For database operations and validation.

## Project Structure
### Swoop.ge Test Automation
- Class: OfferTests in the swoop package
  - rangeTest: Tests the price filter functionality.
  - favouriteOfferTest: Tests adding items to favorites and login page appearance.
  - shareOfferTest: Tests the sharing functionality of an offer.
  - noOffersSoldTest: Verifies offers with zero sales.
  - clearFilterTest: Tests the filter reset functionality.

### SauceDemo Test Automation
- Class: LoginTests in the saucedemo package
  - successfulLoginTest: Validates login and image loading for a standard user.
  - bannedUserLoginTest: Validates error message for a locked-out user.
  - problematicLoginTest: Checks for issues with product image loading.
  - logOutTest: Validates the logout functionality.

## Test Grouping with TestNG
Created testng.xml to define test groups:
- SwoopRegression: Includes all Swoop tests.
- SauceDemoLogin: Includes all SauceDemo login tests.

## How to Run the Tests
1. Clone the repository.
2. Navigate to the project directory.
3. Execute tests using TestNG through the testng.xml file.
