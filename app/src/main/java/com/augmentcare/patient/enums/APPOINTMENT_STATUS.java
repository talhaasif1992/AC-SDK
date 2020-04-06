package com.augmentcare.patient.enums;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class APPOINTMENT_STATUS {
    // ... type definitions
    // Describes when the annotation will be discarded
    @Retention(RetentionPolicy.SOURCE)
    // Enumerate valid values for this interface
    @IntDef({UPCOMMING, CANCELED, COMPLETED,REJECTED,APPROVED,PENDING,UNKNOWN})
    // Create an interface for validating int types
    public @interface AppointmentStatusType {}
    // Declare the constants
    public static final int UPCOMMING = 1;
    public static final int CANCELED = 2;
    public static final int COMPLETED = 3;
    public static final int REJECTED = 4;
    public static final int APPROVED = 5;
    public static final int PENDING = 6;
    public static final int UNKNOWN = 7;

    public final int itemType;

    // Mark the argument as restricted to these enumerated types
    public APPOINTMENT_STATUS(@APPOINTMENT_STATUS.AppointmentStatusType int itemType) {
        this.itemType = itemType;
    }

    public static String getString(@APPOINTMENT_STATUS.AppointmentStatusType int itemType){
        switch (itemType){
            case UPCOMMING:
                return "UPCOMMING";
            case CANCELED:
                return "CANCELED";
            case COMPLETED:
                return "COMPLETED";
            case REJECTED:
                return "REJECTED";
            case APPROVED:
                return "APPROVED";
            case PENDING:
                return "PENDING";
            default:
                return "UNKNOWN";
        }
    }
}