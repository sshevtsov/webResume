package ru.javaresume.webapp;

/**
 * Created by deadRabbit on 14.08.2016.
 */
public class ResumeException extends RuntimeException{

    private final String uuid;

    public ResumeException(Throwable cause) {
        this(null, null, cause);
    }

    public ResumeException(String uuid, String message) {
        super(message);
        this.uuid = uuid;
    }

    public ResumeException(String uuid, String message, Throwable cause) {
        super(message, cause);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
