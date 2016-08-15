package ru.javaresume.webapp;

/**
 * Created by deadRabbit on 14.08.2016.
 */
public class ResumeStorageException extends ResumeException{


    public ResumeStorageException(String uuid, String s) {
        super(uuid, s);
    }

    public ResumeStorageException(String uuid, String s, Throwable throwable) {
        super(uuid, s, throwable);
    }
}
