# Bookstore Management System

A lightweight, object-oriented Java console application for managing a bookstore’s inventory. The system supports adding, updating, removing, and searching for books, each of which is uniquely identified by a submission number.

---

## Overview

This project demonstrates core Java programming concepts including:

- Class design (encapsulation, abstraction)
- Data management using arrays
- Command-line interaction
- Basic testing using **JUnit 4**

It is designed for educational use, small-scale projects, or as a foundation for more advanced bookstore or inventory systems.

---

## Features

- Add books with `title`, `author`, `ISBN`, and `price`
- Automatically assign a unique **submission number** to each book
- List all books currently in the store
- Search for books by title (case-insensitive)
- Update existing book details
- Remove books from the inventory
- Includes a JUnit 4 test suite to validate core functionality

---

## Structure

```
Solution/
├── Solution.java          # Main class with nested Book and Bookstore classes
├── SolutionTest.java      # JUnit 4 test cases for business logic validation
└── README.md              # Project documentation
```

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- [JUnit 4](https://junit.org/junit4/) for testing

### Compile and Run

```bash
javac Solution.java
java Solution
```

### Run Tests (Using CLI)

```bash
javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar Solution.java SolutionTest.java
java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore SolutionTest
```

> Tip: For Windows, replace `:` with `;` in classpath.

---

## Test Coverage

The `SolutionTest.java` suite covers:

- Adding and retrieving a book
- Updating a book’s details
- Removing a book
- Ensuring unique submission numbers are assigned

---

## Sample Console Output

```
WELCOME TO THE BOOK MANAGEMENT SYSTEM
****************************************************

Bookstore Menu:
1. Add Book
2. List Books
3. Find Book by Title
4. Remove Book by Title
5. Update Book Details
6. Exit
```

---
