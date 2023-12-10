package com.example.dotolist.controllers;
import com.example.dotolist.dto.TagDto;
import com.example.dotolist.models.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dotolist.services.TagService;




@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping("/")
    public List<Tag> getAllTags(String param) {
        return tagService.getAllTags();
    }

    @PostMapping("/")
    public Tag createTag(@RequestBody Tag tag) {
        return tagService.createTag(tag);
    }

    @GetMapping("/{id}/")
    public ResponseEntity<TagDto> getTagById(@PathVariable("id") Long id) {        
        Tag tag = tagService.getTagById(id);     
        if (tag != null) {
            TagDto tagDTO = new TagDto(tag);
            return ResponseEntity.ok(tagDTO);
        } else {
            return ResponseEntity.notFound().build();
        } 
    }

    @PatchMapping("/{id}/")
    public ResponseEntity<TagDto> updateTag(@PathVariable("id") Long id, @RequestBody Tag tagDetail){
        Tag tag = tagService.updateTag(id, tagDetail);
        if(tag!=null){
            TagDto tagDto = new TagDto(tag);
            return ResponseEntity.ok(tagDto);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity<?> deleteTag(@PathVariable("id") Long id){
        Boolean result = tagService.deleteTag(id);
        if (result == true){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
