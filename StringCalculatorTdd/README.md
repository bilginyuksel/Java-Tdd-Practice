## StringCalculator

1. String calculator function has a single `add()` method. `Add` method takes a string parameter. This string parameter is an expression an the function should able to add the two numbers inside the expression.

    Example:

    ```java
    String expression = "3,5";
    ```  

    __Expected result is 8__

2. In improvement version of the program expression can be more than 2 number elements. And delimiter can more than 1. Inputs can be very different.

    Example:

    ```java
    String expression = ",3,,,,,5,,7,,"
    ```

    __Expected result is 15__


3. Finally user can use diffent delimiters inside the expression. User doesn't have to use comma as a delimiter. The program should be able to handle the below delimiters.

    Example:

    ```java
    String expression = "-3,5'7==6_33+11";
    ```

    __Expected result is 65__
