package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import model.Backlog;
import model.Sprint;
import model.Task;
import model.TeamMember;
import service.SprintService;
import service.VelocityTracker;

class SprintServiceTest {

    @Test
    void planSprintAddsOnlyTodosFromBacklog() {
        Backlog<Task> backlog = new Backlog<>();
        Task todo = new Task(1, "Small", 5);
        Task doneTask = new Task(2, "Done", 8);
        doneTask.setStatus("DONE");
        backlog.addTask(todo);
        backlog.addTask(doneTask);

        SprintService svc = new SprintService();
        Sprint sprint = svc.planSprint(backlog);

        assertEquals(1, sprint.getTasks().size());
        assertTrue(sprint.getTasks().contains(todo));
        assertFalse(sprint.getTasks().contains(doneTask));
    }

    @Test
    void assignTaskUpdatesStatusAndAssignee() {
        Sprint sprint = new Sprint(1, 30);
        Task task = new Task(10, "Assign me", 5);
        sprint.addTask(task);
        TeamMember member = new TeamMember("Alex", "Developer", 10);

        SprintService service = new SprintService();
        service.assignTask(sprint, 10, member);

        assertSame(member, task.getAssignee());
        assertEquals("IN_PROGRESS", task.getStatus());
    }

    @Test
    void completeTaskMarksTaskDone() {
        Sprint sprint = new Sprint(2, 30);
        Task task = new Task(20, "Complete me", 5);
        sprint.addTask(task);

        SprintService service = new SprintService();
        service.completeTask(sprint, 20);

        assertEquals("DONE", task.getStatus());
    }

    @Test
    void completeSprintRecordsVelocity() {
        Sprint sprint = new Sprint(3, 30);
        Task task = new Task(30, "Finish me", 6);
        task.setStatus("DONE");
        sprint.addTask(task);

        VelocityTracker tracker = new VelocityTracker();
        SprintService service = new SprintService();
        service.completeSprint(sprint, tracker);

        assertEquals(6.0, tracker.getAverageVelocity(), 0.001);
    }
}
