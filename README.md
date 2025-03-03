# Servlet and Filter Functionality with CRUD Operations

## Overview
This project demonstrates the implementation of **Servlets and Filters** in Java EE along with **CRUD operations using JDBC**. It includes:
- HTTP Session Management
- Cookie Management
- Servlet Filters for request validation
- CRUD (Create, Read, Update, Delete) operations using JDBC

## Features
### 1️⃣ **Cookie Management**
- Stores user credentials in cookies upon login.
- Retrieves and displays stored cookies across multiple pages.
- Implements cookie expiration and security measures.

### 2️⃣ **Session Management**
- Creates and manages user sessions using `HttpSession`.
- Retrieves session data across multiple servlets.
- Implements session timeout and invalidation.

### 3️⃣ **Servlet Filters**
- Implements authentication filters to validate login credentials.
- Uses filters to restrict access based on parameters.
- Demonstrates pre-processing and post-processing filters.

### 4️⃣ **CRUD Operations using JDBC**
- Connects to a MySQL database using JDBC.
- Implements Create, Read, Update, and Delete operations on a user table.
- Uses different types of JDBC statements:
  - **Statement**: Basic SQL execution.
  - **PreparedStatement**: Precompiled SQL queries for efficiency.
  - **CallableStatement**: Calls stored procedures.

## Project Structure
```
/ServletFilterCRUDProject
│── src/
│   ├── servlets/
│   │   ├── Cookie1.java
│   │   ├── Cookie2.java
│   │   ├── Cookie3.java
│   │   ├── HSession1.java
│   │   ├── HSession2.java
│   │   ├── HSession3.java
│   │   ├── FilteredServlet.java
│   ├── filters/
│   │   ├── Filter1.java
│   │   ├── Filter2.java
│   ├── crud/
│   │   ├── AddUserServlet.java
│   │   ├── ViewUsersServlet.java
│   │   ├── UpdateUserServlet.java
│   │   ├── DeleteUserServlet.java
│   │   ├── DatabaseConnection.java
│── web.xml
│── index.html
│── README.md
│── database.sql
```

## Setup Instructions
### Prerequisites
- JDK 8+
- Apache Tomcat (or any Java EE-compatible server)
- MySQL Database
- Eclipse/IntelliJ IDEA (Optional)

### Database Setup
1️⃣ Create a MySQL database and table:
```sql
CREATE DATABASE userdb;
USE userdb;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100)
);
```

2️⃣ Update the `DatabaseConnection.java` file with your MySQL credentials:
```java
private static final String URL = "jdbc:mysql://localhost:3306/userdb";
private static final String USER = "root";
private static final String PASSWORD = "yourpassword";
```

### Steps to Run
1️⃣ Clone the repository:
```sh
git clone https://github.com/your-username/your-repo.git
cd your-repo
```

2️⃣ Compile and deploy the application on Tomcat.

3️⃣ Access the servlet using the browser:
```
http://localhost:8080/your-app-name/Cookie1
http://localhost:8080/your-app-name/HSession1
http://localhost:8080/your-app-name/FilteredServlet
http://localhost:8080/your-app-name/AddUserServlet
http://localhost:8080/your-app-name/ViewUsersServlet
http://localhost:8080/your-app-name/UpdateUserServlet
http://localhost:8080/your-app-name/DeleteUserServlet
```

## Git Commands to Push Updates
```sh
git add .
git commit -m "Added servlet and filter functionality with CRUD operations"
git push origin main
```

## Contributing
Feel free to contribute by improving security, adding new features, or optimizing performance. Submit a pull request with your updates.

## License
This project is licensed under the MIT License.

