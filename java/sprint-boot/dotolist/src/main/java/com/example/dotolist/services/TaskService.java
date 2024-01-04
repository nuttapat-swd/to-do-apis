package com.example.dotolist.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dotolist.models.Tag;
import com.example.dotolist.models.Task;
import com.example.dotolist.repositories.TagRepository;
import com.example.dotolist.repositories.TaskRepository;
import com.example.dotolist.utils.BasicUtils;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TagRepository tagRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public Task updateTask(Long id, Task taskDetail){
        Task taskExist = taskRepository.findById(id).orElse(null);

        if (taskExist != null) {
            BeanUtils.copyProperties(taskDetail, taskExist, BasicUtils.getNullPropertyNames(taskDetail));
            taskExist.setId(id);
            return taskRepository.save(taskExist);
        }
        return null;
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public Task addTag(Long taskId, List<Long> tagIds){
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task != null) {
            List<Tag> tagsToAdd = tagIds.stream()
                                    .map(tagId -> tagRepository.findById(tagId)
                                    .orElse(null)).collect(Collectors.toList());
            System.out.println(tagsToAdd);
        }
        
        return null;
    }

}
