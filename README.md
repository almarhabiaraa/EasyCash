# 💳 EasyCash: JavaFX ATM Application

**Course:** Object-Oriented Programming (OOP)  
**Language:** Java (JavaFX)  
**Team Members:** Araa, Sarah, Sahar   

## Project Overview

**EasyCash** is a JavaFX-based ATM simulation program designed to perform core banking transactions through a graphical interface. The system allows users to:

- Log in securely using account number and PIN
- Check account balance
- Deposit and withdraw money
- Generate transaction receipts
- Exit safely from the application

This project demonstrates real-world application of object-oriented principles using Java and JavaFX.

## Repository Structure

```bash
repository/
├── ATM.class        # Compiled Java class file
├── ATM.ctxt         # Context/config file (BlueJ)
├── ATM.java         # Main Java source file
├── package.bluej    # Package info for BlueJ
└── README.TXT       # Project documentation

```

## Key Features
### 1. Login Page
- Accepts account number and PIN
- Validates credentials against pre-defined users (stored in a map)
- Displays appropriate error messages for invalid login attempts
- Credits the developers on the screen

### 2. Menu Page
- Displays current account balance
- Options include:
  - Deposit
  - Withdraw
  - Back to Login
  - Exit
- Uses BorderPane layout for intuitive navigation

### 3. Deposit Page
- Accepts an input amount for deposit
- Updates the balance upon confirmation
- Includes:
  - Input validation
  - Error handling
  - Cancel button (returns to Menu)
  - Deposit button (proceeds to Receipt)

### 4. Withdraw Page
- Accepts an input amount for withdrawal
- Validates balance before deduction
- Displays errors for insufficient funds
- Includes:
  - Cancel button (returns to Menu)
  - Withdraw button (proceeds to Receipt)

### 5. Receipt Page
- Displays transaction type, amount, and date
- Provides buttons to:
- Return to Menu
- Exit Application

## Technologies Used
- Java 8+
- JavaFX GUI Framework
- BlueJ (Educational IDE)

## How to Set Up
### Requirements:
- Java Development Kit (JDK 8 or above)
- JavaFX SDK (if using a version of Java that doesn't bundle it)
- IDE or text editor (e.g., BlueJ, IntelliJ IDEA, Eclipse)

### Steps:
1. Clone the repository or download the .zip file.
```bash
git clone https://github.com/almarhabiaraa/EasyCash.git
```
2. Open the project in your preferred IDE (e.g., BlueJ or IntelliJ).
3. Add JavaFX library to your project settings if necessary.
4. Compile and run the ATM.java file.

Note for BlueJ users: Make sure JavaFX is properly linked in the BlueJ preferences under Libraries.

## Conclusion
EasyCash delivers a clean and interactive ATM experience using JavaFX. It models essential ATM operations like balance inquiry, deposits, and withdrawals, while showcasing OOP principles like encapsulation and modularity. The system is intuitive, user-friendly, and structured for easy future enhancements.

## Contributors
1. Araa AlMarhabi
2. Sarah Alshareef
3. Sahar Albardawil


