package interativasistemas.com.crudrealm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ClientHolder extends RecyclerView.ViewHolder {

    public TextView clientName;
    public String name, id;

    public ClientHolder(View itemView) {
        super(itemView);

        clientName = itemView.findViewById(R.id.clientName);

        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "Nome: "+name + " ID: "+id, Toast.LENGTH_LONG).show();
                Intent editIntent = new Intent(view.getContext(), EditClientActivity.class);
                editIntent.putExtra("id", id);
                Activity currentActivity = (Activity) view.getContext();
                currentActivity.startActivity(editIntent);
            }
        });

    }
}
