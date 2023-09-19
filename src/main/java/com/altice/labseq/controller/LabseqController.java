package com.altice.labseq.controller;

import com.altice.labseq.service.LabSeqService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@OpenAPIDefinition(
        info = @Info(
                title = "Exercício Altice Labs - Labseq",
                version = "1.0.0",
                description = "Resolução do exercício proposto para " +
                        "criação de API capaz de recuperar um valor " +
                        "de uma função conforme o indice informado.",
                contact = @Contact(
                        email = "felipe.sgil@gmail.com"
                )
        )
)
@CrossOrigin("*")
@RestController
@RequestMapping("labseq")
@Validated
public class LabseqController {

    private final LabSeqService labSeqService;

    public LabseqController(LabSeqService labSeqService){
        this.labSeqService = labSeqService;
    }

    @Tag(name = "labseq")
    @Operation(summary = "Retorna um valor da sequencia labseq.", description = "Retorna um valor da sequencia labseq de acordo com o indice")
    @Parameters(
            @Parameter(

                name = "{n}",
                in = ParameterIn.PATH,
                description = "Indice que será localizado/processado para recuperar o valor de labseq.",
                required = true,
                schema = @Schema(type = "int", minimum = "0")
            )
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    type = "number"
                            ))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor",
                    content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            type = "number"
                    ))),
    })
    @GetMapping("{n}")
    public ResponseEntity<Long> labseq(
            @PathVariable("n")
            @PositiveOrZero(message = "O valor deve ser positivo ou zero") int indexLabSeq){
        return ResponseEntity.status(HttpStatus.OK).body(labSeqService.getValueLabSeq(indexLabSeq));
    }

}
