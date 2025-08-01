package ProjectScheduler.controller;

import ProjectScheduler.dto.ScheduleRequestDto;
import ProjectScheduler.dto.ScheduleResponseDto;
import ProjectScheduler.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 생성
    @PostMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.createSchedule(requestDto));
    }

    // 전체 조회
    @GetMapping("/{id}")
    public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules(
            @RequestParam(value = "writer", required = false) String writer) {
        return ResponseEntity.ok(scheduleService.getAllSchedules(writer));
    }


    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.updateSchedule(id, requestDto));
    }
}




