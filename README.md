# 📝 Todo List REST API

This is a simple RESTful API to manage a Todo list, built using **Spring Boot**, **Hibernate (JPA)**, and **PostgreSQL**. The application allows users to create, read, update, and delete todo items.

---

## 🚀 Features

- ✅ REST API with CRUD operations
- ✅ PostgreSQL integration
- ✅ Hibernate + Spring Data JPA
- ✅ Clean architecture with service & repository layers
- ✅ Unit tests with >80% coverage
- ✅ Docker-ready (optional)
- ✅ Checkstyle, JaCoCo, and best practices

---

## 🧱 Technologies

- Java 17+
- Spring Boot 3
- Hibernate / JPA
- PostgreSQL
- Maven
- JUnit 5 + Mockito
- Lombok

---

## 📦 How to Run

### 1. 📂 Prerequisites
- Java 17+
- PostgreSQL running locally (or via Docker)
- Maven

### 2. 🛠️ Setup PostgreSQL

Create a database:

```sql
CREATE DATABASE todo_db;

```
## 🤖 Task Feedback
Task: Create a RESTful API to manage a simple todo list application using Spring Boot, Hibernate, and PostgreSQL
Was it easy to complete the task using AI?
Yes. The process was structured and broken down into logical steps. Generating each component (entity, service, controller, tests) with prompts was smooth.

How long did the task take you to complete?
Approximately 30–40 minutes total (including setup, generation, debugging, and test writing)

Was the code ready to run after generation? What did you have to change to make it usable?
Mostly yes. Minor updates were needed:

Switched DB from MySQL to PostgreSQL

Added PostgreSQL JDBC driver

Set DB credentials in application.properties

Which challenges did you face during completion of the task?

Setting up folder structure programmatically

Managing PostgreSQL configuration correctly for Hibernate

Ensuring unit tests reached >80% coverage

Which specific prompts you learned as a good practice to complete the task?

“Generate a Spring Boot REST controller with CRUD endpoints”

“Switch Spring Boot project from MySQL to PostgreSQL”

“Write JUnit + Mockito unit tests for service class”

“Create application.properties for PostgreSQL with Hibernate”

“Add Checkstyle and JaCoCo to Spring Boot project”

