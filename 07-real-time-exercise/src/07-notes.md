### Handling Multiple Link, Keys Chord

1. How to count number of links in a webpage?
    ```
    driver.findElements(By.tagname("a")).size()
    ```
2. How to count number of links only on header section of the webpage?
    ```
    WebElement header = driver.findElement(By.name("header"));
    header.findElements(By.tagname("a)).size()
    ```
3. How to verify if links on click open a new page?
    ```
    String clickL = Keys.chord(Keys.CONTROL, Keys.ENTER)
    driver.findElements(By.tagname("a")).sendkeys(clickL);
    ```
4. What does hasNext() method return?
    ```
    return true if the iteration has more elements.
    ```
5. How to switch to a new window opened in Selenium?
    ```
    for(String winHandle : driver.getWindowHandles(){
       driver.switchTo().Window(winHandle)
    }
    ```
6. What is the return type of findElements() method?
    ```
    List<WebElement>
    ```

### Handling Calander

1. Find the WebElement for day, month year and store in a List<WebElement>
    ```
    List<WebElement> actualList = driver.findElements(
                                    By.cssSelector(".react-date-picker__inputGroup__input"));
    ```
2. Use loop to get the value with .getDomAttribute()
    ```
    for(int i = 0; i< actualList.size(); i++){
        String value = actualList.get(i).getDomAttribute("value");
        System.out.println(value);
        Assert.assertEquals(value,expectedList[i]);
    }
    ```





