# JDBC Servlet CRUD Operation

## 📌 Project Overview

This project is a **Java web application** built using **JDBC, Servlets, JSP, and MySQL** to perform **CRUD operations** on student records.
It demonstrates how to connect a Java-based web application to a database and manage data using **PreparedStatement**, **DAO pattern**, **DTO classes**, and **session handling**.

The project also includes **student registration, login, display, and update functionalities**.

---

## 🚀 Features

* Student Registration
* Student Login Authentication
* Display All Students
* Update Student Details
* Delete Student Record
* Database Connectivity using JDBC
* Secure Query Execution using **PreparedStatement**
* Session Management using **HttpSession**
* JSP-based frontend pages

---

## 🛠️ Technologies Used

* **Java**
* **JDBC**
* **Servlet**
* **JSP**
* **MySQL**
* **Apache Tomcat**
* **Maven**
* **HTML / CSS**

---

## 📂 Project Structure

```bash id="a8n4pu"
jdbc-servlet-crud-operation/
│── src/
│   └── main/
│       ├── java/
│       │   ├── com.ibm.jdbc_servlet_crud_operation.controller
│       │   ├── com.ibm.jdbc_servlet_crud_operation.prepared_Connection
│       │   ├── com.ibm.jdbc_servlet_crud_operation.prepared_statement.client.controller
│       │   ├── com.ibm.jdbc_servlet_crud_operation.prepared_statement.controller
│       │   ├── com.ibm.jdbc_servlet_crud_operation.prepared_statement.dao
│       │   └── com.ibm.jdbc_servlet_crud_operation.prepared_statement.dto
│       │
│       ├── resources/
│       │
│       └── webapp/
│           ├── student-register.jsp
│           ├── student-login.jsp
│           ├── student-display.jsp
│           ├── student-update.jsp
│           └── WEB-INF/
│
│── pom.xml
```

---

## 📖 Modules Used

### 1. **DTO (Data Transfer Object)**

Used to define the **Student model class** and transfer student data between layers.

### 2. **DAO (Data Access Object)**

Used to interact with the database and perform operations like:

* Insert student
* Fetch all students
* Update student
* Delete student
* Login validation

### 3. **Controller**

Used to handle requests coming from JSP pages and process user actions.

### 4. **PreparedStatement**

Used to execute SQL queries securely and efficiently.

### 5. **HttpSession**

Used to maintain login session and user authentication.

---

## 📋 Functionalities

### ✅ Student Registration

Allows users to register student details into the database.

### ✅ Student Login

Allows registered users to log in using their credentials.

### ✅ Student Display

Displays all student records stored in the database.

### ✅ Student Update

Allows modification of existing student details.

### ✅ Student Delete

Removes a student record from the database.

---

## ⚙️ Database Configuration

Create a MySQL database:

```sql id="9k27zy"
CREATE DATABASE student_db;
```

Example student table:

```sql id="p8r0k5"
CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    age INT,
    phone BIGINT
);
```

> ⚠️ Modify the table columns according to your actual project fields.

---

## 🔌 JDBC Connection Setup

Inside your connection class, configure database details like this:

```java id="spmr0w"
String url = "jdbc:mysql://localhost:3306/student_db";
String username = "root";
String password = "your_password";
```

Make sure:

* MySQL server is running
* JDBC driver dependency is added in `pom.xml`

---

## 📦 Maven Dependency Example

Add MySQL JDBC dependency in `pom.xml`:

```xml id="c6h8b9"
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.3.0</version>
</dependency>
```

---

## ▶️ How to Run the Project

### 1. Clone the Repository

```bash id="72b6t4"
git clone https://github.com/YOUR-USERNAME/jdbc-servlet-crud-operation.git
```

### 2. Open in Eclipse

* Open **Eclipse IDE**
* Import as **Existing Maven Project** or **Dynamic Web Project**

### 3. Configure Apache Tomcat

* Add **Apache Tomcat Server**
* Deploy the project on the server

### 4. Configure MySQL Database

* Create the required database and table
* Update database credentials in JDBC connection class

### 5. Run the Application

Start Tomcat and open in browser:

```text id="yyc4h4"
http://localhost:8080/jdbc-servlet-crud-operation/
```

---

## 🖥️ JSP Pages Included

* `student-register.jsp` → Register student
* `student-login.jsp` → Login student
* `student-display.jsp` → Display all students
* `student-update.jsp` → Update student details

---

## 🧠 Concepts Practiced

This project helped in understanding:

* JDBC database connectivity
* Servlet request/response handling
* JSP scripting and page directives
* CRUD operations in Java web apps
* Session management using `HttpSession`
* Layered architecture using DAO and DTO
* SQL query execution with `PreparedStatement`

---

## 🎯 Learning Outcome

Through this project, I gained hands-on experience in building a **Java-based CRUD web application** with proper backend logic, database integration, and dynamic frontend rendering using JSP and Servlets.

---

## 📸 Screenshots

You can add screenshots here later:

```md id="o7gjx3"
![Register Page](screenshots/register.png)
![Login Page](screenshots/login.png)
![Display Page](screenshots/display.png)
```

---

## 🔮 Future Improvements

* Add form validation
* Use JSTL instead of scriptlets
* Add Bootstrap UI
* Encrypt passwords
* Add search and pagination
* Migrate to Spring Boot in future

---

## 👨‍💻 Author

**Aakash Yadav**

---

## ⭐ GitHub Note

If you found this project useful, feel free to **star the repository**.
