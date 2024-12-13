# News Application

This is a **News Application** developed using **Spring Boot** and connected to a **third-party news API** to fetch and display the latest news articles.

## Features

- Fetch the latest news from a third-party API.
- Display news articles with titles, descriptions, publication dates, and sources.
- Search functionality to filter news by topics or keywords.
- Responsive and user-friendly interface.

## Tech Stack

### Back-End
- **Spring Boot**
- **Java**

### API
- **[NewsAPI](https://newsapi.org/)** or any other third-party news API.

### Front-End
- **Thymeleaf** for server-side rendering.
- HTML, CSS for styling and interactivity.

### Tools
- **Maven** for dependency management.

## Prerequisites

1. **Java JDK 8 or higher**
2. **Spring Boot**
3. **Maven**
4. **NewsAPI Key** (or another API key depending on the news API used)
5. **IDE** (e.g., IntelliJ IDEA, Eclipse, etc.)

## Setup Instructions

### 1. Clone the Repository
```bash
git clone <repository-url>
cd news-application
```

### 2. Configure API Key

- Sign up at [NewsAPI](https://newsapi.org/) (or another news API) to obtain an API key.
- Add your API key to the `application.properties` file located in `src/main/resources`:
```properties
news.api.key=<your-news-api-key>
news.api.url=https://newsapi.org/v2
```

### 3. Build and Run the Application

- Build the application using Maven:
```bash
mvn clean install
```
- Run the Spring Boot application:
```bash
mvn spring-boot:run
```

### 4. Access the Application

- Open your web browser and go to `http://localhost:8080`.

## Project Structure

```
news-application
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.newsapplication
│   │   │       ├── controller
│   │   │       │   └── NewsController.java
│   │   │       ├── model
│   │   │       │   ├── NewsModel.java
│   │   │       │   ├── NewsSourceModel.java
│   │   │       │   └── NewsLangModel.java
│   │   │       ├── service
│   │   │       │   └── NewsService.java
│   │   │       └── NewsApplication.java
│   │   ├── resources
│   │   │   ├── templates
│   │   │   │   ├── Main.html
│   │   │   │   ├── News.html
│   │   │   │   ├── NewsSource.html
│   │   │   │   └── NewsLang.html
│   │   │   ├── application.properties
│   │   └── static
│   └── test
├── pom.xml
└── README.md
```

## Future Enhancements

1. Add pagination for displaying large sets of news articles.
2. Implement user authentication and saved searches.
3. Create a modern front-end using frameworks like React or Angular.

