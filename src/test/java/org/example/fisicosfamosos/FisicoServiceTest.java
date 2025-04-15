package org.example.fisicosfamosos;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FisicoServiceTest {

    @Test
    void includesSuccess() {
        List<Fisico> fisicos = List.of(
                new Fisico("Einstain", "1879", "1955")
        );
        assertTrue( FisicoService.includes(fisicos, 1879) );
        assertTrue( FisicoService.includes(fisicos, 1955) );
        assertTrue( FisicoService.includes(fisicos, 1880) );
        assertFalse( FisicoService.includes(fisicos, 2000) );
        assertFalse( FisicoService.includes(fisicos, 1875) );
    }

    @Test
    void populate() {
        List fisicos = new ArrayList();
        String[] args = {"[Galileo,1564,1642]", "[Einstein,1879,1955]"};
        try {
            FisicoService.populate( fisicos, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertNotNull(fisicos);
        assertTrue(fisicos.size() > 0);
        assertEquals(fisicos.size(), 2);

    }
}