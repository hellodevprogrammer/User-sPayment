# 💳 User Payment Management API (Spring Boot + MySQL)

This project is a RESTful API built with Java Spring Boot and MySQL that allows managing users and their payment records securely. It includes card validation (Luhn check), sensitive data masking, and clean architecture.

---------------------------------------------------------------------------------------------------------------------

## 🧱 Project Structure



![image](https://github.com/user-attachments/assets/0e8ad278-8718-4eab-890e-7f69fd32ecd6)


-----------------------------------------------------------------------------------------------------------------------

🧱 Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/user_payment_db
spring.datasource.username=your_mysql_user
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8089
springdoc.swagger-ui.path=/swagger-ui.html

-------------------------------------------------------------------------------------------------------------------------
🧱 Create MySQL Database:

CREATE DATABASE user_payment_db;

📘 API Documentation (Swagger)

http://localhost:8089/swagger-ui.html

-----------------------------------------------------------------------------------------------------------------------------
📬 API Endpoints

👤 User APIs

| Method | Endpoint      | Description         |
| ------ | ------------- | ------------------- |
| POST   | `/users`      | Create a new user   |
| GET    | `/users`      | Get all users       |
| PUT    | `/users/{id}` | Update a user by ID |
| DELETE | `/users/{id}` | Delete a user by ID |


-----------------------------------------------------------------------------------------------------------------------------

🧱 Sample Create User Request:

POST /users
{
  "name": "John Doe",
  "email": "john@example.com",
  "phone": "9147451517",
  "country": "IN"
}


-------------------------------------------------------------------------------------------------------------------------------

💰 Payment APIs

| Method | Endpoint                   | Description                 |
| ------ | -------------------------- | --------------------------- |
| POST   | `/users/{userId}/payments` | Add a payment for a user    |
| GET    | `/users/{userId}/payments` | Get all payments for a user |



--------------------------------------------------------------------------------------------------------------------------------


🧱 Sample Add Payment Request:

POST /users/1/payments
{
  "amount": 250.75,
  "currency": "USD",
  "description": "Book purchase",
  "card_no": "4111111111111111",
  "card_expiry": "12/2025",
  "card_cvc": "123"
}


--------------------------------------------------------------------------------------------------------------------------------

🗃️ Database Schema

🕵️‍♀️ users table:

| Column      | Type        |
| ----------- | ----------- |
| id          | bigint (PK) |
| name        | varchar     |
| email       | varchar     |
| phone       | varchar     |
| country     | varchar     |
| created\_at | datetime    |
| updated\_at | datetime    |


💵 Payment table:

| Column       | Type             |
| ------------ | ---------------- |
| id           | bigint (PK)      |
| user\_id     | bigint (FK)      |
| amount       | double           |
| currency     | varchar          |
| description  | varchar          |
| card\_no     | varchar (masked) |
| card\_expiry | varchar          |
| card\_cvc    | varchar (masked) |
| created\_at  | datetime         |


--------------------------------------------------------------------------------------------------------------------------------



🧱 Features Implemented

✅ RESTful API (User & Payment)

✅ Luhn Algorithm for card number validation

✅ Card number and CVC masking

✅ MySQL integration via Spring Data JPA

✅ Swagger UI with OpenAPI 3


-------------------------------------------------------------------------------------------------------------------------------
