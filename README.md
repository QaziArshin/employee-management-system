# Employee Management System

## Project Overview

Employee Management System is a Spring Boot REST API application that allows users to securely manage employee records using JWT Authentication and Spring Security.

The application provides user registration, login, authentication, employee CRUD operations, pagination, sorting, validation, and exception handling.

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JWT Authentication
- MySQL
- Maven
- Postman
- Git & GitHub

---

## Features

### Authentication
- User Registration
- User Login
- JWT Token Generation
- JWT Authentication
- Password Encryption using BCrypt

### Employee Management
- Add Employee
- View All Employees
- View Employee by ID
- Update Employee
- Delete Employee

### Additional Features
- Pagination
- Sorting
- Bean Validation
- Global Exception Handling
- RESTful APIs

---

## API Endpoints

### Authentication

POST /api/auth/register

POST /api/auth/login

---

### Employees

GET /api/employees

GET /api/employees/{id}

POST /api/employees

PUT /api/employees/{id}

DELETE /api/employees/{id}

GET /api/employees/page?page=0&size=5&sortBy=name

---

## Security

- JWT Authentication
- Stateless Authentication
- BCrypt Password Encoding
- Spring Security Filter Chain

---

## Database

MySQL

Tables

- users
- employees

---

## Tools Used

- IntelliJ IDEA / Eclipse
- Postman
- MySQL Workbench
- GitHub

---

## Future Enhancements

- Swagger Documentation
- Unit Testing
- Docker
- Role Based Authorization (ADMIN/USER)
