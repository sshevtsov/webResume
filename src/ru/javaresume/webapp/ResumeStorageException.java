package ru.javaresume.webapp;

/**
 * Created by deadRabbit on 14.08.2016.
 */
public class ResumeStorageException extends ResumeException{

    public ResumeStorageException(String uuid, String message) {
        super(uuid, message);
    }

    public ResumeStorageException(String uuid, String message, Throwable cause) {
        super(uuid, message, cause);
    }

    public ResumeStorageException(Throwable cause) {
        super(cause);
    }}
