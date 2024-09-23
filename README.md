# BenchmarkJava-mutated

## Description
`BenchmarkJava-mutated` project is under active development. The benchmark covers the features of Java language from the list below using the selective fuzzing approach to differentiate SAST tools' functional quality.

* Conditionals:
  - if, else, switch
* Loops:
  - while, for, foreach
  - Recursion, mutual recursion
* Hierarchies and Functions:
  - Virtual method calls, lambda expressions, anonymous classes, tuples
* Exception Handling:
  - try, catch, finally, throw, rethrow, multi-catch
* Strings and Regular Expressions:
  - String handling, regular expressions
* Class and Interface Inheritance:
  - Class hierarchies, interfaces, generic parameters, variance, instanceof, wildcards
* Concurrency and Asynchronous Programming:
  - Threads, concurrency APIs
* Dependency Injection:
  - Dependency injection frameworks
* Reflection:
  - Method invocation, field access, instance creation via reflection
* Initializers:
  - List, dictionary, and object initializers
* Pattern Matching:
  - Pattern matching (introduced in newer versions)
* Collections:
  - Lists, dictionaries, sets, enumerators
* Nullable Types:
  - Optional<T> for handling nullable values
* Function Parameters:
  - Varargs (... syntax)

The original OWASP Benchmark at the <a href="https://github.com/OWASP-Benchmark/BenchmarkJava">OWASP Benchmark</a> GitHub pages. Please refer to that site for all the original project details.
