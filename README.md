# 📚 Library Management System

A Java-based Library Management System that helps manage books, members, book issuing, and return operations using MySQL for data storage.

## 🚀 Features

- 📖 Add, update, delete, and view books
- 👤 Add, update, delete, and view members
- 📕 Issue books to members
- 📗 Return issued books
- 🔍 Display available books and issued books
- 💾 MySQL database integration using JDBC
- 🖥️ Console-based menu-driven application

---

## 🛠️ Tech Stack

- Java
- JDBC
- MySQL
- Maven
- IntelliJ IDEA

---

## 📂 Project Structure

```
Library/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── connection/
│   │   │   ├── model/
│   │   │   ├── operation/
│   │   │   └── Main.java
│   └── resources/
│
├── pom.xml
└── README.md
```

---

## ⚙️ Prerequisites

- Java JDK 17 or later
- MySQL Server
- IntelliJ IDEA (or any Java IDE)
- Maven

---

## 🗄️ Database Setup

1. Install MySQL.
2. Create a database.

```sql
CREATE DATABASE library;
```

3. Create the required tables (Books, Members, Issue Records).
4. Update the database credentials in:

```
src/main/java/connection/MySqlConnection.java
```

Example:

```java
String url = "jdbc:mysql://localhost:3306/library";
String username = "root";
String password = "your_password";
```

---

## ▶️ How to Run

1. Clone the repository

```bash
git clone https://github.com/vaishnaviborde1309-coder/library_management_system.git
```

2. Open the project in IntelliJ IDEA.

3. Configure the MySQL database connection.

4. Build the project using Maven.

5. Run `Main.java`.

---

## 📸 Screenshots

Add screenshots of:

- Main Menu
- Book Management
- Member Management
- Issue Book
- Return Book

---

## 🔮 Future Improvements

- Java Swing/JavaFX GUI
- Login Authentication
- Fine Calculation
- Book Search
- Due Date Notifications
- Report Generation
- Barcode Integration

---

## 👩‍💻 Author

**Vaishnavi Borde**

- B.E. Computer Science & Data Science
- Savitribai Phule Pune University (SPPU)

GitHub:
https://github.com/vaishnavi-borde/library_management_system

---

## 📜 License

This project is created for learning and academic purposes.
