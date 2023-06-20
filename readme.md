# Simple Banking System in Java

This repository contains a basic simulation of a banking system implemented in Java. The project demonstrates the principles of Object-Oriented Programming (OOP) such as inheritance and encapsulation.

## Description

The system supports operations like deposit and withdrawal for different types of bank accounts: Regular, Overdraft, and Joint Overdraft. It includes validation checks and custom exceptions for various potential issues such as insufficient balance, invalid social security numbers, or withdrawal amounts.

### The main classes included in the project are:

1. `User`: Represents a user or account holder with properties like first name, last name, and social security number.
2. `Account`: Represents a bank account with operations like deposit and withdrawal.
3. `JointAccount`: Inherits from `Account` and represents a bank account jointly held by two users.
4. `OverdraftAccount`: Inherits from `Account` and represents an overdraft account, which allows for negative balance.
5. `OverdraftJointAccount`: Inherits from `JointAccount` and represents a joint overdraft account.

Additionally, the `IdentifiableEntity` class is used as a base class for entities that require a unique identifier.

### Custom exceptions used in this project are:

1. `InsufficientAmountException`: Thrown when the deposit or withdrawal amount is zero or negative.
2. `InsufficientBalanceException`: Thrown when the withdrawal amount exceeds the account balance.
3. `SsnNotValidException`: Thrown when the social security number provided does not match the account holder's.

## Installation and Usage

The project can be run using any Java IDE or from the command line by compiling the java files and running the Main.java file.