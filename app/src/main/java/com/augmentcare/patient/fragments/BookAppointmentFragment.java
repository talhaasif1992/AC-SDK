package com.augmentcare.patient.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.adapters.AvailableTimingSlotAdapter;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.customviews.DependentsView;
import com.augmentcare.patient.network.restApi.apimodels.BookedInstantAppointmentSlot;
import com.augmentcare.patient.network.restApi.apimodels.DoctorAvailableSlots;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
import com.augmentcare.patient.network.restApi.apimodels.EliteDoctorSuccess;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.bumptech.glide.Glide;
import com.vivekkaushik.datepicker.DatePickerTimeline;
import com.vivekkaushik.datepicker.OnDateSelectedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;

public class BookAppointmentFragment extends BaseFragment implements View.OnClickListener, AvailableTimingSlotAdapter.OnItemClickListener {

    DoctorInfoLimited doctor;
    String exploreInstant, doctorDetailsId;
    String instantDoctor, type, appointmentType, medicalPracticeId="", medicalPracticeName="", cardId="";
    BookedInstantAppointmentSlot exploreInstantModel;
    String endTime;

    int position;
    @BindView(R.id.tv_selected_doctor_name)
    TextView tvDoctorName;
    @BindView(R.id.tv_selected_doctor_degree)
    TextView tvDoctorDegree;
    @BindView(R.id.tv_selected_doctor_speciality)
    TextView tvDoctorSpeciality;
    @BindView(R.id.ratingTV)
    TextView tvRating;
    @BindView(R.id.tv_reviews)
    TextView tvReviews;
    @BindView(R.id.ci_selected_doctor_picture)
    CircleImageView ciPicture;
    @BindView(R.id.datePickerTimeline)
    DatePickerTimeline datePickerTimeline;
    @BindView(R.id.rvTimingSlots)
    RecyclerView rvTimingSlots;
    @BindView(R.id.tv_please_select_date_to_see_available_slots)
    TextView tvPickADateFirst;
    @BindView(R.id.tv_shift)
    TextView tvShift;
    @BindView(R.id.iv_arrow_shift_left)
    ImageView ivShiftBack;
    @BindView(R.id.iv_arrow_shift_right)
    ImageView ivShiftNext;
    @BindView(R.id.dependentView)
    DependentsView dependentsView;
    @BindView(R.id.btn_book_appointment)
    Button buttonBookAppointment;

    private View rootView;
    private Calendar calendar;
    private DoctorAvailableSlots doctorSlots;
    private List<String> slotTimeList = null;
    private List<String> tempSlotList = null;
    private List<String> morningSlots = null;
    private List<String> afternoonSlots = null;
    private List<String> eveningSlots = null;

    private String slotTime=null, selectedDate=null;
    private String pateintName =  "";

    private String dependentId="";

    private String doctorName, doctorId, doctorSpeciality, doctorPicture, doctorRating, doctorRatedCount;
    private AvailableTimingSlotAdapter afternoonAdapter;
    private AvailableTimingSlotAdapter moriningAdapter;
    private AvailableTimingSlotAdapter eveningAdapter;

    private NavController navController;
    private Boolean isFromReschedule;

    EliteDoctorSuccess exploreDoctorSuccess=null;
    BookedInstantAppointmentSlot instantDoctorSuccess=null;

    String paymentMethodTypeRS, selectedDateRS, dependentIdRS, startTimeRS, endTimeRS, cardIdRS, bookByUserRS, pateintIdRS;

