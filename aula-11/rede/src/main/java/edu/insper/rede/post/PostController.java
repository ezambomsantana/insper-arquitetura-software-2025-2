package edu.insper.rede.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Post salvarPost(@RequestBody Post post) {
        return postService.salvarPost(post);
    }

    @PutMapping("/{idPost}/tag/{idTag}")
    public Post associaPostTag(@PathVariable Integer idPost,
                                  @PathVariable Integer idTag) {
        return postService.associaPostTag(idPost, idTag);
    }

    @GetMapping
    public List<Post> listarPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Integer id) {
        return postService.getPost(id);
    }


}
