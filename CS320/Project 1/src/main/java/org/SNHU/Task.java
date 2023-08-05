package org.SNHU;
import java.util.concurrent.atomic.AtomicLong;
/*
@Author: Carlos Affonso
@Date: 2021-03-15
*/
/*

    The task object shall have a
    required unique task ID String that cannot be longer
    than 10 characters. The task ID shall not be null and shall not be updatable.

    The task object shall have a
    required name String field that cannot be longer
    than 20 characters. The name field shall not be null.

    The task object shall have a required description String field that cannot be longer
    than 50 characters. The description field shall not be null.

 */
public class Task {
    private final String id = counter.toString();
    private String name;
    private String description;
    private static AtomicLong counter = new AtomicLong();

    public Task(){
        setId(this);
        this.name = "default";
        this.description = "nodesc";
    }
    public Task(String name, String description) {
        setId(this);
        this.setName(name);
        this.setDescription(description);
    }

    public String getId() {
        return id;
    }

    public String setId(Task task) {
        String id =  counter.toString();
        if (id.length() > 10) {
            throw new IllegalArgumentException("Invalid id");
        }
        counter.incrementAndGet();
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
