package com.minitues.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
@Controller
@SessionAttributes("nane")
public class TodoControllerjpa {


	private TodoRepository todoRepository;
	
	
	public TodoControllerjpa(TodoRepository todoRepository) {
		super();
		
		this.todoRepository=todoRepository;
	}


	@RequestMapping("list-todos")
	public String ListAllTodos(ModelMap model)
	{
		String username=getLoggedInUsername(model);

		

		List<Todo> todos=todoRepository.findByUsername(username);
		model.addAttribute("todos",todos);
		return "listTodos";
	}



	
	
	
	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model)
	{
		String username=getLoggedInUsername(model);
		Todo todo=new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todos";
	}
	
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addNewTodo(ModelMap model,@Valid Todo todo,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "todos";
		}
		String username=getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		
		// TodoService.addTodo(username, todo.getDescription(),
		// 		todo.getTargetDate(), todo.isDone());
		
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id)
	{
		todoRepository.deleteById(id);
		// todoservice.deleteById(id);
		return "redirect:list-todos";
	}
	
	// @RequestMapping("update-todo")
	// public String showUpdateTodoPage(@RequestParam int id,ModelMap model)
	// {
	// 	Todo todo=todoRepository.findById(id).get();
	// 	model.addAttribute("todo", todo);
	// 	return "todos";
	// }
	
	
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id,ModelMap model)
	{
		Todo todo=todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "todos";
	}
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "todos";
		}
		String username=getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		// todoservice.updateTodo(todo);
		
		return "redirect:list-todos";
	}
	private String getLoggedInUsername(ModelMap model) {
		 Authentication  authentication= SecurityContextHolder.getContext().getAuthentication();
		 return authentication.getName();
	}
	// private String getLoggedInUsername(ModelMap model) {
	// 	Authentication authentication = 
	// 			SecurityContextHolder.getContext().getAuthentication();
	// 	return authentication.getName();
	// }
}
