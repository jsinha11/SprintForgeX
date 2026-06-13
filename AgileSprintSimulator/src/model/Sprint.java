package model;

import java.util.ArrayList;
import java.util.List;

public class Sprint 
{
    private int sprintNumber;
    private List<Task> tasks = new ArrayList<>();

    public Sprint(int sprintNumber) 
    {
        this.sprintNumber = sprintNumber;
    }

    public void addTask(Task t) 
    {
        tasks.add(t);
    }

    public int getSprintNumber() 
    { return sprintNumber; }

    public List<Task> getTasks() 
    { return tasks; }

    public int getVelocity() 
    {
        int total = 0;
        for (Task t : tasks) 
            {
            if (t.getStatus().equals("DONE")) 
            {
                total += t.getStoryPoints();
            }
        }
        return total;
    }

    public void display() 
    {
        System.out.println("--- SPRINT " + sprintNumber + " ---");
        if (tasks.isEmpty()) 
        {
            System.out.println("No tasks in this sprint.");
            return;
        }
        for (Task t : tasks) 
        {
            System.out.println(t);
        }
        System.out.println("Velocity so far: " + getVelocity() + " pts");
    }
}