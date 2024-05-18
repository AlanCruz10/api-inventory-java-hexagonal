package org.app.aph.inventory_managament.application.ports.outputs;

import org.app.aph.inventory_managament.application.dtos.requests.CreateProductRequest;
import org.app.aph.inventory_managament.application.dtos.responses.BaseResponse;

public interface ICreateProductPortOutput {

    BaseResponse create(CreateProductRequest request);


}