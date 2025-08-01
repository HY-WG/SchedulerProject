package ProjectScheduler.comment;

import ProjectScheduler.entity.Schedule;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "schedule_comments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)

public class ScheduleComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String content;  // 댓글 내용

    @Column(length = 30, nullable = false)
    private String author;   // 작성자명

    @Column(nullable = false)
    private String password; // 비밀번호 (암호화 추천, 예제는 평문)

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;  // 작성일

    @LastModifiedDate
    private LocalDateTime modifiedAt; // 수정일

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @Builder
    public ScheduleComment(String content, String author, String password, Schedule schedule) {
        this.content = content;
        this.author = author;
        this.password = password;
        this.schedule = schedule;
    }

    // 비밀번호 체크
    public boolean isPasswordMatch(String rawPassword) {
        return this.password.equals(rawPassword);
    }

    // 댓글 내용 수정
    public void updateContent(String content) {
        this.content = content;

    }
}