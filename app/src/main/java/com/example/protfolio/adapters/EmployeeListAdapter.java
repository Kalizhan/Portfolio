package com.example.protfolio.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protfolio.Contact;
import com.example.protfolio.Employee;
import com.example.protfolio.R;

import java.util.List;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.MyTviewHolder> {

    private Context context;
    private List<Employee> employeeList;

    public class MyTviewHolder extends RecyclerView.ViewHolder{
        public TextView title, description, info;

        public MyTviewHolder(View v){
            super(v);
            title = v.findViewById(R.id.title);
            description = v.findViewById(R.id.description);
            info = v.findViewById(R.id.info_view);
        }
    }
    public EmployeeListAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeListAdapter.MyTviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_view_employee, parent, false);

        return new EmployeeListAdapter.MyTviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeListAdapter.MyTviewHolder holder, int position) {
        Employee item = employeeList.get(position);

        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        holder.info.setText(item.getInfo());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }


}
