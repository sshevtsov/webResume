package ru.javaresume.webapp;

/**
 * Created by deadRabbit on 22.08.2016.
 */
public class ResumeNotFoundException extends ResumeStorageException{
    public ResumeNotFoundException(String uuid) {
        super(uuid, "Resume " + uuid + " not found");
    }
}
