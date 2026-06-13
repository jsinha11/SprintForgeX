package model;

public class TeamMember 
{
    private String name;
    private String role;
    private int capacity;

    public TeamMember(String name, String role, int capacity) 
    {
        this.name = name;
        this.role = role;
        this.capacity = capacity;
    }

    public String getName() 
	{ return name; }
    public String getRole() 
	{ return role; }
    public int getCapacity() 
	{ return capacity; }

    public String toString() 
	{
        return name + " (" + role + ") - capacity: " + capacity + " pts";
	}
}