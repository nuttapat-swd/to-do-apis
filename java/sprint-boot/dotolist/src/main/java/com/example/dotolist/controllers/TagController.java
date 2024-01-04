package com.example.dotolist.controllers;
import com.example.dotolist.models.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dotolist.services.TagService;


@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping("/")
    public ResponseEntity<List<Tag>> getAllTags(String param) {
        return ResponseEntity.ok(tagService.getAllTags());
    }

    @PostMapping("/")
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        return new ResponseEntity<Tag>(tagService.createTag(tag), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/")
    public ResponseEntity<Tag> getTagById(@PathVariable("id") Long id) {        
        Tag tag = tagService.getTagById(id);
        if (tag == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tag);
    }

    @PatchMapping("/{id}/")
    public ResponseEntity<Tag> updateTag(@PathVariable("id") Long id, @RequestBody Tag tagDetail){
        Tag tag = tagService.updateTag(id, tagDetail);
        if(tag!=null){
            // TagDto tagDto = new TagDto(tag);
            return ResponseEntity.ok(tag);
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
