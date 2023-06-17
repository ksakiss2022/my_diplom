package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.model.Comment;

import java.io.IOException;

@Service
public interface CommentService {


    public Iterable<CommentDto> getComments();

    public CommentDto addComment(CommentDto commentDto) throws IOException;

    public boolean deleteComment(Integer id);

    public CommentDto updateComment(CommentDto commentDto, Integer id);

    CommentDto addComment(Integer adId, CommentDto comment);

    void deleteComment(Integer adId, Integer commentId);

    CommentDto updateComment(Integer adId, Integer commentId, CommentDto commentDto);
}
