package interativasistemas.com.crudrealm;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ClientHolder extends RecyclerView.ViewHolder {

    public TextView clientName;
    public String name, id;

    public ClientHolder(View itemView) {
        super(itemView);

        clientName = itemView.findViewById(R.id.clientName);

    }
}
