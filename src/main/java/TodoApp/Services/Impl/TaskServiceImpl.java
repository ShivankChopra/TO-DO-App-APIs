package TodoApp.Services.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import TodoApp.Domain.Task;
import org.springframework.stereotype.Service;

import TodoApp.Dao.TaskDao;
import TodoApp.Services.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	TaskDao td;

	public void AddTask(Task task) {
		td.AddTask(task);
	}

	public void editTask(Task task) {
		td.editTask(task);
	}

	public Collection<Task> getAllTasks() {
		return td.getAllTasks();
	}
	
}