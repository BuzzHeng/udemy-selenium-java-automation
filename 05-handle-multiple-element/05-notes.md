# 05-handle-add-to-cart
-----------------------------------------------
### Handling Multiple WebElement

Match known items:	    - Convert array → List, use .contains()  
Loop all item:          - .findElements() -> use .get(i).getText() if needed.  
Text cleanup:	        - .split("-"), .trim()  
Index-based click:	    - get(i) to match product and button  
Avoid text locators:	- Prefer relative XPath over button text  
Efficiency:	            - Stop loop early using break  
Debugging (optional):	- Print formattedName during loop  
Scalability:        	- itemNeeded can come from input (e.g., CSV, Excel, etc.)  

### Synchronization
Implicit Wait : Sets a global timeout for all findElement/findElements before throwing exceptions.
```
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
Pros: Simple, readable, one-liner.
Cons: Can mask performance issues, less control, not suitable for dynamic elements.
```

Explicit wait: Applies wait to a specific condition or element.
```
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example")));

Pros: Precise control, better for dynamic content, no global delay.
Cons: More code.
```
