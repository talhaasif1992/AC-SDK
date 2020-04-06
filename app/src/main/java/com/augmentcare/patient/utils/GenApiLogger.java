package com.augmentcare.patient.utils;

import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.network.restApi.apimodels.BookedInstantAppointmentSlot;
import com.augmentcare.patient.network.restApi.apimodels.CreditCard;
import com.augmentcare.patient.network.restApi.apimodels.SignUpResponse;
import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.blankj.utilcode.util.GsonUtils;
import com.facebook.appevents.AppEventsConstants;

import java.util.Date;

public class GenApiLogger {

    public static void fireFindADoctorDetailEvent(BaseActivity baseActivity) {

        try {
            FacebookLogger.viewControllerLogEvent("find_a_doctor", "doctor_detail", "ViewContent", "0", "");
            SegmentAPIUtils.viewControllerLogEvent("find_a_doctor", "doctor_detail", "ViewContent", "0", "");
        } catch (Exception ignored) {
        }

        try {
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty()) {
                FirebaseLogger.viewFirebaseLogEvent("find_a_doctor_doctor_detail", baseActivity.userData.getId());
                SegmentAPIUtils.intercomEvent(baseActivity.userData.getId(), "find_a_doctor_doctor_detail");
            }
        } catch (Exception ignored) {
        }
    }

    public static void fireBookAppointmentEvent(BaseActivity baseActivity) {
        try {
            FacebookLogger.viewControllerLogEvent("find_a_doctor", "click_on_book_appointment_open_subscription",
                    "ViewContent", "0", "");

            SegmentAPIUtils.viewControllerLogEvent("find_a_doctor", "click_on_book_appointment_open_subscription",
                    "ViewContent", "0", "");
        } catch (Exception ignored) {
        }
        try {
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty()) {
                FirebaseLogger.viewFirebaseLogEvent("find_a_doctor_click_on_book_appointment_open_subscription",
                        baseActivity.userData.getId());

                SegmentAPIUtils.intercomEvent(baseActivity.userData.getId(), "find_a_doctor_click_on_book_appointment_open_subscription");
            }
        } catch (Exception ignored) {
        }
    }

    public static void fireLogAddPaymentInfoEvent(CreditCard creditCard) {
        try {
            FacebookLogger.logAddPaymentInfoEvent(AppEventsConstants.EVENT_NAME_ADDED_PAYMENT_INFO, "PKR",
                    "labs", "", GsonUtils.toJson(creditCard) + "", "");

            SegmentAPIUtils.logAddPaymentInfoEvent(AppEventsConstants.EVENT_NAME_ADDED_PAYMENT_INFO, "PKR",
                    "labs", "", GsonUtils.toJson(creditCard) + "", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void fireRegisterUserOnIntercom(UserDataLogin userData) {
        try {
            IntercomUtils.registerUserOnIntercom(userData.getFirstName(), userData.getLastName(), userData.getEmail(), userData.getPhone());
            SegmentAPIUtils.registerUserOnIntercom(userData.getFirstName(), userData.getLastName(), userData.getEmail(), userData.getPhone());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void fireNotificationEvent() {
        try {
            FacebookLogger.viewControllerLogEvent("notification", "notification_screen",
                    "ViewContent", "0", "");

            SegmentAPIUtils.viewControllerLogEvent("notification", "notification_screen",
                    "ViewContent", "0", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fireResetPasswordEvent() {
        try {
            FacebookLogger.viewControllerLogEvent("register", "forgot_password", "ViewController", "0", "");
            SegmentAPIUtils.viewControllerLogEvent("register", "forgot_password", "ViewController", "0", "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fireFindDoctorCalenderScreenEvent(BaseActivity baseActivity) {
        try {
            FacebookLogger.viewControllerLogEvent("find_a_doctor", "calendar_screen", "ViewContent",
                    "0", "");
            SegmentAPIUtils.viewControllerLogEvent("find_a_doctor", "calendar_screen", "ViewContent",
                    "0", "");
        } catch (Exception ignored) {
        }

        try {
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty()) {
                FirebaseLogger.viewFirebaseLogEvent("find_a_doctor_calander_screen", baseActivity.userData.getId());
                SegmentAPIUtils.intercomEvent(baseActivity.userData.getId(), "find_a_doctor_calander_screen");
            }
        } catch (Exception ignored) {
        }
    }

    public static void fireLabPaymentMethodAddEvent(String type) {
        try {
            FacebookLogger.viewControllerLogEvent("labs", type, "ViewContent", "0", "");
            SegmentAPIUtils.viewControllerLogEvent("labs", type, "ViewContent", "0", "");
        } catch (Exception e) {
        }
    }

    public static void fireBookAppointmentCalanderEvent(BaseActivity baseActivity) {
        try {
            FacebookLogger.viewControllerLogEvent("find_a_doctor", "calander_screen", "ViewContent", "0", "");
            SegmentAPIUtils.viewControllerLogEvent("find_a_doctor", "calander_screen", "ViewContent", "0", "");
        } catch (Exception ignored) {
        }
        try {
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty()) {
                FirebaseLogger.viewFirebaseLogEvent("find_a_doctor_calander_screen", baseActivity.userData.getId());
                SegmentAPIUtils.intercomEvent(baseActivity.userData.getId(), "find_a_doctor_calander_screen");
            }
        } catch (Exception ignored) {
        }
    }

    public static void fireAppointmentConfirmed(String appintment_confirmed) {
        try {
            FacebookLogger.viewControllerLogEvent("find_a_doctor", appintment_confirmed, "ViewContent", "0", "");
            SegmentAPIUtils.viewControllerLogEvent("find_a_doctor", appintment_confirmed, "ViewContent", "0", "");
        } catch (Exception ignored) {
        }
    }

    public static void fireFindADoctorAppointment(String type, BaseActivity baseActivity) {
        try {
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty()) {
                FirebaseLogger.viewFirebaseLogEvent(type, baseActivity.userData.getId());
                SegmentAPIUtils.intercomEvent(baseActivity.userData.getId(), type);
            }
        } catch (Exception ignored) {
        }
    }

    public static void fireAppointmentSickNotes() {
        try {
            FacebookLogger.viewControllerLogEvent(
                    "appointment",
                    "sick_note",
                    "ViewContent",
                    "0",
                    ""
            );

            SegmentAPIUtils.viewControllerLogEvent(
                    "appointment",
                    "sick_note",
                    "ViewContent",
                    "0",
                    ""
            );
        } catch (Exception ignored) {
        }
    }

    public static void fireAppointmentApproveEvent(BaseActivity baseActivity) {
        try {
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty()) {
                FirebaseLogger.viewFirebaseLogEvent("find_a_doctor_consultation_detail",
                        baseActivity.userData.getId());

                SegmentAPIUtils.intercomEvent(
                        baseActivity.userData.getId(), "find_a_doctor_consultation_detail");
            }
        } catch (Exception ignored) {
        }

        try {
            FacebookLogger.viewControllerLogEvent("find_a_doctor",
                    "consultation_detail", "ViewContent", "0", "");

            SegmentAPIUtils.viewControllerLogEvent("find_a_doctor",
                    "consultation_detail", "ViewContent", "0", "");
        } catch (Exception ignored) {
        }
    }

    public static void firePaymentMethodAddEvent(String type) {
        try {
            FacebookLogger.viewControllerLogEvent("labs", type, "ViewContent", "0", "");
            SegmentAPIUtils.viewControllerLogEvent("labs", type, "ViewContent", "0", "");
        } catch (Exception ignored) {
        }
    }

    public static void fireClaimStartEvent() {
        try {
            FacebookLogger.viewControllerLogEvent("claim_start_conversation", "claim_start_conversation", "ViewContent", "0", "");
            SegmentAPIUtils.viewControllerLogEvent("claim_start_conversation", "claim_start_conversation", "ViewContent", "0", "");
        } catch (Exception e) {
        }
    }

    public static void fireManageDependent(BaseActivity baseActivity) {
        try {
            FacebookLogger.viewControllerLogEvent("manage_dependent", "listing_all_dependents",
                    "ViewContent", "0", "");

            SegmentAPIUtils.viewControllerLogEvent("manage_dependent", "listing_all_dependents",
                    "ViewContent", "0", "");
            try {
                if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty()) {
                    FirebaseLogger.viewFirebaseLogEvent("manage_dependent_listing_all_dependents", baseActivity.userData.getId());
                    SegmentAPIUtils.intercomEvent(baseActivity.userData.getId(), "manage_dependent_listing_all_dependents");
                }
            } catch (Exception ignored) {
            }
        } catch (Exception ignored) {
        }
    }

    public static void fireRegisterCorporateUser() {
        try {
            FacebookLogger.viewControllerLogEvent(
                    "register_corporate_user",
                    "phone_code",
                    "ViewContent",
                    "0",
                    ""
            );
            SegmentAPIUtils.viewControllerLogEvent(
                    "register_corporate_user",
                    "phone_code",
                    "ViewContent",
                    "0",
                    ""
            );
        } catch (Exception ignored) {
        }
    }

    public static void fireFindADoctorSelectPaymentMethod(BaseActivity baseActivity, String select_payment_method, String find_a_doctor_select_payment_method) {
        try {
            FacebookLogger.viewControllerLogEvent("find_a_doctor", select_payment_method, "ViewContent", "0", "");
            SegmentAPIUtils.viewControllerLogEvent("find_a_doctor", select_payment_method, "ViewContent", "0", "");
        } catch (Exception ignored) {
        }


        try {
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty()) {
                FirebaseLogger.viewFirebaseLogEvent(find_a_doctor_select_payment_method, baseActivity.userData.getId());
                SegmentAPIUtils.intercomEvent(baseActivity.userData.getId(), find_a_doctor_select_payment_method);
            }
        } catch (Exception ignored) {
        }
    }

    public static void fireRegister() {
        try {
            FacebookLogger.viewControllerLogEvent(
                    "register",
                    "login_user",
                    "ViewContent",
                    "0",
                    ""
            );

            SegmentAPIUtils.viewControllerLogEvent(
                    "register",
                    "login_user",
                    "ViewContent",
                    "0",
                    ""
            );
        } catch (Exception ignored) {
        }
    }

    public static void fireLogin() {
        try {
            FacebookLogger.viewControllerLogEvent(
                    "log_in",
                    "login_user",
                    "ViewContent",
                    "0",
                    ""
            );

            SegmentAPIUtils.viewControllerLogEvent(
                    "log_in",
                    "login_user",
                    "ViewContent",
                    "0",
                    ""
            );
        } catch (Exception ignored) {
        }
    }

    public static void fireCompleterRegistrationEvent(UserLogin userLogin) {
        try {
            FacebookLogger.logCompleteRegistrationEvent(
                    AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION,
                    "",
                    "",
                    userLogin.getUserData().getUserType(),
                    userLogin.getUserData().getId(),
                    "google"
            );
            SegmentAPIUtils.logCompleteRegistrationEvent(
                    AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION,
                    "",
                    "",
                    userLogin.getUserData().getUserType(),
                    userLogin.getUserData().getId(),
                    "google"
            );
        } catch (Exception ignored) {
        }
    }

    public static void fireGoogleEvent(BaseActivity baseActivity, String type) {
        try {
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty()) {
                FirebaseLogger.viewFirebaseLogEvent(type, baseActivity.userData.getId());
                SegmentAPIUtils.intercomEvent(baseActivity.userData.getId(), type);
            }
        } catch (Exception ignored) {
        }
    }

    public static void fireOrginizationPhoneVirefied(UserLogin userLogin) {
        try {
            FirebaseLogger.firebaseUserPropertyEvent(
                    "is_on_plan",
                    userLogin.isIsOnPlan() + ""
            );


            FirebaseLogger.firebaseUserPropertyEvent(
                    "is_employee",
                    userLogin.isFromOrganization() + ""
            );

            FirebaseLogger.firebaseUserPropertyEvent(
                    "is_dependent",
                    userLogin.isIsDependent() + ""
            );


            SegmentAPIUtils.intercomEvent(
                    "is_on_plan",
                    userLogin.isIsOnPlan() + ""
            );


            SegmentAPIUtils.intercomEvent(
                    "is_employee",
                    userLogin.isFromOrganization() + ""
            );

            SegmentAPIUtils.intercomEvent(
                    "is_dependent",
                    userLogin.isIsDependent() + ""
            );
        } catch (Exception ignored) {
        }
    }

    public static void fireisPoicy(String user_id, String type) {
        try {
            FirebaseLogger.firebaseUserPropertyEvent("is_on_policy", type);
            // #TODO need to check
            SegmentAPIUtils.intercomEvent(user_id, "is_on_policy");
        } catch (Exception ignored) {
        }
    }

    public static void firefindADoctor(String type) {
        try {
            FacebookLogger.viewControllerLogEvent("find_a_doctor", type, "ViewContent", "0", "");
            SegmentAPIUtils.viewControllerLogEvent("find_a_doctor", type, "ViewContent", "0", "");
        } catch (Exception e) {
        }
    }

    public static void fireFindADoctorListingDoc(BaseActivity baseActivity) {
        try {
            FirebaseLogger.viewFirebaseLogEvent("find_a_doctor_listing_doc", baseActivity.userData.getId());
            SegmentAPIUtils.intercomEvent("find_a_doctor_listing_doc", baseActivity.userData.getId());
        } catch (Exception e) {
        }
    }

    public static void firefindADoctorDoc(BaseActivity baseActivity, String type) {
        try {
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty()) {
                FirebaseLogger.viewFirebaseLogEvent(type, baseActivity.userData.getId());
                SegmentAPIUtils.intercomEvent(type, baseActivity.userData.getId());
            }
        } catch (Exception ignored) {
        }
    }

    public static void fireInstantDocAvailable() {
        try {
            FacebookLogger.viewControllerLogEvent("instant_doctor", "show_available_doctor", "ViewContent", "0", "");
        } catch (Exception ignored) {
        }
    }

    public static void fireGenericEvent(BaseActivity baseActivity, String type) {
        try {
            FirebaseLogger.viewFirebaseLogEvent(type, baseActivity.userData.getId());
            SegmentAPIUtils.intercomEvent(type, baseActivity.userData.getId());
        } catch (Exception ignored) {
        }
    }

    public static void fireHourGreaterEvent() {
        try {
            FacebookLogger.viewControllerLogEvent("instant_doctor",
                    "confirm_instant_appointment_time_greater_one_hour", "ViewContent", "0", "");

            SegmentAPIUtils.viewControllerLogEvent("instant_doctor",
                    "confirm_instant_appointment_time_greater_one_hour", "ViewContent", "0", "");
        } catch (Exception ignored) {
        }
    }

    public static void fireLessGreaterEvent() {
        try {
            FacebookLogger.viewControllerLogEvent("instant_doctor",
                    "confirm_instant_appointment_time_less_one_hour", "ViewContent", "0", "");

            SegmentAPIUtils.viewControllerLogEvent("instant_doctor",
                    "confirm_instant_appointment_time_less_one_hour", "ViewContent", "0", "");
        } catch (Exception ignored) {
        }

    }

    public static void fireSchedualAppointmentEvent(BaseActivity baseActivity, String specialization, Date appointDate) {
        try {
            FacebookLogger.logEventSchedule(AppEventsConstants.EVENT_NAME_SCHEDULE, baseActivity.userData.getId() + "", "book_appointment", specialization, TextUtils.formatDateAndTime(appointDate));
            SegmentAPIUtils.logEventSchedule(AppEventsConstants.EVENT_NAME_SCHEDULE, baseActivity.userData.getId() + "", "book_appointment", specialization, TextUtils.formatDateAndTime(appointDate));
        } catch (Exception ignored) {
        }
    }

    public static void fireHomeScreenEvent() {
        try {
            FacebookLogger.viewControllerLogEvent("home", "main_home_screen", "ViewContent", "0", "");
            SegmentAPIUtils.viewControllerLogEvent("home", "main_home_screen", "ViewContent", "0", "");
        } catch (Exception ignored) {
        }
    }

    public static void fireRegisterPhoneVerified() {
        try {
            FacebookLogger.viewControllerLogEvent(
                    "register",
                    "phone_verification",
                    "ViewContent",
                    "0",
                    ""
            );
            SegmentAPIUtils.viewControllerLogEvent(
                    "register",
                    "phone_verification",
                    "ViewContent",
                    "0",
                    ""
            );
        } catch (Exception ignored) {
        }
    }

    public static void fireCompleterRegistrationEmailEvent(UserLogin userLogin) {
        try {
            FacebookLogger.logCompleteRegistrationEvent(
                    AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION,
                    "",
                    "",
                    userLogin.getUserData().getUserType(),
                    userLogin.getUserData().getId(),
                    "email"
            );
            SegmentAPIUtils.logCompleteRegistrationEvent(
                    AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION,
                    "",
                    "",
                    userLogin.getUserData().getUserType(),
                    userLogin.getUserData().getId(),
                    "email"
            );
        } catch (Exception ignored) {
        }
    }

    public static void fireRegistrationPassword() {
        try {
            FacebookLogger.viewControllerLogEvent(
                    "register",
                    "password",
                    "ViewContent",
                    "0",
                    ""
            );
            SegmentAPIUtils.viewControllerLogEvent(
                    "register",
                    "password",
                    "ViewContent",
                    "0",
                    ""
            );
        } catch (Exception ignored) {
        }
    }

    public static void fireSetPasswordCorporate() {
        try {
            FacebookLogger.viewControllerLogEvent(
                    "register_corporate_user",
                    "set_password",
                    "ViewContent",
                    "0",
                    ""
            );
            SegmentAPIUtils.viewControllerLogEvent(
                    "register_corporate_user",
                    "set_password",
                    "ViewContent",
                    "0",
                    ""
            );
        } catch (Exception ignored) {
        }
    }

    public static void fireCompleterRegistrationEmployeeCodeEvent(UserDataLogin userDataLogin) {
        try {
            FacebookLogger.logCompleteRegistrationEvent(
                    AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION,
                    "",
                    "",
                    userDataLogin.getFirstName(),
                    userDataLogin.getId(),
                    "employee_code"
            );

            SegmentAPIUtils.logCompleteRegistrationEvent(
                    AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION,
                    "",
                    "",
                    userDataLogin.getFirstName(),
                    userDataLogin.getId(),
                    "employee_code"
            );
        } catch (Exception ignored) {
        }
    }

    public static void fireFindADoctorSelectPaymentMethod(BaseActivity baseActivity, String type) {
        try {
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty()) {
                FirebaseLogger.viewFirebaseLogEvent(type, baseActivity.userData.getId());
                SegmentAPIUtils.intercomEvent(type, baseActivity.userData.getId());
            }
        } catch (Exception ignored) {
        }
    }

    public static void fireSubscriptionScreen(BaseActivity baseActivity, String type) {


        try {
            FacebookLogger.viewControllerLogEvent("subscription_screen", "list_of_plans_or_current_plan",
                    "ViewContent", "0", "");
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty()) {
                FirebaseLogger.viewFirebaseLogEvent(type, baseActivity.userData.getId());
                SegmentAPIUtils.intercomEvent(type, baseActivity.userData.getId());
            }
        } catch (Exception ignored) {
        }
    }

    public static void fireUsedFreeCall(BaseActivity baseActivity, String type) {


        try {
            // Toasty.info(baseActivity,"used free call",Toasty.LENGTH_LONG).show();
            FacebookLogger.viewControllerLogEvent("free_call", type,
                    "ViewContent", "0", "");
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty()) {
                FirebaseLogger.viewFirebaseLogEvent(type, baseActivity.userData.getId());
                SegmentAPIUtils.intercomEvent(type, baseActivity.userData.getId());
            }
        } catch (Exception ignored) {
        }
    }

    public static void firePlanSelectionEvent(BaseActivity baseActivity) {
        try {
            FacebookLogger.logEventContact("Contact", baseActivity.userData.getId() + "");
            SegmentAPIUtils.logEventContact("Contact", baseActivity.userData.getId() + "");
        } catch (Exception ignored) {
        }
    }

    public static void fireForgotPassword() {
        try {
            FacebookLogger.viewControllerLogEvent("register", "forgot_password", "ViewController", "0", "");
            SegmentAPIUtils.viewControllerLogEvent("register", "forgot_password", "ViewController", "0", "");
        } catch (Exception ignored) {
        }
    }

    public static void fireRegiserEmailPhone() {
        try {
            FacebookLogger.viewControllerLogEvent(
                    "register",
                    "emailID_and_phone_number",
                    "ViewController",
                    "0",
                    ""
            );

            SegmentAPIUtils.viewControllerLogEvent(
                    "register",
                    "emailID_and_phone_number",
                    "ViewController",
                    "0",
                    ""
            );
        } catch (Exception ignored) {
        }

    }

    public static void fireGenericNotificationEvent(BaseActivity baseActivity, String type) {
        try {
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty()) {
                FirebaseLogger.viewFirebaseLogEvent(type, baseActivity.userData.getId());
                SegmentAPIUtils.intercomEvent(type, baseActivity.userData.getId());
            }


        } catch (Exception ignored) {

        }
    }

    public static void fireCompleterRegistrationGoogleEvent(UserLogin userLogin) {

        try {
            FacebookLogger.logCompleteRegistrationEvent(
                    AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION,
                    "",
                    "",
                    userLogin.getUserData().getUserType(),
                    userLogin.getUserData().getId(),
                    "google"
            );

            SegmentAPIUtils.logCompleteRegistrationEvent(
                    AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION,
                    "",
                    "",
                    userLogin.getUserData().getUserType(),
                    userLogin.getUserData().getId(),
                    "google"
            );
        } catch (Exception e) {
        }

    }

    public static void fireCompleterRegistrationEmailEvent(SignUpResponse response) {
        try {
            FacebookLogger.logCompleteRegistrationEvent(
                    AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION,
                    "",
                    "",
                    response.getName(),
                    response.getId() + "",
                    "email"
            );
            SegmentAPIUtils.logCompleteRegistrationEvent(
                    AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION,
                    "",
                    "",
                    response.getName(),
                    response.getId() + "",
                    "email"
            );
        } catch (Exception e) {
        }


    }

    public static void fireGenericSignupPassword(BaseActivity baseActivity, String type) {
        try {
            if (baseActivity.userData != null) {
                if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty()) {
                    FirebaseLogger.viewFirebaseLogEvent(type, baseActivity.userData.getId());
                    SegmentAPIUtils.intercomEvent(type, baseActivity.userData.getId());
                }
            }
        } catch (Exception e) {
        }
    }

    public static void fireNotSignIn() {
        try {
            FacebookLogger.viewControllerLogEvent(
                    "not_sign_in",
                    "start_screen",
                    "ViewController",
                    "0",
                    ""
            );

            SegmentAPIUtils.viewControllerLogEvent(
                    "not_sign_in",
                    "start_screen",
                    "ViewController",
                    "0",
                    ""
            );
        } catch (Exception e) {
        }

    }

    public static void fireThankyouEvent() {
        try {
            FacebookLogger.viewControllerLogEvent(
                    "register",
                    "thank_you",
                    "ViewController",
                    "0",
                    ""
            );

            SegmentAPIUtils.viewControllerLogEvent(
                    "register",
                    "thank_you",
                    "ViewController",
                    "0",
                    ""
            );
        } catch (Exception e) {
        }


    }

    public static void fireIncomingVideoCall() {
        try {
            FacebookLogger.viewControllerLogEvent("video_call", "incoming_video_call", "ViewController",
                    "0", "");


            SegmentAPIUtils.viewControllerLogEvent("video_call", "incoming_video_call", "ViewController",
                    "0", "");


        } catch (Exception e) {
        }

    }

    public static void fireGenericVideoCallEvent(String type, UserDataLogin userData) {
        try {
            if (userData.getId() != null && !userData.getId().isEmpty()) {
                FirebaseLogger.viewFirebaseLogEvent(type, userData.getId());
                SegmentAPIUtils.intercomEvent(type, userData.getId());
            }
        } catch (Exception ignored) {
        }
    }

    public static void fireSegmentAndIntercomEvent(BaseActivity baseActivity) {
        try {
            IntercomUtils.intercomEvent(String.valueOf(baseActivity.userData.getUserId()), "clicked_on_doctor_profile");
            SegmentAPIUtils.intercomEvent(String.valueOf(baseActivity.userData.getUserId()), "clicked_on_doctor_profile");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void fireSegmentAndIntercomInstantAppointmentEvent(Date appointDate, BookedInstantAppointmentSlot slot) {
        try {
            IntercomUtils.intercomAppointmentSuccessEvent(String.valueOf(TextUtils.formatDateAndTime(appointDate)), slot.getSlot().getId() + "");
            SegmentAPIUtils.intercomAppointmentSuccessEvent(String.valueOf(TextUtils.formatDateAndTime(appointDate)), slot.getSlot().getId() + "");
        } catch (Exception e) {
        }
    }

    public static void fireIntercomeRegisterUser(BaseActivity baseActivity) {
        try {
            IntercomUtils.registerUserOnIntercom(baseActivity.userData.getFirstName(),
                    baseActivity.userData.getLastName(), baseActivity.userData.getEmail(),
                    baseActivity.userData.getPhone());


            SegmentAPIUtils.registerUserOnIntercom(baseActivity.userData.getFirstName(),
                    baseActivity.userData.getLastName(), baseActivity.userData.getEmail(),
                    baseActivity.userData.getPhone());
        } catch (Exception e) {
        }


    }


    public static void fireIntercomPlanSelection(BaseActivity baseActivity) {
        try {
            IntercomUtils.intercomEvent(String.valueOf(baseActivity.userData.getUserId()), "viewed_subscription_page");
            SegmentAPIUtils.intercomEvent(String.valueOf(baseActivity.userData.getUserId()), "viewed_subscription_page");
        } catch (Exception e) {
        }


    }

    public static void fireSegmentAndIntercomVideoConsultationEvent(UserDataLogin userData) {
        try {
            IntercomUtils.intercomEvent(String.valueOf(userData.getUserId()), "did_consultation");
            SegmentAPIUtils.intercomEvent(String.valueOf(userData.getUserId()), "did_consultation");
        } catch (Exception e) {
        }
    }

    public static void fireSegmentAndIntercomVideoConsultationEvent(UserLogin loggedInUser) {
        try {
            IntercomUtils.intercomEvent(loggedInUser.getUserData().getUserId() + "", "did_consultation");
            SegmentAPIUtils.intercomEvent(loggedInUser.getUserData().getUserId() + "", "did_consultation");
        } catch (Exception e) {
        }

    }
}
