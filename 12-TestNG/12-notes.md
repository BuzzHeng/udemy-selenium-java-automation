### 12 – TestNG + testng.xml
---
[@Test Annotation]
- Marks method as test
- One class can have multiple @Test
[testng.xml Structure]
- Suite → Test → Classes
[Example]
```xml
<suite name="Load Department">
  <test name="Personal Loan">
    <classes>
      <class name="test."/>
      <class name="test."/>
    </classes>
  </test>
</suite>
```
[Usage]
- Run multiple classes
- Supports include/exclude, parameters
- Run with: mvn test -DsuiteXmlFile=testng.xml
- Modularize test cases based up on functionality and trigger them accordingly


### 16.1 – Include / Exclude Methods in testng.xml

---
[Purpose]
- Control which @Test methods to run or skip
- Useful for organizing large test suites

[Best Practice]
- Use consistent method names (e.g. *Login*, *HomeLoan*)
- Makes it easier to include/exclude with patterns

[include] → run only the listed method(s)  
[exclude] → skip only the listed method(s)  
[Regex]   → use `.*` to match patterns (e.g. `.*Login.*`)

[Example]
```xml
<class name="test.test.SecondLesson04">
  <methods>
    <include name="MobileLoginHomeLoan"/>
    <exclude name="WebLoginHomeLoan"/>
    <include name=".*Login.*"/>
  </methods>
</class>
```

### Annotation

@BeforeTest     → runs before <test> in testng.xml  
@AfterTest      → runs after <test> in testng.xml  
@BeforeSuite    → runs before the entire <suite>  
@AfterSuite     → runs after the entire <suite>  
@BeforeClass    → runs once before the first @Test in current class  
@AfterClass     → runs once after the last @Test in current class  
@BeforeMethod   → runs before every @Test method in current class  
@AfterMethod    → runs after every @Test method in current class  
@BeforeGroups   → runs before the first method in specified group(s)  
@AfterGroups    → runs after the last method in specified group(s)

---

### Group Usage in TestNG
[@Test(groups="GroupName")] → assign test method to a group  
<include name="GroupName"/> → run only specific group from testng.xml

[Example]
```java
@Test(groups = "Smoke")
public void verifyLogin() { ... }
```

```xml
<groups>
  <run>
    <include name="Smoke"/>
  </run>
</groups>
```

### 17.1 – Helper Attributes in @Test

---

[dependsOnMethods = {"methodName"}]  
→ run current test only after dependent method passes

[enabled = false]  
→ skip test without commenting or removing

[priority = n]  
→ lower number runs first (optional, not recommended with parallel)

[alwaysRun = true]  
→ run this method even if dependent methods fail

[timeOut = ms]  
→ fail test if it runs longer than given milliseconds

[invocationCount = n]  
→ run the same test method n times

[Example]
```java
@Test(dependsOnMethods = {"login"}, enabled = false)
public void dashboard() { ... }
```

## Parameterizing from TestNG xml files
There should be no hardcoding for framework.
All details should come from external centralized files.
---

[@Parameters] → inject values from testng.xml  
`<parameter name="key" value="value"/>` → defined in xml

[suite-level]  → applies to all tests  
[test-level]   → overrides suite-level for that <test>

[Optional] → @Optional("default") to avoid error if param not found

[Example]
```java
@Parameters({"url"})
@Test
public void launchApp(String url) {
    driver.get(url);
}
```
```xml
<suite name="Suite">
  <parameter name="url" value="https://site.com"/>

  <test name="Module">
    <parameter name="url" value="https://override.com"/>
    <classes>
      <class name="tests.LoginTest"/>
    </classes>
  </test>
</suite>
```

Parameterising with multiple data sets by running tests with multiple combination

How to achieve parameterising?
1. From TestNG xml file using Parameter
2. use DataProvider Annotation