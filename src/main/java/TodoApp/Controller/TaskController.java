package TodoApp.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import TodoApp.Services.TaskService;

@RestController
@RequestMapping("/todoApp")
public class TaskController{
	
	@Autowired
	public TaskService ts;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addTask", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addTask(@RequestBody Task task){
		this.addTask(task);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/editTask", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void editTask(@RequestBody Task task){
		this.ts.editTask(task);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAllTasks")
	public Collection<Task> getAllTasks(){
		return this.ts.getAllTasks();
	}
}