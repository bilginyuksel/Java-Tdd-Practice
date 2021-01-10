## StringCalculator

1. String calculator function has a single `add()` method. `Add` method takes a string parameter. This string parameter is an expression and the function should be able to add two numbers inside this expression.

    Example:

    ```java
    String expression = "3,5";
    ```  

    __Expected result is 8__

2. In the improved version of the program expression can contain multiple numbers and delimiters at the same time. Inputs can be very different.

    Example:

    ```java
    String expression = ",3,,,,,5,,7,,"
    ```

    __Expected result is 15__


3. Input can contain different delimiter types inside the expression. 

    Example:

    ```java
    String expression = "-3,5'7==6_33+11";
    ```

    __Expected result is 65__
