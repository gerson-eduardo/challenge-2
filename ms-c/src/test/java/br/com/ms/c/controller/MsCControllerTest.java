package br.com.ms.c.controller;

import br.com.ms.c.feignClient.MsAuthAndAutoFeign;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MsCControllerTest {
    @InjectMocks
    private MsCController msCController;
    @Mock
    private MsAuthAndAutoFeign msAuthAndAutoFeign;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUser() {
        // Simula o comportamento do feign client.
        when(msAuthAndAutoFeign.getAllByIdUserIdMicrosservce(anyInt(), anyInt()))
                .thenReturn(new ResponseEntity<>("some-body", HttpStatus.OK));

        ResponseEntity<Object> response = msCController.getAllUser(1, 1);

        // Verifica se o método do feign client foi chamado com os argumentos corretos.
        verify(msAuthAndAutoFeign,
                times(1)).getAllByIdUserIdMicrosservce(1, 1);

        // Verifica se a resposta HTTP é a esperada.
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getAllByMicrosservice() {
        // Simula o comportamento do feign client
        when(msAuthAndAutoFeign.getByIdMicrosservice(anyInt()))
                .thenReturn(new ResponseEntity<>("some-body", HttpStatus.OK));

        ResponseEntity<Object> response = msCController.getAllByMicrosservice(3);

        // Verifica se o método do feign client foi chamado com o argumento correto
        verify(msAuthAndAutoFeign, times(1)).getByIdMicrosservice(3);

        // Verifica se a resposta HTTP é a esperada
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}