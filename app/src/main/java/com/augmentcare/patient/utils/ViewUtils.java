package com.augmentcare.patient.utils;

/**
 * Created by qamar on 23/08/2017.
 */


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.google.android.gms.common.SignInButton;
import com.google.android.material.textfield.TextInputLayout;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.content.Context.DOWNLOAD_SERVICE;


/**
 * Created by Qamar Ul Zaman on 5/3/17.
 */

public class ViewUtils {

    public static File dispatchTakePictureIntent(Activity activity, int actionCode) {
        File capturedImage;
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePictureIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        File f = null;
        try {
            f = createImageFile(activity);

            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
        } catch (IOException e) {
            e.printStackTrace();
            f = null;

        }
        capturedImage = f;
        if (f != null) {
            Uri photoURI = FileProvider.getUriForFile(activity,
                    "uk.zapro.qwikkar.fileprovider",
                    f);
            List<ResolveInfo> resInfoList = activity.getPackageManager().queryIntentActivities(takePictureIntent, PackageManager.MATCH_DEFAULT_ONLY);
            for (ResolveInfo resolveInfo : resInfoList) {
                String packageName = resolveInfo.activityInfo.packageName;
                activity.grantUriPermission(packageName, photoURI, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
            }
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            activity.startActivityForResult(takePictureIntent, actionCode);
        }
        return capturedImage;
    }

    public static File dispatchChoosePictureIntent(Activity activity, int actionCode) {
        File capturedImage;
        Intent takePictureIntent = new Intent(Intent.ACTION_GET_CONTENT);
        takePictureIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        takePictureIntent.addCategory(Intent.CATEGORY_OPENABLE);
        File f = null;
        try {
            f = createImageFile(activity);

            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
        } catch (IOException e) {
            e.printStackTrace();
            f = null;

        }
        capturedImage = f;
        if (f != null) {
            Uri photoURI = FileProvider.getUriForFile(activity,
                    "com.augmentcare.patient.fileprovider",
                    f);
            List<ResolveInfo> resInfoList = activity.getPackageManager().queryIntentActivities(takePictureIntent, PackageManager.MATCH_DEFAULT_ONLY);
            for (ResolveInfo resolveInfo : resInfoList) {
                String packageName = resolveInfo.activityInfo.packageName;
                activity.grantUriPermission(packageName, photoURI, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
            }
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            takePictureIntent.setType("image/*");
            activity.startActivityForResult(takePictureIntent, actionCode);
        }
        return capturedImage;
    }

    private static File createImageFile(Activity activity) throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        //mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    public static void showConfirmDialog(Context context, int titleRes, int mesageRes, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_NoActionBar);
        } else {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog);
        }
        builder.setTitle(titleRes)
                .setMessage(mesageRes)
                .setPositiveButton(android.R.string.yes, listener)
                .setNegativeButton(android.R.string.no, listener)
                .show();
    }

    public static void showHeightPicker(Context context, String titleRes, final OnValueSelected listener) {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_NoActionBar);
        } else {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog);
        }
        TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.layout_dialog_title, null);
        textView.setText(titleRes);
        textView.setGravity(Gravity.CENTER);
        builder.setCustomTitle(textView);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_value_picker, null);
        final NumberPicker picker1 = view.findViewById(R.id.pickerNumber1);
        final NumberPicker picker2 = view.findViewById(R.id.pickerNumber2);
        picker1.setMinValue(1);
        picker1.setMaxValue(10);
        picker2.setMinValue(0);
        picker2.setMaxValue(12);
        //picker1.getValue()
        builder.setView(view);
        builder.setTitle(titleRes)

                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int feets = picker1.getValue();
                        int inches = picker2.getValue();
                        String selectedValue = feets + "\'" + inches + "\"";
                        listener.valueSelected(true, selectedValue);

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.valueSelected(false, null);
                    }
                })
                .show();
    }

    public static void showDateTimePicker(Context context, String titleRes, final OnValueSelected<Date> listener) {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_NoActionBar);
        } else {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog);
        }
        TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.layout_dialog_title, null);
        textView.setText(titleRes);
        textView.setGravity(Gravity.CENTER);
        builder.setCustomTitle(textView);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_date_time_picker, null);
        final NumberPicker picker1 = view.findViewById(R.id.pickerNumber1);
        final NumberPicker picker2 = view.findViewById(R.id.pickerNumber2);
        picker1.setMinValue(1);

        picker2.setMinValue(1);

        Calendar calendar = Calendar.getInstance();
        final ArrayList<String> dateStrList = new ArrayList<>();
        final ArrayList<Date> dates = new ArrayList<>();
        final ArrayList<Date> times = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i == 0)
                dateStrList.add("Today");
            else
                dateStrList.add(TextUtils.formatDate(calendar.getTime()));
            dates.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        String[] arr = {};
        picker1.setDisplayedValues(dateStrList.toArray(arr));
        picker1.setMaxValue(dateStrList.size());

        final ArrayList<String> timesString = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            timesString.add(TextUtils.formatTime(calendar.getTime()));
            times.add(calendar.getTime());
            calendar.add(Calendar.MINUTE, 20);
        }


        String[] arrTime = {};
        picker2.setDisplayedValues(timesString.toArray(arrTime));
        picker2.setMaxValue(timesString.size());
        picker1.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        picker2.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        //picker1.getValue()
        builder.setView(view);
        builder.setTitle(titleRes)

                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int indexDate = picker1.getValue();
                        int indexTime = picker2.getValue();
                        Date dateSelected = dates.get(indexDate);
                        Date timeSelected = times.get(indexTime);
                        Calendar timeStamp = Calendar.getInstance();
                        Calendar dateCal = Calendar.getInstance();
                        dateCal.setTime(dateSelected);
                        timeStamp.setTime(timeSelected);
                        timeStamp.set(Calendar.YEAR, dateCal.get(Calendar.YEAR));
                        timeStamp.set(Calendar.MONTH, dateCal.get(Calendar.MONTH));
                        timeStamp.set(Calendar.DAY_OF_MONTH, dateCal.get(Calendar.DAY_OF_MONTH));

                        listener.valueSelected(true, timeStamp.getTime());

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //listener.valueSelected(false, null);
                    }
                })
                .show();
    }

    public static void showValuePicker(Context context, String titleRes, final ArrayList<String> values, String selectedValue, final OnValueSelected listener) {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(context);
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_NoActionBar);
        } else {
            builder = new AlertDialog.Builder(context, android.support.v7.appcompat.R.style.Theme_AppCompat_Light_Dialog);
        }*/

        if (!selectedValue.trim().isEmpty() && values.contains(selectedValue)) {
            values.remove(selectedValue);
            values.add(0, selectedValue);
        }

        TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.layout_dialog_title, null);
        textView.setText(titleRes);
        textView.setGravity(Gravity.CENTER);
        builder.setCustomTitle(textView);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_string_picker, null);
        final NumberPicker picker1 = view.findViewById(R.id.pickerNumber1);
        picker1.setDisplayedValues(values.toArray(new String[]{}));
        picker1.setMinValue(1);
        picker1.setMaxValue(values.size());

        //picker1.getValue()
        builder.setView(view);
        builder.setTitle(titleRes)

                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("", "onClick: ");
                        listener.valueSelected(true, values.get(picker1.getValue() - 1));
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.valueSelected(false, "");
                    }
                })
                .show();
    }


    public static void showProgress(final boolean show, final View progressView, final View contentView) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = progressView.getContext().getResources().getInteger(android.R.integer.config_shortAnimTime);
            if (contentView != null) {
                contentView.setVisibility(show ? View.GONE : View.VISIBLE);
                contentView.animate().setDuration(shortAnimTime).alpha(
                        show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        contentView.setVisibility(show ? View.GONE : View.VISIBLE);
                    }
                });
            }
            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            progressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            if (contentView != null)
                contentView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    public static void showConfirmDialog(Context context, String titleRes, String mesageRes, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_NoActionBar);
        } else {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog);
        }
        builder.setTitle(titleRes)
                .setMessage(mesageRes)
                .setPositiveButton(android.R.string.yes, listener)
                .setNegativeButton(android.R.string.no, listener)
                .show();
    }

    public static void showConfirmPlanDialog(Context context, String titleRes, String mesageRes, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_NoActionBar);
        } else {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog);
        }
        builder.setTitle(titleRes)
                .setMessage(mesageRes)
                .setPositiveButton("YES", listener)
                .setNegativeButton("DON'T SHOW AGAIN", listener)
                .show();
    }

    @SuppressLint("ResourceAsColor")
    public static void showDialog(Context context, String titleRes, String mesageRes, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_NoActionBar);
        } else {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog);
        }
        builder.setTitle(titleRes).setMessage(mesageRes)
                .setPositiveButton("OK", listener)
                .show();
    }

    public static void showOneButtonDialog(Context context, String titleRes, String mesageRes, DialogInterface.OnClickListener listener)
    {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_NoActionBar);
        }
        else
        {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog);
        }

        builder.setTitle(titleRes).setMessage(mesageRes).setPositiveButton("OK", listener).show();
    }

    public static void showLogout(Context context, String titleRes, String mesageRes, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_NoActionBar);
        }
        else
        {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog);
        }
        builder.setTitle(titleRes)
                .setMessage(mesageRes)
                .setPositiveButton("Yes", listener)
                .setNegativeButton("Cancel", listener)
                .show();
    }

    public static void showConfirmDialogCustom(Context context, String titleRes, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog);
        } else {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Dialog);
        }

        View view = LayoutInflater.from(context).inflate(R.layout.layout_signup_confirm, null);
        TextView txtPhone = view.findViewById(R.id.txtPhoneNumber);
        txtPhone.setText(titleRes);
        AlertDialog dialog = builder
                .setView(view)
                .setTitle("Confirm you phone number")
                .setPositiveButton("OK", listener)
                .setNegativeButton("EDIT", listener)
                .create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
    }

    public static void showDialogWithButtons(Context context, String titleRes, String mesageRes, String leftButton, String rightButton, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_NoActionBar);
        } else {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog);
        }
        builder.setTitle(titleRes)
                .setMessage(mesageRes)
                .setPositiveButton(rightButton, listener)
                .setNegativeButton(leftButton, listener)
                .show();
    }


    public static void showPaymentDialog(final Context context, String titleRes, final InputDiloagClickListener listener) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_NoActionBar);
        } else {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog);
        }

        View view = LayoutInflater.from(context).inflate(R.layout.layout_payment_options, null);
        final View btnPayAtLocation = view.findViewById(R.id.btnPayAtLocation);
        final View btnPayOnline = view.findViewById(R.id.btnPayOnline);
        final View btnProceed = view.findViewById(R.id.btnProceed);
        final AlertDialog dialog = builder
                .setView(view)
                .create();
        btnProceed.setTag("Online");
        btnPayOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnProceed.setTag("Online");
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
                btnPayAtLocation.setBackgroundResource(typedValue.resourceId);
                btnPayOnline.setBackgroundResource(R.drawable.shape_payment_selector);
            }
        });
        btnPayAtLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnProceed.setTag("Offline");
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
                btnPayOnline.setBackgroundResource(typedValue.resourceId);
                btnPayAtLocation.setBackgroundResource(R.drawable.shape_payment_selector);
            }
        });
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                listener.onInputDialogClick((String) btnProceed.getTag(), true);
            }
        });

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
    }

    public static void showPaymentDialog(final Context context, String titleRes, final InputDiloagClickListener listener, boolean isCorporate, boolean showPayAtLocation) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_NoActionBar);
        } else {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog);
        }

        View view = LayoutInflater.from(context).inflate(R.layout.layout_payment_options, null);
        final View btnPayAtLocation = view.findViewById(R.id.btnPayAtLocation);
        final View btnPayOnline = view.findViewById(R.id.btnPayOnline);
        final View btnPayByCorp = view.findViewById(R.id.btnPayByOrganization);
        final View btnProceed = view.findViewById(R.id.btnProceed);
        final TextView txtByOrganization = view.findViewById(R.id.txtByOrganization);
        final ImageView ivOrganizationLogo = view.findViewById(R.id.ivOrganizationLogo);
        if (showPayAtLocation) {
            btnPayAtLocation.setVisibility(View.VISIBLE);
        } else {
            btnPayAtLocation.setVisibility(View.GONE);
        }
        if (MyApp.get().getOrganization() != null) {
            txtByOrganization.setText("Pay using " + MyApp.get().getOrganization().getName());
            /*if (MyApp.get().getOrganization().getLogo_url()!=null) {
                Glide.with(context).load(MyApp.get().getOrganization().getLogo_url()).into(ivOrganizationLogo);
            }*/
        }
        if (isCorporate) {
            btnPayByCorp.setVisibility(View.VISIBLE);
        } else {
            btnPayByCorp.setVisibility(View.GONE);
        }
        final AlertDialog dialog = builder
                .setView(view)
                .create();
        btnProceed.setTag("Online");
        btnPayOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnProceed.setTag("Online");
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
                btnPayAtLocation.setBackgroundResource(typedValue.resourceId);
                btnPayByCorp.setBackgroundResource(typedValue.resourceId);
                btnPayOnline.setBackgroundResource(R.drawable.shape_payment_selector);
            }
        });
        btnPayAtLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnProceed.setTag("Offline");
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
                btnPayOnline.setBackgroundResource(typedValue.resourceId);
                btnPayByCorp.setBackgroundResource(typedValue.resourceId);
                btnPayAtLocation.setBackgroundResource(R.drawable.shape_payment_selector);
            }
        });
        btnPayByCorp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnProceed.setTag("Corporate");
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
                btnPayOnline.setBackgroundResource(typedValue.resourceId);
                btnPayAtLocation.setBackgroundResource(typedValue.resourceId);
                btnPayByCorp.setBackgroundResource(R.drawable.shape_payment_selector);
            }
        });
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                listener.onInputDialogClick((String) btnProceed.getTag(), true);
            }
        });


        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
    }

    public static int getScreenHeight(Activity context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        return width;
    }


    public static void showInputDialog(Context context, String titleRes, String inputText, final InputDiloagClickListener listener) {

        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_NoActionBar);
        } else {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog);
        }
        final TextInputLayout editText = (TextInputLayout) LayoutInflater.from(context).inflate(R.layout.layout_text_input, null);
        if (inputText != null)
            editText.getEditText().setText(inputText);
        builder.setTitle(titleRes)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onInputDialogClick(editText.getEditText().getText().toString(), true);
                    }
                })
                .setView(editText)
                .show();

    }

    public static final int INPUT_TYPE_TEXT = 1;
    public static final int INPUT_TYPE_NUMBER = 2;
    public static final int INPUT_TYPE_PHONE = 3;
    public static final int INPUT_TYPE_PASSWORD = 4;

    public static void showInputDialog(Context context, String titleRes, String inputText, int inputType, final InputDiloagClickListener listener) {

        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_NoActionBar);
        } else {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog);
        }
        final TextInputLayout editText = (TextInputLayout) LayoutInflater.from(context).inflate(R.layout.layout_text_input, null);
        switch (inputType) {
            case INPUT_TYPE_NUMBER:
                editText.getEditText().setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            case INPUT_TYPE_TEXT:
                editText.getEditText().setInputType(InputType.TYPE_CLASS_TEXT);
                break;
            case INPUT_TYPE_PASSWORD:
                editText.getEditText().setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                break;
            case INPUT_TYPE_PHONE:
                editText.getEditText().setInputType(InputType.TYPE_CLASS_PHONE);
                break;
            default:
                editText.getEditText().setInputType(InputType.TYPE_CLASS_TEXT);
                break;

        }
        if (inputText != null)
            editText.getEditText().setText(inputText);
        builder.setTitle(titleRes)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onInputDialogClick(editText.getEditText().getText().toString(), true);
                    }
                })
                .setView(editText)
                .show();

    }

    private static File createImageFile(Context context) throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = context.getFilesDir();
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        image.getAbsolutePath();
        return image;
    }


    public static void showPermissionExplaination(final Activity context, int titleRes, int mesageRes, final String permission, final int requestCode) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_NoActionBar);
        } else {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog);
        }
        builder.setTitle(titleRes)
                .setMessage(mesageRes)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(context,
                                new String[]{permission},
                                requestCode);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    public static void showPermissionExplainationMultiple(final Activity context, int titleRes, int mesageRes, final String[] permission, final int requestCode) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_NoActionBar);
        } else {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog);
        }
        builder.setTitle(titleRes)
                .setMessage(mesageRes)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(context,
                                permission,
                                requestCode);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    public static ProgressDialog showProgressDialog(Activity activity, String message) {
        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        return progressDialog;
    }

    public static void dismissProgressDialog(Activity activity, ProgressDialog progressDialog) {
        try {
            if (activity != null && progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String saveBmpToFile(Context context, Bitmap bitmap, String fileName) {
        //String filename = "Signature.png";
        String filePath = "";
        File f = new File(context.getCacheDir(), fileName);
        try {

            f.createNewFile();
            filePath = f.getAbsolutePath();
            //Convert bitmap to byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
            byte[] bitmapdata = bos.toByteArray();

            //write the bytes in file
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(bitmapdata);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            return null;

        }
        return filePath;
    }

    public static boolean isNetworkAvailable(Context context)
    {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void showErrorToast(Context context, int errorMessageRes) {
        Toast toast;
        toast = Toast.makeText(context, errorMessageRes, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showErrorToast(Context context, String errorMessage) {
        Toast toast;
        toast = Toast.makeText(context, errorMessage, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void hideKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void setGooglePlusButtonText(SignInButton signInButton, String buttonText) {
        // Find the TextView that is inside of the SignInButton and set its text
        for (int i = 0; i < signInButton.getChildCount(); i++) {
            View v = signInButton.getChildAt(i);

            if (v instanceof TextView) {
                TextView tv = (TextView) v;
                tv.setText(buttonText);
                tv.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                tv.setTextSize(18);
                if (tv.getLayoutParams() instanceof FrameLayout.LayoutParams) {

                    FrameLayout.LayoutParams params = ((FrameLayout.LayoutParams) tv.getLayoutParams());
                    params.gravity = Gravity.LEFT | Gravity.CENTER_VERTICAL;
                    tv.setLayoutParams(params);
                }
                return;
            }
        }
    }

    public static void downloadFileUsingDM(Context context, String url, String title, String fileName) {
        try {
            DownloadManager dm = (DownloadManager) context.getSystemService(DOWNLOAD_SERVICE);

            DownloadManager.Request request = new DownloadManager.Request(
                    Uri.parse(url));
            request.setTitle(title);
            request.setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, fileName);
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setVisibleInDownloadsUi(true);
            long id = dm.enqueue(request);
                    /*String url = "http://www.example.com";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(RequestFactory.BASE_URL+RequestFactory.DOWNLOAD_PRESCRIPTION+"1812"));
                    startActivity(i);*/
        } catch (Exception e) {
        }
    }

    public static void openURL(Context context, String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        context.startActivity(intent);
    }

    public static void openDoctorApp(Context context) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.patient.doctor"));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scrollToEnd(final ScrollView scroll) {
        scroll.post(new Runnable() {
            @Override
            public void run() {
                scroll.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}

