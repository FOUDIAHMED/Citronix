package ahmed.foudi.citronix.exception;

import ahmed.foudi.citronix.dto.error.ErrorDTO;
import ahmed.foudi.citronix.exception.farmexception.FarmException;
import ahmed.foudi.citronix.exception.fieldexception.SuperficieFieldException;
import ahmed.foudi.citronix.exception.harvestexception.HarvestException;
import ahmed.foudi.citronix.exception.treeexception.PlantingDateException;
import ahmed.foudi.citronix.exception.treeexception.TreeAlreadyHarvestedException;
import ahmed.foudi.citronix.exception.treeexception.TreeDensityException;
import ahmed.foudi.citronix.exception.treeexception.TreeNotProductiveException;
import jakarta.persistence.EntityNotFoundException;
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
    @ExceptionHandler(FarmException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> handleFarmException(Exception ex, WebRequest request) {
        return buildErrorResponse(ex.getMessage(), request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PlantingDateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> handlePlantingDateException(Exception ex, WebRequest request) {
        return buildErrorResponse(ex.getMessage(), request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TreeDensityException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> handleTreeDensityException(Exception ex, WebRequest request) {
        return buildErrorResponse(ex.getMessage(), request, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HarvestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> handleHarvestException(Exception ex, WebRequest request) {
        return buildErrorResponse(ex.getMessage(), request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TreeAlreadyHarvestedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> handleTreeAlreadyHarvestedException(Exception ex, WebRequest request) {
        return buildErrorResponse(ex.getMessage(), request, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TreeNotProductiveException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> handleTreeNotProductiveException(Exception ex, WebRequest request) {
        return buildErrorResponse(ex.getMessage(), request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> handleEntityNotFoundException(Exception ex, WebRequest request) {
        return buildErrorResponse(ex.getMessage(), request, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException(Exception ex, WebRequest request) {
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
