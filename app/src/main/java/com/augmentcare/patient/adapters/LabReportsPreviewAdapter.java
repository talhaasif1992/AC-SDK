package com.augmentcare.patient.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.RequestedReports;
import com.blankj.utilcode.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LabReportsPreviewAdapter extends RecyclerView.Adapter<LabReportsPreviewAdapter.ViewHolder> {

    private List<RequestedReports> requestedReports = new ArrayList<>();

    public void setRequestedReports(List<RequestedReports> requestedReports) {
        this.requestedReports.clear();
        this.requestedReports.addAll(requestedReports);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LabReportsPreviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_report, parent, false);
        return new LabReportsPreviewAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LabReportsPreviewAdapter.ViewHolder holder, int position) {
        holder.bindMe(requestedReports.get(position));
    }

    @Override
    public int getItemCount() {
        return requestedReports.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View rootView;

        @BindView(R.id.txtLabReportName)
        TextView txtLabReportName;

        private RequestedReports reports;

        public ViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            ButterKnife.bind(this, rootView);
        }

        void bindMe(RequestedReports results) {
            this.reports = results;

            txtLabReportName.setText(
                    StringUtils.null2Length0(
                            reports.getName()
                    )
            );
        }
    }
}