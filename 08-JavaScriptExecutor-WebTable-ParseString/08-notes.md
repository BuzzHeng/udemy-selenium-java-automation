
### 08 - Handling Scroll JavaScriptExecutor
[Headless browser] - No UI, Run Faster  
`ChromeOptions.addArguments("headless")`  

[Scrolling to Element] - Needed when element not in view 
```java
JavaScriptExecutor js = (JavaScriptExecutor) driver;
js.executeScript("window.scrollBy(0,500)");
```
[WebElement for table grids]
- Should always start from parent traverse to the table data cell td
- .tableFixHead td:nth-child(4)

Integer.parseInt

[Assert.assertEquals(actual, expected)]
- actual → result from code/test
- expected → what you assume it should be