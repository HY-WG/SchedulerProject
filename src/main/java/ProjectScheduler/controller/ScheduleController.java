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


    //  1. 일정 생성 (POST /api/schedules)
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.createSchedule(requestDto));
    }

    // 2. 전체 조회 (GET /api/schedules?writer=작성자명)
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules(
            @RequestParam(value = "writer", required = false) String writer) {
        return ResponseEntity.ok(scheduleService.getAllSchedules(writer));
    }

    // 3. 단일 일정 조회 (GET /api/schedules/{id})
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getScheduleById(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.getScheduleById(id));
    }

    // 4. 일정 수정 (PUT /api/schedules/{id})
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.updateSchedule(id, requestDto));
    }
}




