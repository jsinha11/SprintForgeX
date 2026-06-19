package service;

import java.util.ArrayList;
import java.util.List;
import model.Sprint;


public class VelocityTracker 
{
    private final List<Integer> velocities = new ArrayList<>();

    public void recordSprint(Sprint s) 
    {
        velocities.add(s.getVelocity());
        System.out.println("Sprint " + s.getSprintNumber() + " velocity recorded: " + s.getVelocity() + " pts");
    }

    public double getAverageVelocity() 
    {
        if (velocities.isEmpty()) return 0;
        int sum = 0;
        for (int v : velocities) sum += v;
        return (double) sum / velocities.size();
    }

    public void displayHistory() 
    {
        System.out.println("--- VELOCITY HISTORY ---");
        if (velocities.isEmpty()) 
        {
            System.out.println("No sprints recorded yet.");
            return;
        }
        for (int i = 0; i < velocities.size(); i++) 
        {
            System.out.print("Sprint " + (i + 1) + ": ");
            for (int j = 0; j < velocities.get(i); j++) System.out.print("*");
            System.out.println(" (" + velocities.get(i) + " pts)");
        }
        System.out.println("Average velocity: " + getAverageVelocity() + " pts");
    }
}