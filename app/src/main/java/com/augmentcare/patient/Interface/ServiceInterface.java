package com.augmentcare.patient.Interface;

import android.widget.ImageButton;

import com.augmentcare.patient.model.PrescribedOrderItem;

public interface ServiceInterface {
    void prescribedItemAdd(PrescribedOrderItem prescribedOrderItem, String orderitem, ImageButton imageButton);
    void prescribedItemRemove(String orderitemId, ImageButton imageButton);
}