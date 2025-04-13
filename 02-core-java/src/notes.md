--------------------------
# 02-Core-Java
--------------------------

### CoreJavaBrushUp1
```
1. Variables & Data Types
    - int: whole numbers
    - String: text
    - char: single character
    - double: decimal numbers
    - boolean: true/false

2. Arrays
    - Fixed size, zero-indexed
    - Declare with size or initialize directly
    - Use arr[index] to access elements
    - Use arr.length to get size

3. Looping (applies to arrays, lists, strings)
    - for-loop: use index when position matters
    - for-each: simpler when only value is needed
```

### CoreJavaBrushUp2
```
1. Array vs ArrayList (Interview qns)
    - Array: fixed size, can store primitives or objects
    - ArrayList: dynamic size, object-only, many built-in methods

2. ArrayList Usage
    - add(), get(), size(), contains()
    - contains() is case-sensitive

3. Convert Array to List
    - Arrays.asList(array) → allows list methods like contains()

4. Control Flow (applies to any collection or logic)
    - if-else: condition checks
    - %: check for even/multiples
    - break: exit loop early
```

### CoreJavaBrushUp3
```
1. Strings (interview qns)
    - String is an object
    - Two ways to define: literal (string pool) or new keyword (heap)
    - Strings are immutable

2. Useful String Methods
    - split(): split text into parts
    - trim(): remove spaces
    - charAt(i): get char at index
    - length(): total characters

3. Looping a String
    - Use for-loop + charAt(i) to read characters
    - Reverse with loop from length-1 to 0

4. Notes
    - Use .equals() to compare values, not ==
    - split() returns a String array
```

### MethodDemo & MethodDemo2
```
1. Methods
    - Reusable code blocks, can return values

2. Static vs Non-Static
    - static: called without object (class-level)
    - non-static: needs object to call (instance-level)

3. Cross-Class Method Calls
    - Use new ClassName() to call methods from another class

4. Notes
    - Methods can print and return values
    - Return type must match method definition
```