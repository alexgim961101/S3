package com.example.S3Component;

import com.example.S3Component.dto.PostDto;
import com.example.S3Component.utils.S3cp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SNSService {
    private final S3cp s3Cp;
    private final PostRepository postRepository;
    public Post savePost(PostDto postDto) throws IOException {
        String url = s3Cp.saveFile(postDto.getFile());
        Post post = postDto.toEntity(url);

        Post postEntity = postRepository.save(post);
        return postEntity;
    }

    public List<Post> readAll() {
        return postRepository.findAll();
    }
}
