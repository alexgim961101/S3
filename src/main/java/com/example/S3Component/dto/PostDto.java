package com.example.S3Component.dto;

import com.example.S3Component.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PostDto {
    private MultipartFile file;
    private String content;

    public Post toEntity(String url) {
        return Post.builder()
                .imgUrl(url)
                .content(content)
                .build();
    }
}
