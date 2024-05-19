package org.app.aph.inventory_managament.application.use_cases;

import org.app.aph.inventory_managament.application.dtos.responses.BaseResponse;
import org.app.aph.inventory_managament.application.ports.inputs.IProductPortInput;
import org.app.aph.inventory_managament.application.ports.outputs.IInventoryPortOutput;
import org.app.aph.inventory_managament.domain.entities.OrderProduct;
import org.app.aph.inventory_managament.domain.entities.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryUseCaseImpl implements IInventoryPortOutput {

    private final IProductPortInput input;

    public InventoryUseCaseImpl(IProductPortInput input) {
        this.input = input;
    }

    @Override
    public BaseResponse reduceStock(List<OrderProduct> list) {
        list.forEach(orderProduct -> {
            Product product = input.findByUuid(orderProduct.getProductId());
            Long newStock = product.getStock() - orderProduct.getQuantity();
            input.reduceStock(product, newStock);
        });
        return BaseResponse.builder()
                .message("Stock reduced successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200)
                .build();
    }

}