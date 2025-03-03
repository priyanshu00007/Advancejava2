# Servlet and Filter Functionality

## Overview
This project demonstrates the implementation of **Servlets and Filters** in Java EE. It includes:
- HTTP Session Management
- Cookie Management
- Servlet Filters for request validation

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

## Project Structure
```
/ServletFilterProject
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
│── web.xml
│── index.html
│── README.md
```

## Setup Instructions
### Prerequisites
- JDK 8+
- Apache Tomcat (or any Java EE-compatible server)
- Eclipse/IntelliJ IDEA (Optional)

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
```

## Contributing
Feel free to contribute by improving security, adding new features, or optimizing performance. Submit a pull request with your updates.

## License
This project is licensed under the MIT License.

