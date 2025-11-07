package np.com.krishnabk.tasks.mappers.impl;

import np.com.krishnabk.tasks.domain.dto.TaskListDTO;
import np.com.krishnabk.tasks.domain.entities.Task;
import np.com.krishnabk.tasks.domain.entities.TaskList;
import np.com.krishnabk.tasks.domain.entities.TaskStatus;
import np.com.krishnabk.tasks.mappers.TaskListMapper;
import np.com.krishnabk.tasks.mappers.TaskMapper;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDTO(TaskListDTO taskListDTO) {
        return new TaskList(
                taskListDTO.id(),
                taskListDTO.title(),
                taskListDTO.description(),
                Optional.ofNullable(taskListDTO.tasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::fromDTO)
                                .toList()
                        )
                        .orElse(null),
                null,
                null
        );
    }


    @Override
    public TaskListDTO toDTO(TaskList taskList) {
        return new TaskListDTO(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTasks())
                        .map(List::size)
                        .orElse(0),
                calculateTaskListProgress(taskList.getTasks()),
                Optional.ofNullable(taskList.getTasks())
                        .map(tasks ->
                                tasks.stream().map(taskMapper::toDTO).toList()
                        ).orElse(null)
                );
    }

    private Double calculateTaskListProgress(List<Task> tasks){
        if(null == tasks){
            return null;
        }

        long closedTaskCount = tasks.stream().filter(task ->
                TaskStatus.CLOSED == task.getStatus()
        ).count();

        return (double) closedTaskCount /tasks.size();
    }

}
