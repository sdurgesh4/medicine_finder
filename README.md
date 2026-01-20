💊 Medicine Finder Application

A Spring Boot–based Medicine Search Application that loads a large real-world Indian medicine dataset (~96 MB, 20,000+ records) locally at startup and provides fast, substring-based search with a clean Thymeleaf + Bootstrap UI.

🚀 Features

🔍 Live medicine search (substring-based, case-insensitive)

⚡ Fast in-memory lookup (data loaded once at startup)

📦 Handles large JSON dataset (96 MB) efficiently

🧠 Smart normalization for real-world inconsistent data

💊 Displays:

Medicine name

Manufacturer

Price (₹)

Type (Allopathy, etc.)

Pack size

Ingredients

Availability (Discontinued / Available)

🖥️ Responsive UI using Thymeleaf + Bootstrap

🧪 REST API usable independently (Postman / frontend)

🛠️ Tech Stack

Java 17+

Spring Boot

Spring Web (REST APIs)

Jackson (JSON parsing)

Thymeleaf

Bootstrap 5

Maven

📂 Project Architecture
com.app.medicine_finder
│
├── controller
│   ├── MedicineController.java        # REST APIs
│   └── MedicineUIController.java      # Thymeleaf UI
│
├── service
│   ├── MedicineService.java
│   └── MedicineServiceImpl.java
│
├── model
│   └── Medicine.java                  # JSON-mapped model
│
├── loader
│   └── MedicineDataLoader.java        # Loads JSON at startup
│
├── store
│   └── MedicineStore.java             # In-memory index (HashMap)
│
├── dto
│   └── MedicineResponseDto.java
│
├── util
│   └── MedicineNameNormalizer.java    # Normalizes search terms
│
└── MedicineFinderApplication.java

📦 Dataset

Source: Indian Medicine Dataset (JSON)

Size: ~96 MB

Records: 20,000+ medicines

Format: JSON array with real-world fields

The dataset is loaded locally from disk to avoid network latency and startup failures.

⚙️ How Data Loading Works

JSON file is loaded once at application startup

Parsed using Jackson

Stored in an in-memory HashMap for O(1) lookup

Unknown JSON fields are safely ignored using:

@JsonIgnoreProperties(ignoreUnknown = true)

Why this approach?

Avoids repeated file I/O

Works with large datasets

Extremely fast search performance

Easy to migrate to DB later

🔍 Search Logic

The search follows a two-step strategy:

Exact match (fastest)

Substring match (fallback)

Example searches:

Augmentin

Augmentin 625

625

mentin

Normalization ensures:

Case-insensitive search

Extra spaces handled

Real-world inconsistent names work correctly

🌐 API Endpoints
🔹 Search Medicines
GET /api/medicines/search?q={query}

Example
GET /api/medicines/search?q=Augmentin

Sample Response
{
  "name": "Augmentin 625 Duo Tablet",
  "manufacturer": "Glaxo SmithKline Pharmaceuticals Ltd",
  "type": "allopathy",
  "packSize": "strip of 10 tablets",
  "price": "223.42",
  "ingredients": [
    "Amoxycillin (500mg)",
    "Clavulanic Acid (125mg)"
  ],
  "discontinued": false
}

🖥️ UI Access

Open in browser:

http://localhost:8080/


Features:

Live search as you type

Bootstrap card layout

Clean, responsive design

No page reloads (AJAX via Fetch API)

▶️ How to Run
Prerequisites

Java 17+

Maven

Steps
mvn clean install
mvn spring-boot:run


Ensure the JSON file is placed at:

src/main/resources/data/indian_medicine_data.json


(or configured as an external file path)

⚠️ Notes on Large Files

IntelliJ may warn about large JSON size — this does not affect runtime

Dataset is treated as a data asset, not source code

Recommended to keep the JSON file closed in IDE

🧠 Design Decisions (Interview-Ready)

Load large datasets once at startup

Use HashMap for fast search

Normalize input and dataset keys

Ignore unknown JSON fields for stability

Keep service layer independent of data source

🔮 Future Enhancements

Alternative medicines (same composition / effect)

Price-based sorting & filtering

Search by ingredient or manufacturer

Pagination for large result sets

Move dataset to DB / Elasticsearch

Medicine detail page

👨‍💻 Author

Durgesh Singh
Java | Spring Boot | Full-Stack Developer | Educator

⭐ Final Note

This project demonstrates real-world backend problem solving:

Large data handling

Performance optimization

Clean architecture

Practical UI integration

Feel free to ⭐ the repository if you find it useful.
