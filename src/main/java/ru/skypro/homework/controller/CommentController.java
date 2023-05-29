package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.model.Ads;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.service.CommentService;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Класс CommentController является REST-контроллером, который обрабатывает запросы для работы с комментариями.
 */
@RestController//аннотация @RestController указывает, что это класс REST-контроллера
@RequestMapping("/ads")//устанавливает базовый URL-адрес для всех методов, которые обрабатываются этим контроллером.
@CrossOrigin(value = "http://localhost:3000")//определяет адреса и порты, с которых будет доступен данный ресурс.
public class CommentController {
    private final CommentService commentService;
    private final AdsRepository adsRepository;
    private final CommentRepository commentRepository;

    public CommentController(CommentService commentService, AdsRepository adsRepository, CommentRepository commentRepository) {
        this.commentService = commentService;
        this.adsRepository = adsRepository;
        this.commentRepository = commentRepository;
    }

    //getComments предназначена для получения списка комментариев к определенному объявлению. Для этого нужно передать ID
    // объявления в параметре URL. В ответ сервер возвращает массив объектов CommentDto в формате JSON.
    @Operation(
            operationId = "getComments",
            summary = "Получить комментарии объявления",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = CommentDto.class))
                            )),
                    @ApiResponse(responseCode = "401", description = "Unauthorized")
            }, tags = "Комментарии")
    @GetMapping("/ads/{id}/comments")
    public ResponseEntity<CommentDto> getComments(@Parameter(description = "Id комментария") @PathVariable Integer id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }


// операция "addComment" предназначена для добавления нового комментария к определенному объявлению. Для этого нужно
// передать объект Comment в теле запроса. В ответ сервер вернет объект CommentDto созданного комментария.
    @Operation(
            operationId = "addComment",
            summary = "Добавить комментарий к объявлению",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = CommentDto.class))
                            )),
                    @ApiResponse(responseCode = "401", description = "Unauthorized")
            }, tags = "Комментарии")
    @PostMapping("/comment")
    public ResponseEntity<CommentDto> addComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    // операция "deleteComment" предназначена для удаления определенного комментария. Для этого нужно передать ID
    // комментария и ID объявления в параметрах URL. В ответ сервер вернет статус 204 No Content в случае успешного
    // удаления.
    @Operation(
            operationId = "deleteComment",
            summary = "Удалить комментарий",
            responses = {
                    @ApiResponse(responseCode = "204", description = "No Content"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
            }, tags = "Комментарии")
    @DeleteMapping("//ads/{adId}/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@Parameter(description = "Id комментария") @PathVariable Integer id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


   // операция "updateComment" предназначена для обновления определенного комментария. Для этого нужно передать в теле
   // запроса объект Comment с обновленными полями и ID комментария и ID объявления в параметрах URL. В ответ сервер
   // вернет объект Comment обновленного комментария.
    @Operation(
            operationId = "adId",
            summary = "Обновить комментарий",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = AdsDto.class))
                            )),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden")
            }, tags = "Комментарии")
    @PatchMapping("/comment")
    public ResponseEntity<Comment> updateComment(
            @PathVariable Long adId,
            @PathVariable Long commentId,
            @RequestBody Comment updateRequest,
            Authentication authentication
    ) {
        if (authentication == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Ads ads = adsRepository.findAdsById(id);
        if (ads == null) {
            return ResponseEntity.notFound().build();
        }

        Comment comment = commentRepository.findCommentById(id);
        return ResponseEntity.notFound().build();

    }

}
