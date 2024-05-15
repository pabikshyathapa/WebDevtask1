package com.example.demo.Exception;
import com.example.demo.pojo.GlobalApilResponse;
import com.example.demo.pojo.GlobalApilResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice

public class CustomExceptionHandler {
    @ExceptionHandler({Exception.class})
    public GlobalApilResponse<String> handleAll(final Exception ex,
                                               final WebRequest request) {
        GlobalApilResponse<String> response = new GlobalApilResponse<>();
        response.setMessage(ex.getMessage());
        response.setStatus(400);
        response.setData("request failed");
        return response;
    }
}
