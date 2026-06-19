package model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BacklogTest {

    @Test
    public void addAndRemoveTasks() {
        Backlog backlog = new Backlog();
        Task task1 = new Task(1, "First", 3);
        Task task2 = new Task(2, "Second", 5);

        backlog.addTask(task1);
        backlog.addTask(task2);
        List<Task> tasks = backlog.getTasks();

        assertEquals(2, tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task2));

        backlog.removeTask(1);
        tasks = backlog.getTasks();
        assertEquals(1, tasks.size());
        assertFalse(tasks.contains(task1));
        assertTrue(tasks.contains(task2));
    }

    @Test
    public void testAddTaskThrowsOnNull() {
        Backlog backlog = new Backlog();
        assertThrows(IllegalArgumentException.class, () -> backlog.addTask(null));
    }
}
