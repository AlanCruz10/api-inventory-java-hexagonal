package org.app.aph.inventory_managament.application.use_cases;

import org.app.aph.inventory_managament.application.dtos.responses.BaseResponse;
import org.app.aph.inventory_managament.application.mappers.ProductDtoMapper;
import org.app.aph.inventory_managament.application.ports.inputs.IProductPortInput;
import org.app.aph.inventory_managament.application.ports.outputs.IDeleteProductPortOutput;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductUseCaseImpl implements IDeleteProductPortOutput {

    private final IProductPortInput portInput;

    public DeleteProductUseCaseImpl(IProductPortInput portInput) {
        this.portInput = portInput;
    }

    @Override
    public BaseResponse delete(String uuid) {
        portInput.delete(uuid);
        return BaseResponse.builder()
                .message("Product deleted successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200)
                .build();
    }

}