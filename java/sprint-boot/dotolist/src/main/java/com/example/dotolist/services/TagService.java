package com.example.dotolist.services;
import com.example.dotolist.models.Tag;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dotolist.repositories.TagRepository;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag getTagById(Long id){
        return tagRepository.findById(id).orElse(null);
    }

    public Tag updateTag(Long id, Tag tagDetails){
        Tag tag = tagRepository.findById(id).orElse(null);
        if (tag != null) {
            if (tagDetails.getTitle() != null) {
                tag.setTitle(tagDetails.getTitle());
            }
            if (tagDetails.getColor()!= null) {
                tag.setColor(tagDetails.getColor());
            }
            return tagRepository.save(tag);
        }
        return null;
    }

    public boolean deleteTag(Long id){
        Tag tag = tagRepository.findById(id).orElse(null);
        if (tag != null) {
            tagRepository.delete(tag);
            return true;
        }
        else{
            return false;
        }
    }

}
