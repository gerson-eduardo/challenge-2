package br.com.ms.a.controller;

import br.com.ms.a.feingnclient.CentralFeign;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MsAControllerTest {
    @InjectMocks
    private MsAController controller;
    @Mock
    private CentralFeign feign;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUser() {
        when(feign.getAllByIdUserIdMicrosservce(anyInt(), anyInt())).thenReturn(new ResponseEntity<>("some-body", HttpStatus.OK));
        ResponseEntity<Object> response = controller.getAllUser(1, 1);
        verify(feign, times(1)).getAllByIdUserIdMicrosservce(1, 1);
        assert (response.getStatusCode()).equals(HttpStatus.OK);
    }

    @Test
    void getAllByMicrosservice() {
        when(feign.getByIdMicrosservice(anyInt())).thenReturn(new ResponseEntity<>("some-body", HttpStatus.OK));
        ResponseEntity<Object> response = controller.getAllByMicrosservice(3);
        verify(feign, times(1)).getByIdMicrosservice(3);
        assert (response.getStatusCode()).equals(HttpStatus.OK);
    }
}