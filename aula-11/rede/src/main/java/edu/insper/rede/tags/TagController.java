package edu.insper.rede.tags;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    public Tag salvarTag(@RequestBody Tag tag) {
        return tagService.salvarTag(tag);
    }

    @GetMapping
    public List<Tag> listarTags() {
        return tagService.listarTags();
    }

    @GetMapping("/{id}")
    public Tag getTag(@PathVariable Integer id) {
        return tagService.getTag(id);
    }
}
