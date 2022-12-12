package com.example.S3Component;

import com.example.S3Component.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class SNSController {

    private final SNSService snsService;

    @PostMapping()
    public Post uploadPost(@ModelAttribute PostDto postDto) throws IOException {
        Post result = snsService.savePost(postDto);
        return result;
    }

    @GetMapping()
    public List<Post> getAllPost() {
        List<Post> postList = snsService.readAll();
        return postList;
    }
}
