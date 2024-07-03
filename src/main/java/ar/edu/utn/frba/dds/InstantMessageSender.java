package ar.edu.utn.frba.dds;

public interface InstantMessageSender {
  void sendMessage(
      InstantMessageApp provider,
      String telephone,
      String message
  ); // throws InvalidTelephoneNumberException;
}
