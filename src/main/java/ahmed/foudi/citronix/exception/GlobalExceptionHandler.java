package ahmed.foudi.citronix.exception;

import ahmed.foudi.citronix.dto.error.ErrorDTO;
import ahmed.foudi.citronix.exception.fieldexception.SuperficieFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SuperficieFieldException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> handleSuperficieFieldException(Exception ex, WebRequest request) {
        return buildErrorResponse(ex.getMessage(), request, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorDTO> buildErrorResponse(String message, WebRequest request, HttpStatus status) {
        ErrorDTO errorDTO = ErrorDTO.builder()
                .message(message)
                .path(request.getDescription(false))
                .status(status.value())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorDTO, status);
    }
}
