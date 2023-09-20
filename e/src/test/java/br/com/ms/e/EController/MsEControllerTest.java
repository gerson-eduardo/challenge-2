package br.com.ms.e.EController;

import br.com.ms.e.feignClient.MsAuthAndAutoFeign;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class MsEControllerTest {

    @InjectMocks
    private MsEController msEController;
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

        ResponseEntity<Object> response = msEController.getAllUser(1, 1);

        // Verifica se o método do feign client foi chamado com os argumentos corretos.
        verify(msAuthAndAutoFeign,
                times(1)).getAllByIdUserIdMicrosservce(1, 1);

        // Verifica se a resposta HTTP é a esperada.
        assert (response.getStatusCode()).equals(HttpStatus.OK);
    }

    @Test
    void getAllByMicrosservice() {
        // Simula o comportamento do feign client
        when(msAuthAndAutoFeign.getByIdMicrosservice(anyInt()))
                .thenReturn(new ResponseEntity<>("some-body", HttpStatus.OK));

        ResponseEntity<Object> response = msEController.getAllByMicrosservice(3);

        // Verifica se o método do feign client foi chamado com o argumento correto
        verify(msAuthAndAutoFeign, times(1)).getByIdMicrosservice(3);

        // Verifica se a resposta HTTP é a esperada
        assert(response.getStatusCode()).equals(HttpStatus.OK);
    }
}