
# 📸 Screenshot Processing API

A **Spring Boot** backend that receives screenshots from a Rust client, processes them using **Pixtral** and **LangChain4j** for AI-driven classification and data extraction, stores the results in **MongoDB**, enables streaming of processed images, and generates detailed activity reports.

---

## 🧰 Tech Stack

- **Java + Spring Boot** — RESTful backend services
- **MongoDB** — Persistent storage for screenshot logs
- **Pixtral** — Image insight generation
- **LangChain4j** — AI-based classification and structured data extraction
- **Spring AI** — AI service orchestration
- **Maven/Gradle** — Build and dependency management

---

## 📡 API Endpoints

### 1. Upload & Process Screenshot

```
POST /api/screenshot
```

**Request Type**: `multipart/form-data`

**Parameters**:
- `file` (MultipartFile, **required**) — The screenshot image.
- `userId` (String, optional)
- `businessId` (String, optional)
- `domainId` (String, optional)
- `project` (String, optional)

**Description**:
- Accepts a screenshot from the Rust application.
- Processes it using **Pixtral** and **LangChain4j**.
- Stores metadata and extracted data in MongoDB (`screenshotlog` collection).
- Returns `200 OK` on successful processing.

---

### 2. Stream Processed Screenshot

```
GET /api/screenshot/stream/{id}
```

**Path Variable**:
- `id` (String) — Unique identifier of the screenshot.

**Description**:
- Streams the processed image or associated data.
- Enables real-time updates or progressive loading for frontend clients.

---

### 3. Generate Reports

```
GET /api/screenshot/reports
```

**Query Parameters** (all optional):
- `startDate` (String, `YYYY-MM-DD`)
- `endDate` (String, `YYYY-MM-DD`)
- `userId` (String)
- `businessId` (String)
- `domainId` (String)
- `project` (String)

**Description**:
- Generates analytical reports based on filters.
- Supports custom time ranges: daily, weekly, monthly.
- Can be filtered by user, business, domain, and project.

---

## 🚀 Usage Flow

1. **Rust Client Upload**  
   Rust application uploads image via `POST /api/screenshot`.

2. **AI-Powered Processing**  
   Screenshot is processed using **Pixtral** for insights and **LangChain4j** for structured data extraction.

3. **Data Persistence**  
   Results are saved in MongoDB under the `screenshotlog` collection.

4. **Stream Back Processed Data**  
   Clients can stream the processed result via `/api/screenshot/stream/{id}`.

5. **Generate Analytics**  
   Reports can be queried via the `/api/screenshot/reports` endpoint with rich filtering.

---

## ⚙️ Setup & Running

1. **MongoDB Configuration**  
   Set connection details in `application.properties`:
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/screenshotdb
   ```

2. **Install Dependencies**  
   Use Maven or Gradle to install dependencies:
   ```bash
   ./mvnw clean install
   ```

3. **Configure API Keys**  
   Set API keys and secrets for **Pixtral** and **LangChain4j** either in:
   - `application.properties`
   - Environment variables

4. **Start the Application**  
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Client Integration (Rust)**  
   Rust application makes a `POST` request to:
   ```
   /api/screenshot
   ```
   with multipart form data including the image.

---

## 📝 Notes

- **LangChain4j** uses few-shot examples to extract structured JSON data.
- **Pixtral** provides AI-powered visual insight classification.
- **Streaming** support can be extended to chunked transfers or WebSocket-based communication.
- **Reports API** supports advanced filtering for custom dashboards.

---

## 🤝 Contributing & Support

Found a bug or want to contribute?  
Open an issue or submit a pull request on the repository.

---