    public BookAppointmentFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_book_appointment, container, false);
        return rootView;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        slotTime = null;
        selectedDate = null;
        pateintName =  baseActivity.userData.getFirstName() + " " + baseActivity.userData.getLastName();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initMe();

        GenApiLogger.fireBookAppointmentCalanderEvent(baseActivity);
    }

    private void initMe() {
        ButterKnife.bind(this, rootView);

        gettingDataFromBundle();

        navController = Navigation.findNavController(rootView);
        ((HomeScreenActivity)baseActivity).setToolbarTitle("Book Appointment");

        moriningAdapter = new AvailableTimingSlotAdapter(new ArrayList<>(), getContext(), "Morning");
        eveningAdapter = new AvailableTimingSlotAdapter(new ArrayList<>(), getContext(), "Evening");
        afternoonAdapter = new AvailableTimingSlotAdapter(new ArrayList<>(), getContext(), "Afternoon");

        calenderSettings();

        if(isFromReschedule){
            if(instantDoctor.equals("yes")){
                setBackPress(false, this::bookInstantAppointment);

            }
            else if(instantDoctor.equals("no")){
                setBackPress(false, BookAppointmentFragment.this::getPatientAppointmentApiCall);
            }
        }

        ivShiftNext.setOnClickListener(view -> {
            if (tvShift.getText().equals("Morning")){
                if(afternoonSlots.size()>0){
                    slotsRecyclerViewSettings();
                    tvShift.setText("Afternoon");
                    afternoonAdapter.setAvailableSlotList(afternoonSlots);
                    rvTimingSlots.setAdapter(afternoonAdapter);
                    afternoonAdapter.setOnItemClickListener(BookAppointmentFragment.this);
                }
                else if(eveningSlots.size()>0){
                    slotsRecyclerViewSettings();
                    tvShift.setText("Evening");
                    eveningAdapter.setAvailableSlotList(eveningSlots);
                    rvTimingSlots.setAdapter(eveningAdapter);
                    eveningAdapter.setOnItemClickListener(BookAppointmentFragment.this);
                }
                else{
                    ivShiftNext.getDrawable().setTint(Color.DKGRAY);
                }

            }else if(tvShift.getText().equals("Afternoon")){
                if(eveningSlots.size()>0){
                    slotsRecyclerViewSettings();
                    tvShift.setText("Evening");
                    eveningAdapter.setAvailableSlotList(eveningSlots);
                    rvTimingSlots.setAdapter(eveningAdapter);
                    eveningAdapter.setOnItemClickListener(BookAppointmentFragment.this);
                }
                else{
                    ivShiftNext.getDrawable().setTint(Color.DKGRAY);
                }
            }
        });

        ivShiftBack.setOnClickListener(view -> {
            if (tvShift.getText().equals("Evening")){
                if(afternoonSlots.size()>0){
                    slotsRecyclerViewSettings();
                    tvShift.setText("Afternoon");
                    afternoonAdapter.setAvailableSlotList(afternoonSlots);
                    rvTimingSlots.setAdapter(afternoonAdapter);
                    afternoonAdapter.setOnItemClickListener(BookAppointmentFragment.this);
                }
                else if(morningSlots.size()>0){
                    slotsRecyclerViewSettings();
                    tvShift.setText("Morning");
                    moriningAdapter.setAvailableSlotList(morningSlots);
                    rvTimingSlots.setAdapter(moriningAdapter);
                    moriningAdapter.setOnItemClickListener(BookAppointmentFragment.this);
                }
                else{
                    ivShiftBack.getDrawable().setTint(Color.DKGRAY);
                }
            }
            else if (tvShift.getText().equals("Afternoon")){
                if(morningSlots.size()>0) {
                    slotsRecyclerViewSettings();
                    tvShift.setText("Morning");
                    moriningAdapter.setAvailableSlotList(morningSlots);
                    rvTimingSlots.setAdapter(moriningAdapter);
                    moriningAdapter.setOnItemClickListener(BookAppointmentFragment.this);
                }
                else{
                    ivShiftBack.getDrawable().setTint(Color.DKGRAY);
                }
            }
        });

        buttonBookAppointment.setOnClickListener(view -> {
            try{
                if(NetworkUtils.isConnected()){
                    if(selectedDate==null){
                        Toasty.error(getContext(),"Please Select a Date To Continue").show();
                    }
                    else if(slotTime == null){
                        Toasty.error(getContext(),"Please Select a Time Slot To Continue").show();
                    }
                    else{
                        try{
                            if (type != null && type.equals("explore") && exploreInstant.equals("no"))
                            {
                                if(appointmentType.equals("online")){
                                    if(doctor.getFee()>0) {
                                        navController.navigate(BookAppointmentFragmentDirections
                                                .actionBookAppointmentFragmentToExplorePaymentFragment()
                                                .setCardId(cardId)
                                                .setDependentId(dependentId)
                                                .setDoctor(doctor)
                                                .setPateintName(pateintName)
                                                .setSelectedDate(selectedDate)
                                                .setTimeSlot(slotTime)
                                                .setEndTime(endTime)
                                                .setInstantDoctor(instantDoctor)
                                                .setAppointmentType(appointmentType)
                                                .setDoctorDetailId(doctorDetailsId)
                                                .setMedicalPracticeId(medicalPracticeId)
                                                .setMedicalPracticeName(medicalPracticeName)
                                                .setType(type)
                                        );
                                    }
                                    else{
                                        int medicalPracticeId;
                                        String dependentId;
                                        String startTime, endTime, selectedDate;

                                        selectedDate = convertFormat(
                                                this.selectedDate,
                                                "EEE MMM dd hh:mm:ss zzz yyyy",
                                                "yyyy-MM-dd"
                                        );

                                        startTime = convertFormat(
                                                this.slotTime,
                                                "hh:mm a",
                                                "hh:mm"
                                        );

                                        endTime = convertFormat(
                                                this.endTime,
                                                "hh:mm a",
                                                "hh:mm"
                                        );

                                        if(PrefsHelper.get(baseActivity).getString(Constants.SLOT_LOCATION, "").equalsIgnoreCase("Online")){
                                            medicalPracticeId = 0;
                                        }
                                        else{
                                            medicalPracticeId = Integer.parseInt(PrefsHelper.get(baseActivity).getString(Constants.SLOT_LOCATION, ""));
                                        }

                                        if (this.dependentId != null && !this.dependentId.isEmpty()){
                                            dependentId = this.dependentId;
                                        }
                                        else { dependentId = ""; }

                                        getDisposer().add(
                                                baseActivity.RXAPI.makePaymentAndBookSlot(medicalPracticeId,doctorId,dependentId ,startTime+"-"+endTime, startTime+"-"+endTime,selectedDate,
                                                        "pay_at_location",cardId, baseActivity.userData.getUserId()+"", baseActivity.userData.getUserId()+"")
                                                        .subscribe(this::onMakePaymentAndBookSlot, LocalUtils::processAPIError)
                                        );
                                    }
                                }
                                else if(appointmentType.equals("offline")) {
                                    navController.navigate(BookAppointmentFragmentDirections
                                            .actionBookAppointmentFragmentToExplorePaymentFragment()
                                            .setCardId(cardId)
                                            .setDependentId(dependentId)
                                            .setDoctor(doctor)
                                            .setPateintName(pateintName)
                                            .setSelectedDate(selectedDate)
                                            .setTimeSlot(slotTime)
                                            .setEndTime(endTime)
                                            .setInstantDoctor(instantDoctor)
                                            .setAppointmentType(appointmentType)
                                            .setDoctorDetailId(doctorDetailsId)
                                            .setMedicalPracticeId(medicalPracticeId)
                                            .setMedicalPracticeName(medicalPracticeName)
                                            .setType(type)
                                    );
                                }
                            }
                            else{
                                bookInstantAppointment();
                                fireEvents();

                            }
                        }
                        catch(Exception ignored){}
                    }
                }
                else{
                    Toasty.error(getContext(),"Please Check your Internet Connection").show();
                }
            }catch(Exception ignored){}
        });
    }



    @SuppressLint("CheckResult")
    public void gettingDataFromBundle() {
        if(getArguments() != null) {
            BookAppointmentFragmentArgs args = BookAppointmentFragmentArgs.fromBundle(getArguments());

            if(args.getDoctor() != null){
                doctor = args.getDoctor();
                doctorName = doctor.getName();

                for(int i = 0; i < doctor.getSpecialization().size(); i++){
                    if (i == 0){
                        doctorSpeciality = doctor.getSpecialization().get(i);
                    } else if (i == doctor.getSpecialization().size()) {
                        doctorSpeciality = doctorSpeciality + " , " + doctor.getSpecialization().get(i);
                    } else{
                        doctorSpeciality = doctorSpeciality + " , " + doctor.getSpecialization().get(i);
                    }
                }
                doctorPicture = doctor.getPicture();
                doctorRating = doctor.getRating();
                doctorRatedCount = Integer.toString(doctor.getRatedCount());

                tvDoctorName.setText(doctorName);
                tvDoctorDegree.setText("");
                tvDoctorSpeciality.setText(doctorSpeciality);
                tvRating.setText(doctorRating);
                tvReviews.setText(doctorRatedCount + " Reviews");
                Glide.with(baseActivity)
                        .load(doctorPicture)
                        .error(R.drawable.profile_placeholder)
                        .placeholder(R.drawable.profile_placeholder)
                        .into(ciPicture);
            }
            if(args.getDoctorDetailId() != null){
                doctorDetailsId = args.getDoctorDetailId();
            }
            if(args.getAppointmentType() != null){
                appointmentType = args.getAppointmentType();
            }
            if(args.getType() != null){
                type = args.getType();
            }
            if(args.getDoctorId() != null){
                doctorId = args.getDoctorId();
            }
            if(args.getMedicalPracticeId() != null){
                medicalPracticeId = args.getMedicalPracticeId();
            }
            if(args.getMedicalPracticeName() != null){
                medicalPracticeName = args.getMedicalPracticeName();
            }
            if(args.getExploreInstantModelResponseObj()!=null){
                instantDoctorSuccess = args.getExploreInstantModelResponseObj();
            }
            if(args.getExploreDoctorSuccessResponseObj() != null){
                exploreDoctorSuccess = args.getExploreDoctorSuccessResponseObj();
            }

            isFromReschedule = args.getIsFromReschedule();
            instantDoctor = args.getInstantDoctor();

            dependentsView.getSelectedDependent(value -> {
                if(value.getId() == null){
                    dependentId = baseActivity.userData.getId();
                    pateintName =  baseActivity.userData.getFirstName() + " " + baseActivity.userData.getLastName();
                }
                else{
                    dependentId = Integer.toString(value.getId());
                    pateintName = value.getName();
                }
            });
        }
    }

    public void slotsRecyclerViewSettings() {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 4);
        rvTimingSlots.setLayoutManager(mLayoutManager);
        rvTimingSlots.setHasFixedSize(true);
    }

    public void calenderSettings() {
        calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        datePickerTimeline.setInitialDate(year, month, day);

        datePickerTimeline.setOnDateSelectedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(int year, int month, int day, int dayOfWeek){
                if(NetworkUtils.isConnected()){
                    if(morningSlots != null){
                        morningSlots.clear();
                        moriningAdapter.clearAdapter();
                    }
                    if(afternoonSlots != null) {
                        afternoonSlots.clear();
                        afternoonAdapter.clearAdapter();
                    }
                    if(eveningSlots != null) {
                        eveningSlots.clear();
                        eveningAdapter.clearAdapter();
                    }

                    selectedDate = datePickerTimeline.selectedDate().toString();

                    if(type != null && instantDoctor.equals("yes")){
                        type = "explore";
                        exploreInstant = "yes";
                        getDoctorSlotsApiCall(doctorId, selectedDate);
                    }
                    else{
                        type = "explore";
                        exploreInstant = "no";
                        getDoctorSlotsApiCall(doctorId, selectedDate);
                    }
                }
                else{
                    Toasty.error(getContext(),"Please Check your Internet Connection").show();
                }

                GenApiLogger.fireFindDoctorCalenderScreenEvent(baseActivity);

            }

            @Override
            public void onDisabledDateSelected(int year, int month, int day, int dayOfWeek, boolean isDisabled){}
        });
    }

    private void getDoctorSlotsApiCall(String doctorId, String date) {
        String type;
        String medicalPracticeId;

        if (PrefsHelper.get(getContext()).getString(Constants.SLOT_LOCATION, "")
                .equalsIgnoreCase("Online")) {
            type = "online";
        } else {
            type = "offline";
        }

        if (!PrefsHelper.get(getContext()).getString(Constants.SLOT_LOCATION, "")
                .equalsIgnoreCase("Online")) {
            medicalPracticeId = PrefsHelper.get(getContext()).getString(Constants.SLOT_LOCATION, "");
        } else {
            medicalPracticeId = "0";
        }

        getDisposer().add(
                baseActivity.RXAPI.getAvailableSlots(type, doctorId, date, medicalPracticeId)
                        .subscribe(
                                res -> {
                                    onGetDoctorSlots(res);
                                },
                                e -> {
                                    LocalUtils.processAPIError(e);
                                }
                        )
        );
    }

    private void onGetDoctorSlots(DoctorAvailableSlots doctorAvailableSlots) {
        doctorSlots = doctorAvailableSlots;
        if(doctorSlots.getAvailableSlots().size() > 0){

            slotTimeList = new ArrayList<>();
            tempSlotList = new ArrayList<>();

            for(int i = 0; i < doctorSlots.getAvailableSlots().size(); i++){
                slotTimeList.add(getTime(doctorSlots.getAvailableSlots().get(i).getStartTime()));
                tempSlotList.add(getTime(doctorSlots.getAvailableSlots().get(i).getStartTime()));
            }

            returnSlotShifts(tempSlotList);

            if(morningSlots.size()>0) {
                slotsRecyclerViewSettings();
                tvShift.setText("Morning");
                moriningAdapter.setAvailableSlotList(morningSlots);
                rvTimingSlots.setAdapter(moriningAdapter);
                moriningAdapter.setOnItemClickListener(BookAppointmentFragment.this);
                tvPickADateFirst.setVisibility(View.GONE);
            }
            else if(afternoonSlots.size()>0){
                slotsRecyclerViewSettings();
                tvShift.setText("Afternoon");
                afternoonAdapter.setAvailableSlotList(afternoonSlots);
                rvTimingSlots.setAdapter(afternoonAdapter);
                afternoonAdapter.setOnItemClickListener(BookAppointmentFragment.this);
                tvPickADateFirst.setVisibility(View.GONE);
            }
            else if(eveningSlots.size()>0) {
                slotsRecyclerViewSettings();
                tvShift.setText("Evening");
                eveningAdapter.setAvailableSlotList(eveningSlots);
                rvTimingSlots.setAdapter(eveningAdapter);
                eveningAdapter.setOnItemClickListener(BookAppointmentFragment.this);
                tvPickADateFirst.setVisibility(View.GONE);
            }
        }
        else{
            tvShift.setText("");
            tvPickADateFirst.setText("No Slot Available");
            tvPickADateFirst.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view){}

    private String getTime(String formatTime) {
        String outputText = "";
        DateFormat outputFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());

        try{
            Date date123;
            date123 = inputFormat.parse(formatTime);
            Calendar cal = Calendar.getInstance(); // creates calendar
            cal.setTime(date123); // sets calendar time/selectedDate
            cal.add(Calendar.HOUR_OF_DAY, 5); // adds one hour
            date123 = cal.getTime(); // returns new selectedDate object, one hour in the future
            outputText = outputFormat.format(date123);
        }
        catch (Exception ignored) { }
        return outputText;
    }

    private String convertFormat(String date,String currentFormat,String expectedFormat){
        return TimeUtils.date2String(TimeUtils.string2Date(date,currentFormat), expectedFormat);
    }

    public int getHours(String time) {
        int h1 = (int) time.charAt(1) - '0';
        int h2 = (int) time.charAt(0) - '0';
        int hour = (h2 * 10 + h1 % 10);
        return hour;
    }

    public String getAM_PM(String time) {
        String AM_PM = String.valueOf(time.charAt(6)) + time.charAt(7);
        return AM_PM;
    }

    public void returnSlotShifts(List<String> timeSlotList){
        morningSlots = new ArrayList<>();
        afternoonSlots = new ArrayList<>();
        eveningSlots = new ArrayList<>();

        for (int i = 0; i < timeSlotList.size(); i++){
            timeSlotList.set(i,timeSlotList.get(i).toUpperCase().replaceAll("\\.",""));
            if(timeSlotList.get(i).contains("AM")){
                if (getHours(timeSlotList.get(i)) == 12){
                    eveningSlots.add(timeSlotList.get(i));
                }
                if (getHours(timeSlotList.get(i)) >= 9 && getHours(slotTimeList.get(i)) < 12){
                    morningSlots.add(timeSlotList.get(i));
                }
            }
            else if(timeSlotList.get(i).contains("PM")){
                if(getHours(timeSlotList.get(i)) == 12){
                    afternoonSlots.add(timeSlotList.get(i));
                }
                else if (getHours(timeSlotList.get(i)) >= 1 && getHours(slotTimeList.get(i)) < 6){
                    afternoonSlots.add(timeSlotList.get(i));
                }
                else if (getHours(timeSlotList.get(i)) >= 6 && getHours(timeSlotList.get(i)) < 12){
                    eveningSlots.add(timeSlotList.get(i));
                }
            }
        }
    }

    @Override
    public void onItemClick(TextView v, RecyclerView.Adapter adapter, int position) {
        if (adapter instanceof AvailableTimingSlotAdapter) {
            AvailableTimingSlotAdapter slotAdapter = ((AvailableTimingSlotAdapter) adapter);

            tvShift.setText(slotAdapter.getShiftType());
            if(doctorSlots.getAvailableSlots().get(position).getEndTime()!=null) {
                endTime = getTime(doctorSlots.getAvailableSlots().get(position).getEndTime());
            }
            slotTime= v.getText().toString();

            if (adapter.equals(moriningAdapter)) {
                afternoonAdapter.setLastSelectedPos(-1);
                eveningAdapter.setLastSelectedPos(-1);
            } else if (adapter.equals(afternoonAdapter)) {
                moriningAdapter.setLastSelectedPos(-1);
                eveningAdapter.setLastSelectedPos(-1);
            } else if (adapter.equals(eveningAdapter)) {
                afternoonAdapter.setLastSelectedPos(-1);
                moriningAdapter.setLastSelectedPos(-1);
            }
        }
    }

    public void bookInstantAppointment(){
        if(isFromReschedule){
            String date=null;

            BookAppointmentFragmentArgs args = null;
            if(getArguments()!=null) {
                args = BookAppointmentFragmentArgs.fromBundle(getArguments());
            }
            if(args!=null && args.getDependentId()!=null){
                dependentIdRS = args.getDependentId();
            }
            if(args!=null && args.getSelectedDate()!=null && args.getTime()!=null){
                selectedDateRS = args.getSelectedDate();
                slotTime = args.getTime();

                date = convertFormat(selectedDateRS,"EEE MMM dd hh:mm:ss zzz yyyy", "yyyy-MM-dd")+ " " + slotTime;
                // slotTime
                date = convertFormat(
                        date,
                        "yyyy-MM-dd hh:mm a",
                        "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"
                );
            }
            if(args!=null && args.getStartTime()!= null){
                slotTime = args.getStartTime();
            }
            if(args!=null && args.getDoctorDetailId()!=null){
                doctorDetailsId = args.getDoctorDetailId();
            }

            getDisposer().add(
                    baseActivity.RXAPI.bookInstantAppointment(Integer.parseInt(doctorDetailsId), "", dependentIdRS, date)
                            .subscribe(this::onBookInstantAppointment, LocalUtils::processAPIError)
            );
        }
        else {
            String dependentID;
            // slotTime
            String date = convertFormat(
                    selectedDate,
                    "EEE MMM dd hh:mm:ss zzz yyyy",
                    "yyyy-MM-dd"
            ) + " " + slotTime;
            // slotTime
            date = convertFormat(
                    date,
                    "yyyy-MM-dd hh:mm a",
                    "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"
            );

            if (dependentId != null && !dependentId.isEmpty()) {
                dependentID = dependentId;
            } else {
                dependentID = "";
            }

            getDisposer().add(
                    baseActivity.RXAPI.bookInstantAppointment(Integer.parseInt(doctorDetailsId), "", dependentID, date)
                            .subscribe(this::onBookInstantAppointment, LocalUtils::processAPIError)
            );
        }
    }

    private void onBookInstantAppointment(BookedInstantAppointmentSlot bookedInstantAppointmentSlot) {
        exploreInstantModel = bookedInstantAppointmentSlot;

        if(exploreInstantModel.isSuccess()){
            navController.navigate(BookAppointmentFragmentDirections
                    .actionBookAppointmentFragmentToAppointmentApprovedFragment()
                    .setExporeInstantModelResponseObj(bookedInstantAppointmentSlot)
                    .setExploreDoctorSuccessResponseObj(null)
                    .setDoctor(doctor)
                    .setInstantDoctor(instantDoctor)
                    .setSelectedDate(selectedDate)
                    .setPateintName(pateintName)
                    .setDependentId(dependentId)
                    .setTime(slotTime)
                    .setType("")
                    .setAppointmentType(appointmentType)
                    .setDoctorDetailId(doctorDetailsId)
                    .setMedicalPracticeId(medicalPracticeId)
                    .setMedicalPracticeName(medicalPracticeName)
            );
        }
    }

    private void fireEvents() {
        GenApiLogger.fireAppointmentConfirmed("appintment_confirmed");
        GenApiLogger.fireFindADoctorAppointment("find_a_doctor_appintment_confirmed",baseActivity);
      }


       private void getPatientAppointmentApiCall(){

        String startTime=null,endTime=null;

        BookAppointmentFragmentArgs args = null;
        if(getArguments()!=null) {
            args = BookAppointmentFragmentArgs.fromBundle(getArguments());
        }

        if(args!=null && args.getDependentId()!=null){
            dependentIdRS = args.getDependentId();
        }
        if(args!=null && args.getStartTime()!=null){
            startTimeRS = args.getStartTime();

            startTime = convertFormat(
                    startTimeRS,
                    "hh:mm a",
                    "hh:mm"
            );
        }
        if(args!=null && args.getEndTime()!=null){
            endTimeRS = args.getEndTime();

            endTime = convertFormat(
                    endTimeRS,
                    "hh:mm a",
                    "hh:mm"
            );
        }
        if(args!=null && args.getSelectedDate()!=null){
            selectedDateRS = args.getSelectedDate();
        }
        if(args!=null && args.getPaymentMethodType()!=null){
            paymentMethodTypeRS = args.getPaymentMethodType();
        }
        if(args!=null && args.getCardId()!=null){
            cardIdRS = args.getCardId();
        }
        if(args!=null && args.getBookByUser()!=null){
            bookByUserRS = args.getBookByUser();
        }
        if(args!=null && args.getPateintId()!=null){
            pateintIdRS = args.getPateintId();
        }
        if(medicalPracticeId.equals("")){
            medicalPracticeId = "0";
        }

        getDisposer().add(
                baseActivity.RXAPI.makePaymentAndBookSlot(Integer.parseInt(medicalPracticeId),doctorId,dependentIdRS ,startTime+"-"+endTime,
                        startTime+"-"+endTime, selectedDateRS,
                        paymentMethodTypeRS,cardIdRS, bookByUserRS, pateintIdRS)
                        .subscribe(this::onMakePaymentAndBookSlot, LocalUtils::processAPIError)
        );
    }

    private void onMakePaymentAndBookSlot(EliteDoctorSuccess exploreDoctorSuccess) {
        this.exploreDoctorSuccess = exploreDoctorSuccess;

        navController.navigate(BookAppointmentFragmentDirections
                .actionBookAppointmentFragmentToAppointmentApprovedFragment()
                .setExploreDoctorSuccessResponseObj(exploreDoctorSuccess)
                .setExporeInstantModelResponseObj(instantDoctorSuccess)
                .setDoctor(doctor)
                .setSelectedDate(selectedDateRS)
                .setType("explore")
                .setDependentId(dependentIdRS)
                .setPateintName(pateintName)
                .setTime(startTimeRS)
                .setStartTime(startTimeRS)
                .setEndTime(endTimeRS)
                .setPaymentMethodType(paymentMethodTypeRS)
                .setCardId(cardIdRS)
                .setAppointmentType(appointmentType)
                .setDoctorDetailId(doctorDetailsId)
                .setMedicalPracticeId(medicalPracticeId+"")
                .setMedicalPracticeName(medicalPracticeName)
                .setInstantDoctor(instantDoctor)
                .setIsFromExplorePayment(true)
        );
    }
}