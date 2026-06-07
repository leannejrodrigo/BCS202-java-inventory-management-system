public class InvalidLoginException extends Exception{
    @Override
    public String getMessage() {
        return "error: Wrong username or password.";
    }
}
