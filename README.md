# Basic Employee Management System ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

## What is this Project ?

This project serves as a backend for the Basic Employee Management System. Common CRUD endpoints can be found on
Employee entities. There exists also a department module on which each employee can be assigned on a specific
department.

## Project Architecture

#### This project follows the standard Spring Boot Architecture found [here](https://www.javatpoint.com/spring-boot-architecture).

![image](https://github.com/celsodasecond/ems-backend/assets/75917932/bda679e3-838a-460b-881e-f59ff7592589)
![image](https://github.com/celsodasecond/ems-backend/assets/75917932/3cbea442-7947-4f6b-9b12-32631018f822)

## Want to get the boilerplate ?

[Just click this link](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.1.3&packaging=jar&jvmVersion=17&groupId=com.celso&artifactId=ems-backend&name=ems-backend&description=Demo%20project%20for%20Spring%20Boot%20-%20Employee%20Management%20System&packageName=com.celso.ems-backend&dependencies=web,h2,data-jpa,lombok).

## Development

### API Endpoints

#### Employee

- **@POST: /api/employees/add** - Add Employee with fields "firstName", "lastName", "email", and a many-to-one
  relationship with departments parameter "departmentId".
- **@GET: /api/employees/{employeeId}** - Returns specific employee by employeeId.
- **@GET: /api/employees/** - Returns the list of all employees.
- **@PUT: /api/employees/{employeeId}** - Updated the data of the employee by new values either fully or partially.
- **@DELETE: /api/employees/{employeeId}** - Deletes an employee record by giving the employeeId.

#### Department

- **@POST: /api/departments/add** - Add Department with fields "departmentName" and "departmentDescription".
- **@GET: /api/departments/{departmentId}** - Returns specific department by departmentId.
- **@GET: /api/departments/** - Returns the list of all departments.
- **@PUT: /api/departments/{departmentId}** - Updated the data of the department by new values either fully or
  partially.
- **@DELETE: /api/departments/{departmentId}** - Deletes a department record by giving the departmentId.

### Dependencies

- Maven
- Spring Boot 3.1.3
- Java 17
- Spring Web
- Lombok
- Spring Data JPA
- H2 Database

### Clone Project

```shell
https://github.com/celsodasecond/employee-management-backend.git
```

This Command will copy a full project to your local environment

