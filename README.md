# Selenium Java Automation (Udemy Course Notes)

This repository contains Java code and notes from the Udemy course:  
**"Selenium WebDriver with Java - Basics to Advanced + Frameworks"**.

The goal is to learn Selenium automation step-by-step with practical code, concepts, and browser testing.
---
## Project Structure
```bash
udemy-selenium-java-automation/
│
|── driver/                         # ✅ Browser drivers (chromedriver.exe, msedgedriver.exe, etc.)
│
├── src/
│   └── main/
│       └── java/
│           └── SeleniumIntro.java  # ✅ Java class with browser setup
│
├── pom.xml                         # ✅ Maven configuration file (Selenium dependencies)
├── .gitignore                      # ✅ (optional) Ignore IDE files, driver binaries, etc.
└── README.md                       # ✅ Project overview and setup notes
```
---
## 🚀 Features
- Manual vs Automatic WebDriver setup using Selenium Manager
- Chrome, Firefox, and Edge browser support
- Code written with inline comments for easy learning
- Console output: page title, current URL
- Uses Selenium 4.6+ (for Selenium Manager support)
---

## ✅ Requirements

- Java JDK 17+
- Maven installed
- IntelliJ IDEA or any Java IDE
- Selenium Java dependency (via `pom.xml`)
---

## Running the Project
1. Clone the repo
2. Open in IntelliJ IDEA
3. (Optional) Download drivers into `driver/` folder for manual setup
4. Set the browser and `useManualSetup` flag in `SeleniumIntro.java`
5. Run the `main()` method
---

## 🧠 Notes

- `driver.close()` → closes current tab  
- `driver.quit()` → closes entire browser and ends session  
- From Selenium 4.6+, you can skip manual setup using Selenium Manager.
