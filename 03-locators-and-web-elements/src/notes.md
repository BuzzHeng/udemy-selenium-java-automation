# 03-locators-and-web-element

----------------------------------
### Selenium WebDrivers Locators
```
1. Selenium WebDrivers Locators
 - Locators -> ways to identify an HTML elmeent on page and perform action
    1) ID
    2) Xpath
    3) CSS Selector
    4) name
    5) Class Name
    6) Tag Name
    7) Link Text
    8) Partial Link Text

2. Finding Elements (Using Locators)
        - `By.id("value")`       → Select element by `id` attribute
        - `By.name("value")`     → Select element by `name` attribute
        - `By.className("value")`→ Select element by class name (only one class)
        - **Other types**: `By.tagName`, `By.cssSelector`, `By.xpath` (used later)
    
3. HTML Element Structure
        - **Tag name**: The HTML element (e.g., `input`, `button`, `div`)
        - **Attribute**: Property of the tag (e.g., `id`, `name`, `type`, `class`)
        - **Attribute value**: The value assigned to the attribute (e.g., `id="username"` → value is `"username"`)
    
4. Performing Actions
        - `.sendKeys("text")` → Types text into an input field
        - `.click()`          → Clicks on buttons or links
    
Key Concepts  
        1. Use the most specific and stable locator (id > name > class)  
        2. HTML elements are identified by tag + attributes  
        3. Space in class attribute = multiple classes (only use one)  
```
### Locators with CSS Selectors & Waits
```
1. Implicit Wait
    - `driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(x))`
    - Tells WebDriver to wait for elements before throwing error
    
2. CSS Selector Syntax
    - `tagname.classname`       → e.g., `button.signInBtn`
    - `tagname#id`              → e.g., `input#inputUsername`
    - `tagname[attribute='val']`→ e.g., `input[placeholder='Username']`
    - Combine selectors for precision

3. Extracting Text
    - `getText()` → Get visible text from element

4. Debug with DevTools / SelectorHub
    - Use `$('selector')` in Console for CSS validation
    - Use `xpath` or `css` in SelectorHub to confirm uniqueness

Key Concepts  
    1. Use `implicitlyWait` to handle slow-loading elements  
    2. CSS Selectors are fast and flexible  
    3. `p.error` targets a `<p>` tag with class `error`  
    4. Validate selectors in DevTools or SelectorHub before using in code
```
