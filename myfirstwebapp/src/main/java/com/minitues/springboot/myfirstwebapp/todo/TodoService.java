package com.minitues.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
@Service
public class TodoService {
	private static List<Todo> todos=new ArrayList<>();
	private static int todosCount = 1;
	static {
		todos.add(new Todo(1,"in28minutes","Aws Certified1",
				LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount, "in28minutes","Learn DevOps 1", 
				LocalDate.now().plusYears(2), false ));
		todos.add(new Todo(++todosCount, "in28minutes","Learn Full Stack Development 1", 
				LocalDate.now().plusYears(3), false ));
	}
	
	public List<Todo> findByUsername(String username)
	{
		Predicate<? super Todo> predicater=todo->todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicater).toList();
	}
	public static void addTodo(String username,String description,LocalDate targetDate,boolean done)
	{
		Todo todo=new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
	}
	
	public void deleteById(int id)
	{
		Predicate<? super Todo> predicater=todo->todo.getId()==id;
		todos.removeIf(predicater);
	}
	public Todo findById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicater=todo->todo.getId()==id;
		Todo todo=todos.stream().filter(predicater).findFirst().get();
		return todo;
	}
	public  void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteById(todo.getId());
		todos.add(todo);
		
	}
}
