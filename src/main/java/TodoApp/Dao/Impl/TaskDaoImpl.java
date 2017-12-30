package TodoApp.Dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import TodoApp.Domain.Task;
import org.springframework.stereotype.Repository;

import TodoApp.Dao.TaskDao;

@Repository
public class TaskDaoImpl implements TaskDao{

	private JdbcTemplate jdbcTemplate;
	
	private String getAllTasks = "select * from task;";
	private String editTask = "update task set taskName=?, isDone=? where taskId=? ; ";
	private String addTask = "insert into task(taskId, taskName, isDone) values(?, ?, ?);";
	
	public TaskDaoImpl(DataSource datasource){
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	public void AddTask(Task task) {
		jdbcTemplate.update(addTask, task.getTaskId(), task.getTaskName(), task.getIsDone());
	}

	public void editTask(Task task) {
		jdbcTemplate.update(editTask, task.getTaskName(), task.getIsDone(), task.getTaskId());
	}

	public Collection<Task> getAllTasks() {
		return jdbcTemplate.query(getAllTasks, new RowMapper<Task>(){

			public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
				String id = rs.getString("taskId");
				String name = rs.getString("taskName");
				String isDone = rs.getString("isDone");
				
				Task task = new Task(id, name, isDone);
				return task;
			}// map row
		});// return statement
	}
	
}