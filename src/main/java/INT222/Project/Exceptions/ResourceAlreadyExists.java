package INT222.Project.Exceptions;

public class ResourceAlreadyExists extends RuntimeException{
    public ResourceAlreadyExists(String message) {
        super(message);
    }
}