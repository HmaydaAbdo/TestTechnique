# SkyPay - Java Maven Project

## Overview

SkyPay is a Java-based banking system that allows users to deposit, withdraw, and track account transactions. The system includes classes for managing accounts and transactions, along with methods to print account statements in a specified format.

This project also includes unit tests to verify the functionality of the methods in the `Account` class, including deposit, withdrawal, and statement printing.

## Requirements

Before running the project, ensure you have the following installed:

- **Java 17** or higher
- **Maven** (for building and running the project)
- **JUnit 5** (for running tests, already included in the `pom.xml`)

## Running the Java Program

To run the main program, follow these steps:

1. Clone the repository or download the project.
2. Open a terminal and navigate to the project directory.
3. Run the following Maven command to compile and run the program:

    ```bash
    mvn clean compile exec:java
    ```

   This will execute the program, and you should see the output printed on the console. If everything is set up correctly, it will show deposit, withdrawal, and balance updates.

## Running Tests

To run the unit tests for the project, follow these steps:

1. Navigate to the project directory (if not already there).
2. Run the following Maven command to execute the tests:

    ```bash
    mvn test
    ```

   This will run all the unit tests defined in the project and provide feedback on whether all tests passed or failed. If any tests fail, Maven will provide detailed error logs.

## Project Structure

- `src/main/java/org/example/interfaces/AccountService.java`: Defines the `AccountService` interface with methods for deposit, withdrawal, and statement printing.
- `src/main/java/org/example/entities/Account.java`: Implements the `AccountService` interface and manages account transactions.
- `src/main/java/org/example/entities/Transaction.java`: Represents individual transactions with a date, amount, and balance.
- `src/test/java/org/example/AccountServiceTest.java`: Contains unit tests for verifying the behavior of the `Account` class methods.

## Example Usage

Here’s an example of how the program runs:

1. A deposit of 1000 is made.
2. Another deposit of 2000 is made.
3. A withdrawal of 500 is performed.
4. The statement prints in reverse order, showing transactions from most recent to oldest.

The final balance will be the result of the deposits minus any withdrawals.

## Additional Information

If you encounter any issues or have questions about the project, feel free to contact me 