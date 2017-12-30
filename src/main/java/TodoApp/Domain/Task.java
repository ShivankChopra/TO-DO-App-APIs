package TodoApp.Domain;

public class Task{
	
	private String taskId;
	private String taskName;
	private String isDone;
	private String createdAt;
	private String doneAt;
	 
	public Task(){}

	public Task(String taskId, String taskName, String isDone/*, String createdAt, String doneAt*/) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.isDone = isDone;
		/*this.createdAt = createdAt;
		this.doneAt = doneAt;*/
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getIsDone() {
		return isDone;
	}

	public void setIsDone(String isDone) {
		this.isDone = isDone;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getDoneAt() {
		return doneAt;
	}

	public void setDoneAt(String doneAt) {
		this.doneAt = doneAt;
	}
	
	
	
	
	
}