# Selenium Summary Notes

---
## [ Table of Content ]  
1. Intro and Setup
2. Core Java
3. Selenium WebDriver: Locators and WebElements
---
## 1. Intro and Setup
[ Installation & Setup ]
- Download ChromeDriver (match browser version)
- IntelliJ: Add Selenium JARs or use Maven:
  ```xml
  <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.20.0</version>
  </dependency>  
  ```
[ Environment Variable (System Variable) ]
- JAVA_HOME -> C:\Program Files\Java\jdk-21
- Path -> C:\ProgramFile\Java\jdk-21\bin

[ Maven ] 
- To set project library and build auomation
  ```xml
  <dependencies> //Parent
    <dependency> //Child
    <\dependency>
  <\dependencies>
  ```

[ Core Concept of BrowserDriver and WebDriver ]
- Interface `WebDriver`
-> Abstract method(Method with Empty body) for any class to implement must provide its own version
- `ChromeDriver`,`FirefoxDriver`,`EdgeDriver`, `GeckoDriver`
- Need to create object of class to access method  
  `ChromeDriver driver = New ChromeDriver //Can access all method ChromeDriver `  
  `WebDriver driver = New ChromeDriver(); //Can access all method ChromeDriver define in WebDriver`

---
## 2. Core Java
[ Variables & Data Types ]
- int, double, char, String, boolean  

[ Arrays ]
- `String[] array = new String[3]; //Declare wth size`
- `String[] array = {"1","2","3"}; //Initialize directly`
- `array[index] //Access element at index`
- `array.length //Get array size`  

[ Loop ]
- `for (int i = 0; i < n; i++)    // Use when index/position matters`
- `for (String item : collection) // Enhanced for-loop when only values are needed`

[ArraysList]
- Dynamic Size
- Arrays.asList(array) -> allow list methods like contains()
  ```Java
    - ArrayList<String> list = new ArrayList<>(); // Create list
    - list.add("item"); // Add element
    - list.get(index); // Access element
    - list.set(index, "value"); // Modify element
    - list.remove(index); // Remove by index
    - list.remove("value"); // Remove by value
    - list.size(); // Get number of elements
    - list.contains("value"); // Check if exists
    - list.clear(); // Remove all elements
  ```

[ Strings (Interview Basics) ]
- String is an object
- Defined via literal (stored in String pool) or with `new` (stored in heap)
- Strings are immutable (cannot be changed after creation)
- Use str.equals(other) to compare values
- Avoid using `==` for content comparison
- str.split() returns a String[]

[ Useful String Methods ]
- str.split(" ") → split text into parts
- str.trim() → remove leading/trailing spaces
- str.charAt(i) → get character at index i
- str.length() → number of characters

