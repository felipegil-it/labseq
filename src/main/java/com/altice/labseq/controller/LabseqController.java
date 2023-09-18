package com.altice.labseq.controller;

import com.altice.labseq.service.LabSeqService;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("labseq")
@Validated
public class LabseqController {

    private final LabSeqService labSeqService;

    public LabseqController(LabSeqService labSeqService){
        this.labSeqService = labSeqService;
    }

    @GetMapping("{n}")
    public ResponseEntity<Long> labseq(@PathVariable("n") @PositiveOrZero(message = "O valor deve ser positivo ou zero") int indexLabSeq){
        return ResponseEntity.status(HttpStatus.OK).body(labSeqService.getValueLabSeq(indexLabSeq));
    }

}
