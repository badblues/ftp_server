package badblues.smtp;

public class MyMessage {
    String subject;
    String content;
    String fileName;

    MyMessage (String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    MyMessage(String subject, String content, String fileName) {
        this.subject = subject;
        this.content = content;
        this.fileName = fileName;
    }
}
