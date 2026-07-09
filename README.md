# AVL Tree Visualizer

The AVL Tree Visualizer is a full-stack web application built to understand how AVL Trees maintain balance after insertion and deletion operations. It provides a simple and interactive way to visualize tree structure changes while learning the concepts of self-balancing binary search trees.

The project is developed using **Java** and **Spring Boot** for the backend, while the frontend is built with **HTML, CSS, JavaScript, and SVG** to display the AVL Tree dynamically.

---

## Why I Built This Project

AVL Trees are one of the most important self-balancing data structures, but understanding rotations and balancing from theory alone can be difficult.

I built this project to strengthen my understanding of:

- AVL Tree implementation
- Height calculation
- Balance Factor
- LL, RR, LR and RL Rotations
- Spring Boot REST APIs
- Frontend and Backend integration
- Dynamic SVG rendering

---

## Features

- Insert nodes into an AVL Tree
- Delete nodes from the AVL Tree
- Automatic AVL balancing after every operation
- Dynamic tree visualization using SVG
- Interactive and responsive user interface
- Learn AVL page explaining AVL Tree concepts
- Rotations page describing LL, RR, LR and RL rotations
- Clean and modern beige-themed UI

---

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring MVC
- Maven

### Frontend
- HTML5
- CSS3
- JavaScript
- SVG

### Tools
- IntelliJ IDEA
- VS Code
- Git
- GitHub

---

## How It Works

1. The user enters a value from the web interface.
2. The frontend sends a request to the Spring Boot REST API.
3. The backend performs AVL Tree insertion or deletion.
4. Heights and balance factors are updated automatically.
5. If required, the tree performs LL, RR, LR or RL rotations.
6. The updated tree is returned as JSON.
7. JavaScript redraws the complete tree dynamically using SVG.

---

## Pages

### Visualizer
Perform AVL Tree operations and view the tree structure dynamically.

### Learn AVL
Provides an introduction to AVL Trees, their properties, time complexity, applications, advantages, and disadvantages.

### Rotations
Explains the four AVL balancing rotations:
- LL Rotation
- RR Rotation
- LR Rotation
- RL Rotation

---

## How to Run

1. Clone the repository

```bash
git clone https://github.com/your-username/AVL-Tree-Visualizer.git
```

2. Open the project in IntelliJ IDEA.

3. Reload the Maven project.

4. Run:

```
AvlvisualizerApplication.java
```

5. Open your browser:

```
http://localhost:7070/
```

*(Use the port configured in your `application.properties` file.)*

---

## Project Structure

```
src
├── controller
├── dto
├── model
├── service
├── resources
│   ├── static
│   │   ├── css
│   │   └── js
│   └── templates
│       ├── index.html
│       ├── learn.html
│       └── rotations.html
```
---

## Future Improvements

- Search node functionality
- Tree traversal visualization
- Live statistics panel
- Animation for AVL rotations
- Export tree as SVG/PNG
- Dark mode

---

## What I Learned

Through this project, I improved my understanding of:

- AVL Tree algorithms
- Java programming
- Spring Boot development
- REST API implementation
- SVG graphics
- Frontend and backend integration
- MVC architecture
- Git and GitHub workflow


