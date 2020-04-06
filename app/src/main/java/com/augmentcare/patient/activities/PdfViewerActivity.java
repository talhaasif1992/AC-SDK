//package com.augmentcare.patient.activities;
//
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.view.View;
//
//import com.augmentcare.patient.R;
//import com.augmentcare.patient.base.BaseActivity;
//import com.augmentcare.patient.utils.Constants;
//import com.github.barteksc.pdfviewer.PDFView;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class PdfViewerActivity extends BaseActivity {
//
//    @BindView(R.id.pdfView)
//    PDFView pdfView;
//    @BindView(R.id.progressContent)
//    View progressContent;
//    Uri pdfPath;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pdf_viewer);
//        ButterKnife.bind(this);
//
//        pdfPath = getIntent().getParcelableExtra(Constants.KEY_DATA);
//
//        if (pdfPath != null) {
//            pdfView.fromUri(pdfPath).load();
//        }
//     if(getSupportActionBar()!=null) {
//         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//         getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black);
//         getSupportActionBar().setTitle("YOUR REPORT");
//     }
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home){
//            finish();
//        }
//        return super.onOptionsItemSelected(item);
//    }
//}
