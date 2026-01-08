# Transaction-Management-System
A simple Spring Boot application for managing financial transactions. This project demonstrates CRUD operations, filtering, and balance calculation using Spring Data JPA, H2 Database, and RESTful APIs

Features

Create Transaction: Add income or expense transactions.
View All Transactions: Retrieve all transactions from the database.
Get Transaction by ID: Fetch details of a specific transaction.
Filter Transactions: Filter transactions based on minimum and maximum amount.
Calculate Balance: Compute the net balance (Income - Expense).


Tech Stack

Java 21
Spring Boot 4.0
Spring Data JPA
H2 Database (In-memory)
Lombok (for boilerplate code reduction)
Spring Boot DevTools (for development convenience)


Project Structure
com.example.Transaction
│
├── Dto
│   ├── inputDto.java
│   ├── ViewDto.java
│   └── BalanceDto.java
│
├── Entity
│   └── Transaction.java
│
├── Repository
│   └── TransactionRepo.java
│
├── web
│   └── TransactionService.java
│
├── exception
│   ├── InputSearchException.java
│   └── NotFoundException.java
│
└── TransactionMapper.java

Future Enhancements

Add authentication & authorization using Spring Security.
Implement pagination and sorting for transactions.
Integrate with a real database (MySQL/PostgreSQL).
Add unit and integration tests.
