package com.augmentcare.patient.network.restApi;

import com.augmentcare.patient.model.AAdress;
import com.augmentcare.patient.model.AChat;
import com.augmentcare.patient.model.OrderItem;
import com.augmentcare.patient.model.prescribedLabsModel.PrescribedTest;
import com.augmentcare.patient.model.prescribedMedicineModel.PrescribedMedicine;
import com.augmentcare.patient.model.prescribedMedicineModel.PrescribedMeds;
import com.augmentcare.patient.network.restApi.apimodels.APlan;
import com.augmentcare.patient.network.restApi.apimodels.AddDependentResponse;
import com.augmentcare.patient.network.restApi.apimodels.Address;
import com.augmentcare.patient.network.restApi.apimodels.AppointmentSlot;
import com.augmentcare.patient.network.restApi.apimodels.AreasResponse;
import com.augmentcare.patient.network.restApi.apimodels.AuthenticateOEResponse;
import com.augmentcare.patient.network.restApi.apimodels.BookedInstantAppointmentSlot;
import com.augmentcare.patient.network.restApi.apimodels.CartDetail;
import com.augmentcare.patient.network.restApi.apimodels.ClaimDetailsModel.ClaimDetailsModel;
import com.augmentcare.patient.network.restApi.apimodels.ConsultationDetails;
import com.augmentcare.patient.network.restApi.apimodels.ConsultationSlots;
import com.augmentcare.patient.network.restApi.apimodels.ConsultationsList;
import com.augmentcare.patient.network.restApi.apimodels.CouponResponse;
import com.augmentcare.patient.network.restApi.apimodels.CreatedClaimResponse;
import com.augmentcare.patient.network.restApi.apimodels.CreditCard;
import com.augmentcare.patient.network.restApi.apimodels.Data;
import com.augmentcare.patient.network.restApi.apimodels.Dependent;
import com.augmentcare.patient.network.restApi.apimodels.DependentTypesResponse;
import com.augmentcare.patient.network.restApi.apimodels.DependentsCoveredResponse;
import com.augmentcare.patient.network.restApi.apimodels.DependentsList;
import com.augmentcare.patient.network.restApi.apimodels.DoctorAvailableSlots;
import com.augmentcare.patient.network.restApi.apimodels.DoctorDetail;
import com.augmentcare.patient.network.restApi.apimodels.DoctorFilterOptionResponse;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoOverView;
import com.augmentcare.patient.network.restApi.apimodels.EliteDoctorSuccess;
import com.augmentcare.patient.network.restApi.apimodels.ErrorResponse;
import com.augmentcare.patient.network.restApi.apimodels.ErrorsResponse;
import com.augmentcare.patient.network.restApi.apimodels.FinalizeOrderRequest;
import com.augmentcare.patient.network.restApi.apimodels.FreeCallModel.FreeCallModel;
import com.augmentcare.patient.network.restApi.apimodels.GenericResponse;
import com.augmentcare.patient.network.restApi.apimodels.GetUserClaimsList;
import com.augmentcare.patient.network.restApi.apimodels.HealthPointResponse;
import com.augmentcare.patient.network.restApi.apimodels.InstantAppointmentSlotResult;
import com.augmentcare.patient.network.restApi.apimodels.JazzCashResponse;
import com.augmentcare.patient.network.restApi.apimodels.LabOrderResponse;
import com.augmentcare.patient.network.restApi.apimodels.LabTest;
import com.augmentcare.patient.network.restApi.apimodels.LabsAvailabilityResponse;
import com.augmentcare.patient.network.restApi.apimodels.MedicinesList;
import com.augmentcare.patient.network.restApi.apimodels.Message;
import com.augmentcare.patient.network.restApi.apimodels.MessageResponse;
import com.augmentcare.patient.RemoteMessage.NotificationObject;
import com.augmentcare.patient.network.restApi.apimodels.Order;
import com.augmentcare.patient.network.restApi.apimodels.OrderDetailsResponse;
import com.augmentcare.patient.network.restApi.apimodels.Patientslot;
import com.augmentcare.patient.network.restApi.apimodels.PayOrderMedRequest;
import com.augmentcare.patient.network.restApi.apimodels.Payment;
import com.augmentcare.patient.network.restApi.apimodels.ProfilesInfo;
import com.augmentcare.patient.network.restApi.apimodels.RatingModelRequest;
import com.augmentcare.patient.network.restApi.apimodels.ResponseData;
import com.augmentcare.patient.network.restApi.apimodels.ResponseData1;
import com.augmentcare.patient.network.restApi.apimodels.SignUpResponse;
import com.augmentcare.patient.network.restApi.apimodels.TokBoxObj;
import com.augmentcare.patient.network.restApi.apimodels.UpdateUserInfoResponse;
import com.augmentcare.patient.network.restApi.apimodels.User;
import com.augmentcare.patient.network.restApi.apimodels.UserInfo;
import com.augmentcare.patient.network.restApi.apimodels.UserInfoUpdateRequest;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.augmentcare.patient.network.restApi.apimodels.UserPlans.UserPlansResponse;
import com.augmentcare.patient.network.restApi.apimodels.notificationsModels.NotificationResponseModel;
import com.augmentcare.patient.network.restApi.apirequests.AppointmentRequest;
import com.augmentcare.patient.network.restApi.apirequests.CancelDoctorAppointmentRequest;
import com.augmentcare.patient.network.restApi.apirequests.CreateClaimRequest;
import com.augmentcare.patient.network.restApi.apirequests.GenericRequest;
import com.augmentcare.patient.network.restApi.apirequests.LoginRequest;
import com.augmentcare.patient.network.restApi.apirequests.PayAndCreateSlotRequest;
import com.augmentcare.patient.network.restApi.apirequests.SignUpRequest;
import com.augmentcare.patient.network.restApi.apirequests.TokBoxSessionRequest;
import com.augmentcare.patient.network.restApi.apirequests.TokenRequest;
import com.augmentcare.patient.network.restApi.apirequests.VerifyOTPRequest;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Zulqurnain on 15/04/2018.
 */

