package ProjectScheduler.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ScheduleCommentRequestDto {

    @NotBlank(message = "댓글 내용을 입력하세요.")
    @Size(max = 100, message = "댓글 내용은 최대 100자입니다.")
    private String content;

    @NotBlank(message = "작성자명을 입력하세요.")
    @Size(max = 30)
    private String author;

    @NotBlank(message = "비밀번호를 입력하세요.")
    private String password;
}

