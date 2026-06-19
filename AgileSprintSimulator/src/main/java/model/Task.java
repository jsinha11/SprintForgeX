package model;

public class Task {
	private int id;
	private String title;
	private String status; // e.g., 
	private int storyPoints;
	private TeamMember assignee;

	public Task(int id, String title, int storyPoints) {
		this.id = id;
		this.title = title;
		this.storyPoints = storyPoints;
		this.status = "TODO";
		this.assignee = null;
	}

    public Task(TeamMember assignee, int id, String status, int storyPoints, String title) {
        this.assignee = assignee;
        this.id = id;
        this.status = status;
        this.storyPoints = storyPoints;
        this.title = title;
    }

    public Task(TeamMember assignee) {
        this.assignee = assignee;
    }

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStoryPoints() {
		return storyPoints;
	}

	public TeamMember getAssignee() {
		return assignee;
	}

	public void setAssignee(TeamMember assignee) {
		this.assignee = assignee;
	}

	@Override
	public String toString() {
		return "Task{" +
				"id=" + id +
				", title='" + title + '\'' +
				", status='" + status + '\'' +
				", storyPoints=" + storyPoints +
				", assignee=" + (assignee == null ? "unassigned" : assignee.getName()) +
				'}';
	}

    public void setId(int id) {
        this.id = id;
    }
}
