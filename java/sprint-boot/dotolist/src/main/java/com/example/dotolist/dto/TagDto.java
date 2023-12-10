package com.example.dotolist.dto;

import com.example.dotolist.models.Tag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TagDto {

    private Long id;
    private String title;
    private String color;

    public TagDto(Tag tag) {
        this.id = tag.getId();
        this.title = tag.getTitle();
        this.color = tag.getColor();
    }

}
