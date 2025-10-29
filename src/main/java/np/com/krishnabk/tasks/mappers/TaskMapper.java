package np.com.krishnabk.tasks.mappers;

import np.com.krishnabk.tasks.domain.dto.TaskDTO;
import np.com.krishnabk.tasks.domain.entities.Task;

public interface TaskMapper {

    Task fromDTO(TaskDTO taskDTO);

    TaskDTO toDTO(Task task);
}
