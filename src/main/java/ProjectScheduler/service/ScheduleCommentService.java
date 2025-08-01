package ProjectScheduler.service;


import ProjectScheduler.entity.Schedule;
import ProjectScheduler.comment.ScheduleComment;
import ProjectScheduler.dto.ScheduleCommentRequestDto;
import ProjectScheduler.dto.ScheduleCommentResponseDto;
import ProjectScheduler.repository.ScheduleCommentRepository;
import ProjectScheduler.repository.ScheduleRepository;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional

public class ScheduleCommentService {

    private final ScheduleCommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    private static final int MAX_COMMENTS_PER_SCHEDULE = 10;

    public ScheduleCommentResponseDto createComment(Long scheduleId, ScheduleCommentRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 일정입니다."));

        long count = commentRepository.countBySchedule(schedule);
        if (count >= MAX_COMMENTS_PER_SCHEDULE) {
            throw new IllegalStateException("하나의 일정에는 최대 10개의 댓글만 작성할 수 있습니다.");
        }

        ScheduleComment comment = ScheduleComment.builder()
                .content(requestDto.getContent())
                .author(requestDto.getAuthor())
                .password(requestDto.getPassword())
                .schedule(schedule)
                .build();

        ScheduleComment saved = commentRepository.save(comment);

        return toResponseDto(saved);
    }

    public List<ScheduleCommentResponseDto> getCommentsBySchedule(Schedule schedule) {
        List<ScheduleComment> comments = commentRepository.findBySchedule(schedule);
        return comments.stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    private ScheduleCommentResponseDto toResponseDto(ScheduleComment comment) {
        return ScheduleCommentResponseDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .author(comment.getAuthor())
                .createdAt(comment.getCreatedAt())
                .modifiedAt(comment.getModifiedAt())
                .build();
    }


}

