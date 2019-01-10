package com.poc.smtp.email.infrastruct.handller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor(staticName = "of")
public class ErrorMessageResponse {

    private HttpStatus status;
    private String message;

}
