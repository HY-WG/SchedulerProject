package ProjectScheduler.repository;

import ProjectScheduler.entity.Schedule;
import ProjectScheduler.comment.ScheduleComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleCommentRepository extends JpaRepository<ScheduleComment, Long> {
    List<ScheduleComment> findBySchedule(Schedule schedule);
    long countBySchedule(Schedule schedule);
}

