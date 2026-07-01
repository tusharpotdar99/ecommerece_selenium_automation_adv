# 🛒 Ecommerce Web Application Automation Testing Framework

A robust, scalable, and maintainable UI automation framework developed for testing an E-commerce web application using **Java**, **Selenium WebDriver**, **TestNG**, and the **Page Object Model (POM)**. The framework follows industry-standard design principles, supports reusable components, and is designed for easy maintenance and scalability.

---

## 🚀 Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Log4j2
* Page Object Model (POM)
* Component-Based Architecture
* WebDriverManager
* ThreadLocal DriverFactory
* Apache Commons IO
* Extent Reports *(Optional)*
* Git & GitHub

---

## 🏗️ Framework Architecture

The framework follows a layered architecture:

```text
Test Cases
     │
     ▼
Page Objects
     │
     ▼
Reusable Components
     │
     ▼
Base Page
     │
     ▼
Driver Factory
     │
     ▼
Selenium WebDriver
```

This design keeps test scripts clean, readable, reusable, and easy to maintain.

---

## 📂 Project Structure

```text
EcommerceAutomationFramework
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── Base
│   │   │   ├── Driver
│   │   │   ├── Enums
│   │   │   ├── PageObjects
│   │   │   ├── Components
│   │   │   ├── Utilities
│   │   │   └── Listeners
│   │
│   └── test
│       ├── java
│       │   ├── TestCases
│       │   ├── DataProviders
│       │   └── TestUtilities
│       │
│       └── resources
│           ├── config.properties
│           ├── testng.xml
│           └── log4j2.xml
│
├── screenshots
├── reports
├── logs
├── pom.xml
└── README.md
```

---

## ✨ Key Features

* Component-Based Page Object Model
* Cross-browser support
* DriverFactory using ThreadLocal WebDriver
* Centralized browser management
* Reusable page components
* Explicit Wait implementation
* Configurable test execution
* Maven build support
* Logging using Log4j2
* Screenshot capture on failure
* Scalable framework structure
* Clean and maintainable code
* Easy integration with CI/CD tools
* Supports parallel execution
* Industry-standard coding practices

---

## 🧩 Design Patterns Used

### Page Object Model (POM)

Each page is represented as a separate Java class containing:

* Web elements
* Page actions
* Validations

This improves readability and maintainability.

---

### Component-Based Design

Reusable UI sections such as:

* Header
* Navigation Menu
* Search Bar
* Product Card
* Shopping Cart
* Footer

are implemented as independent components and reused across multiple pages.

---

### Driver Factory

The framework uses a centralized DriverFactory responsible for:

* Browser initialization
* Driver lifecycle management
* Thread-safe driver handling
* Browser configuration

Benefits:

* Better maintainability
* Supports parallel execution
* Single point of browser management

---

## 🧪 Test Coverage

The framework automates major E-commerce functionalities, including:

* User Registration
* User Login
* Product Search
* Product Details Verification
* Product Filtering
* Add to Cart
* Update Cart
* Remove Product from Cart
* Wishlist
* Checkout Flow
* Order Placement
* Logout

---

## ⚙️ Browser Support

* Google Chrome
* Mozilla Firefox
* Microsoft Edge

---

## 📝 Logging

The framework uses **Log4j2** for logging.

Logs include:

* Test execution details
* Browser initialization
* User actions
* Error messages
* Exception stack traces
* Execution status

---

## 📸 Screenshot Capture

Screenshots are automatically captured for failed test cases and stored in the screenshots directory for debugging.

---

## ⏳ Synchronization

The framework uses:

* Explicit Wait
* Fluent Wait *(where required)*

to improve test stability and reduce flaky executions.

---

## 🔧 Build Tool

Apache Maven is used for:

* Dependency management
* Test execution
* Build automation

Run all tests:

```bash
mvn clean test
```

Run a specific TestNG suite:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## 🛠️ Coding Standards

The framework follows:

* Object-Oriented Programming (OOP)
* SOLID Principles
* DRY (Don't Repeat Yourself)
* Single Responsibility Principle
* Reusable utility methods
* Clean Code practices
* Consistent naming conventions

---

## 📈 Future Enhancements

* Selenium Grid support
* Docker integration
* GitHub Actions / Jenkins CI
* Allure Reporting
* Extent Reports
* Database validation
* API integration
* Data-driven testing
* Retry Analyzer
* TestNG Listeners
* Cloud execution (BrowserStack / LambdaTest)

---

## 👨‍💻 Author

**Tushar Potdar**

Automation Test Engineer

---

## 📄 License

This project is created for learning, demonstration, and automation framework development purposes.
