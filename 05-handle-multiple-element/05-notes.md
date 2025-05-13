# 05-handle-add-to-cart

**Handling Multiple WebElements:**

* **Match Known Items:** Convert array → List, use `.contains()`
* **Loop All Items:** `.findElements()` → use `.get(i).getText()` if needed.
* **Text Cleanup:** `.split("-")`, `.trim()`
* **Index-based Click:** `.get(i)` to match product and button
* **Avoid Text Locators:** Prefer relative XPath over button text
* **Efficiency:** Stop loop early using `break`
* **Debugging (optional):** Print `formattedName` during loop.
* **Scalability:** `itemNeeded` can come from input (e.g., CSV, Excel, etc.).

**Synchronization:**

* **Implicit Wait:** Sets a global timeout for all `findElement`/`findElements` before throwing exceptions.
  **Pros:** Simple, readable, one-liner.
  **Cons:** Can mask performance issues, less control, not suitable for dynamic elements.


* **Explicit Wait:** Applies wait to a specific condition or element.
  **Pros:** Precise control, better for dynamic content, no global delay.
  **Cons:** More code.  

  Explicit Wait can be achieved in 2 ways:  
    1.  **WebDriverWait:** Customized wait method based on condition.
    2.  **FluentWait:** Find WebElement repeatedly at regular interval.


  Both implement `Wait` interface.

  `WebDriverWait` and `FluentWait` work together to implement explicit waiting, which is defined by the `Wait` interface. 

* **FluentWait Use Case:** Dynamic loads (e.g., 3s wait, 7s load).