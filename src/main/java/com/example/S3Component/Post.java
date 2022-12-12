package com.example.S3Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                                        // DB 저장 index
    private String imgUrl;                                  // DB에 저장될 이미지의 URL
    private String content;                                 // 포스트 내용
    private LocalDateTime createTime;                       // 포스트 생성 시간

    // DB 저장 직전에 함수 실행
    @PrePersist
    public void createDate() {
        this.createTime = LocalDateTime.now();
    }
}
