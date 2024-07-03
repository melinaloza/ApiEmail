package ar.edu.utn.frba.dds;

public class Main {
  public static void main(String[] args) {
    NotificationService notificationService = new NotificationService();
    InstantMessageSender sender = new EmailSenderAdapter();

    // Ejemplo de notificación por correo electrónico
    notificationService.notify(sender, InstantMessageApp.EMAIL, "paolitalf2021@gmail.com", "Mensaje de prueba por correo electrónico");
  }
}