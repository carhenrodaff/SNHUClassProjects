import org.SNHU.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/*
@Author: Carlos Affonso
@Date: 2021-03-15
 */
public class TaskServiceTest{
    public static TaskService taskservice = new TaskService();
    @Test
    public void testAdd(){
        Task task = new Task();
        assertEquals(taskservice.tasks.size(), 0);
        taskservice.addTask(task);
        assertEquals(taskservice.tasks.size(), 1);
    }
    @Test
    public void testRemove(){
        Task task = new Task();
        taskservice.addTask(task);
        assertEquals(taskservice.tasks.size(), 2);
        taskservice.deleteTask(task.getId());
        assertEquals(taskservice.tasks.size(), 1);
    }
    @Test
    public void testUpdate(){
        Task task = new Task();
        taskservice.addTask(task);
        assertSame("default", task.getName());
        assertSame("nodesc", task.getDescription());
        taskservice.updateTask(task.getId(), "newname", "newdesc");
        assertSame("newname", task.getName());
        assertSame("newdesc", task.getDescription());
    }
}
