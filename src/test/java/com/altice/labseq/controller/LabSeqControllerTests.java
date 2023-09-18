package com.altice.labseq.controller;

import com.altice.labseq.service.LabSeqService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class LabSeqControllerTests {

    private LabSeqService labSeqService;
    private LabseqController labseqController;

    @BeforeEach
    public void setup() {
        labSeqService = mock(LabSeqService.class);
        labseqController = new LabseqController(labSeqService);
    }

    @Test
    public void testLabseqWithPositiveNumber() {
        int indexLabSeq = 5;
        long expectedValue = 1L;
        when(labSeqService.getValueLabSeq(indexLabSeq)).thenReturn(expectedValue);

        ResponseEntity<Long> response = labseqController.labseq(indexLabSeq);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedValue, response.getBody());
    }

    @Test
    public void testLabseqWithZero() {
        int indexLabSeq = 0;
        long expectedValue = 0L;
        when(labSeqService.getValueLabSeq(indexLabSeq)).thenReturn(expectedValue);

        ResponseEntity<Long> response = labseqController.labseq(indexLabSeq);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedValue, response.getBody());
    }

    @Test
    public void testLabseqWithNegativeNumber() {
        int indexLabSeq = -1;

        try {
            labseqController.labseq(indexLabSeq);
        } catch (IllegalArgumentException e) {
            assertEquals("O valor deve ser positivo ou zero", e.getMessage());
        }
    }

}
