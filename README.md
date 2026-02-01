📚 AI-Powered-Student-Performance-Analytics

## Live Backend URL
https://ai-powered-student-performance-1z8u.onrender.com

This project is a Spring Boot–based backend system that analyzes student academic performance using AI-generated insights.
Instead of exposing AI directly, the system integrates AI within custom REST APIs, ensuring better control, security, and stability.

🧠 Tech Stack

Java, Spring Boot

Spring AI (ChatClient)

MySQL, Spring Data JPA

Lombok

REST APIs

Postman

⚙️ Features

👤 Role-based Access — Only ADMIN can create/delete, users can only view data

🔐 Password Encryption — Use BCrypt for secure password storage

📧 Email Notifications — Sent automatically email on create/update/delete

🚫 Error Handling & Logging with Slf4j

Features after integrating AI : 

AI-driven analysis of student performance based on attendance and marks.

Dynamic prompt generation using real student data.

Structured JSON responses including performance summary, weak areas, improvement suggestions, and career recommendations.

Graceful fallback handling when AI services are unavailable.

Clean layered architecture (Controller–Service–Repository).

⚠️ Challenges Faced

AI API quota limitations and downtime.

Prompt type mismatch issues in Spring AI.

Handling inconsistent AI responses safely.

✅ Solution Approach

Used PromptTemplate → Prompt for correct Spring AI integration.

Implemented try–catch fallback logic to avoid API crashes.

Used DTOs with Lombok Builder pattern for clean response handling.

🚀 Future Enhancements

Frontend integration (React/Angular).

Support for multiple AI providers.

▶️ How to Run

Clone the repository

Configure database and AI API key

Run the Spring Boot application

Test APIs using Postman


👨‍💻 Author

Kishan Singh
📧 Email :  [kishansingh121128@gmail.com]
🌐 Linkedin : [https://www.linkedin.com/in/kishan-java-backend/]
