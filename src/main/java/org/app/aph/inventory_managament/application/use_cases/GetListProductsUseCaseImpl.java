package org.app.aph.inventory_managament.application.use_cases;

import org.app.aph.inventory_managament.application.dtos.responses.BaseResponse;
import org.app.aph.inventory_managament.application.mappers.ProductDtoMapper;
import org.app.aph.inventory_managament.application.ports.inputs.IProductPortInput;
import org.app.aph.inventory_managament.application.ports.outputs.IGetListProductsPortOutput;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class GetListProductsUseCaseImpl implements IGetListProductsPortOutput {

    private final IProductPortInput portInput;

    private final ProductDtoMapper mapper;

    public GetListProductsUseCaseImpl(IProductPortInput portInput, ProductDtoMapper mapper) {
        this.portInput = portInput;
        this.mapper = mapper;
    }

    @Override
    public BaseResponse list() {
        return BaseResponse.builder()
                .data(mapper.toListDto(portInput.list()))
                .message("List products obtained successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200)
                .build();
    }

}