package ProjectScheduler.controller;

import ProjectScheduler.dto.ScheduleCommentRequestDto;
import ProjectScheduler.dto.ScheduleCommentResponseDto;
import ProjectScheduler.service.ScheduleCommentService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules/{scheduleId}/comments")
@RequiredArgsConstructor
public class ScheduleCommentController {

    private final ScheduleCommentService commentService;

    @PostMapping
    public ResponseEntity<ScheduleCommentResponseDto> createComment(
            @PathVariable Long scheduleId,
            @Validated @RequestBody ScheduleCommentRequestDto requestDto) {

        ScheduleCommentResponseDto responseDto = commentService.createComment(scheduleId, requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}

