# qualito-spring-auth-template

A jumpstart template for building a Spring Boot 2.7.7 web application with authentication, owned and maintained by Qualito.

---

## Features

- **Spring Boot 2.7.7**: Production-ready framework.
- **Authentication**: Role-based user authentication.
- **Thymeleaf**: Preconfigured for dynamic HTML templates.
- **Database**: Configured for MySQL with Docker support.
- **Developer Tools**: Includes Spring DevTools.
- **Logging**: Debug-level logging for Spring Security.

---

## Requirements

- **Java 17+**
- **Gradle Build Tool**
- **Docker & Docker Compose**

---

## Quick Start

### 1. Clone the Repository

```bash
git clone https://github.com/Qualito/qualito-spring-auth-template.git
cd qualito-spring-auth-template
```
### 2. Start the Database

Run the following command in the root directory to start MySQL using Docker Compose:

```bash
docker-compose up -d
```
### 3. Build and Run the Application

```bash
./gradlew bootRun
```
---
