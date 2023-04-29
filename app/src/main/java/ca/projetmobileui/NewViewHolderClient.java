package ca.projetmobileui;



import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewViewHolderClient extends RecyclerView.ViewHolder {
    ImageView imageArticle;
    TextView txtFirstNameClient;
    TextView txtLastNameClient;
    Button btnArticle;

    public NewViewHolderClient(@NonNull View itemView) {
        super(itemView);
        this.imageArticle = (ImageView) itemView.findViewById(R.id.imageNew);
        this.txtFirstNameClient = (TextView) itemView.findViewById(R.id.txtFirstNameClient);
        this.txtLastNameClient = (TextView) itemView.findViewById(R.id.txtLastNameClient);
        this.btnArticle = (Button) itemView.findViewById(R.id.btnArticle);
    }
}
