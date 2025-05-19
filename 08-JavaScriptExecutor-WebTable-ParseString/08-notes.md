
### 08 - Handling Scroll JavaScriptExecutor
JavaScripExecutor used to Identify objects which has hidden element

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


```
<tr> = Table Row → groups cells horizontally  
<th> = Table Header Cell → used inside <tr>, for column/row labels
<td> = Table Data Cell → used inside <tr>, for normal data

Get the columns in a table with xpath.
List<WebElement> tblCol = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th"))
```

How to perform Arrow Key Down?
driver.findElement(By.Id("text-id").sendKeys(Keys.DOWN);


How to extract value from a field with help of Javascript Executor?

```declarative
String val = "return document.getElementById(\"hiddentext\").value;";
String text = (String) js.executeScript(val);
```