## Java Streams, Lambda Expressions for Building Optmized Code

What are streams?
- Streams API are featured from Java 8
- To perform various aggregated operations on the data returned from collection classes 
by drastically reduced complexity of code.

What is Lambda Expression?
- new arrow operator ->
- Divides lambda expressions in two parts:
  - Left side: Parameter required by expressions, empty if not required.
  - Right side: Actions of the lambda expressions.

The working of stream can be explained in three stages:
1. Create a stream
2. Perform intermediate operations on the initial stream to transform it into another stream 
and so on further intermediate operations
3. Perform terminal operation on final stream to get result.

An important characteristic of intermediate operations is laziness.
When executing this code snippet, nothing is printed on console.
Because intermediate operations will only be executed when a terminal operation is present.

--- 3 Key Steps to Using Stream ---
1. Get the stream     → list.stream(), Arrays.stream(...), etc.
2. Process the stream → filter(), map(), sorted(), etc.
3. Collect the result → collect(...), forEach(), count(), etc.

--- Intermediate Operations ---
filter()         -> keep items matching a condition  
map()            -> transform each item  
flatMap()        -> flatten nested lists  
sorted()         -> sort the stream  
distinct()       -> remove duplicates  
limit()          -> take first N items  
skip()           -> skip first N items  
peek()           -> inspect/debug elements

--- Terminal Operations ---
collect()        -> convert stream to list/set/map  
count()          -> count number of items  
forEach()        -> perform action on each item  
anyMatch()       -> true if any item matches  
allMatch()       -> true if all items match  
noneMatch()      -> true if no items match  
findFirst()      -> get first item (if present)  
findAny()        -> get any item (parallel-friendly)  
reduce()         -> combine items into one  
toArray()        -> convert to array

--- Common Stream Sources ---
list.stream()                        -> from List  
set.stream()                         -> from Set  
Arrays.stream(array)                 -> from Array  
map.entrySet().stream()              -> from Map entries  
map.keySet().stream()                -> from Map keys  
map.values().stream()                -> from Map values  
Stream.of("a", "b", "c")             -> from values directly  
IntStream.range(1, 10)               -> 1 to 9  
IntStream.rangeClosed(1, 10)         -> 1 to 10  
Files.lines(Paths.get("file.txt"))   -> from file lines  
reader.lines()                       -> from BufferedReader

### 13 – Handling Tables in Selenium (Simple)

#### Basic Tags
- `<table>` = table
- `<tr>`    = row
- `<td>`    = cell
- `<th>`    = header

#### Read Table
- All rows        → `//table//tr`
- First column    → `//tr/td[1]`
- Specific cell   → `//tr[2]/td[3]`
- Get text        → `element.getText()`

#### Loop Rows
```java
List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
for (WebElement row : rows) {
    List<WebElement> cells = row.findElements(By.tagName("td"));
}
```

#### Filter Item + Get Price
```java
rows.stream()
    .filter(s -> s.getText().contains("Rice"))
    .map(s -> getPrice(s)) // use custom method
    .forEach(System.out::println);
```

#### Custom Method
```java
public static String getPrice(WebElement s) {
    return s.findElement(By.xpath("following-sibling::td[1]")).getText();
}
```

#### Pagination
```java
do {
    // filter and get price
    if (price.isEmpty()) {
        driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
    }
} while (price.isEmpty());
```

#### Tips
- Use `following-sibling::td[1]` to get price cell
- Check list size before using `.get()`
- Avoid hardcoding row numbers — scan dynamically
