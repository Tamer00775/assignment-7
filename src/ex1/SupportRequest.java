package ex1;

public class SupportRequest {
    public enum Type {HARDWARE, SOFTWARE, NETWORK}

    private final Type type;
    private final String description;

    public SupportRequest(Type type, String description) {
        this.type = type;
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
