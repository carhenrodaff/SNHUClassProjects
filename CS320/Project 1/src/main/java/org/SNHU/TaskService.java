package org.SNHU;
import java.util.HashMap;
import org.mockito.Mock;



/*
@author: Carlos Affonso
@Date: 2021-03-15
 */
/*
Reqs:

    The task service shall be able to add tasks with a unique ID.
    The task service shall be able to delete tasks per task ID.
    The task service shall be able to update task fields per task ID. The following fields are updatable:
        Name
        Description
import org.taskservice.Task.*;
 */
public class TaskService{
    @Mock
     public static HashMap<String, Task> tasks = new HashMap<String, Task>();
    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }
    public void deleteTask(String id) {
        tasks.remove(id);
    }
    public void updateTask(String id, String name, String description) {
        tasks.get(id).setName(name);
        tasks.get(id).setDescription(description);
    }
}
