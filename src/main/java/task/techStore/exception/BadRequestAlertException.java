package task.techStore.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BadRequestAlertException extends RuntimeException {
    public BadRequestAlertException(String message) {
        super(message);
    }
}
