


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