package ProjectScheduler.dto;

import lombok.*;
import lombok.Builder;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ScheduleCommentResponseDto {

    private Long id;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<ScheduleCommentResponseDto> comments;

    }
