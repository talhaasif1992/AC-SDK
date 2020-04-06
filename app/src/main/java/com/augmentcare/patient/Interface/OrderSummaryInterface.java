package com.augmentcare.patient.Interface;

import com.augmentcare.patient.model.PrescribedOrderItem;

public interface OrderSummaryInterface {
    void orderItemDelete(String orderitem);
    void prescribedItemAdd(PrescribedOrderItem prescribedOrderItem,int position);
}