# Bob’s Bakery — Back-End

A self-contained Spring Boot REST API that provides all server-side functionality for Bob’s Bakery:

* **Product catalogue** – CRUD endpoints for breads, pastries and seasonal items  
* **Ordering & checkout** – cart, order placement, payment-callback hooks  
* **Inventory tracking** – real-time stock levels and low-stock alerts  
* **User accounts & roles** – JWT-secured sign-up / login for customers and admins  
* **Admin dashboard API** – sales metrics, order fulfilment status and product analytics  

---

## Tech stack

| Layer | Choice | Notes |
|-------|--------|-------|
| Language | **Java 17** | 100 % of codebase |
| Framework | **Spring Boot 3.x** | Web / MVC, Validation, Security, Actuator |
| Build tool | **Gradle 8 (wrapper included)** | `./gradlew build` everywhere |
| Database | **PostgreSQL 15** | Change to MySQL/MariaDB by editing `application.properties` |
| Migrations | **Flyway** | Auto‑runs on startup |
| AuthN/Z | **Spring Security + JWT** | Roles: `CUSTOMER`, `ADMIN` |

---

## Getting started (local)

```bash
# 1 – clone
git clone https://github.com/Enock97/Bobs-Bakery-BackEnd.git
cd Bobs-Bakery-BackEnd

# 2 – configure env (edit .env or export vars)
export DB_URL=jdbc:postgresql://localhost:5432/bakery
export DB_USER=postgres
export DB_PASS=postgres
export JWT_SECRET=change-me

# 3 – run
./gradlew bootRun
```

Server starts on **`http://localhost:8080`** with hot‑reload.

---
