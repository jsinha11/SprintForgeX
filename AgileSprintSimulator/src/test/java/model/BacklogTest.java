package model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class BacklogTest {

    private IllegalArgumentException assertThrows2;

    public BacklogTest(IllegalArgumentException assertThrows2) {
        this.assertThrows2 = assertThrows2;
    }

    @Test
    public void addAndRemoveTasks() {
        Backlog<Task> backlog = new Backlog<>();
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
        Backlog<Task> backlog = new Backlog<>();
        assertThrows2 = assertThrows(IllegalArgumentException.class, () -> backlog.addTask(null));
    }

    public void setAssertThrows2(IllegalArgumentException assertThrows2) {
        this.assertThrows2 = assertThrows2;
    }

    public IllegalArgumentException getAssertThrows2() {
        return assertThrows2;
    }
}
