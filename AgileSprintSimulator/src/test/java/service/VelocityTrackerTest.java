package service;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import model.Sprint;
import model.Task;

class VelocityTrackerTest {

    @Test
    void averageVelocityCalculatesCorrectly() {
        Sprint sprint1 = new Sprint(1, 30);
        Task t1 = new Task(1, "Task A", 5);
        Task t2 = new Task(2, "Task B", 8);
        t1.setStatus("DONE");
        t2.setStatus("DONE");
        sprint1.addTask(t1);
        sprint1.addTask(t2);

        Sprint sprint2 = new Sprint(2, 30);
        Task t3 = new Task(3, "Task C", 13);
        t3.setStatus("DONE");
        sprint2.addTask(t3);

        VelocityTracker tracker = new VelocityTracker();
        tracker.recordSprint(sprint1);
        tracker.recordSprint(sprint2);

        assertEquals(13.0, tracker.getAverageVelocity(), 0.001);
    }

    @Test
    void getAverageVelocityReturnsZeroWhenNoSprintsRecorded() {
        VelocityTracker tracker = new VelocityTracker();
        assertEquals(0.0, tracker.getAverageVelocity(), 0.001);
    }

    @Test
    void displayHistoryShowsEmptyMessageWhenNoSprints() {
        VelocityTracker tracker = new VelocityTracker();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        try {
            tracker.displayHistory();
        } finally {
            System.setOut(originalOut);
        }

        String printed = output.toString();
        assertTrue(printed.contains("No sprints recorded yet."));
        assertTrue(printed.contains("--- VELOCITY HISTORY ---"));
    }

    @Test
    void displayHistoryShowsVelocityStarsForRecordedSprints() {
        Sprint sprint = new Sprint(1, 10);
        Task task = new Task(1, "Done Task", 2);
        task.setStatus("DONE");
        sprint.addTask(task);

        VelocityTracker tracker = new VelocityTracker();
        tracker.recordSprint(sprint);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        try {
            tracker.displayHistory();
        } finally {
            System.setOut(originalOut);
        }

        String printed = output.toString();
        assertTrue(printed.contains("Sprint 1: ** (2 pts)"));
        assertTrue(printed.contains("Average velocity: 2.0 pts"));
    }
}