public interface APIService {


    @GET("/api/v1/medicines_catalogs/prescribed_medicines")
    Observable<Response<ResponseData<PrescribedMedicine>>> getPrescribedMedicine();

    @GET("/api/v1/lab_tests/prescribed_tests")
    Observable<Response<ResponseData<PrescribedTest>>> getPrescribedTests();

    @GET("/api/v1/carts/cart_details")
    Observable<Response<ResponseData<CartDetail>>> getCartDetails();

    @GET("/api/v1/user_addresses")
    Observable<Response<ResponseData<UserInfo>>> getUserAddress();

    @GET("/api/v1/users/get_role_id")
    Observable<Response<ResponseData<AChat>>> getRoleID();

    @GET("/api/v1/chat/get_chat_data")
    Observable<Response<ResponseData<AChat>>> getChatData();

    @GET("/api/v1/chat/get_chat_lines")
    Observable<Response<ResponseData<AChat>>> getChatLines();

    @GET("/api/v1/chat/get_chat_id")
    Observable<Response<ResponseData<AChat>>> getChatId();

    @GET("/api/v1/dependants")
    Observable<Response<ResponseData<Dependent>>> getDependent();

    @POST("/api/v1/carts/build_meds_cart")
    Observable<Response<ResponseData<PrescribedMeds>>> buildMedsCart();

    @GET("/api/v1/user_plans")
    Observable<ResponseData<List<APlan>>> getPlans();

    @POST("/api/v1/user_plans")
    Observable<ResponseData1<UserLogin>> purchasePlans(
            @Body GenericRequest request
    );

    @GET("/api/v1/user_plans/get_user_current_plan")
    Observable<ResponseData1<GenericResponse>> getUserCurrentPlan();

    @POST("/api/v1/user_plans/cancel_subscription")
    Observable<ResponseData1<GenericResponse>> cancelPlan(
            @Body GenericRequest request
    );

    @GET("/api/v1/user_plans/coupon_verify")
    Observable<ErrorsResponse> verifyCoupon(
            @Query("coupon_code") String couponCode,
            @Query("plan_id") String planID

    );

    @POST("/api/v1/users/update_user_part_of_project")
    Observable<ResponseData1<User>> setPromo(
            @Body GenericRequest request
    );

    @POST("/api/v1/payments")
    Observable<ResponseData1<Payment>> makePayment(
            @Body GenericRequest request
    );

