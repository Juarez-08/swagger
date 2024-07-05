package com.ejemplo;

public class NotificadorEmail {

    private final EmailCliente emailCliente;

    // Constructor que recibe el cliente de correo
    public NotificadorEmail(EmailCliente emailCliente) {
        this.emailCliente = emailCliente;
    }

    // Método para enviar notificaciones por correo
    public void enviarNotificacion(String direccionCorreo, String contenidoMensaje) {
        // Validación de la dirección de correo
        if (direccionCorreo == null || direccionCorreo.isEmpty()) {
            throw new IllegalArgumentException("La dirección de correo no puede estar vacía");
        }
        // Validación del contenido del mensaje
        if (contenidoMensaje == null) {
            throw new IllegalArgumentException("El mensaje no puede ser nulo");
        }
        // Enviar el correo utilizando el cliente de correo
        emailCliente.enviarCorreo(direccionCorreo, contenidoMensaje);
    }
}
