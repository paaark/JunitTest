package com.example.junittest.business.board.mapper;

import com.example.junittest.business.board.entity.Board;
import com.example.junittest.business.board.form.BoardForm.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BoardMapper {

    BoardMapper mapper = Mappers.getMapper(BoardMapper.class);

    Board toEntity(Request.Add add);

    Response.Find toDto(List<Board> boardList);

    Response.FindAll toDto();

}
