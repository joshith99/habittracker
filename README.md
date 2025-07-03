# Habit Tracker – DevOps Project

A Java 17 Spring Boot REST API for habit tracking, fully automated with CI/CD, containerized with Docker, deployed via Ansible, and monitored using Graphite and Grafana.

## 🚀 Features

- RESTful API for managing habits (CRUD operations)
- Java 17, Spring Boot, Maven
- JUnit tests for API validation
- Containerized with Docker
- Automated CI/CD pipeline with GitHub Actions
- Infrastructure automation using Ansible
- Real-time monitoring with Graphite & Grafana

## ⚙️ Prerequisites

- Java 17+
- Maven 3.6+
- Docker & Docker Compose
- Ansible
- (Optional) Postman for API testing

## 🏗️ Build & Run Locally

**Clone the repository:**
```
git clone https://github.com/joshith99/habittracker.git 
cd habittracker
```
**Build with Maven:**
```
mvn clean package
```
**Run locally:**
```
mvn spring-boot:run
```
App will be available at [http://localhost:8080](http://localhost:8080).

## 🐳 Docker

**Build Docker image:**
```
docker build -t habittracker:latest .
```
**Run container:**
```
docker run -d -p 8080:8080 habittracker:latest
```
## 🤖 CI/CD with GitHub Actions

Automated pipeline defined in `.github/workflows/ci.yml`:

- Builds and tests with Maven
- Builds Docker image
- Pushes image to GitHub Container Registry (GHCR)

## 🛠️ Deployment with Ansible

Use `deploy_docker_image.yml` and `inventory.ini` to automate Docker deployment:
```
ansible-playbook -i inventory.ini deploy_docker_image.yml
```

## 📊 Monitoring with Graphite & Grafana

**Start monitoring stack:**
```
docker compose up -d
```
Configure Spring Boot to export metrics to Graphite (`application.properties`).

**Access:**
- Graphite: [http://localhost:9080](http://localhost:9080)
- Grafana: [http://localhost:3000](http://localhost:3000) (default login: admin/admin)


## 🧪 API Endpoints

| Method | Endpoint         | Description         |
|--------|------------------|--------------------|
| GET    | /habits          | List all habits    |
| POST   | /habits          | Create a new habit |
| PUT    | /habits/{id}     | Update a habit     |
| DELETE | /habits/{id}     | Delete a habit     |
| GET    | /habits/summary  | Get habit summary  |
