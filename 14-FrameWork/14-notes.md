


Create Page Object Class for LoginScreen and migrate the test

Implementing Action Methods for PageFactory Web Elements to implement logic

Create Abstract Component to reuse common methods/code
in framework

From child to parent class
Can sent by using super() keyword

super() → Used to call and pass values to the parent class constructor from the child.


Reusable element should be in AbstractComponents Class

Assertion/Validation should only be in Test

PageObject only should have actions

Reduce initializing PageObject in test by chaining.

[ PageObject Chaining - Cleaner and more readable test flow ]
- Reduce new PageObject(driver) in tests
- Return next PageObject in methods
[ Example ]
```java
CartPage cart = new LoginPage(driver)
        .login("user", "pass")
        .addToCart();
```
[ Method Format ]
```java
public ProductPage login(String user, String pass){
    return new ProductPage(driver);
}
```

[ Test Configuration Methods ]
Base Test Class
- initializeDriver() method
- launchApplication() method
- 
[ Global Properties ] 
- Create GlobalData.properties in test resource 
Properties prop = new Properties();
FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "Relative Filepath");
prob.load(fis);

[ Parallel Run ]

- Use @AfterMethod/@BeforeMethod for landing page / tear down

[ Test Strategy ]
- Decide how test should be categorise with appropriate annotation.
100 Test Cases -> 100 Java
- Do not blindly create test cases
- Divide the test case based on category
Java class -> Login Page 5 @Test, @Test, @Test, @Test, @Test
Java class -> submit Order, order check
ProductCatalogue -> @Test

[ Run test in Parallel and  Apply Groups using TestNG.xml ]
- @Test(dependsonMethod=""")
- @Test(group="ErrorHandling")
```xml
<groups>
    <run>
        <include name="ErrorHandling"/>
    </run>
</groups>
```
- @Test(alwaysRun = true)

[ Parameterization ]

@Test(dataProvider = "getData", groups="Purchase")