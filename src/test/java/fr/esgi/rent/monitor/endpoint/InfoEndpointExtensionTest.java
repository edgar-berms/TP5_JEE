package fr.esgi.rent.monitor.endpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.info.InfoEndpoint;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InfoEndpointExtensionTest {

    private InfoEndpoint infoEndpointMock;
    private InfoEndpointExtension extension;

    @BeforeEach
    void setUp() {
        infoEndpointMock = mock(InfoEndpoint.class);
        extension = new InfoEndpointExtension(infoEndpointMock);
    }

    @Test
    void info_shouldReturnInfoWithStatusOK() {
        // Given
        Map<String, Object> mockInfo = new HashMap<>();
        when(infoEndpointMock.info()).thenReturn(mockInfo);

        // When
        WebEndpointResponse<Map> response = extension.info();

        // Then
        assertEquals(200, response.getStatus());
        assertTrue(response.getBody().containsKey("Description"));
        assertTrue(response.getBody().containsKey("Author"));
        assertEquals("kevin-llps", response.getBody().get("Author"));
        assertEquals("Framework JEE - Spring Rent API", response.getBody().get("Description"));

        verify(infoEndpointMock, times(1)).info();
    }
}