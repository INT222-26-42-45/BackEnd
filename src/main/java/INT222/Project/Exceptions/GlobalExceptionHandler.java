package INT222.Project.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException r){
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("Not_Found");
        response.setErrorMessage(r.getMessage());
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<ExceptionResponse> resourceAlreadyExist(ResourceAlreadyExists r){
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("CONFLICT");
        response.setErrorMessage(r.getMessage());
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MaxUploadSizeExceededException .class)
    public ResponseEntity<ExceptionResponse> handleMaxSizeException(MaxUploadSizeExceededException exc) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("EXCEPTATION_FAILED");
        response.setErrorMessage("File upload too large.");
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.EXPECTATION_FAILED);
    }


}
