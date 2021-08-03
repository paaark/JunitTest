package com.example.junittest.business.board.api;

import com.example.junittest.business.board.application.BoardService;
import com.example.junittest.business.board.entity.Board;
import com.example.junittest.business.board.form.BoardForm.*;
import com.example.junittest.business.board.mapper.BoardMapper;
import com.example.junittest.common.response.dto.ResponseDto;
import com.example.junittest.common.response.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardMapper mapper = Mappers.getMapper(BoardMapper.class);

    @PostMapping("/boards")
    public ResponseEntity<ResponseDto> add(@RequestBody Request.Add add){

        boardService.save(mapper.toEntity(add));

        return ApiResponse.success(HttpStatus.CREATED,"정상적으로 등록되었습니다.","returnUrl");
    }

    @GetMapping("/board")
    public ResponseEntity<ResponseDto> boards() {
        return ApiResponse.success(HttpStatus.OK, mapper.toDto(boardService.findAll()), "returnUrl");
    }

    @GetMapping("/board/{id}")
    public ResponseEntity<ResponseDto> board(@PathVariable Long id){
        return ApiResponse.success(HttpStatus.OK, boardService.findById(id), "returnUrl");
    }

}
