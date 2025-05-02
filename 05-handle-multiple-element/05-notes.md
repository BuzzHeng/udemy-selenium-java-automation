# 05-handle-add-to-cart
-----------------------------------------------
### Handling Multiple WebElement

Match known items:	    Convert array → List, use .contains()
Loop all item:          .findElements() -> use .get(i).getText() if needed.
Text cleanup:	        .split("-"), .trim()
Index-based click:	    get(i) to match product and button
Avoid text locators:	Prefer relative XPath over button text
Efficiency:	            Stop loop early using break
Debugging (optional):	Print formattedName during loop
Scalability:        	itemNeeded can come from input (e.g., CSV, Excel, etc.)