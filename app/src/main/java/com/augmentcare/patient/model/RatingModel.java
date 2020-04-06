package com.augmentcare.patient.model;

public class RatingModel {
    String slot_id;
    String rating;
    String rating_comments;

    public String getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(String note_id) {
        this.slot_id = note_id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating_comments() {
        return rating_comments;
    }

    public void setRating_comments(String rating_comments) {
        this.rating_comments = rating_comments;
    }

    public RatingModel(){}

    public RatingModel(String slot_id, String rating, String rating_comments) {
        this.slot_id = slot_id;
        this.rating = rating;
        this.rating_comments = rating_comments;
    }
}