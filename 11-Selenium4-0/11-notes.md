## Selenium Relative Locator

#### What is it?
- Allows locating elements **relative to other elements**
- Improves readability, especially in dynamic or flex layouts
- Requires:  
  `import static org.openqa.selenium.support.locators.RelativeLocator.with

#### Syntax Overview
- Above(): Element located above with respect to the specified element.
- Below(): Element located below
- toLeftOf(): Element located to the left
- toRightOf(): Element located to the right
```java
with(By.tagName("element")).above(referenceElement)
with(By.tagName("element")).below(referenceElement)
with(By.tagName("element")).toLeftOf(referenceElement)
with(By.tagName("element")).toRightOf(referenceElement)
```


Syntax:
`driver.findElement(By.TagName('label).above(nameEditBox))`
---
#### Example Use Case
```java
WebElement nameEditBox = driver.findElement(By.cssSelector("input[name='name']"));

String labelAbove = driver.findElement(
    with(By.tagName("label")).above(nameEditBox)
).getText();
System.out.println(labelAbove);
```

### 15 – Window, Screenshot, and Element Size

---

#### Invoking Multiple Window/Tab from Selenium using one driver instance

#### [Open New Tab & Switch Back]
- Open main page (form)
- Use `driver.switchTo().newWindow(WindowType.TAB)` to open new tab
- Get all window handles: `getWindowHandles()`
- Use `Iterator` to get parent and child window IDs
- Switch to child window
- Navigate to second URL.
- Switch back to parent window
```java
driver.switchTo().newWindow(WindowType.TAB);   // Open new tab
Set<String> handles = driver.getWindowHandles();
Iterator<String> it = handles.iterator();
String parentID = it.next();
String childID = it.next();

driver.switchTo().window(childID);             // Switch to new tab
driver.get("https://rahulshettyacademy.com/"); // Load 2nd URL

// Grab course name from child window
String courseName = driver.findElements(By.cssSelector("a[href*='courses']"))
                          .get(1).getText();

// Switch back to parent and fill form
driver.switchTo().window(parentID);
driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
```

---

#### Capture WebElement Screenshot using Selenium

```java
File file = element.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(file, new File("element.png")); // Requires Apache Commons IO
```
---

#### Get Height Width of WebElement using Selenium

```java
int height = element.getRect().getDimension().getHeight();
int width = element.getRect().getDimension().getWidth();
System.out.println(height + " x " + width);
```
---
#### Summary Notes
- Use `WindowType.TAB` to open new tabs
- Switch using `getWindowHandles()` and `switchTo().window(id)`
- Use `.getScreenshotAs()` to capture a specific element
- `.getRect().getDimension()` gives element's size