[ Looping a String ]
  ```java
  for (int i = 0; i < str.length(); i++)  
    str.charAt(i); // Forward traversal
  
  for (int i = str.length() - 1; i >= 0; i--)  
    str.charAt(i); // Reverse traversal`
  ```

[ Method Concept ]
- A method is a block of code that performs a task
- Defined once, reusable many times
- Can print or return values
- returnType must match what method returns  

[ Method Syntax ]  
  ```java
  returnType methodName(parameters) {
    // code
    return value;
  }
  ```

[ Method Static vs Non-Static ]
- static → can call method without object (class-level)
- non-static → needs create object to call method (instance-level)

[ Cross-Class Method Calls ]
- Use: new ClassName().methodName();

[ Types ]
- Void Method → no return value
- Return Method → returns a value
- Static Method → no object needed
- Instance Method → needs object
  
---
## 3. Selenium WebDriver: Locators and WebElements
[ Locator Types ]
Used with: 
driver.findElement(By...)  //Single
driver.findElements(By...) //Multiple
- By.id("value")  -> Locate by ID attribute
- By.name("value) -> Locate by name attribute
- By.className("value) -> Only support one class name
- By.tagName("tag)     -> Locate by HTML tag(e.g., "input","div","a")
- By.linkText("exact text")     -> Match exact link text
- By.partialLinkText("partial") -> Match partial link text
- By.cssSelector("selector) -> Flexible, Fast;
- By.xpath("expression")    -> Most Powerful;

[ HTML Element Structure ]
`<element attribute="value">content</element>`  
[ Example ]  
`<input type="text" id="username" class="input-field" value="admin" />`
- Tag Name     → input
- Attributes   → type, id, class, value
- Attribute Values → "text", "username", "input-field", "admin"
- Self-closing Tag → no content inside (e.g., `<input />`, `<img />`)
- Nested Tags → `<div><p>Text</p></div>`

[ Common Web Actions ]
- element.sendKeys("text") → Type into input field
- element.click() → Click button, checkbox, or link
- element.clear() → Clear existing input
- element.getText() → Get visible text from element

[ Implicit Wait ]
- driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(x));
- Sets a global wait time for element presence
- Avoids immediate NoSuchElementException

[ Debugging Tools ]
- $('cssSelector') → Test CSS in browser console
- $x('xpath') → Test XPath in browser console
- Tools: SelectorHub, ChroPath → Validate locators

[ Assertion (Validation) ]
- Assert.assertEquals(actual, expected);
- Use for verifying displayed text, values, or states

[ CSS Selectors ]  
Cannot traverse backward (no parent access)
- #id → e.g., #inputUsername
- tag#id → input#inputUsername
- tag.class → button.signInBtn
- tag[attr='value'] → input[placeholder='Email']
- tag:nth-child(n) → Indexing
- parent child → e.g., form p

[ XPath Syntax ]  
Can navigate both forward and backward (parent, sibling, etc.)  
- //tag → tag name only
- //tag[@attr='value'] → by attribute
- //tag[@attr='value'][n] → index
- //parent/child[n] → parent-child structure
- //tag[contains(@attr,'val')] → partial match
- //parent[@attr='value']/child[n] → nested
- //tag[text()='ExactText'] → match exact text
- //*[text()='Text'] → any tag with text
- following-sibling:: → traverse siblings

[ Validate in DevTools ]
- CSS: `$('selector')` → e.g., `$('p.error')`
- XPath: `$x('xpath')` → e.g., `$x('//input[@type="text"]')`
- Quote Tip: single outside, double inside or vice versa

[ Use Case Recommendation ]
- Prefer CSS when:
  - ID, class, or attributes are enough
  - Simpler, faster access is needed
- Use XPath when:
  - Need parent, sibling traversal
  - Matching based on complex logic or text content

[ Key Concepts ]
- Prefer stable locators: ID > Name > Class > CSS > XPath
- By.className() accepts only one class
- CSS is faster, XPath more powerful
- Always test selectors before use


## 4. Web Element Technique
[ Static Dropdown (Select Class) ]
  ```java
    Select dropdown = new Select(driver.findElement(By.id("dropdownId")));
    dropdown.selectByVisibleText("Option 1");
    dropdown.selectByIndex(index)
    dropdown.selectByValue("value")
  ```

[ Dynamic Dropdown ]
- Not using `<select>`; clickable `<div>` or `<li>` items
- Use XPath with indexing or parent-child structure
- Example: `//ul/li[2]` or `//div[@class='dropdown']/ul/li`
```java
driver.findElement(By.id("dropdownInput")).click();
driver.findElement(By.xpath("//li[text()='Option 2']")).click();
```

[ Auto-Suggestive Dropdown ]
- Type input
- Wait for suggestion list
- Use findElements() to fetch all options
- Loop and match desired value → click()
```java
driver.findElement(By.id("inputField")).sendKeys("Ind");
List<WebElement> options = driver.findElements(By.cssSelector("li.suggestion"));
for (WebElement option : options) {
    if (option.getText().equals("India")) {
        option.click();
        break;
    }
}
```

[ Checkbox Handling ]
- isSelected() → check if selected
- click() → select/deselect
- findElements(By.cssSelector("input[type='checkbox']")) → count checkboxes
```java
WebElement checkbox = driver.findElement(By.id("check"));
if (!checkbox.isSelected()) {
    checkbox.click();
}
```

[ Calendar Date Picker ]
- CSS: .ui-state-default.ui-state-active → select today's date
- Use getAttribute("style") to verify if date is enabled

