# 🚀 Selenium TestNG Hybrid Framework

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.x-green?style=for-the-badge&logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-7.x-red?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-3.x-blue?style=for-the-badge&logo=apache-maven)

A robust **Selenium WebDriver Test Automation Framework** using Java, TestNG, and Page Object Model (POM) structure with data-driven testing support via Excel. The framework integrates **ExtentReports** for reporting and captures **screenshots** for failed tests.

---

## 📑 Table of Contents

- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Installation](#-installation)
- [Running Tests](#-running-tests)
- [Reporting](#-reporting)
- [Utilities](#-utilities)
- [Notes](#-notes)

---

## 📁 Project Structure
SeleniumTestNGFramework-main/
├── .mvn/
├── .settings/
├── Reports/ # ExtentReports output
├── Screenshots/ # Screenshots of failed tests
├── src/
│ ├── main/java/utils/ # Utility classes
│ └── test/java/
│ ├── base/ # Base class for driver setup
│ ├── listeners/ # TestNG listeners
│ ├── pages/ # Page Object classes
│ └── tests/ # Test classes
├── resources/ # Config files and test data
├── target/ # Maven build output (auto-generated)
├── pom.xml # Maven dependencies
└── testng.xml # TestNG suite configuration

text


---

## ✅ Prerequisites

| Requirement | Version |
|-------------|---------|
| Java | 17 or higher |
| Maven | 3.x |
| Browser Driver | Chrome/Firefox/Edge (in PATH) |
| IDE | IntelliJ IDEA / Eclipse / VS Code |

---

## ⚙️ Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Talha3367/SeleniumTestNGFramework.git
   cd SeleniumTestNGFramework
Install dependencies via Maven:

Bash

mvn clean install
Configure browser drivers:

Ensure browser drivers are in the system PATH
Or configure them in Base.java
▶️ Running Tests
Option 1: Using TestNG XML
Bash

mvn test -DsuiteXmlFile=testng.xml
This will execute all tests defined in testng.xml.

Option 2: Using Maven Surefire Plugin
Bash

mvn clean test
📊 Reporting
Report Type	Location
ExtentReports	Reports/extentReport.html
Failed Test Screenshots	Screenshots/
💡 Open Reports/extentReport.html in a browser to view detailed test results.

🛠️ Utilities
Utility Class	Description
CommonUtils.java	General utilities - screenshots, random emails, reading test data from Excel
ElementUtils.java	Helper methods for Selenium WebElements
MyXLSReader.java	Utility for reading Excel files for data-driven testing
📝 Notes
✅ Framework follows Page Object Model (POM) for better maintainability
✅ Data-driven tests supported via Excel (resources/ProjectData.xlsx)
✅ TestNG listeners (MyListeners.java) used for reporting and logging
✅ Fully Java-based and compatible with GitHub language detection