    @POST("/api/v1/notifications/get_notifications")
    Observable<NotificationResponseModel> getNotification(
            @Body GenericRequest genericRequest
    );

    @GET("/api/v1/user_cards")
    Observable<ResponseData1<List<CreditCard>>> userCards();

    @DELETE("/api/v1/user_cards/{CARD_ID}")
    Observable<ErrorsResponse> deleteCard(@Path("CARD_ID") String cardId);

    @POST("/api/v1/user_cards")
    Observable<ResponseData1<CreditCard>> addCard(@Body GenericRequest request);

    @GET("/api/v1/app_version_check")
    Observable<NotificationObject> getAppVersion();

    @POST("/api/v1/chat/add_chat_lines")
    Observable<Response<ResponseData<AChat>>> addChatLines();

    @POST("/api/v1/carts/add_order_item")
    Observable<Response<ResponseData<Order>>> addOrderItem(
            @Body Order order
    );

    @POST("/api/v1/user_addresses/")
    Observable<Response<ResponseData<String>>> updateUserAddress(
            @Body AAdress aAdress
    );

    @POST("/api/v1/carts/checkout")
    Observable<Response<ResponseData<String>>> checkout(
            @Body Order order
    );

    @POST("/api/v1/carts/remove_order_item")
    Observable<Response<ResponseData<String>>> removeOrderItem(
            @Body OrderItem orderItem
    );

    //TODO Not found
    //@GET("/api/v1/user_uploaded_reports/")
    //@GET("/api/v1/user_prescriptions/list_prescriptions")
    //@POST("/api/v1/medicines_catalogs")
    //@POST("/api/v1/consultations/add_update_rating")
    //@GET("/api/v1/users/get_channel_key")


    // GET request

//    // http://drtechpk.com/admin/rest-apies/auth.php?request=<SERVICE NAME>
//    @GET("auth.php?request=Aboutinfo")
//    Observable<DrTechResponse<List<AboutInfo>>> getAboutInfo();    // http://drtechpk.com/admin/rest-apies/auth.php?request=<SERVICE NAME>
//
//
//    @Multipart
//    @POST("career-auth.php")
//    Observable<DrTechResponse<Boolean>> careerApply(
//            @Part("c_name") RequestBody name,
//            @Part("c_f_name") RequestBody fullname,
//            @Part("email") RequestBody email,
//            @Part("contact_number") RequestBody phone,
//            @Part("c_letter") RequestBody cover,
//            @Part("experience") RequestBody exp_req,
//            @Part("job_id") RequestBody jobID,
//            @Part("subject") RequestBody positionName,
//            @Part MultipartBody.Part MediaFile
//    );
//
//    @FormUrlEncoded
//    @POST("auth-post.php")
//    Observable<EmptyModel> contactUsSubmit(
//            @Field("name") String name,
//            @Field("email") String email,
//            @Field("comments") String message,
//            @Field("numb") String number
//    );

    // POST requests

    @Multipart
    @POST("/s3_upload?path=profile/images")
    Observable<Response<String>> uploadFile(
            @Query("user_id") String userID,
            @Part("name") RequestBody name,
            @Part("filename") RequestBody fileName,
            @Part MultipartBody.Part MediaFile
    );

    @GET("/api/v1/users/get_dependents")
    Observable<ResponseData<DependentsCoveredResponse>> getAllDependentsOfUser(@Query("user_id") Integer userID,@Query("organization_id") Integer orgID);

    @GET("/api/v1/all_dependents_type")
    Observable<ResponseData<DependentTypesResponse>> getAllDependentType();

    @GET("/api/v1/employees/all_covered_dependents")
    Observable<ResponseData<DependentsCoveredResponse>> getAllDependentOfEmployee(
            @Query("organization_id") int orgID,
            @Query("user_id") int userID
    );

    @GET("/api/v1/claims/{CLAIM_ID}")
    Observable<ClaimDetailsModel> getClaimDetails(@Path("CLAIM_ID") String claimID);

    @GET("/api/v1/claims")
    Observable<ResponseData1<GetUserClaimsList>> getUserClaims(@Query("user_id") String userID);

    @GET("/api/v1/orders/re_order")
    Observable<ResponseData<List<LabTest>>> reOrderLabTest(@Query("id") String labOrderID);

