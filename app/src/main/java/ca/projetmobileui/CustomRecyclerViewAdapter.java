package ca.projetmobileui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ca.projetmobileui.Models.Courier;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<NewViewHolder> {
    private final List<Courier> couriers;
    private final Context context;
    private final LayoutInflater mLayoutInflater;

    public CustomRecyclerViewAdapter(List<Courier> couriers, Context context) {
        this.couriers = couriers;
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View recyclerViewItem =
                mLayoutInflater.inflate(R.layout.recyclerview_item_layout, parent,
                        false);
        return new NewViewHolder(recyclerViewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {

        Courier courier = this.couriers.get(position);
        String lastName = courier.getLastName();
        holder.txtNewDescription.setText(lastName);
        holder.txtNewTitle.setText(courier.getFirstName());

        holder.btnArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, detailsInfoCourierActivity.class);

                String firstName = courier.getFirstName();
                intent.putExtra("firstName", firstName);
                String lastName = courier.getLastName();
                intent.putExtra("lastName", lastName);
                String address = courier.getAdress();
                intent.putExtra("adress", address);
                String phoneNumber = courier.getPhoneNumber();
                intent.putExtra("phoneNumber", phoneNumber);
                String DateHeure = courier.getDateHeure();
                intent.putExtra("DateHeure", DateHeure);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return this.couriers.size();
    }
}
