package np.com.krishnabk.tasks.domain.dto;

import np.com.krishnabk.tasks.domain.entities.TaskPriority;
import np.com.krishnabk.tasks.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDTO(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