[ Java Alerts ]
- switchTo().alert().accept() → OK
- switchTo().alert().dismiss() → Cancel
- switchTo().alert().getText() → Read message  
  ```Java  
    Alert alert = driver.switchTo().alert();
    System.out.println(alert.getText());
    alert.accept();
  ```

[ E2E Flight Search Scenario ]
- Select From/To via dynamic dropdowns
- Handle disabled return dates
- Increase passenger count
- Apply discounts (e.g., Senior Citizen)
- Click Search
- Assert results with TestNG

[ Simple Form Handling ]
- Fill: name, email, password, gender, DOB
- Submit the form
- Validate success message using assertions

## 5. Handle Multiple WebElement

[ Add to Cart Logic ]
- Match Known Items  
  → Convert array to List → use .contains()  
  → Example: Arrays.asList(itemsNeeded).contains(formattedName)
- Loop All Items  
  → Use driver.findElements()    
  → Access with .get(i).getText()
- Text Cleanup  
  → Use .split("-")[0].trim() to clean product name
- Index-based Click  
  → Use .get(i) to click corresponding Add-to-Cart button  
  → XPath: //div[@class='product-action']/button
- Avoid Text Locators  
  → Prefer relative XPath instead of button text
- Efficiency  
  → Use break after adding all required items
- Debugging (optional)  
  → Print formattedName during loop for verification
- Scalability  
  → itemsNeeded[] can be loaded dynamically (e.g., CSV, Excel)
```java
// Items needed
String[] items = {"Brocolli", "Cucumber", "Beetroot"};
List<String> itemsNeeded = Arrays.asList(items);
// Get all product elements
List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
for (int i = 0; i < products.size(); i++) {
    // Clean product name
    String[] name = products.get(i).getText().split("-");
    String formattedName = name[0].trim();
    // Debug (optional)
    System.out.println("Found: " + formattedName);
    // Match with needed items
    if (itemsNeeded.contains(formattedName)) {
        // Click "Add to Cart" button relative to product
        driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
        // Stop if all matched
        if (items.length == 0)
            break;
    }
}
```

[ Synchronization ]

- Implicit Wait ->Global timeout for all findElement/findElements  
`driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(x))`
- Explicit Wait -> Wait for specific condition or element
  1) WebDriverWait
  ```java
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
  ```
  2) FluentWait → Repeated polling + timeout + exception handling  
  - Best for unpredictable load times
  ```java
    Wait<WebDriver> wait = new FluentWait<>(driver)  
    .withTimeout(Duration.ofSeconds(10))  
    .pollingEvery(Duration.ofMillis(500))  
    .ignoring(NoSuchElementException.class);  
    wait.until(ExpectedConditions.elementToBeClickable(By.id("elementId")));
  ```
- Interface  
  → Both WebDriverWait and FluentWait implement Wait interface

---
## [ 6. Mouse, Keyboard, Frame, and Tab Control ]

[ Actions Class ]
- Setup → Actions a = new Actions(driver)
- Mouse Over → a.moveToElement(el).perform()
- Right Click → a.contextClick(el).perform()
- Double Click → a.doubleClick(el).perform()
- Drag & Drop → a.dragAndDrop(src, tgt).perform()
- Send Key → a.sendKeys(Keys.ENTER).perform()
- Chain Actions → a.moveToElement(el).click().keyDown(Keys.SHIFT).sendKeys("abc").build().perform()

[ Tab / Window Handling ]
- Get IDs → Set<String> handles = driver.getWindowHandles()
- Iterate IDs → Iterator<String> it = handles.iterator()
- Get ParentID → String parentID = it.next()
- Get ChildID → String childID = it.next()
- Switch Tab → driver.switchTo().window(childID)
- Switch Back → driver.switchTo().window(parentID)

[ Frame Handling ]
- Count Frames → driver.findElements(By.tagName("iframe")).size()
- Switch by Index → driver.switchTo().frame(0)
- Switch by Name → driver.switchTo().frame("frameName")
- Switch by Element → driver.switchTo().frame(el)
- Exit Frame → driver.switchTo().defaultContent()
- Up One Frame → driver.switchTo().parentFrame()
---
## [ Handling Multiple Links and Calendar ]
[ Multiple Link & Keys Chord ]
- Count All Links → `driver.findElements(By.tagName("a")).size()`
- Count Header Links
```java
  WebElement header = driver.findElement(By.name("header"))
  header.findElements(By.tagName("a")).size()
```

