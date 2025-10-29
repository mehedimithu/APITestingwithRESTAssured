 **API Testing with REST Assured**


# 🧪 API Testing with REST Assured

This project demonstrates **API Testing using REST Assured** in **Java** with **JUnit 5** and **Maven**.  
It covers testing of CRUD operations (`GET`, `POST`, `PUT`, `DELETE`) for the sample API hosted at:

```
http://localhost:8888/api_testing
```

---

## 📁 Project Structure

```
API_TEST_WITH_RESTASSURED/
│
├── .github/
├── .vscode/
├── src/
│   ├── main/
│   └── test/java/
│       ├── challenges/
│       │   └── ApiChallenge.java
│       ├── models/
│       │   └── Product.java
│       └── training/
│           └── ApiTests.java
│
├── target/
├── pom.xml
├── localhost.session.sql
└── README.md
```

---

## ⚙️ Setup Instructions

### 1️⃣ Prerequisites
- Java 17+
- Maven 3+
- VS Code or IntelliJ IDEA
- Local API Server running at `http://localhost:8888/api_testing`

### 2️⃣ Clone the Repository
```bash
git clone https://github.com/<your-username>/APITestingwithRESTAssured.git
cd APITestingwithRESTAssured
```

### 3️⃣ Install Dependencies
```bash
mvn clean install
```

### 4️⃣ Run Tests
```bash
mvn test
```

---

## 🧾 Test Cases Summary

### 1. Get Categories
**Endpoint:** `/category/read.php`  
**Expected Result:** Should return all available categories with 200 OK.

### 2. Get Products
**Endpoints:** `/product/read_one.php?id=2`, `/product/read.php`  
**Expected Result:** Product data should be returned with valid `id` and `name` fields.

### 3. Create Product
**Endpoint:** `/product/create.php`  
**Method:** POST  
**Expected Result:** Product created successfully (201 Created).

### 4. Update Product
**Endpoint:** `/product/update.php`  
**Expected Result:** Product updated successfully (200 OK).

### 5. Delete Product
**Endpoint:** `/product/delete.php`  
**Expected Result:** Product deleted successfully (200 OK).

### 6. Create Serialized Product
**Endpoint:** `/product/create.php`  
**Expected Result:** Product created using serialized object (201 Created).

### 7. Deserialize Product
**Endpoint:** `/product/read_one.php?id=2`  
**Expected Result:** Deserialized product matches expected values.

---

## 🧰 Tools & Technologies

| Category | Tool |
|-----------|------|
| Language | Java |
| Test Framework | JUnit 5 |
| API Library | REST Assured |
| Build Tool | Maven |
| IDE | VS Code / IntelliJ IDEA |
| Assertion Library | Hamcrest |

---

## 🧩 Future Enhancements
- Integrate Allure Report for advanced reporting.  
- Add TestNG for parallel testing.  
- Enable CI/CD via GitHub Actions.  
- Support data-driven testing.

---

## 🧑‍💻 Author
**Mehedi Hasan**  
_Senior Software QA Engineer_  
🌐 [GitHub Profile](https://github.com/mehedimithu)
