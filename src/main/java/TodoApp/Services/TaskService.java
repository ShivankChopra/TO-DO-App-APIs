package TodoApp.Services;

import java.util.Collection;

import org.springframework.scheduling.config.Task;

public interface TaskService{
	
	public void AddTask(Task task);
	
	public void editTask(Task task);
	
	public Collection<Task> getAllTasks();
}