package service;

import model.Backlog;
import model.Sprint;
import model.Task;
import model.TeamMember;

public class SprintService 
{
    private int sprintCounter = 1;

    public Sprint planSprint(Backlog<Task> backlog) 
    {
        Sprint sprint = new Sprint(sprintCounter++);
        System.out.println("Planning Sprint " + sprint.getSprintNumber());
        for (Task t : backlog.getTasks()) 
        {
            if (t.getStatus().equals("TODO")) 
            {
                sprint.addTask(t);
                System.out.println("Added to sprint: " + t.getTitle());
            }
        }
        return sprint;
    }

    public void assignTask(Sprint sprint, int taskId, TeamMember member) 
    {
        for (Task t : sprint.getTasks()) 
        {
            if (t.getId() == taskId) 
            {
                t.setAssignee(member);
                t.setStatus("IN_PROGRESS");
                System.out.println("Assigned " + t.getTitle() + " to " + member.getName());
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void completeTask(Sprint sprint, int taskId) 
    {
        for (Task t : sprint.getTasks()) 
        {
            if (t.getId() == taskId) 
            {
                t.setStatus("DONE");
                System.out.println("Task completed: " + t.getTitle());
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void completeSprint(Sprint sprint, VelocityTracker tracker) 
    {
        System.out.println("Completing Sprint " + sprint.getSprintNumber());
        tracker.recordSprint(sprint);
    }
}