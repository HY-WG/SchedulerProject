package ProjectScheduler.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class ScheduleRequestDto {

    private Long Id;
    private String title;
    private String content;
    private String writer;
    private String password;

}

