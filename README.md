Agile Sprint Simulator

A console-based Java application that simulates Agile/Scrum sprint planning and execution — manage a product backlog, organize tasks into sprints, assign work to team members, and track velocity over time.

Features


Backlog Management – Create and maintain a product backlog of user stories/tasks.
Sprint Planning – Group tasks into sprints with defined scope and timelines.
Task Tracking – Track individual task status, effort, and assignment.
Team Management – Assign tasks to team members and manage workload.
Velocity Tracking – Measure team velocity across sprints to support future planning.
Console UI – Simple, interactive menu-driven interface for managing the simulation.


Project Structure

AgileSprintSimulator/
└── src/
    ├── model/
    │   ├── Backlog.java        # Represents the product backlog
    │   ├── Sprint.java         # Represents a sprint and its scope
    │   ├── Task.java           # Represents an individual task/story
    │   └── TeamMember.java     # Represents a team member
    │
    ├── service/
    │   ├── SprintService.java      # Business logic for sprint operations
    │   └── VelocityTracker.java    # Tracks and calculates team velocity
    │
    └── ui/
        ├── ConsoleMenu.java    # Console-based menu interface
        └── Main.java           # Application entry point

Architecture

The project follows a simple layered architecture:


model – Plain Java objects representing core domain entities (Backlog, Sprint, Task, TeamMember).
service – Business logic layer that operates on the model (sprint management, velocity calculations).
ui – Console interface layer that interacts with the user and delegates to the service layer.


Getting Started

Prerequisites


Java JDK 8 or higher
A Java IDE (IntelliJ IDEA, Eclipse, VS Code) or just javac/java on the command line


Running the Application


Clone the repository:


bash   git clone https://github.com/jsinha11/AGILESPRINTSIMULATOR.git
   cd AGILESPRINTSIMULATOR/AgileSprintSimulator/src


Compile the source files:


bash   javac -d out model/*.java service/*.java ui/*.java


Run the application:


bash   java -cp out ui.Main


Follow the on-screen console menu to manage backlogs, sprints, tasks, and team members.


Usage

Once running, the ConsoleMenu presents options to:


Add/view backlog items
Create and plan sprints
Assign tasks to team members
Update task status
View team velocity and sprint reports


Roadmap


 Persist data to a file or database
 Add burndown chart visualization
 Support multiple concurrent sprints
 Add unit tests for model and service layers
 Build a web/GUI frontend


Contributing

Contributions are welcome. Please open an issue or submit a pull request with your proposed changes.

License

This project is currently unlicensed. Add a license of your choice (e.g., MIT, Apache 2.0) to clarify usage rights.

Author

jsinha11
