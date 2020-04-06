package com.augmentcare.patient.network.restApi;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;

import androidx.appcompat.app.AppCompatActivity;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.network.restApi.apimodels.APlan;
import com.augmentcare.patient.network.restApi.apimodels.AddDependentResponse;
import com.augmentcare.patient.network.restApi.apimodels.Address;
import com.augmentcare.patient.network.restApi.apimodels.AppointmentSlot;
import com.augmentcare.patient.network.restApi.apimodels.AreasResponse;
import com.augmentcare.patient.network.restApi.apimodels.BookedInstantAppointmentSlot;
import com.augmentcare.patient.network.restApi.apimodels.ClaimDetailsModel.ClaimDetailsModel;
import com.augmentcare.patient.network.restApi.apimodels.ConsultationDetails;
import com.augmentcare.patient.network.restApi.apimodels.ConsultationSlots;
import com.augmentcare.patient.network.restApi.apimodels.ConsultationsList;
import com.augmentcare.patient.network.restApi.apimodels.CouponResponse;
import com.augmentcare.patient.network.restApi.apimodels.CreatedClaimResponse;
import com.augmentcare.patient.network.restApi.apimodels.CreditCard;
import com.augmentcare.patient.network.restApi.apimodels.Dependent;
import com.augmentcare.patient.network.restApi.apimodels.DependentTypesResponse;
import com.augmentcare.patient.network.restApi.apimodels.DependentsCoveredResponse;
import com.augmentcare.patient.network.restApi.apimodels.DependentsList;
import com.augmentcare.patient.network.restApi.apimodels.DoctorAvailableSlots;
import com.augmentcare.patient.network.restApi.apimodels.DoctorDetail;
import com.augmentcare.patient.network.restApi.apimodels.DoctorFilterOptionResponse;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
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
import com.augmentcare.patient.network.restApi.apimodels.Lab;
import com.augmentcare.patient.network.restApi.apimodels.LabOrderResponse;
import com.augmentcare.patient.network.restApi.apimodels.LabTest;
import com.augmentcare.patient.network.restApi.apimodels.Medicine;
import com.augmentcare.patient.network.restApi.apimodels.MedicinesList;
import com.augmentcare.patient.network.restApi.apimodels.Message;
import com.augmentcare.patient.RemoteMessage.NotificationObject;
import com.augmentcare.patient.network.restApi.apimodels.OrderDetailsResponse;
import com.augmentcare.patient.network.restApi.apimodels.Patientslot;
import com.augmentcare.patient.network.restApi.apimodels.ProfilesInfo;
import com.augmentcare.patient.network.restApi.apimodels.RatingModelRequest;
import com.augmentcare.patient.network.restApi.apimodels.ResponseData;
import com.augmentcare.patient.network.restApi.apimodels.ResponseData1;
import com.augmentcare.patient.network.restApi.apimodels.SignUpResponse;
import com.augmentcare.patient.network.restApi.apimodels.TokBoxObj;
import com.augmentcare.patient.network.restApi.apimodels.User;
import com.augmentcare.patient.network.restApi.apimodels.UserInfo;
import com.augmentcare.patient.network.restApi.apimodels.UserInfoUpdateRequest;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.augmentcare.patient.network.restApi.apimodels.UserPlans.UserPlans;
import com.augmentcare.patient.network.restApi.apimodels.UserPlans.UserPlansResponse;
import com.augmentcare.patient.network.restApi.apimodels.notificationsModels.NotificationResponseModel;
import com.augmentcare.patient.network.restApi.apirequests.CancelDoctorAppointmentRequest;
import com.augmentcare.patient.network.restApi.apirequests.CreateClaimRequest;
import com.augmentcare.patient.network.restApi.apirequests.DoctorsListRequest;
import com.augmentcare.patient.network.restApi.apirequests.GenericRequest;
import com.augmentcare.patient.network.restApi.apirequests.LoginRequest;
import com.augmentcare.patient.network.restApi.apirequests.PayAndCreateSlotRequest;
import com.augmentcare.patient.network.restApi.apirequests.SignUpRequest;
import com.augmentcare.patient.network.restApi.apirequests.TokBoxSessionRequest;
import com.augmentcare.patient.network.restApi.apirequests.TokenRequest;
import com.augmentcare.patient.network.restApi.apirequests.VerifyOTPRequest;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.MapUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import es.dmoral.toasty.Toasty;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by Zulqurnain on 16/04/2018.
 */

public class RxApi {
    private static final String TAG = "RxApi";
    private apiStatusChange apiStatusChange;
    public int API_COUNT = 0;
    private AppCompatActivity topActivity = null;

    ////////////////// STATICS ////////////////////

    public static String DOWNLOAD_PRESCRIPTION = "/api/v1/prescriptions/download_pdf?slot_id=";


