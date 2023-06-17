package ru.skypro.homework.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.mappers.CommentMapper;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.service.CommentService;

import java.io.IOException;

@Service
@Transactional
@Slf4j
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final AdsRepository adsRepository;

    public CommentServiceImpl(CommentRepository commentRepository, AdsRepository adsRepository) {
        this.commentRepository = commentRepository;
        this.adsRepository = adsRepository;
    }

    @Override
    public Iterable<CommentDto> getComments() {
        return null;
    }

    @Override
    public CommentDto addComment(CommentDto commentDto) throws IOException {
        return null;
    }

    @Override
    public boolean deleteComment(Integer id) {
        return false;
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto, Integer id) {
        return null;
    }

    @Override
    public CommentDto addComment(Integer adId, CommentDto comment) {
        Comment newComment = CommentMapper.INSTANCE.INSTANCE.commentDtoToComment(comment);
        log.info("Save comment: " + newComment);
        return CommentMapper.INSTANCE.INSTANCE.commentToCommentDto(newComment);
    }

    @Override
    public void deleteComment(Integer adId, Integer commentId) {
        Comment comment = commentRepository.findByIdAndAdId(commentId, adId)
                .orElseThrow(() -> new NotFoundException("Comment not found"));
        commentRepository.delete(comment);
    }

    @Override
    public CommentDto updateComment(Integer adId, Integer commentId, CommentDto commentDto) {
        Comment comment = CommentMapper.INSTANCE.INSTANCE.commentDtoToComment(commentDto);
        log.info("Update comment: " + comment);
        return CommentMapper.INSTANCE.INSTANCE.commentToCommentDto(commentRepository.save(comment));
    }
}