- Open Links in New Tab → 
```java
String clickL = Keys.chord(Keys.CONTROL, Keys.ENTER)
driver.findElements(By.tagName("a")).sendKeys(clickL)
```
- hasNext() → Returns true if the iteration has more elements
- Switch to New Window → 
```java
for(String winHandle : driver.getWindowHandles()) {
    driver.switchTo().window(winHandle)
}
findElements() Return Type → List<WebElement>
```

[ Handling Calendar ]
- getDomAttribute()
  ```java
    //Get Calendar Fields
    List<WebElement> actualList = driver.findElements(
    By.cssSelector(".react-date-picker__inputGroup__input"))
  
    //Loop and Assert Value
    for (int i = 0; i < actualList.size(); i++) {
    String value = actualList.get(i).getDomAttribute("value")
    System.out.println(value)
    Assert.assertEquals(value, expectedList[i])
    }
  ```
---

## 7. Handling Scroll and JavaScriptExecutor

[ Headless Browser ]
- Enable Headless → options.addArguments("headless")

[ Scroll ]
- Scroll Down → js.executeScript("window.scrollBy(0,500)")

[ Table Access ]
- Column CSS → .tableFixHead td:nth-child(4)
- Get Headers → driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th"))

[ Assert ]
- Syntax → Assert.assertEquals(actual, expected)

[ Parse Integer ]
- Syntax → Integer.parseInt("123")

[ Arrow Key ]
- Send Down → el.sendKeys(Keys.DOWN)

[ Hidden Field via JS ]
- Get Value → ```java
  String text = (String) js.executeScript("return document.getElementById('hiddentext').value")  

[ HTML Tags ]
```declarative
  <tr> → table row  
  <th> → header cell  
  <td> → data cell  
```
---
## 8. Selenium Misc Notes

[ ChromeOptions Setup ]
- Set Download Path
- Ignore SSL Errors 
- Use Proxy

[ WebDriver manage() ]
```java
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
```
[ Take Screenshot ]
```java
File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(src, new File("path/screenshot.png"));
```
[ Broken Link Check (HttpURLConnection) ]
1. Get all `<a>` elements
2. Use `.getDomProperty("href")` to get full URL
3. Use `HEAD` request
4. Assert: response code < 400

**Example:**
```java
List<WebElement> links = driver.findElements(By.cssSelector("li.gf-li a"));
SoftAssert sa = new SoftAssert();

for (WebElement link : links) {
    String url = link.getDomProperty("href");
    HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
    conn.setRequestMethod("HEAD");
    conn.connect();
    int code = conn.getResponseCode();

    sa.assertTrue(code < 400, link.getText() + " broken: " + code);
}
sa.assertAll();
```

---

[ Modern Alternative (Java 11+ HttpClient) ]
```java
HttpRequest req = HttpRequest.newBuilder()
    .uri(URI.create(url))
    .method("HEAD", HttpRequest.BodyPublishers.noBody())
    .build();

HttpResponse<Void> res = HttpClient.newHttpClient()
    .send(req, HttpResponse.BodyHandlers.discarding());

System.out.println(res.statusCode());
```
[ Attribute Methods Summary ]
- `getText()` -> Visible text for Button/link labe|  
- `getAttribute("href")` -> Raw HTML value for Original tag value  
- `getDomAttribute("href")`-> Same as above (strict spec) for Static value
- `getDomProperty("href")` -> Resolved full value (absolute) for link checking

[ SoftAssert Usage ]
```java
SoftAssert sa = new SoftAssert();

sa.assertTrue(condition, "Failure message");
sa.assertEquals(actual, expected, "Mismatch message");

sa.assertAll(); // Required to report all failures
```
**Use When:**
- You want to continue test execution even if some validations fail
- Useful for checking multiple links, table rows, or form fields
--- 