    public RxApi(apiStatusChange apiStatusChange) {
        this.apiStatusChange = apiStatusChange;

        try {
            topActivity = (AppCompatActivity) ActivityUtils.getTopActivity();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setApiStatusChange(RxApi.apiStatusChange apiStatusChange) {
        this.apiStatusChange = apiStatusChange;

        try {
            topActivity = (AppCompatActivity) ActivityUtils.getTopActivity();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private <T> Observable<T> bindLoadingAction(apiStatusChange apiStatusChange, final Observable<T> source) {
        API_COUNT++;

        final Observable<T> o = source
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        new Handler(Looper.getMainLooper()).post(() -> {
            if (apiStatusChange != null)
                apiStatusChange.onChange(RequestLoadState.IDLE);
        });
        return o.lift(observer -> new Observer<T>() {
            @Override
            public void onSubscribe(Disposable d) {
//                API_COUNT++;

                new Handler(Looper.getMainLooper()).post(() -> {
                    if (apiStatusChange != null)
                        apiStatusChange.onChange(RequestLoadState.LOADING);
                });
                observer.onSubscribe(d);
            }

            @Override
            public void onNext(T t) {
                observer.onNext(t);
                MyApp.HANDLER.postDelayed(() -> {
                    if (API_COUNT > 0) API_COUNT--;
                }, 2000);
            }

            @Override
            public void onError(Throwable e) {
                API_COUNT--;

                new Handler(Looper.getMainLooper()).post(() -> {
                    if (apiStatusChange != null)
                        apiStatusChange.onChange(RequestLoadState.ERROR);
                });
                observer.onError(e);
            }

            @Override
            public void onComplete() {
                if (API_COUNT > 0) API_COUNT--;

                new Handler(Looper.getMainLooper()).post(() -> {
                    if (apiStatusChange != null)
                        apiStatusChange.onChange(RequestLoadState.COMPLETE);
                });
                observer.onComplete();
            }
        });
    }


    private Observable<Boolean> processAPIErrorResponse(Observable<ErrorResponse> ob) {
        if (topActivity == null) {
            try {
                topActivity = (AppCompatActivity) ActivityUtils.getTopActivity();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!NetworkUtils.isConnected()) {
            Toasty.error(topActivity, R.string.error_no_internet).show();
            return Observable.empty();
        }
        return bindLoadingAction(apiStatusChange, ob)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(urr -> {
                    checkResponseError(urr);
                    return Observable.just(urr.isSuccess());
                });
    }

    private Observable<String> processAPIStringV2(Observable<Response<String>> ob) {
        if (topActivity == null) {
            try {
                topActivity = (AppCompatActivity) ActivityUtils.getTopActivity();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!NetworkUtils.isConnected()) {
            Toasty.error(topActivity, R.string.error_no_internet).show();
            return Observable.empty();
        }
        return bindLoadingAction(apiStatusChange, ob)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(urr -> {
                    if (urr != null && urr.isSuccessful() && urr.body() != null) {
                        try {
                            ResponseData errorResponse = GsonUtils.fromJson(urr.body(), ResponseData.class);
                            checkResponseError(errorResponse);
                            try {
                                JSONObject obj = new JSONObject(urr.body());
                                String data = obj.getJSONObject("data").toString();

                                return Observable.just(data);
                            } catch (Exception e) {
                                throw e;
                            }
                        } catch (Exception e) {
                            ResponseData1 errorResponse = GsonUtils.fromJson(urr.body(), ResponseData1.class);
                            checkResponseError(errorResponse);
                            try {
                                JSONObject obj = new JSONObject(urr.body());
                                String data = obj.getJSONObject("data").toString();

                                return Observable.just(data);
                            } catch (Exception ee) {
                                throw ee;
                            }
                        }
                    }
                    else if (urr != null && urr.errorBody() != null) { // error
                        try {
                            ErrorResponse errorResponse = GsonUtils.fromJson(urr.errorBody().string(), ErrorResponse.class);
                            checkResponseError(errorResponse);
                        } catch (Exception e) {
                            ErrorsResponse errorResponse = GsonUtils.fromJson(urr.errorBody().string(), ErrorsResponse.class);
                            checkResponseError(errorResponse);
                        }
                        return Observable.just(urr.errorBody().string());
                    }
                    else{
                        throw new Exception("Try Again Invalid Request");
                    }
                });
    }

    private <T> Observable<T> processAPIResponseDataV2(Observable<ResponseData<T>> ob) {
        if (topActivity == null) {
            try {
                topActivity = (AppCompatActivity) ActivityUtils.getTopActivity();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!NetworkUtils.isConnected()) {
            Toasty.error(topActivity, R.string.error_no_internet).show();
            return Observable.empty();
        }
        return bindLoadingAction(apiStatusChange, ob)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(urr -> {
                    checkResponseError(urr);
                    return Observable.just(urr.getData());
                });
    }


    private <T> Observable<Pair<Headers, T>> processAPIResponseDataV1(Observable<Response<ResponseData<T>>> ob) {
        if (topActivity == null) {
            try {
                topActivity = (AppCompatActivity) ActivityUtils.getTopActivity();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!NetworkUtils.isConnected()) {
            Toasty.error(topActivity, R.string.error_no_internet).show();
            return Observable.empty();
        }
        return bindLoadingAction(apiStatusChange, ob)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(urr -> {
                    checkResponseError(urr);
                    if (urr.body() == null) {
                        throw new Exception("try again invalid request sent");
                    }
                    return Observable.just(new Pair<>(urr.headers(), urr.body().getData()));
                });
    }

    private Observable<Boolean> processAPIErrorsResponse(Observable<ErrorsResponse> ob) {
        if (topActivity == null) {
            try {
                topActivity = (AppCompatActivity) ActivityUtils.getTopActivity();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!NetworkUtils.isConnected()) {
            Toasty.error(topActivity, R.string.error_no_internet).show();
            return Observable.empty();
        }
        return bindLoadingAction(apiStatusChange, ob)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(urr -> {
                    checkResponseError(urr);
                    return Observable.just(urr.isSuccess());
                });
    }

    private <T> Observable<T> processAPIResponseData1V2(Observable<ResponseData1<T>> ob) {
        if (topActivity == null) {
            try {
                topActivity = (AppCompatActivity) ActivityUtils.getTopActivity();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!NetworkUtils.isConnected()) {
            Toasty.error(topActivity, R.string.error_no_internet).show();
            return Observable.empty();
        }
        return bindLoadingAction(apiStatusChange, ob)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(urr -> {
                    checkResponseError(urr);
                    return Observable.just(urr.getData());
                });
    }

    private <T> Observable<Pair<Headers, T>> processAPIResponseData1V1(Observable<Response<ResponseData1<T>>> ob) {
        if (topActivity == null) {
            try {
                topActivity = (AppCompatActivity) ActivityUtils.getTopActivity();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!NetworkUtils.isConnected()) {
            Toasty.error(topActivity, R.string.error_no_internet).show();
            return Observable.empty();
        }
        return bindLoadingAction(apiStatusChange, ob)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(urr -> {
                    checkResponseError1(urr);
                    if (urr.body() == null) {
                        throw new Exception("try again invalid request sent");
                    }
                    return Observable.just(new Pair<>(urr.headers(), urr.body().getData()));
                });
    }

    private <T> void checkResponseError1(Response<ResponseData1<T>> returnedResult) {
        try {
            if (returnedResult == null) {
                throw new Exception("try again invalid request sent");
            } else if (returnedResult.errorBody() != null || !returnedResult.isSuccessful()) {
                ResponseBody errorBody = returnedResult.errorBody();
                throw new Exception((errorBody == null || errorBody.string() == null) ? "API error..." : errorBody.string());
            } else if (returnedResult.body() != null && (returnedResult.body().getData() == null || !returnedResult.body().isSuccess())) {
                if (returnedResult.body().getErrors() != null && returnedResult.body().getErrors().size() > 0) {
                    throw new Exception(returnedResult.body().getErrors().get(0));
                } else if (!StringUtils.isEmpty(returnedResult.body().getMessage())) {
                    throw new Exception(returnedResult.body().getMessage());
                } else if (!StringUtils.isEmpty(returnedResult.body().getError())) {
                    throw new Exception(returnedResult.body().getError());
                } else if (StringUtils.isEmpty(returnedResult.body().getStatus())) {
                    return;
                }
                throw new Exception("try again invalid request sent");
            }
        } catch (Exception e) {
        }
    }

    private <T> void checkResponseError(Response<ResponseData<T>> returnedResult) {
        try {
            if (returnedResult == null) {
                throw new Exception("try again invalid request sent");
            } else if (returnedResult.errorBody() != null || !returnedResult.isSuccessful()) {
                ResponseBody errorBody = returnedResult.errorBody();
                throw new Exception((errorBody == null || errorBody.string() == null) ? "API error..." : errorBody.string());
            } else if (returnedResult.body() != null && (returnedResult.body().getData() == null || !returnedResult.body().isSuccess())) {
                if (!StringUtils.isEmpty(returnedResult.body().getError())) {
                    throw new Exception(returnedResult.body().getError());
                } else if (!StringUtils.isEmpty(returnedResult.body().getMessage())) {
                    throw new Exception(returnedResult.body().getMessage());
                } else if (returnedResult.body().getErrors() != null && returnedResult.body().getErrors().getFullMessages().size() > 0) {
                    throw new Exception(returnedResult.body().getErrors().getFullMessages().get(0));
                } else if (StringUtils.isEmpty(returnedResult.body().getStatus())) {
                    return;
                }
                throw new Exception("try again invalid request sent");
            }
        } catch (Exception e) {
        }
    }

    private <T> void checkResponseError(ResponseData returnedResult) throws Exception {
        checkResponseError((ErrorResponse) returnedResult);
    }

    private <T> void checkResponseError(ErrorResponse returnedResult) throws Exception {
        if (returnedResult == null) {
            throw new Exception("try again invalid request sent");
        } else if (!returnedResult.isSuccess()) {
            if (!StringUtils.isEmpty(returnedResult.getError())) {
                throw new Exception(returnedResult.getError());
            } else if (!StringUtils.isEmpty(returnedResult.getMessage())) {
                throw new Exception(returnedResult.getMessage());
            } else if (returnedResult.getErrors() != null && returnedResult.getErrors().getFullMessages().size() > 0) {
                throw new Exception(returnedResult.getErrors().getFullMessages().get(0));
            } else if (StringUtils.isEmpty(returnedResult.getStatus())) {
                return;
            }
            throw new Exception("try again invalid request sent");
        }
    }

    private <T> void checkResponseError(ResponseData1 returnedResult) throws Exception {
        checkResponseError((ErrorsResponse) returnedResult);
    }

    private <T> void checkResponseError(ErrorsResponse returnedResult) throws Exception {
        if (returnedResult == null) {
            throw new Exception("try again invalid request sent");
        } else if (!returnedResult.isSuccess()) {
            if (returnedResult.getErrors() != null && returnedResult.getErrors().size() > 0) {
                throw new Exception(returnedResult.getErrors().get(0));
            } else if (!StringUtils.isEmpty(returnedResult.getMessage())) {
                throw new Exception(returnedResult.getMessage());
            } else if (!StringUtils.isEmpty(returnedResult.getError())) {
                throw new Exception(returnedResult.getError());
            } else if (StringUtils.isEmpty(returnedResult.getStatus())) {
                return;
            }
            throw new Exception("try again invalid request sent");
        }
    }

    public enum RequestLoadState {
        LOADING, COMPLETE, ERROR, IDLE
    }

    public interface apiStatusChange {
        void onChange(RequestLoadState state);
    }

    //////////////// REAL API section begins here

    public Observable<SignUpResponse> changePassword(String newPassword) {
        return processAPIResponseDataV2(
                API.getApi().changePassword(
                        new GenericRequest()
                                .withPassword(newPassword)
                                .withPasswordConfirmation(newPassword)
                )
        );
    }

    public Observable<UserInfo> getUserInfo(int userRoleID) {
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().getUserInfo(
                        new GenericRequest()
                                .withUserRoleID(userRoleID)
                )
        ).flatMap(response -> {
            if (response.getUserInfo() == null) {
                throw new Exception("user not found...");
            }
            return Observable.just(response.getUserInfo());
        });
    }

    public Observable<UserInfo> updateUserProfile(UserInfoUpdateRequest request) {
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().updateUserInfo(request))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(res -> {
                    if (res == null){
                        throw new Exception("try again invalid request sent");
                    } else if (!res.isSuccess()){
                        if (res.getError() != null && res.getError().get(0) != null) {
                            throw new Exception(res.getError().get(0));
                        }
                        throw new Exception("try again invalid request sent");
                    }
                    return Observable.just(res.getUserInfo());
                });
    }

    public Observable<Boolean> deleteDependent(int userId) {
        return processAPIErrorsResponse(API.getApi().deleteDependent(userId));
    }

    public Observable<AddDependentResponse> addDependent(
            Dependent dependent
    ) {
        return processAPIResponseData1V2(API.getApi().addDependents(dependent));
    }

    public Observable<AddDependentResponse> updateDependent(
            int user_id,
            Dependent dependent
    ) {
        return processAPIResponseData1V2(
                API.getApi().updateDependent(
                        user_id,
                        dependent
                )
        );
    }

    public Observable<DependentsCoveredResponse> getAllDependentsOfUser(Integer userID) {
        return processAPIResponseDataV2(
                API.getApi().getAllDependentsOfUser(userID, null)
        );
    }

    public Observable<Boolean> updateConsultationRating(RatingModelRequest ratingModel) {
        return processAPIErrorResponse(
                API.getApi().rateDoctorConsultation(ratingModel)
        );
    }

    public Observable<DependentsCoveredResponse> getAllDependentOfEmployee(int orgID, int userID) {
        return processAPIResponseDataV2(
                API.getApi().getAllDependentOfEmployee(orgID, userID)
        );
    }

    public Observable<DependentTypesResponse> getAllDependentTypes() {
        return processAPIResponseDataV2(
                API.getApi().getAllDependentType()
        );
    }

    public Observable<com.augmentcare.patient.network.restApi.apimodels.Message> sendClaimMessage(String claimID, String message) {
        return processAPIResponseDataV2(
                API.getApi().sendClaimMessage(new Message()
                        .withClaimId(Integer.valueOf(claimID))
                        .withMessage(message)
                )
        ).flatMap(e -> {
            return Observable.just(e.getMessage());
        });
    }

    public Observable<ClaimDetailsModel> getClaimDetails(String claimUID) {
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().getClaimDetails(claimUID)
        );
    }

    public Observable<CreatedClaimResponse> createClaim(Integer amount, String consultation, String speciality, String location, String date, String time,
                                                        Integer organizationId, String transactionType, String userId, String transactionFor, String claimType,
                                                        List<String> uploadedFiles, String dependentId) {
        return processAPIResponseData1V2(
                API.getApi().createClaim(new CreateClaimRequest()
                        .withAmount(amount)
                        .withConsultationWith(consultation)
                        .withSpeciality(speciality)
                        .withLocation(location)
                        .withDate(date)
                        .withTime(time)
                        .withOrganizationId(organizationId)
                        .withTransactionType(transactionType)
                        .withUserId(userId)
                        .withTransactionFor(transactionFor)
                        .withClaimType(claimType)
                        .withUploadedFiles(uploadedFiles)
                        .withDependentId(dependentId)
                )
        );
    }

    public Observable<GetUserClaimsList> getClaimByUser(int userID) {
        return processAPIResponseData1V2(
                API.getApi().getUserClaims(userID + "")
        );
    }

    public Observable<ErrorResponse> getClaimByUser(int claimID, List<String> uploadedFilesURLs) {
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().claimSetImagesFiles(
                        new GenericRequest()
                                .withId(claimID)
                                .withListOfStrings(uploadedFilesURLs)
                )
        );
    }


    public Observable<Response<String>> uploadFile(int userID, File fileToSend) {
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), fileToSend);
        MultipartBody.Part media = MultipartBody.Part.createFormData("file", FileUtils.getFileName(fileToSend), requestFile);
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().uploadFile(
                        userID + "",
                        RequestBody.create(MediaType.parse("text/plain"), userID + ""),
                        RequestBody.create(MediaType.parse("text/plain"), FileUtils.getFileName(fileToSend)),
                        media
                )
        );
    }

    public Observable<List<LabTest>> reOrderLabTest(int labOrderID) {
        return processAPIResponseDataV2(
                API.getApi().reOrderLabTest(labOrderID + "")
        );
    }

    public Observable<List<Lab>> checkLabsAvailability(List<Integer> listOfLabIDs, String area) {
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().checkLabsAvailability(
                        new GenericRequest()
                                .withTests(listOfLabIDs)
                                .withArea(area)
                )
        )
                .flatMap(t -> {
                    if (t.getSuccess() != null && t.getSuccess()) {
                        return Observable.just(t.getResults().getLabs());
                    } else {
                        return Observable.just(new ArrayList<Lab>());
                    }
                })
                .map(t -> {
                    for (int i = 0; i < listOfLabIDs.size(); i++) {
                        t.get(i).withID(listOfLabIDs.get(i));
                    }
                    return t;
                });
    }

    public Observable<LabOrderResponse> getLabOrderDetails(int labOrderID) {
        return processAPIResponseDataV2(
                API.getApi().getLabOrderDetils(labOrderID + "")
        );
    }

    public Observable<List<LabTest>> getAllLabTestsList() {
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().getAllLabTestsList()
        ).flatMap(t -> {
            if (t.getSuccess() != null && t.getSuccess()) {
                return Observable.just(t.getLabTests());
            } else {
                return Observable.just(new ArrayList<>());
            }
        });
    }

    public Observable<Boolean> setEmployeeSignUpPassword(String email, String pass, String employeeCode) {
        return processAPIErrorResponse(
                API.getApi().setEmployeeSignUpPassword(email, pass, employeeCode)
        );
    }

    public Observable<UserLogin> signUpVerifyEmployeeCode(String code) {
        return processAPIResponseData1V2(
                API.getApi().signUpVerifyEmployeeCode(code)
        );
    }

    public Observable<DoctorFilterOptionResponse> getDoctorsFilterOptionsList() {
        return processAPIResponseDataV2(
                API.getApi().getDoctorsFilterOptionsList()
        );
    }

    public Observable<List<DoctorInfoLimited>> getDoctorsList(DoctorsListRequest request) {
        Map<String, String> map = MapUtils.newTreeMap(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                },
                new Pair<String, String>("page", request.getPage()),
                new Pair<String, String>("per_page", request.getPerPage()),
                new Pair<String, String>("filters", request.getFilters()),
                new Pair<String, String>("search", request.getSearch()),
                new Pair<String, String>("name", request.getName()),
                new Pair<String, String>("specialization", request.getSpecialization()),
                new Pair<String, String>("city_id", request.getCityId()),
                new Pair<String, String>("hospital_id", request.getHospitalId()),
                new Pair<String, String>("fee_min", request.getFeeMin()),
                new Pair<String, String>("fee_max", request.getFeeMax()),
                new Pair<String, String>("gender", request.getGender()),
                new Pair<String, String>("reviews", request.getReviews()),
                new Pair<String, String>("rating", request.getRating()),
                new Pair<String, String>("experience_min", request.getExperienceMin()),
                new Pair<String, String>("experience_max", request.getExperienceMax()),
                new Pair<String, String>("distance_min", request.getDistanceMin()),
                new Pair<String, String>("distance_max", "")
        );
        return processAPIResponseDataV2(API.getApi().getDoctorsList(map))
                .flatMap(t -> Observable.just(t.getDoctorInfoLimitedList()));
    }

    public Observable<CouponResponse> updateMedicineQuantity(
            int medicineID,
            String quantityPack,
            String type // medicine / labs
    ) {
        return processAPIResponseDataV2(
                API.getApi().getMedicineQuantity(
                        new GenericRequest()
                                .withId(medicineID)
                                .withQuantityPack(quantityPack)
                                .withType(type)
                )
        );
    }

    public Observable<MedicinesList> getAllMedicines() {
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().getAllMedcinesList()
        );
    }


