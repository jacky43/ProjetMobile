package ca.projetmobileui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewViewHolder extends RecyclerView.ViewHolder {
    ImageView imageArticle;
    TextView txtNewTitle;
    TextView txtNewDescription;
    Button btnArticle;

    public NewViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageArticle = (ImageView) itemView.findViewById(R.id.imageNew);
        this.txtNewTitle = (TextView) itemView.findViewById(R.id.txtNewTitle);
        this.txtNewDescription = (TextView) itemView.findViewById(R.id.txtNewDescription);
        this.btnArticle = (Button) itemView.findViewById(R.id.btnArticle);
    }
}
