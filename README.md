# TaskQueue

TaskQueue is an AI-integrated task manager designed to optimize scheduling and task management through intelligent algorithms.


## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Project Overview
TaskQueue leverages artificial intelligence to enhance task prioritization and management, helping users efficiently organize their workload and boost productivity.

## Features
- **AI-Driven Prioritization**: Utilizes AI to assess task urgency and importance, ensuring optimal scheduling.
- **User Authentication**: Secure login and profile management system.
- **Task Management**: Allows users to create, edit, and delete tasks with ease.
- **Calendar Integration**: Interactive calendar for visual task tracking and deadlines.
- **Notifications**: Automated reminders to keep users informed about upcoming tasks.

## Installation
To get TaskQueue running locally:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/namekart-piyush/myTodoList.git
   cd myTodoList
   ```

2. **Install dependencies**:
   ```bash
   mvn install
   ```

3. **Configure environment**:
   Create an `application.properties` file in `src/main/resources`:
   ```plaintext
   server.port=8080
   spring.datasource.url=jdbc:mysql://localhost:3306/taskqueue
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Start the application**:
   ```bash
   mvn spring-boot:run
   ```

## Usage
- **For Individuals**: Manage and prioritize personal tasks with AI recommendations.
- **For Teams**: Collaborate on tasks with shared access and real-time updates.

## Technologies Used
- **Backend**: Java, Spring Boot
- **Frontend**: TypeScript, Gemini
- **APIs**: OpenFeign for service integration
- **Database**: MySQL
- **Artificial Intelligence**: Custom algorithms for task analysis and scheduling

## Contributing
We encourage contributions:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-yourfeature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature-yourfeature`).
5. Submit a Pull Request.

## Contact
- **Author**: Piyush Singh
- **GitHub**: [Piyush Singh](https://github.com/namekart-piyush)
- **LinkedIn**: [Piyush Singh](https://www.linkedin.com/in/piyush-singh908)
