package org.app.aph.inventory_managament.application.ports.outputs;

import org.app.aph.inventory_managament.application.dtos.responses.BaseResponse;
import org.app.aph.inventory_managament.domain.entities.OrderProduct;

import java.util.List;

public interface IInventoryPortOutput {

    BaseResponse reduceStock(List<OrderProduct> list);

}