package exceptions.details;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Data
@SuperBuilder
public class ExceptionsDetailsNotFound {
    private Integer status;
    private String title;
    private Instant timestamp;
    private String details;
    private String developerMessage;
}
