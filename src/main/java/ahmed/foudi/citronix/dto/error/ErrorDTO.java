package ahmed.foudi.citronix.dto.error;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorDTO {
    private String message;
    private String path;
    private int status;
    private LocalDateTime timestamp;
}
