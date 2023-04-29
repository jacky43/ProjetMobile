package ca.projetmobileui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ca.projetmobileui.Models.Client;
import ca.projetmobileui.Models.Courier;

public class CustomRecyclerViewAdapterClient extends RecyclerView.Adapter<NewViewHolderClient> {
    private final List<Client> clients;
    private final Context context;
    private final LayoutInflater mLayoutInflater;

    public CustomRecyclerViewAdapterClient(List<Client> clients, Context context) {
        this.clients = clients;
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NewViewHolderClient onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View recyclerViewItem =
                mLayoutInflater.inflate(R.layout.recyclerview_item_layout, parent,
                        false);
        return new NewViewHolderClient(recyclerViewItem);

    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolderClient holder, int position) {

        Client client = this.clients.get(position);
        String lastName = client.getLastName();
        holder.txtLastNameClient.setText(lastName);
        holder.txtFirstNameClient.setText(client.getFirstName());

        holder.btnArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsInfoClientActivity.class);

                String firstName = client.getFirstName();
                intent.putExtra("firstName", firstName);
                String lastName = client.getLastName();
                intent.putExtra("lastName", lastName);
                String adress = client.getAdress();
                intent.putExtra("adress", adress);
                String phoneNumber = client.getPhoneNumber();
                intent.putExtra("phoneNumber", phoneNumber);
                String dateCourse = client.getDateCourse();
                intent.putExtra("dateCourse", dateCourse);
                double price = client.getPrice();
                intent.putExtra("price", price);
                context.startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return this.clients.size();
    }
}
