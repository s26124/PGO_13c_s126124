package g13c.cw7;

@SuppressWarnings("serial")
public class StoryViolationException extends RuntimeException {
    /* Unchecked exceptions extend RuntimeException */
    private String message;

    public StoryViolationException(String string) {
        System.out.println(string);

    }

    public void printMessage() {
        System.out.println(message);
    }



}