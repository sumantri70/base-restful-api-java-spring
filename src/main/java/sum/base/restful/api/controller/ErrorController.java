package sum.base.restful.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sum.base.restful.api.dto.base.RestResponse;
import sum.base.restful.api.error.NotFoundException;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ConstraintViolationException.class)
    public RestResponse<String> badRequest(ConstraintViolationException constraintViolationException){
        return RestResponse.badRequest(
                constraintViolationException.getMessage()
        );
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NotFoundException.class)
    public RestResponse<String> notFound(NotFoundException notFoundException){
        return RestResponse.notFound(
                notFoundException.getMessage()
        );
    }

}
