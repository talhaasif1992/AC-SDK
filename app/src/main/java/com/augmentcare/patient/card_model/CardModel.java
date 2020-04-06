package com.augmentcare.patient.card_model;

public class CardModel {

    int card_type;

    public int getCard_type() {
        return card_type;
    }

    public void setCard_type(int card_type) {
        this.card_type = card_type;
    }

    public void CardModel(){}
    public CardModel(int card_type) {
        this.card_type = card_type;
    }
}
