package ex1;

public class Main {
    public static void main(String[] args) {
        HardwareRequestHandler hardwareHandler = new HardwareRequestHandler();
        SoftwareRequestHandler softwareHandler = new SoftwareRequestHandler();
        NetworkSupportHandler networkHandler = new NetworkSupportHandler();

        hardwareHandler.setNextHandler(softwareHandler);
        softwareHandler.setNextHandler(networkHandler);

        SupportRequest request1 = new SupportRequest(SupportRequest.Type.HARDWARE, "Проблема с компьютером");
        SupportRequest request2 = new SupportRequest(SupportRequest.Type.SOFTWARE, "Проблема с программой");
        SupportRequest request3 = new SupportRequest(SupportRequest.Type.NETWORK, "Проблема с интернетом");

        hardwareHandler.handleRequest(request1);
        hardwareHandler.handleRequest(request2);
        hardwareHandler.handleRequest(request3);
    }
}
