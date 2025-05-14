Actions:

How to MouseOver on object with Selenium?
Performing Mouse and Keyboard interaction with Selenium
Context click on element
Double click on element
Drag and drop the element

Frames:
What are Frames?
How to identify Frames in application
How to handle frames?
Best practices when working with Frames application.



### Selenium Actions Class - Core Notes

* **What:** `Actions` class in Selenium (Java).
* **Why:** For complex mouse/keyboard actions (move, type, click, right-click, double-click, hold keys).
* **How:**
    1.  `Actions a = new Actions(driver)`
    2.  Chain methods (e.g., `.moveToElement().sendKeys().keyDown().click()`)
    3.  `.contextClick()` for right click  
    4.  `.build().perform()` to execute the chain.

### Selenium - Switching Windows/Tabs

**Window/Tab Handling:**
- Get all open IDs: `Set<String> window = driver.getWindowHandles()`
- Iterate IDs: Use `Iterator<String> it = window.iterator();`
- ParentID: `parentID = it.next();` 
- ChildID: `childID = it.next();`
- Switch To specific window/tab: `driver.switchTo().window(childID)`. 
- Switch Back: Use the stored parent ID.

**Frame Handling:**
- Key: Need to switch into frame to interact with element inside.
- `driver.switchTo.frame()`
  - By WebElement
  - By Name or ID
  - By Index
  - Nested Frames: Switch parent frame first, then switch child frame from within parent.
    - Count Frames: `driver.findElements(By.tagName("iframe")).size()`.
  - Actions like drag/drop work inside frame after switching.