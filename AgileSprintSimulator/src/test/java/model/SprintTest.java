package model;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SprintTest {
    @Test
    void addTaskAddsTaskToSprint() {
        Task t = new Task(1, "Example task", 3);
        Sprint s = new Sprint(1);
        s.addTask(t);

        assertEquals(1, s.getTasks().size());
        assertTrue(s.getTasks().contains(t));
    }

    @Test
    void getVelocityCountsOnlyDoneTasks() {
        Sprint sprint = new Sprint(2);
        Task todo = new Task(1, "Todo task", 5);
        Task done = new Task(2, "Done task", 8);
        done.setStatus("DONE");

        sprint.addTask(todo);
        sprint.addTask(done);

        assertEquals(8, sprint.getVelocity());
    }

    @Test
    void displayShowsNoTasksMessageWhenEmpty() {
        Sprint sprint = new Sprint(3, 10);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        try {
            sprint.display();
        } finally {
            System.setOut(originalOut);
        }

        String printed = output.toString();
        assertTrue(printed.contains("No tasks in this sprint."));
        assertTrue(printed.contains("--- SPRINT 3 ---"));
    }
}
