# NTUT OOP Homework: Calculator Testing

This repository uses JUnit 4 to test the **Calculator.jar**, which is created by using IntelliJ. The video tutorials of creating a Java Calculator are here:

[1. Buidling GUI](https://www.youtube.com/watch?v=S_L-gThl01Y) 

[2. Writing Your Code](https://www.youtube.com/watch?v=YQHU8P2tzG4)

[3. Testing using JUnit](https://www.youtube.com/watch?v=2jaVOGnH4jo)

The default jar file will fail all the tests. You need to upload your own **Caculator.jar** to pass all the tests!


## Running the JUnit tests on your computer

Clone this repository, copy your **Caculator.jar** to the folder, and run the following commands:

### Windows

```
javac -cp ".;junit-4.13.1.jar;Calculator.jar" CalculatorFormTest.java
```
```
java -cp ".;junit-4.13.1.jar;Calculator.jar;hamcrest-core-1.3.jar" CalculatorFormTest
```
### Linux

```
javac -cp ".:./junit-4.13.1.jar:./Calculator.jar" CalculatorFormTest.java
```
```
java -cp ".:./junit-4.13.1.jar:./Calculator.jar:./hamcrest-core-1.3.jar" CalculatorFormTest
```

The test program will print **true** if your **Caculator.jar** pass all the tests!