    public Observable<DoctorDetail> getDoctorProfile(int userID) {
        return processAPIResponseDataV2(
                API.getApi().getDoctorProfile(userID)
        ).flatMap(t -> Observable.just(t.getDoctorDetail()));
    }

    public Observable<ConsultationsList> getAllConsultations(
            String slotStatus, // prescription_submitted,""
            int page,
            int perPageitems
    ) {
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().getAllConsultations(
                        new GenericRequest()
                                .withSlotStatus(slotStatus)
                                .withPage(page)
                                .withPerPage(perPageitems)
                )
        );
    }

    public Observable<Boolean> signOut(String firebaseToken) {
        return processAPIErrorResponse(
                API.getApi().signOut(firebaseToken)
        );
    }

    public Observable<List<APlan>> subcriptionPlan() {
        return processAPIResponseDataV2(API.getApi().getPlans());
    }

    public Observable<GenericResponse> getUserCurrentPlan() {
        return processAPIResponseData1V2(API.getApi().getUserCurrentPlan());
    }

    public Observable<UserLogin> purchasePlan(String token, String plan_id, String couponCode) {
        return processAPIResponseData1V2(
                API.getApi().purchasePlans(
                        new GenericRequest()
                                .withUserplan(
                                        new UserPlans()
                                                .withId(plan_id)
                                                .withStripeToken(token)
                                                .withCouponCode(couponCode)
                                )
                )
        );
    }

    public Observable<GenericResponse> cancelPlan(int plan_id) {
        return processAPIResponseData1V2(
                API.getApi().cancelPlan(
                        new GenericRequest()
                                .withUserPlanId(plan_id)
                )
        );
    }

    public Observable<User> setPromo(String promo) {
        return processAPIResponseData1V2(
                API.getApi().setPromo(
                        new GenericRequest()
                                .withPart_of_project(promo)
                )
        );
    }

    public Observable<Boolean> verifyPromoCode(String promo, String planID) {
        return processAPIErrorsResponse(API.getApi().verifyCoupon(promo, planID));
    }

