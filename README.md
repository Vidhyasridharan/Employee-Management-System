# Employee Management System (Spring Boot)

A RESTful backend service for managing employee records, built using Spring Boot.

## Summary
This project demonstrates core backend engineering concepts including REST API design, layered architecture, and scalable data retrieval using pagination and sorting.

## Key Features
- CRUD operations for employee entities
- Pagination and sorting support for large datasets
- Clear separation of controller, service, and repository layers
- In-memory database for local development and testing

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

## API Capabilities

### Retrieve Employees (Paginated)
GET /employees?page=0&size=10&sort=lastName,asc

bash
Copy code

## Running Locally
```bash
git clone https://github.com/Vidhyasridharan/ems.git
cd ems
./mvnw spring-boot:run

Engineering Focus
-RESTful API design
-Pagination and sorting for scalability
-Clean and maintainable backend structure
-Dependency injection and service abstraction

Future Enhancements
-Input validation
-Global exception handling
-Persistent database integration
-Automated tests
