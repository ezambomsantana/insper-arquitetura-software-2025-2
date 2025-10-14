package edu.insper.rede.tags;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public Tag salvarTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public List<Tag> listarTags() {
        return tagRepository.findAll();
    }

    public Tag getTag(Integer id) {
        return tagRepository.findById(id).get();
    }


}
