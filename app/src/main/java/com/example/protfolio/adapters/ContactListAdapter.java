package com.example.protfolio.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protfolio.Contact;
import com.example.protfolio.R;

import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.MyTviewHolder> {

    private Context context;
    private List<Contact> contactList;

    public class MyTviewHolder extends RecyclerView.ViewHolder{
        public TextView title, description;

        public MyTviewHolder(View v){
            super(v);
            title = v.findViewById(R.id.title);
            description = v.findViewById(R.id.description);
        }
    }
    public ContactListAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public MyTviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_view_contact, parent, false);

        return new MyTviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTviewHolder holder, int position) {
        Contact item = contactList.get(position);

        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
