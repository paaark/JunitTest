package com.example.junittest.business.board.form;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class BoardForm {

    public static class Request {
        @Getter
        @NoArgsConstructor
        public static class Add {
            private String title;
            private String content;

            public Add(String title, String content) {
                this.title = title;
                this.content = content;
            }
        }

        @Getter
        @NoArgsConstructor
        public static class Modify {
            private String title;
            private String content;

            public Modify(String title, String content) {
                this.title = title;
                this.content = content;
            }
        }
    }

    public static class Response{

        @Getter
        public static class Find{
            private String title;
            private String content;

            public Find(String title, String content) {
               this.title = title;
               this.content = content;
            }
        }

        @Getter
        public static class FindAll{
            private Long id;
            private String title;
            private String content;

            public FindAll(Long id, String title, String content) {
                this.id = id;
                this.title = title;
                this.content = content;
            }
        }
    }


}
