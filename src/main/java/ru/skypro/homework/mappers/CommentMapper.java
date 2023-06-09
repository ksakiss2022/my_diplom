package ru.skypro.homework.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.model.Comment;

import java.util.Collection;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "pk", source = "id")
    @Mapping(target = "createdAt", source = "createdAt")
    CommentDto commentToCommentDto (Comment comment);

    @InheritInverseConfiguration
    Comment commentDtoToComment(CommentDto commentDto);

    Collection<CommentDto> commentCollectionToCommentDto(Collection<Comment> commentCollection);
}