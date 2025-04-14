# 03-locators-and-web-element

----------------------------------
### Selenium WebDriver Locators
```
1. Locator Types (used with `driver.findElement(By...)`)
   - ID             → By.id("value")
   - Name           → By.name("value")
   - Class Name     → By.className("value") — only one class allowed
   - Tag Name       → By.tagName("tag")
   - Link Text      → By.linkText("exact text")
   - Partial Link   → By.partialLinkText("partial")
   - CSS Selector   → By.cssSelector("selector")
   - XPath          → By.xpath("expression")

2. HTML Element Structure
   - Tag Name: e.g., input, button, div
   - Attribute: e.g., id, name, type, class
   - Attribute Value: e.g., id="username" → "username"

3. Common Web Actions
   - .sendKeys("text") → Type into a field
   - .click()          → Click a button or link
   - .clear()          → Clear input
   - .getText()        → Extract visible text

4. Implicit Wait
   - `driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(x))`
   - Waits for elements before throwing timeout error

5. Debugging Tools
   - `$('selector')`   → Test CSS in browser console
   - `$x('xpath')`     → Test XPath in browser console
   - Use SelectorHub or ChroPath to validate locator uniqueness

6. Assertion (for validation)
    - Assert.assertEquals(actual, expected)
    - Useful for verifying UI text or values
```

---
### CSS Selectors & XPath Syntax
```
1. CSS Selector Patterns
   - #id                     → e.g., #inputUsername
   - tagname#id              → e.g., input#inputUsername
   - tagname.classname       → e.g., button.signInBtn
   - tagname[attr='value']   → e.g., input[placeholder='Email']
   - Indexing: nth-child(n)
   - Parent-child: e.g., form p

2. XPath Patterns
   - Tag name only: //tagname
   - Attribute:         //tagname[@attribute='value'] → //input[@type='text']
   - Index:             //tag[@attr='val'][index] → //input[@type='text'][2]
   - ParentChild:       //parent/child[n] → //form/input[3]
   - Partial match:     //tag[contains(@attr,'val')] → //button[contains(@class,'submit')]
   - ParentAttribute + ChildIndex (Custom): 
        //parentTag[@attribute='value']/childTag[index] → //div[@class='container']/button[1]
   - Exact Text Match: 
        //tagname[text()='Text'] → `//button[text()='Log Out']`
        //*[text()='Text']       → `//*[text()='Log Out']`
```


---

### Validating XPath & CSS in DevTools (Quotes)

✅ CSS → use `$()`
- Example: `$('p.error')`
- With attribute: `$('input[placeholder="Email"]')`

✅ XPath → use `$x()`
- Example: `$x('//input[@placeholder="Name"]')`
- Alternate: `$x("//input[@type='text']")`

💡 Tip:
- Use **single quotes outside**, **double quotes inside** (or vice versa)
- Test in **DevTools Console** or **SelectorHub**

### Key Concepts
```
1. Prefer stable locators (ID > Name > Class > XPath/CSS)
2. Use only one class for By.className()
3. CSS is fast and readable, XPath is powerful and flexible
4. Always validate your selectors before using in code
```
