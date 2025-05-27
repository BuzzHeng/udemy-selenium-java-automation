1. Static Dropdown (Select Class)
    - Use `Select` class to handle `<select>` dropdowns
    - Methods: selectByIndex(), selectByVisibleText(), selectByValue()


2. Dynamic Dropdown (Normal Clickable Options)
    - Handle dynamic dropdowns without `<select>`
    - Techniques: XPath with indexing, Parent-Child traversal


3. Auto-Suggestive Dropdown
    - Enter text
    - Wait for suggestions
    - Loop through list and select matching item
    - Use findElements() to get list of matching elements


4. Handling Checkboxes
    - isSelected() → Validate if checkbox is selected
    - click() → Toggle checkbox
    - findElements() with input[type='checkbox'] to count total checkboxes


5. Calendar Date Pickers
    - Use CSS Selector `.ui-state-default.ui-state-active` to select today's date
    - Use `style` attribute to check if date fields are enabled or disabled


6. Handling Java Alerts
    - switchTo().alert().accept() → Accept alert
    - switchTo().alert().dismiss() → Dismiss confirmation box
    - switchTo().alert().getText() → Extract alert message


7. End-to-End Scenario (E2E Flight Search)
    - Fill dynamic dropdown (From/To)
    - Handle return date disabling
    - Increment passengers count
    - Apply senior citizen discount
    - Click Search button
    - Assert results with TestNG assertions


8. Simple Form Handling (Assignment 1)
    - Fill form fields (name, email, password, gender, DOB)
    - Click Submit button
    - Validate success message

---
