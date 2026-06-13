package model;
public class Task 
{
    private int id;
    private String title;
    private int storyPoints;
    private String status;
    private TeamMember assignee;

    public Task(int id, String title, int storyPoints) 
    {
        this.id = id;
        this.title = title;
        this.storyPoints = storyPoints;
        this.status = "TODO";
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getStoryPoints() { return storyPoints; }
    public String getStatus() { return status; }
    public TeamMember getAssignee() { return assignee; }
    public void setStatus(String status) { this.status = status; }
    public void setAssignee(TeamMember assignee) { this.assignee = assignee; }

    public String toString() {
        return "[" + id + "] " + title + " (" + storyPoints + " pts) - " + status +
               (assignee != null ? " -> " + assignee.getName() : "");
    }
}