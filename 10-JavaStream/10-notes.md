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