
------------
Setting up
------------

`JAVA_HOME` → `C:\Program Files\Java\jdk-21`
 
`Path` → Add `C:\Program Files\Java\jdk-21\bin`

Maven -> Dependencies (Parent), Dependency (child)

###### Core Concept of BrowserDriver and WebDriver




```
1. What is interface of Java?
An interface is like a blueprint or contract. 
It has abstract methods — which are methods with no body — 
and any class that implements the interface must provide its own version of those methods.

2. WebDrive is an interface which provide Set of Browser Automation
methods with empty bodies(Abstract method)
For example, in Selenium, we have the WebDriver interface. 
Then we have classes like ChromeDriver, FirefoxDriver, SafariDriver, and EdgeDriver. 
All these classes implement the WebDriver interface and provide their own implementation 
of the methods, depending on the browser.

3. Need to create object of class to access methods
present in the class.
ChromeDriver driver = New ChromeDriver();
# driver object here has access to all methods of Chrome Driver

WebDriver driver = New WebDriver();
# driver object here has access to method of Chrome Driver which 
are defined in web Driver interfaces
```