    @GET("/api/v1/test_reports")
    Observable<ResponseData<LabOrderResponse>> getLabOrderDetils(@Query("id") String labOrderID);

    @GET("/api/v1/verify_employee_code")
    Observable<ResponseData1<UserLogin>> signUpVerifyEmployeeCode(@Query("code") String code);

    @GET("/api/v1/specializations/list_all_dropdown_options")
    Observable<ResponseData<DoctorFilterOptionResponse>> getDoctorsFilterOptionsList();

    @GET("/api/v1/doctors/list_doctors")
    Observable<ResponseData<GenericResponse>> getDoctorsList(@QueryMap Map<String,String> request);

    @GET("/api/v1/carts/update_quantity")
    Observable<ResponseData<CouponResponse>> getMedicineQuantity(@Body GenericRequest request);

    @GET("/api/v1/medicines_catalogs")
    Observable<MedicinesList> getAllMedcinesList();

    @GET("/api/v1/doctors/get_doctor_profile")
    Observable<ResponseData<GenericResponse>> getDoctorProfile(
            @Query("user_id") int userID
    );

    @GET("/api/v1/order_details/{id}")
    Observable<OrderDetailsResponse> getOrderDetails(
            @Path("id") int orderID
    );

    @GET("/api/v1/areas/all")
    Observable<AreasResponse> getAllAreas(@Query("type") String optionalType);

    @GET("/api/v1/doctor_slots")
    Observable<ConsultationSlots> getDoctorSlotsInConsultation(
            @Query("user_id") int userID // optional
    );

    @GET("/api/v1/carts/apply_coupon")
    Observable<ResponseData<CouponResponse>> applyCouponCode(
            @Query("coupon") String couponCode,
            @Query("type") String type // lab / medicine
    );

    @GET("/api/v1/dependants")
    Observable<ResponseData<DependentsList>> getAllDependents();

    @GET("/api/v1/users/get_dependents")
    Observable<ResponseData<DependentsList>> getDependentsOfUser(
            @Query("user_id") int userID,
            @Query("organization_id") int organizationID
    );

    @GET("/api/v1/users/get_doctors")
    Observable<ResponseData<List<DoctorDetail>>> getDoctorByUserID(@Query("user_id") int userID);

    @GET("/api/v1/users/find_doctors")
    Observable<Response<ResponseData<List<DoctorDetail>>>> findDoctors();

    @POST("/api/v1/users/get_user_info_from_role_id")
    Observable<GenericResponse> getUserInfo(@Body GenericRequest request);

    @POST("/api/v1/users/update_user_information")
    Observable<UpdateUserInfoResponse> updateUserInfo(@Body UserInfoUpdateRequest request);

    @POST("/api/v1/refresh_token")
    Observable<Response<ResponseData1<UserLogin>>> refreshToken();

    //    @GET("/api/v1/auth/validate_token")
//    Observable<Response<ResponseData<UserLogin>>> validateToken(@Body LoginRequest loginRequest);
    @POST("/api/v1/auth/sign_in")
    Observable<Response<ResponseData<UserLogin>>> signIn(@Body LoginRequest loginRequest);

    @POST("/api/v1/login_from_sdk")
    Observable<Response<ResponseData<UserLogin>>> signInWithSDK(@Body LoginRequest loginRequest);

    @POST("/api/v1/auth")
    Observable<Response<String>> signUp(@Body SignUpRequest signUpRequest);

    @PUT("/api/v1/auth")
    Observable<ResponseData<SignUpResponse>> changePassword(@Body GenericRequest request);

    @POST("/api/v1/auth/password")
    Observable<ErrorResponse> resetPassword(@Body LoginRequest loginRequest);

    @POST("/api/v1/verify_and_confirm")
    Observable<ResponseData1<UserLogin>> verifyOTP(@Body VerifyOTPRequest verifyOTPRequest);

    @POST("/api/v1/create_code")
    Observable<ErrorResponse> resendOTP(@Body LoginRequest loginRequest);

    @POST("/api/v1/verify_otp_code")
    Observable<ResponseData> verifyOTPPhone(@Body VerifyOTPRequest verifyOTPRequest);

    @POST("/api/v1/mobile_app_features")
    Observable<ResponseData<GenericResponse>> getAppFeatures(@Body TokenRequest tokenRequest);

