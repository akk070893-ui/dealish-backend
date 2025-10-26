# Dealish - Spring Boot Backend

## Overview
Backend for Dealish (Nearby Restaurant Finder). Uses Spring Boot, JPA, and H2 for local testing. DataLoader seeds sample data on startup.

## Prerequisites (for non-coders)
1. Install Java 17 JDK: https://adoptium.net/ (choose OpenJDK 17)
2. Install Maven: https://maven.apache.org/install.html
3. (Optional) Install Git: https://git-scm.com/
4. (Optional) Install Docker Desktop (if you want to run with MySQL via docker-compose)

## Quick run (easiest way)
1. Open a terminal (Command Prompt / PowerShell on Windows).
2. Navigate to the project folder (where pom.xml is). Example:
   ```
   cd C:\Users\YourName\Downloads\dealish-backend
   ```
3. Build and run with Maven (this runs the app with H2 in-memory DB):
   ```bash
   mvn clean package
   mvn spring-boot:run
   ```
4. Open browser to test APIs:
   - List restaurants: http://localhost:8080/api/restaurants
   - H2 console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:dealishdb)

## Run inside IDE (VS Code / IntelliJ)
1. Open the project folder in the IDE.
2. Let the IDE import Maven project.
3. Run `DealishApplication` (right-click -> Run).

## Docker (optional) - run with MySQL
1. Build Docker image:
   ```bash
   mvn clean package -DskipTests
   docker build -t dealish-backend:latest .
   ```
2. Or run with docker-compose (uses MySQL):
   ```bash
   docker-compose up -d
   ```
(Compose file included)

## Endpoints
- GET /api/restaurants
- GET /api/restaurants/{id}
- POST /api/restaurants
- GET /api/users
- POST /api/users
- GET /api/menu-items
- POST /api/menu-items
- GET /api/offers
- POST /api/offers
- GET /api/feedback
- POST /api/feedback
- GET /api/orders
- POST /api/orders

## Need help?
If anything fails, copy the error and send it to me — I’ll help fix it step-by-step.
