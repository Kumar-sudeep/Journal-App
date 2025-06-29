# 📓 Journal App

A full-stack Journal Web Application built using **Spring Boot (Java)** for the backend and **HTML/CSS/Bootstrap/jQuery** for the frontend. It allows users to create, read, update, and delete journal entries stored in **MongoDB Atlas**.

---

## 🛠️ Tech Stack

- **Backend**: Spring Boot, Java 17  
- **Frontend**: HTML, CSS, Bootstrap, jQuery  
- **Database**: MongoDB Atlas  
- **Build Tool**: Maven  
- **Other**: RESTful API, MVC Architecture  

---

## 🚀 Features

- 📝 Create and save journal entries  
- 📖 Fetch all journal entries of a user  
- 🔍 View entry by ID  
- ✏️ Update entry by ID  
- ❌ Delete entry by ID  
- 🔐 User-based journal association

---

## 📁 Project Structure

```
├── .gitattributes
├── .gitignore
├── .idea/
│   ├── .gitignore
│   ├── compiler.xml
│   ├── encodings.xml
│   ├── jarRepositories.xml
│   ├── misc.xml
│   ├── workspace.xml
├── .mvn/
│   └── wrapper/
│       └── maven-wrapper.properties
├── HELP.md
├── LICENSE
├── README.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── net/
│   │   │       └── edigest/
│   │   │           └── journalApp/
│   │   │               ├── JournalApplication.java
│   │   │               ├── controller/
│   │   │               │   ├── HealthCheck.java
│   │   │               │   ├── JournalEntryControllerV2.java
│   │   │               │   └── UserController.java
│   │   │               ├── entity/
│   │   │               │   ├── JournalEntry.java
│   │   │               │   └── User.java
│   │   │               ├── repository/
│   │   │               │   ├── JournalEntryRepository.java
│   │   │               │   └── UserRepository.java
│   │   │               └── service/
│   │   │                   ├── JournalEntryService.java
│   │   │                   └── UserService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       │   ├── create.html
│   │       │   ├── edit.html
│   │       │   └── index.html
│   │       └── templates/
│   └── test/
│       └── java/
│           └── net/
│               └── edigest/
│                   └── journalApp/
│                       └── JournalAppApplicationTests.java
├── target/
    └── ... (compiled class files)

```

---

## ⚙️ How to Run

### 1. Clone the repository
```bash
git clone https://github.com/your-username/journal-app.git
cd journal-app/backend
```

### 2. Configure MongoDB
Update your `application.properties`:
```properties
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.mongodb.net/journal-db?retryWrites=true&w=majority
server.port=9091
```

### 3. Run the App
```bash
mvn clean spring-boot:run
```

Backend will start on: `http://localhost:9091`

### 4. Access the Frontend
Open:
```
http://localhost:9091/index.html
```

---

## 🧪 API Endpoints

| Method | Endpoint                            | Description                      |
|--------|-------------------------------------|----------------------------------|
| GET    | `/journal/{user_name}`             | Get all entries for a user       |
| GET    | `/journal/id/{id}`                 | Get a single entry by ID         |
| POST   | `/journal/{user_name}`             | Create a new journal entry       |
| PUT    | `/journal/id/{user_name}/{id}`     | Update a journal entry           |
| DELETE | `/journal/id/{user_name}/{id}`     | Delete a journal entry           |

---

## 🧑‍💻 Author

**Sudeep Kumar Das**  
- 🎓 B.Tech, ITER, SOA University  
- 🌐 Portfolio: *Coming Soon*  
- 📧 Email: *your.email@example.com*  

---

## 📃 License

This project is licensed under the MIT License.
