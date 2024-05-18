package org.app.aph.inventory_managament.infrastructure.rest.controllers;

import org.app.aph.inventory_managament.application.dtos.requests.CreateProductRequest;
import org.app.aph.inventory_managament.application.dtos.responses.BaseResponse;
import org.app.aph.inventory_managament.application.ports.outputs.ICreateProductPortOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CreateProductController {

    private final ICreateProductPortOutput output;

    public CreateProductController(ICreateProductPortOutput output) {
        this.output = output;
    }

    @PostMapping()
    public ResponseEntity<BaseResponse> create(@RequestBody CreateProductRequest request) {
        return output.create(request).apply();
    }

}