//    public Observable<Payment> makePayment(String token, int plan_id) {
//        return processAPIResponseData1V2(
//                bindLoadingAction(
//                        apiStatusChange,
//                        API.getApi().makePayment(
//                                new GenericRequest()
//                                        .withUserplan(
//                                                new PayAndCreateSlotRequest()
//                                                        .withStripeEmail(plan_id)
//                                                        .withStripeToken(token)
//                                        )
//                        )
//                )
//        );
//    }

    public Observable<Address> addUserAdress(
            int userId,
            String city,
            String area,
            int areaID,
            int cityID,
            String streetAddress1,
            String streetAddress2
    ) {
        return processAPIResponseDataV2(
                API.getApi().addUserAdress(
                        new Address()
                                .withUserId(userId)
                                .withCity(city)
                                .withArea(area)
                                .withAreaId(areaID)
                                .withCityId(cityID)
                                .withStreetAddress1(streetAddress1)
                                .withStreetAddress2(streetAddress2)
                )
        );
    }

    public Observable<Boolean> finalizeOrder(FinalizeOrderRequest request) {
        return processAPIErrorResponse(
                API.getApi().finalizeOrder(request)
        );
    }

    /**
     * This api is follow up for createOrder() API
     *
     * @param productslist   results from followed up API
     * @param orderID        "order" from followed up API
     * @param areasInAddress area in Address
     * @return medicines list
     */

    public Observable<List<Medicine>> authenticateOE(
            List<String> productslist,
            int orderID,
            String areasInAddress
    ) {
        return processAPIResponseDataV2(
                API.getApi().authenticateOE(productslist, orderID, areasInAddress)
        ).flatMap(t -> {
            if (StringUtils.isEmpty(t.getError())) {
                return Observable.just(t.getMedicines());
            }
            return Observable.error(new Throwable(StringUtils.null2Length0(t.getError())));
        });
    }

    /**
     * @param orderType
     * @param roleID
     * @param address
     * @param prescriptionID
     * @param areasInAddress
     * @return Pair of two things
     * - first is "Order" Number
     * - second is "results" List of string
     */

    public Observable<Pair<Integer, List<String>>> createOrder(
            String orderType, // labs / pharmacy
            int roleID,
            String address,
            int prescriptionID,
            String areasInAddress
    ) {
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().createOrder(orderType, roleID, address, prescriptionID, areasInAddress)
        ).flatMap(t -> Observable.just(new Pair<Integer, List<String>>(t.getOrder(), t.getResults())));
    }

    /**
     * get all areas for specific type or not type
     *
     * @param optionalType lab / pharmacy or nothing just empty
     * @return
     */

    public Observable<AreasResponse> getAllAreas(String optionalType) {
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().getAllAreas(optionalType)
        );
    }

    public Observable<OrderDetailsResponse> getOrderDetails(int orderID) {
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().getOrderDetails(orderID)
        );
    }

    public Observable<ConsultationSlots> getDoctorSlotsInConsultation(int userID) {
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().getDoctorSlotsInConsultation(userID)
        );
    }

    public Observable<ConsultationDetails> getConsultationDetails(boolean isDoctorSlot, int slotID) {
        return processAPIResponseDataV2(
                API.getApi().getConsultationDetails(isDoctorSlot, slotID + "")
        );
    }

    public Observable<TokBoxObj> getTokBoxVideoSession(TokBoxSessionRequest request) {
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().getTokBoxVideoSession(request)
        );
    }

    public Observable<List<Patientslot>> getCompletedPatientSlots(int patientID, int doctorID) {
        return processAPIResponseDataV2(
                API.getApi().getCompletedPatientSlots(patientID, doctorID)
        );
    }

    public Observable<List<Patientslot>> getPendingPatientSlots(int patientID) {
        return processAPIResponseDataV2(
                API.getApi().getPendingPatientSlots(patientID)
        );
    }

    public Observable<List<Patientslot>> getApprovedPatientSlots(int patientID) {
        return processAPIResponseDataV2(
                bindLoadingAction(
                        apiStatusChange,
                        API.getApi().getApprovedPatientSlots(patientID)
                )
        );
    }

    public Observable<Boolean> addDoctorNotes(
            int consultationID,
            int patientRoleID,
            boolean isDoctorIncluded,
            boolean updateNotes,
            String notesToUpdate
    ) {
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().addDoctorNotes(consultationID, patientRoleID, isDoctorIncluded, updateNotes, notesToUpdate)
        ).flatMap(t -> Observable.just(t.isSuccess()));
    }

    public Observable<HealthPointResponse> addHealthPoints(
            String healthType,
            int consultationID,
            int userID,
            int healthPoints
    ) {
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().addHealthPoints(healthType, consultationID, userID, healthPoints)
        )
                .flatMap(t -> {
                    if (t.getSuccess() != null && t.getSuccess()) {
                        return Observable.just(t);
                    }
                    return Observable.error(new Throwable("unable to add health points..."));
                });
    }

    public Observable<List<Patientslot>> getAllSlotsForPatient(int patientID) {
        return processAPIResponseDataV2(
                API.getApi().getPatientAllSlots(patientID)
        );
    }

    public Observable<DoctorAvailableSlots> getAvailableSlots(String type, String doctorId, String selectedDate, String medicalPracticeId) {
        return processAPIResponseDataV2(
                API.getApi().getAvailableSlotsOfDoctor(type, doctorId, selectedDate, medicalPracticeId)
        );
    }

    public Observable<EliteDoctorSuccess> makePaymentAndBookSlot(int medicalPracticeId, String doctorId, String dependentId, String startTime,
                                                                 String endTime, String date, String paymentMethodType, String cardId, String bookByUserId, String pateintId) {
        AppCompatActivity activity = (AppCompatActivity) ActivityUtils.getTopActivity();
        if (!NetworkUtils.isConnected()) {
            Toasty.error(activity, R.string.error_no_internet).show();
            return Observable.empty();
        }
        Observable<EliteDoctorSuccess> api = API.getApi().createPaymentAndBookSlot(
                new PayAndCreateSlotRequest()
                        .withMedicalPracticeId(medicalPracticeId)
                        .withDoctorId(doctorId)
                        .withPatientId(pateintId)
                        .withStartTime(startTime)
                        .withEndTime(endTime)
                        .withDay(date)
                        .withPaymentMethodType(paymentMethodType)
                        .withCardId(cardId)
                        .withBookedByUserId(bookByUserId)
                        .withDependentId(dependentId)
        );

        return bindLoadingAction(apiStatusChange, api)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(urr -> {
                    checkResponseError(urr);
                    return Observable.just(urr);
                });

    }

    /**
     * apply coupon code and get appropriate response
     *
     * @param couponCode coupon code
     * @param type       lab or medicine
     * @return response
     */

    public Observable<CouponResponse> applyCouponCode(String couponCode, String type) {
        return processAPIResponseDataV2(
                API.getApi().applyCouponCode(couponCode, type)
        );
    }

    /**
     * get Weekly slots availability of doctor
     *
     * @param doctorID
     * @return List of weekly days availability
     * i.e
     * - Monday: true
     * - Tuesday: false
     * - Wednesday: true
     * - Thursday: false
     * - Friday: false
     * - Saturday: true
     * - Sunday: false
     */

    public Observable<List<Boolean>> getDoctorsWeeklySlotFreeTime(int doctorID) {
        return processAPIResponseDataV2(
                processAPIResponseDataV2(
                        API.getApi().getWeeklySlotsForDoctor(doctorID)
                )
        );
    }

    public Observable<DoctorInfoOverView> instantDoctorInfoOverview(String appointmentTimeAndDate, int doctorID) {
        return processAPIResponseDataV2(
                API.getApi().instantDoctorInfoOverview(appointmentTimeAndDate, doctorID)
        );
    }

    public Observable<BookedInstantAppointmentSlot> bookInstantAppointment(int doctorID, String orderID, String dependentID, String currenttimeAndDate) {
        return
                bindLoadingAction(
                        apiStatusChange,
                        API.getApi().bookInstantAppointment(
                                new GenericRequest()
                                        .withAppointmentTime(currenttimeAndDate)
                                        .withDoctorId(doctorID)
                                        .withOrderID(orderID)
                                        .withDependentID(dependentID)
                        )
                ).observeOn(AndroidSchedulers.mainThread())
                        .flatMap(urr -> {
                            if (!urr.isSuccess() && urr.getErrors().size() > 0) {
                                if (apiStatusChange != null)
                                    apiStatusChange.onChange(RequestLoadState.ERROR);
                                return Observable.error(new Throwable(urr.getErrors().get(0)));
                            }
                            return Observable.just(urr);
                        });
    }

    public Observable<InstantAppointmentSlotResult> getInstantAppointmentSlots(String currenttimeAndDate) {
        return processAPIResponseDataV2(
                API.getApi().instantAppointmentSlots(currenttimeAndDate)
        );
    }

    public Observable<Pair<Integer, ResponseData1<UserLogin>>> refreshTokenHeaders() {
        return refreshTokenHeaders(false);
    }

    public Observable<Pair<Integer, ResponseData1<UserLogin>>> refreshTokenHeaders(boolean withLoading) {
        if (!NetworkUtils.isConnected()) {
            Toasty.error(Utils.getApp(), R.string.error_no_internet).show();
            return Observable.empty();
        }
        Observable<Response<ResponseData1<UserLogin>>> observable = withLoading ?
                bindLoadingAction(apiStatusChange, API.getApi().refreshToken()) :
                API.getApi().refreshToken();


        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(urr -> {
                    checkResponseError1(urr);
                    Headers headers = urr.headers();
                    PrefsHelper.setAccessTokenSP(StringUtils.null2Length0(headers.get(Constants.KEY_ACCESS_TOKEN_UP)));
                    PrefsHelper.setUIDSP(StringUtils.null2Length0(headers.get(Constants.KEY_UID_UP)));
                    PrefsHelper.setClientSP(StringUtils.null2Length0(headers.get(Constants.KEY_CLIENT_UP)));
                    API.reset();
                    return Observable.just(new Pair<>(urr.code(), urr.body()));
                });
    }

    public Observable<List<DoctorDetail>> getDoctorsByUserID(int userID) {
        return processAPIResponseDataV2(
                API.getApi().getDoctorByUserID(userID)
        );
    }

    public Observable<AppointmentSlot> cancelConsultationofDoctor
            (CancelDoctorAppointmentRequest request) {
        return processAPIResponseDataV2(
                API.getApi().cancelConsultationWithDoctor(request)
        );
    }

    public Observable<List<Dependent>> getAllDependent() {
        return processAPIResponseDataV2(
                API.getApi().getAllDependents()
        ).map(DependentsList::getDependents);
    }

    public Observable<List<Dependent>> getDependents(
            int userID,
            int organizationID
    ) {
        return processAPIResponseDataV2(
                API.getApi().getDependentsOfUser(
                        userID,
                        organizationID
                )
        ).map(DependentsList::getDependents);
    }

    public Observable<Boolean> verifyOTPandThenChangePassword(String phone, String otpCode, String pass) {
        return processAPIResponseData1V2(
                API.getApi().verifyOTPAndChangePassword(
                        new VerifyOTPRequest()
                                .withPhone(phone)
                                .withPassword(pass)
                                .withCode(otpCode)
                )
        ).map(s -> s != null);
    }

    public Observable<List<String>> getBindNumbersForAlfalahClients() {
        return processAPIResponseDataV2(API.getApi().getBinNumbersForAlfalah())
                .map(GenericResponse::getList);
    }

    public Observable<String> getAppFeaturesHTML() {
        return processAPIResponseDataV2(
                API.getApi().getAppFeatures(
                        new TokenRequest()
                                .withVersion(BuildConfig.VERSION_CODE + "")
                                .withPlatform("android")
                )
        ).map(GenericResponse::getHtml);
    }

    public Observable<ProfilesInfo> getProfilesByPhone(String phoneNo, String email){
        return processAPIResponseDataV2(
                API.getApi().getProfilesByPhoneNumber(
                        new LoginRequest()
                                .withPhone(phoneNo)
                                .withEmail(email)
                )
        );
    }

    public Observable<List<DoctorDetail>> getDoctors() {
        return processAPIResponseDataV1(API.getApi().findDoctors())
                .map(s -> s.second);
    }

    public Observable<String> resetPassword(String email) {
        LoginRequest loginRequest =
                new LoginRequest()
                        .withEmail(email)
                        .withRedirectURL(BuildConfig.SOCKET_URL + "/");
        return bindLoadingAction(apiStatusChange, API.getApi().resetPassword(loginRequest))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<ErrorResponse, ObservableSource<? extends String>>() {
                    @Override
                    public ObservableSource<? extends String> apply(ErrorResponse s) throws Exception {
                        return Observable.just(s.getMessage());
                    }
                });
    }

    public Observable<UserLogin> loginGoogle(String googleToken, String firebaseToken) {
        TokenRequest tokenRequest =
                new TokenRequest()
                        .withToken(googleToken)
                        .withDeviceId(firebaseToken)
                        .withPlatform("android")
                        .withVersion(BuildConfig.VERSION_NAME);
        return LocalUtils.getFirebaseToken()
                .flatMap(token ->
                        processAPIResponseDataV1(
                                API.getApi().googleSignIn(tokenRequest)
                        )).flatMap(pair -> {
                    Headers headers = pair.first;
                    PrefsHelper.setAccessTokenSP(StringUtils.null2Length0(headers.get(Constants.KEY_ACCESS_TOKEN_UP)));
                    PrefsHelper.setUIDSP(StringUtils.null2Length0(headers.get(Constants.KEY_UID_UP)));
                    PrefsHelper.setClientSP(StringUtils.null2Length0(headers.get(Constants.KEY_CLIENT_UP)));

                    pair.second
                            .withHeader_access_token(PrefsHelper.getAccessTokenFromSP())
                            .withHeader_clientID(PrefsHelper.getClientFromSP())
                            .withHeader_uID(PrefsHelper.getUIDFromSP());
                    API.reset();
                    return Observable.just(pair.second);
                });
    }

    public Observable<UserLogin> loginNormal(String email, String password) {
        LoginRequest loginRequest =
                new LoginRequest()
                        .withEmail(email)
                        .withPassword(password)
                        .withPlatform("android")
                        .withACPATIENTMOBILEAPP4969208517(true);
        return LocalUtils.getFirebaseToken()
                .flatMap(token ->
                        processAPIResponseDataV1(
                                API.getApi().signIn(loginRequest.withDeviceId(token))
                        ).flatMap(pair -> {
                            Headers headers = pair.first;
                            PrefsHelper.setAccessTokenSP(StringUtils.null2Length0(headers.get(Constants.KEY_ACCESS_TOKEN_UP)));
                            PrefsHelper.setUIDSP(StringUtils.null2Length0(headers.get(Constants.KEY_UID_UP)));
                            PrefsHelper.setClientSP(StringUtils.null2Length0(headers.get(Constants.KEY_CLIENT_UP)));

                            pair.second
                                    .withHeader_access_token(PrefsHelper.getAccessTokenFromSP())
                                    .withHeader_clientID(PrefsHelper.getClientFromSP())
                                    .withHeader_uID(PrefsHelper.getUIDFromSP());
                            API.reset();
                            return Observable.just(pair.second);
                        })
                );
    }

    public Observable<UserLogin> loginSDK(LoginRequest loginRequest) {
        loginRequest
                .withPlatform("android")
                .withACPATIENTMOBILEAPP4969208517(true);
        return LocalUtils.getFirebaseToken()
                .flatMap(token ->
                        processAPIResponseDataV1(
                                API.getApi().signInWithSDK(loginRequest.withDeviceId(token))
                        ).flatMap(pair -> {
                            Headers headers = pair.first;
                            PrefsHelper.setAccessTokenSP(StringUtils.null2Length0(headers.get(Constants.KEY_ACCESS_TOKEN_UP)));
                            PrefsHelper.setUIDSP(StringUtils.null2Length0(headers.get(Constants.KEY_UID_UP)));
                            PrefsHelper.setClientSP(StringUtils.null2Length0(headers.get(Constants.KEY_CLIENT_UP)));

                            pair.second
                                    .withHeader_access_token(PrefsHelper.getAccessTokenFromSP())
                                    .withHeader_clientID(PrefsHelper.getClientFromSP())
                                    .withHeader_uID(PrefsHelper.getUIDFromSP());
                            API.reset();
                            return Observable.just(pair.second);
                        })
                );
    }

    public Observable<SignUpResponse> signUp(SignUpRequest signUpRequest) {
        signUpRequest
                .withConfigName("default")
                .withConfirmSuccessUrl(BuildConfig.SOCKET_URL + "/")
                .withACPATIENTMOBILEAPP4969208517(true);
        return LocalUtils.getFirebaseToken()
                .flatMap(token -> processAPIStringV2(
                        bindLoadingAction(
                                apiStatusChange,
                                API.getApi()
                                        .signUp(signUpRequest.withDeviceId(token)))
                        ).flatMap(urr -> {
                            SignUpResponse signUpResponse = GsonUtils.fromJson(urr, SignUpResponse.class);
                            return Observable.just(signUpResponse);
                        })
                );
    }

    public Observable<Boolean> resendOTP(String email, String phone) {
        LoginRequest loginRequest =
                new LoginRequest()
                        .withEmail(email)
                        .withPhone(phone);
        return bindLoadingAction(apiStatusChange, API.getApi().resendOTP(loginRequest))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(s -> Observable.just(s.isSuccess()));
    }

    public Observable<Boolean> verifyOTPPhone(String phone, String code){
        VerifyOTPRequest verifyOTPRequest = new VerifyOTPRequest().withCode(code).withPhone(phone);
        return bindLoadingAction(apiStatusChange,API.getApi().verifyOTPPhone(verifyOTPRequest))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(s -> Observable.just(s.isSuccess()));
    }

    public Observable<UserLogin> verifyOTP(String email, String phone, String code) {
        VerifyOTPRequest verifyOTPRequest =
                new VerifyOTPRequest()
                        .withCode(code)
                        .withEmail(email)
                        .withPhone(phone)
                        .withConfigName("default")
                        .withConfirmSuccessUrl(BuildConfig.SOCKET_URL + "/")
                        .withACPATIENTMOBILEAPP4969208517(true);
        return LocalUtils.getFirebaseToken()
                .flatMap(token -> bindLoadingAction(apiStatusChange, API.getApi().verifyOTP(verifyOTPRequest.withDeviceId(token)))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .flatMap(er -> {
                            if (!er.isSuccess()) {
                                ((BaseActivity) topActivity).stopLoader();
                                throw new Exception(er.getStatus());
                            }
                            return Observable.just(er.getData());
                        }));
    }


