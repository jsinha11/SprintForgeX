package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Backlog;
import model.Sprint;
import model.Task;
import model.TeamMember;
import service.SprintService;
import service.VelocityTracker;

public class ConsoleMenu 
{
    private Scanner scanner = new Scanner(System.in);
    private Backlog<Task> backlog = new Backlog<>();
    private SprintService sprintService = new SprintService();
    private VelocityTracker velocityTracker = new VelocityTracker();
    private List<TeamMember> team = new ArrayList<>();
    private Sprint currentSprint = null;
    private int taskIdCounter = 1;

    public void start() 
    {
        System.out.println("=== Agile Sprint Simulator ===");
        team.add(new TeamMember("Alice", "Developer", 10));
        team.add(new TeamMember("Bob", "Tester", 8));

        int choice = -1;
        while (choice != 0) 
        {
            System.out.println("\n1. View Backlog\n2. Add Task\n3. Plan Sprint\n4. Assign Task\n5. Complete Task\n6. Complete Sprint\n7. View Velocity\n0. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) 
            {
                case 1 -> Backlog.display();
                case 2 -> {
                    System.out.print("Task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Story points: ");
                    int pts = scanner.nextInt();
                    scanner.nextLine();
                    backlog.addTask(new Task(taskIdCounter++, title, pts));
                    System.out.println("Task added!");
                }
                case 3 -> {
                    currentSprint = sprintService.planSprint(backlog);
                    if (currentSprint == null) {
                        System.out.println("No sprint could be planned. Add tasks to the backlog first.");
                    } else {
                        currentSprint.display();
                    }
                }
                case 4 -> {
                    if (currentSprint == null) { System.out.println("Plan a sprint first!"); break; }
                    System.out.print("Task ID: "); int tid = scanner.nextInt();
                    System.out.println("Choose member: ");
                    for (int i = 0; i < team.size(); i++)
                        System.out.println((i+1) + ". " + team.get(i));
                    int mi = scanner.nextInt() - 1;
                    sprintService.assignTask(currentSprint, tid, team.get(mi));
                }
                case 5 -> {
                    if (currentSprint == null) { System.out.println("Plan a sprint first!"); break; }
                    System.out.print("Task ID to complete: "); int cid = scanner.nextInt();
                    sprintService.completeTask(currentSprint, cid);
                }
                case 6 -> {
                    if (currentSprint == null) { System.out.println("Plan a sprint first!"); break; }
                    sprintService.completeSprint(currentSprint, velocityTracker);
                    currentSprint = null;
                }
                case 7 -> velocityTracker.displayHistory();
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setBacklog(Backlog<Task> backlog) {
        this.backlog = backlog;
    }

    public void setSprintService(SprintService sprintService) {
        this.sprintService = sprintService;
    }

    public void setVelocityTracker(VelocityTracker velocityTracker) {
        this.velocityTracker = velocityTracker;
    }

    public void setTeam(List<TeamMember> team) {
        this.team = team;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}