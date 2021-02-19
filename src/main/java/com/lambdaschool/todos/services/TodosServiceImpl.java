package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{
    @Autowired
    public TodoRepository todoRepository;

    //get todos by id

    @Override
    public void markComplete(long todoid)
    {
        Todos newTodos = todoRepository.findById(todoid)
            .orElseThrow(() -> new EntityNotFoundException("Todo "+ todoid + " Not Found"));
        newTodos.setCompleted(true);
    }
}
