package com.altice.labseq.service;

import org.junit.*;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class LabSeqServiceImplTests {

    private LabSeqService labSeqService;

    @Before
    public void setUp() {
        labSeqService = new LabSeqServiceImpl();
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testGetValueLabSeqPerformance() {
        labSeqService.calcValFromLabSeq(10000);
    }

}
