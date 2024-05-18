package org.app.aph.inventory_managament.application.use_cases;

import org.app.aph.inventory_managament.application.dtos.requests.CreateProductRequest;
import org.app.aph.inventory_managament.application.dtos.responses.BaseResponse;
import org.app.aph.inventory_managament.application.mappers.ProductDtoMapper;
import org.app.aph.inventory_managament.application.ports.inputs.IProductPortInput;
import org.app.aph.inventory_managament.application.ports.outputs.ICreateProductPortOutput;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCaseImpl implements ICreateProductPortOutput {

    private final IProductPortInput portInput;

    private final ProductDtoMapper mapper;

    public CreateProductUseCaseImpl(IProductPortInput portInput, ProductDtoMapper mapper) {
        this.portInput = portInput;
        this.mapper = mapper;
    }

    @Override
    public BaseResponse create(CreateProductRequest request) {
        return BaseResponse.builder()
                .data(mapper.toDto(portInput.save(mapper.toDomain(request))))
                .message("Product created successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .status(201)
                .build();
    }

}