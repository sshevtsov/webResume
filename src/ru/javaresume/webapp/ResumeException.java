package ru.javaresume.webapp;

/**
 * Created by deadRabbit on 14.08.2016.
 */
public class ResumeException extends RuntimeException{

    private final String uuid;

    public ResumeException(String uuid, String s) {
        super(s);
        this.uuid = uuid;
    }

    public ResumeException(String uuid, String s, Throwable throwable) {
        super(s, throwable);
        this.uuid = uuid;
    }
}
