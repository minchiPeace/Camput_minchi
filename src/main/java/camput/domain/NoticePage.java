package camput.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class NoticePage {

    @Id
    @GeneratedValue
    @Column(name = "noticePage_id")
    private Long id;
    private String noticeTitle;
    private String noticeContent;
    private LocalDateTime localDateTime;

    @Builder
    public NoticePage(String noticeTitle, String noticeContent, LocalDateTime localDateTime) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.localDateTime = localDateTime;
    }
}
