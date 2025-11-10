# 💪 Gym Management System - Backend (Spring Boot)

This is the **backend server** for the Gym Management System project, built with **Spring Boot**.  
It provides all the API endpoints needed to manage trainees and workout plans for a gym.

---

## ⚙️ Overview

- Built with **Spring Boot**, following **Object-Oriented Programming (OOP)** principles.  
- Does **not use a database**; all data is stored in memory for simplicity.  
- Handles **CRUD operations** for trainees and workout plans.  
- Supports advanced features like:
  - Assigning a workout plan to a trainee  
  - Removing a plan from a trainee  
  - Filtering trainees by join date  
  - Grouping trainees by join year  

---

## 🗂 Project Structure

### Models
- **TraineeDto**
  - `id` (Long)  
  - `name` (String)  
  - `email` (String)  
  - `joinDate` (LocalDate)  
  - `activePlanId` (Long, optional)  

- **WorkoutPlanDto**
  - `id` (Long)  
  - `planName` (String)  
  - `description` (String)  
  - `difficulty` (int)  

### Services
- **TraineeService.java**: Handles business logic for trainees.  
- **WorkoutPlanService.java**: Handles business logic for workout plans.  

### Controllers
- **TraineeController.java**
  - `GET /trainees` → List all trainees  
  - `POST /trainees` → Create a new trainee  
  - `PUT /trainees/{traineeId}/assign-plan/{planId}` → Assign a plan  
  - `PUT /trainees/{traineeId}/remove-plan` → Remove assigned plan  
  - `GET /trainees/joined-after/{date}` → Get trainees who joined after a specific date  
  - `GET /trainees/grouped-by-year` → Group trainees by join year  

- **WorkoutPlanController.java**
  - `GET /plans` → List all workout plans  
  - `POST /plans` → Create a new plan  

---

## 🛠 How to Run

1. Clone the repository:
bash
git clone https://github.com/ShokryArraf/Gym-Management-System.git

2. Open the project in your IDE (e.g., IntelliJ IDEA or VS Code).

3. Run the Spring Boot application (it will start on http://localhost:8080).

4. Use Postman or the fronted i made on [![Frontend Demo](https://img.shields.io/badge/Frontend-Web-blue)](https://precious-axolotl-e0bc87.netlify.app/)
.

💡 Notes

This project is purely for learning purposes and does not persist data, so all data will reset when the server restarts.

The project demonstrates OOP concepts like encapsulation, services, and separation of concerns.

It’s designed to easily integrate with a frontend application.
