package br.com.academiadev.model;

public class SupportTicket {

    private String title;
    private String message;
    private User author;

    public SupportTicket(String title, String message, User author) {
        this.title = title;
        this.message = message;
        this.author = author;
    }

    public String getTitle()   { return title; }
    public String getMessage() { return message; }
    public User getAuthor()    { return author; }

    @Override
    public String toString() {
        return String.format("[TICKET] De: %s | Assunto: %s | Mensagem: %s",
                author.getEmail(), title, message);
    }
}
