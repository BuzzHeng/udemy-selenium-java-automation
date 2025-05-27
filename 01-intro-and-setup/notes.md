
-------------------------------
01 -Intro and Setup
-------------------------------

`JAVA_HOME` → `C:\Program Files\Java\jdk-21`  
`Path` → Add `C:\Program Files\Java\jdk-21\bin`

### Maven - To set project library and build automation
```
<dependencies>  //Parent
    <dependency>    //Child
    <\dependency>
<\dependencies>

✅ Automates these tasks:
   - Compile code (javac)
   - Run unit tests (JUnit, TestNG)
   - Package into JAR/WAR
   - Download and manage dependencies (e.g., Selenium)
   - Clean old build files (mvn clean)
   - Execute lifecycle phases in order (validate → compile → test → package → install → deploy)

mvn compile      # Compiles your code
mvn test         # Runs your test cases
mvn package      # Packages code into a JAR
mvn clean install # Cleans, builds, and installs the project
```

### Core Concept of BrowserDriver and WebDriver

```
1. What is interface of Java?
An interface is like a blueprint or contract. 
It has abstract methods — which are methods with empty body — 
and any class that implements the interface must provide its own version of those methods.

2. WebDriver is an interface which provide Set of Browser Automation
methods with empty bodies(Abstract method)
For example, in Selenium, we have the WebDriver interface. 
Then we have classes like ChromeDriver, FirefoxDriver, SafariDriver, and EdgeDriver. 
All these classes implement the WebDriver interface and provide their own implementation 
of the methods, depending on the browser.

3. Need to create object of class to access methods
present in the class.
ChromeDriver driver = New ChromeDriver();
# driver object here has access to all methods of Chrome Driver

WebDriver driver = New ChromeDriver();
# driver object here has access to method of Chrome Driver which 
are defined in web Driver interfaces
```