package com.Angualrlearn.LearnAngular.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(ResourceNotFoundExcepiton.class)
    ResponseEntity<ResourceNotFoundExcepiton> resosoucenotfount(ResourceNotFoundExcepiton ex)
    {
           return new ResponseEntity<ResourceNotFoundExcepiton>(new ResourceNotFoundExcepiton("Something went wront"), HttpStatus.NOT_FOUND);
    }

}
