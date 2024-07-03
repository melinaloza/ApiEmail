package ar.edu.utn.frba.dds;

public class NotificationService {
  public void notify(InstantMessageSender sender, InstantMessageApp provider, String email, String message) {
    sender.sendMessage(provider, email, message);
  }
}