package com.ejemplo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class NotificadorEmailTest {

    @Mock
    private EmailCliente emailClienteMock;

    @Test
    public void testNotificar() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", "Hola Mundo");

        // Verificar que emailClienteMock.enviarCorreo se llamó con los argumentos correctos
        verify(emailClienteMock).enviarCorreo("ejemplo@test.com", "Hola Mundo");
    }

    @Test
    public void testNotificarConDireccionVacia() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        assertThrows(IllegalArgumentException.class, () -> {
            notificador.notificar("", "Mensaje");
        });

        // Verificar que no se realiza el envío si la dirección es vacía
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    @Test
    public void testNotificarConDireccionNula() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        assertThrows(IllegalArgumentException.class, () -> {
            notificador.notificar(null, "Mensaje");
        });

        // Verificar que no se realiza el envío si la dirección es nula
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    @Test
    public void testNotificarConMensajeNulo() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        assertThrows(IllegalArgumentException.class, () -> {
            notificador.notificar("ejemplo@test.com", null);
        });

        // Verificar que no se realiza el envío si el mensaje es nulo
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    @Test
    public void testNotificarConDireccionYMensajeValidos() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", "Mensaje válido");

        // Verificar que emailClienteMock.enviarCorreo se llamó con los argumentos correctos
        verify(emailClienteMock).enviarCorreo("ejemplo@test.com", "Mensaje válido");
    }
}
