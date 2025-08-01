package ProjectScheduler.repository;

import ProjectScheduler.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByWriterOrderByModifiedAtDesc(String writer);
    List<Schedule> findAllByOrderByModifiedAtDesc();
}
