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
journal-app/
├── backend/
│   └── src/main/java/com/example/journal/
│       ├── controller/
│       ├── model/
│       ├── repository/
│       ├── service/
│       └── JournalApplication.java
├── resources/
│   ├── static/           # HTML/CSS/JS frontend
│   └── application.properties
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