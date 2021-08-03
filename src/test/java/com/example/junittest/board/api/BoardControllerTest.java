package com.example.junittest.board.api;

import com.example.junittest.business.board.entity.Board;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
public class BoardControllerTest {

    protected MockMvc mockMvc;
    private ObjectMapper mapper;

    @Test
    @DisplayName("게시글 등록")
    void add() throws Exception{

        ObjectNode content = mapper.createObjectNode();
        content.put("title", "테스트 제목");
        content.put("content", "테스트 내용");

        mockMvc.perform(
                post("/boards")
                        .content(mapper.writeValueAsString(content))
                        .contentType(MediaType.APPLICATION_JSON)
        );
        
    }

    @Test
    @DisplayName("게시글 조회")
    void getBoard() throws Exception {
        mockMvc.perform(get("/board/{id}", 1L));
    }
    
    
    
}
