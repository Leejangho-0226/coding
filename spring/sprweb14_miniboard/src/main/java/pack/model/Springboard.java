package pack.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "springboard")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Springboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;

    @Column(length = 10)
    private String author;

    @Column(length = 30)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime bwrite;

    private int readcnt;
}
