
public class DependencyInversion {
    public static void main(String[] args) {
        MessageService emailService = new EmailService();
        NotificationService notifier = new NotificationService(emailService);
        notifier.notifyUser("Dependency Inversion Principle!");
    }
}

interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Email sent: " + message);
    }
}

class NotificationService {
    private MessageService service;

    public NotificationService(MessageService service) {
        this.service = service;
    }

    public void notifyUser(String message) {
        service.sendMessage(message);
    }
}
