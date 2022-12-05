package com.example.book5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Integer bookId;
    private String name;
    private String author;
    private String category;
    private Date date;
    private Integer page;
    private String description;
    private byte[] image;
    private String base64Str;

}
