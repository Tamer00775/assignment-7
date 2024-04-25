package ex1;

public class HardwareRequestHandler implements SupportHandler {
    private SupportHandler nextHandler;
    @Override
    public void handleRequest(SupportRequest supportRequest) {
        if (supportRequest.getType() == SupportRequest.Type.HARDWARE) {
            System.out.println("Обработка запроса по оборудованию: " + supportRequest.getDescription());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(supportRequest);
        }
    }

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
