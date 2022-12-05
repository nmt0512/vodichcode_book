package com.example.book5.converter;

import com.example.book5.dto.BookDto;
import com.example.book5.entity.BookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class BookConverter {
    private ModelMapper mapper = new ModelMapper();
    public BookDto toDto(BookEntity entity)
    {
        BookDto dto = mapper.map(entity, BookDto.class);
        dto.setBase64Str(Base64.getEncoder().encodeToString(dto.getImage()));
        return dto;
    }
}
