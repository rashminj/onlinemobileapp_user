package com.cg.oma.exception;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.oma.Resposeinfo.ResponseInfo;
@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(MethodArgumentNotValidException.class)
ResponseEntity<ResponseInfo> exceptionHandlingForValidation(MethodArgumentNotValidException e,HttpServletRequest requst) {

Map<String, String> m = new LinkedHashMap<>();
List<ObjectError> list = e.getBindingResult().getAllErrors();
list.forEach(obj->{
FieldError fe = (FieldError)obj;
String fieldName =fe.getField();
String errorMsg = fe.getDefaultMessage();
m.put(fieldName, errorMsg);
});

ResponseInfo rinfo=new ResponseInfo(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(),m.toString(),requst.getRequestURI());
ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.NOT_FOUND);
return rentity ;
}


@ExceptionHandler(Exception.class)
ResponseEntity<ResponseInfo> exceptionHandlingForUser(Exception e,HttpServletRequest requst) {

ResponseInfo rinfo=new ResponseInfo(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(),e.getMessage(),requst.getRequestURI());
ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.NOT_FOUND);
return rentity ;
}


}
