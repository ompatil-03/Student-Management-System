# Student Management System

## Table of Contents

1. [Overview](#overview)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Prerequisites](#prerequisites)
5. [Setup Instructions](#setup-instructions)
6. [Screenshots](#screenshots)

## Overview

The Student Management System is a Java-based application designed to manage student records efficiently. It utilizes JDBC for database connectivity and MySQL as the database management system. This project allows users to perform CRUD (Create, Read, Update, Delete) operations on student records, providing a simple and intuitive interface.

## Features

- Add new student records
- View existing student records
- Update student information
- Delete student records
- Search for students by their IDs

## Technologies Used

- **Java:** Core programming language for the application.
- **JDBC:** Java Database Connectivity for database interaction.
- **MySQL:** Relational database management system to store student records.

## Prerequisites

Before running this project, ensure you have the following installed:

- Java Development Kit (JDK) 8 or above
- MySQL Server
- MySQL Connector/J (JDBC Driver)

## Setup Instructions

1. **Clone the Repository:**
   ```sh
   git clone https://github.com/yourusername/student-management-system.git
   cd student-management-system
   ```

2. **Create the Database:**
   - Open MySQL Workbench or any MySQL client.
   - Execute the following SQL script to create the database and tables:
     ```sql
     CREATE DATABASE student_management;
     USE student_management;

     CREATE TABLE students (
         id INT AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR(50) NOT NULL,
         course VARCHAR(50),
         city VARCHAR(50),
         totalMarks int,
         phoneNo VARCHAR(20)
     );
     ```

3. **Configure Database Connection:**
   - Open the `DatabaseConnection.java` file in the `src` directory.
   - Update the database URL, username, and password according to your MySQL setup:
     ```java
     private static final String URL = "jdbc:mysql://localhost:3306/database_name";
     private static final String USER = "yourusername";
     private static final String PASSWORD = "yourpassword";
     ```

4. **Compile and Run the Application:**
   - Open a terminal/command prompt.
   - Navigate to the project directory and run:
     ```sh
     javac -d bin src/com/studentmanagement/*.java
     java -cp bin:lib/mysql-connector-java-8.0.23.jar com.studentmanagement.Main
     ```

## Screenshots

| Adding Student | Table View |
| -------------- | ---------- |
| ![Adding Student](https://github.com/user-attachments/assets/e323979d-28cc-476b-b47e-5e70d4d32588) | ![Table View](https://github.com/user-attachments/assets/c2106e98-cda0-4578-9777-aac4cb4ed3f6) |
| Updating Student | Deleting Student |
| ---------------- | ---------------- |
| ![Updating Student](https://github.com/user-attachments/assets/afc13a23-a360-402d-9650-0e4128e108be) | ![Deleting Student](https://github.com/user-attachments/assets/91f7f1be-f750-48c7-b732-d8473f257761) |


