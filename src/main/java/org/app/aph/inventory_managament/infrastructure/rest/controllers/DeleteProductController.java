package org.app.aph.inventory_managament.infrastructure.rest.controllers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.app.aph.inventory_managament.application.dtos.responses.BaseResponse;
import org.app.aph.inventory_managament.application.ports.outputs.IDeleteProductPortOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class DeleteProductController {

    private final IDeleteProductPortOutput output;

    public DeleteProductController(IDeleteProductPortOutput output) {
        this.output = output;
    }

    @DeleteMapping()
    public ResponseEntity<BaseResponse> delete(@RequestParam @NotNull @NotBlank String uuid) {
        return output.delete(uuid).apply();
    }

}