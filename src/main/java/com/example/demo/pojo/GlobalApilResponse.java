package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor

    public class GlobalApilResponse<T> {
        private Integer status;
        private String message;
        private T data;
    }
