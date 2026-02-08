# Web Automation Gist

This project is a **web automation testing framework** built with **Java** and **Maven**.

It is designed for practicing and demonstrating:
- Web UI automation
- Test execution and reporting
- Clean project structure

## Tech Stack
- Java
- Maven
- Selenium / Web Automation
- Allure Report

## Project Structure

src/ -> Source code (tests & utilities)
allure-results/ -> Allure test results
.idea/ -> IDE configuration
pom.xml -> Maven configuration
.env.example -> Environment variables example


## Prerequisites
- Java 8 or higher
- Maven
- Web browser (Chrome / Firefox)
- WebDriver compatible with your browser

## Setup
1. Clone the repository
2. Copy `.env.example` to `.env`
3. Update environment variables if needed
4. Install dependencies:
   ```bash
   mvn clean install

Run Tests

mvn test
