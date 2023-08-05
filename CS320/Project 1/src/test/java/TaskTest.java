
import org.junit.jupiter.api.*;
import org.SNHU.*;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    public void testTaskName(){
        Task task = new Task();

        assertNotNull(task.getName());
        assertTrue(task.getName().length() <= 20);
        assertThrows(IllegalArgumentException.class, () -> task.setName("123456789012345678901"));
    }
    @Test
    public void testTaskID(){
        Task task = new Task();
        assertNotNull(task.getId());
        assertTrue(task.getId().length() <= 10);
    }
    @Test
    public void testTaskDescription(){
        Task task = new Task();
        assertNotNull(task.getDescription());
        assertTrue(task.getDescription().length() <= 50);
        assertThrows(IllegalArgumentException.class, () -> task.setDescription("123456789012345678901234567890123456789012345678901"));
    }

}
