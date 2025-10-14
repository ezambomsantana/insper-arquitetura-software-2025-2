package edu.insper.rede.post;

import edu.insper.rede.tags.Tag;
import edu.insper.rede.tags.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagService tagService;

    public Post salvarPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPost(Integer id) {
        return postRepository.findById(id).get();
    }

    public Post associaPostTag(Integer idPost, Integer idTag) {
        Post post = postRepository.findById(idPost).get();
        Tag tag = tagService.getTag(idTag);

        post.getTags().add(tag);

        return postRepository.save(post);

    }


}
