package org.app.aph.inventory_managament.application.ports.outputs;

import org.app.aph.inventory_managament.application.dtos.responses.BaseResponse;

public interface IInventoryPortOutput {
    BaseResponse create();
    BaseResponse delete();
    BaseResponse list();
}