    @POST("/api/v1/users/get_profiles_by_phone")
    Observable<ResponseData<ProfilesInfo>> getProfilesByPhoneNumber(@Body LoginRequest loginRequest);

    @GET("/api/v1/site_settings/get_bin_numbers?partner_name=alfalah")
    Observable<ResponseData<GenericResponse>> getBinNumbersForAlfalah();

    @POST("/api/v1/verify_otp_code_and_set_passwrod")
    Observable<ResponseData1<Data>> verifyOTPAndChangePassword(@Body VerifyOTPRequest verifyOTPRequest);

    @POST("/api/v1/request_slot/update_slot_v2")
    Observable<ResponseData<AppointmentSlot>> cancelConsultationWithDoctor(@Body CancelDoctorAppointmentRequest cancelDoctorAppointmentRequest);

    @GET("/api/v1/doctors/instant_doctor2")
    Observable<ResponseData<InstantAppointmentSlotResult>> instantAppointmentSlots(@Query("appointment_time") String currentTime); // 2019-11-30T09:45:00.000Z

    @POST("/api/v1/request_slot/book_instant_appointment")
    Observable<BookedInstantAppointmentSlot> bookInstantAppointment(@Body GenericRequest genericRequest); // 2019-11-30T09:45:00.000Z

    @POST("/api/v1/doctors/instant_doctor_info")
    Observable<ResponseData<DoctorInfoOverView>> instantDoctorInfoOverview(
            @Query("appointment_time") String appointmentDateTime, // 2019-11-30T09:45:00.000Z
            @Query("doctor_id") int doctorID
    );

    @POST("/api/v1/doctor_slots/weekly_slots")
    Observable<ResponseData<ResponseData<List<Boolean>>>> getWeeklySlotsForDoctor(
            @Query("doctor_id") int doctorID
    );

    @FormUrlEncoded
    @POST("/api/v1/consultations/getAllPatientSlots")
    Observable<ResponseData<List<Patientslot>>> getPatientAllSlots(
            @Field("patient_id") int patientID
    );

    @FormUrlEncoded
    @POST("/api/v1/health_points/add_new")
    Observable<HealthPointResponse> addHealthPoints(
            @Field("health_type") String healthType,
            @Field("consultation_id") int consultationID,
            @Field("user_id") int userID,
            @Field("value") int points
    );

    @FormUrlEncoded
    @POST("/api/v1/chat/add_chat_session")
    Observable<ResponseData<String>> addDoctorNotes(
            @Field("consultation_id") int consultationID,
            @Field("patient_role_id") int patientRoleID,
            @Field("doctor") boolean isDoctor,
            @Field("updateNotes") boolean updateNotes,
            @Field("user_notes") String notes
    );

    @FormUrlEncoded
    @POST("/api/v1/consultations/getPendingPatientSlots")
    Observable<ResponseData<List<Patientslot>>> getPendingPatientSlots(
            @Field("patient_id") int patientID
    );

    @FormUrlEncoded
    @POST("/api/v1/consultations/getApprovedPatientSlots")
    Observable<ResponseData<List<Patientslot>>> getApprovedPatientSlots(
            @Field("patient_id") int patientID
    );

    @FormUrlEncoded
    @POST("/api/v1/consultations/getCompletedPatientSlots")
    Observable<ResponseData<List<Patientslot>>> getCompletedPatientSlots(
            @Field("patient_id") int patientID,
            @Field("doctor_id") int doctorID
    );

    @FormUrlEncoded
    @POST("/api/v1/consultations/getConsultationDetails")
    Observable<ResponseData<ConsultationDetails>> getConsultationDetails(
            @Field("doctor") boolean isDoctorSlot,
            @Field("slot_id") String slotID
    );

    @FormUrlEncoded
    @POST("/api/v1/create_order")
    Observable<GenericResponse> createOrder(
            @Field("order_type") String orderType, // labs / pharmacy
            @Field("role_id") int roleID,
            @Field("address") String address,
            @Field("prescription_id") int prescriptionID,
            @Field("area") String areasInAddress
    );

