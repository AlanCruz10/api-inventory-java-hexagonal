package org.app.aph.inventory_managament.infrastructure.rest.controllers;

import org.app.aph.inventory_managament.application.dtos.responses.BaseResponse;
import org.app.aph.inventory_managament.application.ports.outputs.IGetListProductsPortOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GetListProductsController {

    private final IGetListProductsPortOutput output;

    public GetListProductsController(IGetListProductsPortOutput output) {
        this.output = output;
    }

    @GetMapping
    public ResponseEntity<BaseResponse> list() {
        return output.list().apply();
    }

}