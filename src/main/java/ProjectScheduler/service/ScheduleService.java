package ProjectScheduler.service;

import ProjectScheduler.dto.ScheduleCommentResponseDto;
import ProjectScheduler.dto.ScheduleRequestDto;
import ProjectScheduler.dto.ScheduleResponseDto;
import ProjectScheduler.entity.Schedule;
import ProjectScheduler.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // 일정 생성
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(
                requestDto.getTitle(),
                requestDto.getContent(),
                requestDto.getWriter(),
                requestDto.getPassword()
        );
        Schedule saved = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(saved);
    }

    // 전체 일정 조회 (작성자 조건 optional)
    public List<ScheduleResponseDto> getAllSchedules(String writer) {
        List<Schedule> schedules = (writer == null || writer.isEmpty())
                ? scheduleRepository.findAllByOrderByModifiedAtDesc()
                : scheduleRepository.findAllByWriterOrderByModifiedAtDesc(writer);

        return schedules.stream()
                .map(ScheduleResponseDto::new)
                .collect(Collectors.toList());
    }

    // 단건 조회
    public ScheduleResponseDto getScheduleById(Long id) {
        Schedule schedule = findSchedule(id);
        return new ScheduleResponseDto(schedule);
    }

    // 수정
    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = findSchedule(id);

        // 비밀번호 확인
        if (!schedule.isPasswordMatch(requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        schedule.update(requestDto.getTitle(), requestDto.getWriter());
        return new ScheduleResponseDto(schedule);
    }

    private Schedule findSchedule(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("일정을 찾을 수 없습니다."));
    }

    // 일정 단건 조회
    public ScheduleResponseDto getScheduleWithComments(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("일정을 찾을 수 없습니다."));

        ScheduleCommentService scheduleCommentService = null;
        List<ScheduleCommentResponseDto> comments = scheduleCommentService.getCommentsBySchedule(schedule);

        return ScheduleResponseDto.fromEntity(schedule, comments);
    }

}
