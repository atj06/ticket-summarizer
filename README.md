# Ticket Summarizer

A full-stack AI-powered Ticket Summarizer application built with **Spring Boot** and deployed on **AWS EC2** using **Docker**, **Docker Compose**, and **Nginx**.

The application allows users to submit support tickets, automatically generates an AI-powered summary, predicts the ticket priority and category, and stores the ticket information for retrieval.

---

## Features

* Create support tickets
* AI-generated ticket summaries
* Automatic priority prediction
* Automatic category prediction
* RESTful API
* Dockerized deployment
* Nginx reverse proxy configuration
* AWS EC2 deployment

---

## Tech Stack

* Java 17
* Spring Boot
* Maven
* REST APIs
* Docker
* Docker Compose
* Nginx
* AWS EC2
* Groq API

## Project Structure

```
ticket-summarizer/
│── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│── Dockerfile
│── pom.xml
│── README.md
```

---

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/atj06/ticket-summarizer.git
```

### Navigate to the Project

```bash
cd ticket-summarizer
```

### Build the Project

```bash
./mvnw clean package
```

### Run the Application

```bash
./mvnw spring-boot:run
```
## API Endpoints

| Method | Endpoint        | Description                                 |
| ------ | --------------- | ------------------------------------------- |
| POST   | `/tickets`      | Create a new ticket and generate AI summary |
| GET    | `/tickets`      | Retrieve all tickets                        |
| GET    | `/tickets/test` | Test controller endpoint                    |

---

## Docker Deployment

This project can be containerized using Docker.

### Build Docker Image

```bash
docker build -t ticket-summarizer .
```

### Run Docker Container

```bash
docker run -p 8080:8080 ticket-summarizer
```

---

## Deployment

The application was deployed on an **AWS EC2** instance using:

* Docker
* Docker Compose
* Nginx Reverse Proxy

The deployment was verified by successfully:

* Creating tickets
* Generating AI summaries
* Predicting ticket priority
* Predicting ticket category
* Retrieving stored tickets
---

## What I Learned

During this project, I gained hands-on experience with:

* Building REST APIs using Spring Boot
* Containerizing applications using Docker
* Managing multi-container applications with Docker Compose
* Configuring Nginx as a reverse proxy
* Deploying applications on AWS EC2
* Integrating AI services through the Groq API
* Debugging deployment, networking, and API communication issues

---

## Future Improvements

* User authentication and authorization
* Database integration
* Custom domain name
* HTTPS using Let's Encrypt
* CI/CD pipeline for automated deployment
* Monitoring and logging

---

##  Author

**Anisha TJ**

Developed as part of a full-stack deployment and cloud learning project.
