package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Backlog 
{
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task t) 
    {
        if (t == null) 
        {
            throw new IllegalArgumentException("Task cannot be null");
        }
        tasks.add(t);
    }

    public void removeTask(int id) 
    {
        tasks.removeIf(t -> t.getId() == id);
    }

    public List<Task> getTasks() 
    {
        return Collections.unmodifiableList(tasks);
    }

    public void display() 
    {
        if (tasks.isEmpty()) 
        {
            System.out.println("Backlog is empty.");
            return;
        }
        System.out.println("--- BACKLOG ---");
        for (Task t : tasks) 
        {
            System.out.println(t);
        }
    }
}