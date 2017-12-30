package TodoApp.Dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

//import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import TodoApp.Domain.Task;
import org.springframework.stereotype.Repository;

import TodoApp.Dao.TaskDao;

@Repository
public class TaskDaoImpl implements TaskDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String getAllTasks = "select * from task;";
	private String editTask = "update task set taskName=?, isDone=? where taskId=? ; ";
	private String editCompletedTask = "update task set taskName=?, isDone=?, doneAt=? where taskId=? ; ";
	private String addTask = "insert into task(taskName, isDone, createdAt) values(?, ?, ?);";
	private String addCompletedTask = "insert into task(taskName, isDone, createdAt, doneAt) values(?, ?, ?, ?);";
	
	/*public TaskDaoImpl(DataSource datasource){
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}*/
	
	public void AddTask(Task task) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/mm/dd");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		
		if(task.getIsDone().equals("yes"))
		    jdbcTemplate.update(addCompletedTask, task.getTaskName(), task.getIsDone(), date, date);
		else
			jdbcTemplate.update(addTask, task.getTaskName(), task.getIsDone(), date);
	}

	public void editTask(Task task) {
		if(task.getIsDone().equals("yes")){
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/mm/dd");
			LocalDateTime now = LocalDateTime.now();
			String date = dtf.format(now);
		    jdbcTemplate.update(editCompletedTask, task.getTaskName(), task.getIsDone(), date, task.getTaskId());
		}
		else
		    jdbcTemplate.update(editTask, task.getTaskName(), task.getIsDone(), task.getTaskId());
	}

	public Collection<Task> getAllTasks() {
		return jdbcTemplate.query(getAllTasks, new RowMapper<Task>(){

			public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("taskId");
				String name = rs.getString("taskName");
				String isDone = rs.getString("isDone");
				String createdAt = rs.getString("createdAt");
				String doneAt = rs.getString("doneAt");
				
				Task task = new Task(id, name, isDone, createdAt, doneAt);
				return task;
			}// map row
		});// return statement
	}
	
}