## About
This project demonstrates CRUD operations in Java using JDBC and PostgreSQL.  
It applies OOP principles and connection pooling for efficient database management.

# JDBC-CRUD-App

A modular Java application demonstrating **CRUD operations** (Create, Read, Update, Delete) using **JDBC** with PostgreSQL.  
Built with **Maven** for dependency management and structured into packages for scalability.

## 📂 Project Structure
- `com.admin` → Admin access and menu handling
- `com.employee` → Employee CRUD operations and menu
- `com.mainMenu` → Main navigation entry point
- `com.pool` → Connection Pool utility for optimized DB connectivity

## ⚙️ Features
- CRUD operations on employee records
- Role-based access (Admin / Employee)
- Connection pooling for efficient database usage
- OOP principles applied (Encapsulation, Abstraction, Polymorphism)

## 🚀 Technologies Used
- Java (JDK 8+)
- JDBC
- PostgreSQL
- Maven

## ▶️ How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/selvavijinraja/JDBC-CRUD-App.git
2. Configure database in Connection_Pool.java:
   ```java
   String url = "jdbc:postgresql://localhost:5432/yourDB";
   String user = "postgres";
   String password = "yourpassword";
3. Build and run:
   ```bash
   mvn clean install
   java -cp target/jdbc-project-1.0-SNAPSHOT.jar com.mainMenu.MainMenu
## 📜 License
This project is for learning purposes.

---

### 🔧 How to add it
1. In your local project folder, create a file named `README.md`.  
2. Paste the above content into it.  
3. Commit and push to GitHub:
   ```bash
   git add README.md
   git commit -m "Add README file"
   git push origin main



