package np.com.krishnabk.tasks.mappers;

import np.com.krishnabk.tasks.domain.dto.TaskListDTO;
import np.com.krishnabk.tasks.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDTO(TaskListDTO taskListDTO);

    TaskListDTO toDTO(TaskList taskList);

}
