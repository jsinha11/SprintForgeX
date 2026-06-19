package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void gettersAndSettersWork() {
        Task task = new Task(1, "Example", 8);
        assertEquals(1, task.getId());
        assertEquals("Example", task.getTitle());
        assertEquals(8, task.getStoryPoints());
        assertEquals("TODO", task.getStatus());
        assertNull(task.getAssignee());

        TeamMember member = new TeamMember("Alex", "Developer", 10);
        task.setAssignee(member);
        task.setStatus("IN_PROGRESS");

        assertSame(member, task.getAssignee());
        assertEquals("IN_PROGRESS", task.getStatus());
        assertTrue(task.toString().contains("Alex"));
    }
}