//
//    public Observable<String> logOutMe(Login loginPost) {
//        RequestBody body = RequestBody.create(MediaType.parse("application/json"), GsonUtils.toJson(loginPost));
//        return processApiLoader2(API.getApi().logout(LocalUtils.getStoredAuthHeaderValue(), body));
//    }


    // AMAAN WORK

    public Observable<List<CreditCard>> getUserCards() {
        return processAPIResponseData1V2(API.getApi().userCards());
    }

    public Observable<NotificationResponseModel> getNOtifications(long id) {
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().getNotification(new GenericRequest().withUserRoleID(Integer.parseInt(Long.toString(id))))
        );
    }

    public Observable<Boolean> getDeleteCard(String cardId) {
        return processAPIErrorsResponse(API.getApi().deleteCard(cardId));
    }


    public Observable<CreditCard> addCreditCard(String token) {
        return processAPIResponseData1V2(
                API.getApi().addCard(
                        new GenericRequest()
                                .withToken(token)
                )
        );
    }
    public Observable<NotificationObject> getAppVersion() {
        return bindLoadingAction(apiStatusChange,API.getApi().getAppVersion()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()));
    }


    public Observable<JazzCashResponse> jazzCashPayPlan(int selectedPlanID, String jazzCashAccountNumber) {
        UserPlans userPlans = new UserPlans()
                .withId(selectedPlanID + "")
                .withJazzAccount(jazzCashAccountNumber) // test number 03000725405
                .withCouponCode("");

        UserPlansResponse plansReponse =
                new UserPlansResponse()
                        .withUserPlans(userPlans);

        return bindLoadingAction(
                apiStatusChange,
                API.getApi().jazzCashPay(plansReponse)
        );
    }

    public Observable<ResponseData<Void>> resetCounter(long id){
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().resetCounter(new GenericRequest().withUserRoleID(Integer.parseInt(Long.toString(id))))
        );
    }

    public Observable<FreeCallModel> checkFreeCall(){
        return bindLoadingAction(
                apiStatusChange,
                API.getApi().getFreeCall()
        );
    }
}