    @FormUrlEncoded
    @POST("/api/v1/authenticate_oe")
    Observable<ResponseData<AuthenticateOEResponse>> authenticateOE(
            @Field("products") List<String> products,
            @Field("order_id") int orderID,
            @Field("area") String area

    );

    @POST("/api/v1/finalize_order")
    Observable<ErrorResponse> finalizeOrder(
            @Body FinalizeOrderRequest request
    );

    @POST("/api/v1/user_addresses")
    Observable<ResponseData<Address>> addUserAdress(
            @Body Address address
    );

    @DELETE("/api/v1/auth/sign_out")
    Observable<ErrorResponse> signOut(
            @Query("device_id") String firebaseToken
    );

    @POST("/api/v1/consultations/get_consultations")
    Observable<ConsultationsList> getAllConsultations(@Body GenericRequest request);

    @FormUrlEncoded
    @POST("/api/v1/users/set_employee_password")
    Observable<ErrorResponse> setEmployeeSignUpPassword(
            @Field("email") String email,
            @Field("password") String password,
            @Field("code") String employeeCode
    );

    @POST("/api/v1/lab_tests")
    Observable<GenericResponse> getAllLabTestsList();

    @POST("/api/v1/check_labs")
    Observable<LabsAvailabilityResponse> checkLabsAvailability(@Body GenericRequest request);

    @POST("/api/v1/claims/attach_files")
    Observable<ErrorResponse> claimSetImagesFiles(@Body GenericRequest request);

    @POST("/api/v1/claims")
    Observable<ResponseData1<CreatedClaimResponse>> createClaim(@Body CreateClaimRequest request);

    @POST("/api/v1/claims/message")
    Observable<ResponseData<MessageResponse>> sendClaimMessage(@Body Message request);

    @DELETE("/api/v1/dependants/{ID}")
    Observable<ErrorsResponse> deleteDependent(@Path("ID") int id );

//    @POST("/api/v1/users/add_dependents")
    @POST("/api/v1/dependants")
    Observable<ResponseData1<AddDependentResponse>> addDependents(@Body Dependent dependentRequest);

    @PUT("/api/v1/dependants/{ID}")
    Observable<ResponseData1<AddDependentResponse>> updateDependent(@Path("ID") int id,@Body Dependent dependentRequest);

    @POST("/api/v1/consultations/add_update_rating")
    Observable<ErrorResponse> rateDoctorConsultation(
            @Body RatingModelRequest ratingModelRequest
    );

    @POST("/api/v1/chat/session")
    Observable<TokBoxObj> getTokBoxVideoSession(@Body TokBoxSessionRequest request);

    @POST("/api/v1/google_signin")
    Observable<Response<ResponseData<UserLogin>>> googleSignIn(@Body TokenRequest tokenRequest);


    //#TODO fix below API's after confirming from backend developer

    @POST("/api/v1/request_slot/create_slot")
    Observable<Response<String>> addAppointment(@Body AppointmentRequest appointmentRequest);

    @POST("/api/v1/payments/create_payment_and_book_slot")
    Observable<EliteDoctorSuccess> createPaymentAndBookSlot(
            @Body PayAndCreateSlotRequest payAndCreateSlotRequest
    );

    @GET("/api/v1/doctor_slots/available_slots")
    Observable<ResponseData<DoctorAvailableSlots>> getAvailableSlotsOfDoctor(
            @Query("type") String type, // online / offline
            @Query("doctor_id") String doctorID,
            @Query("date") String currentDateTime, // 2019-11-30T09:45:00.000Z
            @Query("medical_practice_id") String medicalPracticeID
    );

    @POST("/api/v1/notifications/reset_counter")
    Observable<ResponseData<Void>> resetCounter(
            @Body GenericRequest genericRequest
    );

    @POST("/api/v1/users/{PATIENT_ID}/orders/lab")
    Observable<Response<String>> getLabOrderDetailsForPatient(@Path("PATIENT_ID") String patientID);

    @POST("/api/v1/orders/pay_and_order")
    Observable<Response<String>> payAndOrderMedicine(@Body PayOrderMedRequest request);

    @POST("api/v1/jazzcash/mobile_account_pay")
    Observable<JazzCashResponse> jazzCashPay(@Body UserPlansResponse user_plans);

    @GET("/api/v1/users/free_and_total_calls")
    Observable<FreeCallModel> getFreeCall();
}