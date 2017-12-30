package TodoApp.Dao;

import java.util.Collection;

import TodoApp.Domain.Task;

public interface TaskDao{
	
    public void AddTask(Task task);
	
	public void editTask(Task task);
	
	public Collection<Task> getAllTasks();
}