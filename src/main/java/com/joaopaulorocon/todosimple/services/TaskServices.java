package com.joaopaulorocon.todosimple.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaopaulorocon.todosimple.models.Task;
import com.joaopaulorocon.todosimple.models.User;
import com.joaopaulorocon.todosimple.repositores.TasksRepository;

@Service
public class TaskServices {
    
    
    @Autowired
    private TasksRepository tasksRepository;
    
    @Autowired
    private UserServices userServices;

    public Task findById(Long id) {
        Optional<Task> user = this.tasksRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException(
                "Tarefa não encontrada!!Id: " + id + " Tipo :" + Task.class.getName()));
    }

    @Transactional
    public Task create(Task obj) {
        User user = this.userServices.findById(obj.getUser().getId());
        obj.setId(null);
        obj.setUser(user);
        obj = this.tasksRepository.save(obj);
        return obj;
    }

    @Transactional
    public Task update(Task obj){
        Task newObj = findById(obj.getId());
        newObj.setDescripition(obj.getDescripition());
        return this.tasksRepository.save(newObj);
    }

    public List <Task>  findAllById(Long userId){
        List<Task> tasks = this.tasksRepository.findByUser_Id(userId);
        return tasks;
    }

    public void delete(Long id){
        findById(id);
        try {
            this.tasksRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas a este usuário!!");
        }
    }


}
