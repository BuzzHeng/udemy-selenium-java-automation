# Selenium Misc Notes

## 1. ChromeOptions Setup
- Set download directory
- Ignore SSL certificates
- Use proxy (if site requires)

---

## 2. WebDriver manage()
```java
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
```

---

## 3. Take Screenshot
```java
File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(src, new File("path/screenshot.png"));
```

---

## 4. Broken Link Check (HttpURLConnection)
**Steps:**
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

## 5. Modern Alternative (Java 11+ HttpClient)
```java
HttpRequest req = HttpRequest.newBuilder()
    .uri(URI.create(url))
    .method("HEAD", HttpRequest.BodyPublishers.noBody())
    .build();

HttpResponse<Void> res = HttpClient.newHttpClient()
    .send(req, HttpResponse.BodyHandlers.discarding());

System.out.println(res.statusCode());
```

---

## 6. Attribute Methods Summary
| Method                      | Returns                          | Use Case                        |
|-----------------------------|-----------------------------------|----------------------------------|
| `getText()`                 | Visible text                     | Button/link label               |
| `getAttribute("href")`      | Raw HTML value                   | Original tag value              |
| `getDomAttribute("href")`   | Same as above (strict spec)      | Static value                    |
| `getDomProperty("href")`    | Resolved full value (absolute)   | Use for link checking           |

---

## 7. SoftAssert Usage
```java
SoftAssert sa = new SoftAssert();

sa.assertTrue(condition, "Failure message");
sa.assertEquals(actual, expected, "Mismatch message");

sa.assertAll(); // Required to report all failures
```

**Use When:**
- You want to continue test execution even if some validations fail
- Useful for checking multiple links, table rows, or form fields
