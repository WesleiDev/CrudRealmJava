package interativasistemas.com.crudrealm;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ClientsAdapter extends RecyclerView.Adapter<ClientHolder> {

    public List<Client> clientList;

    public ClientsAdapter(List<Client> clients){
        this.clientList = clients;
    }

    @NonNull
    @Override
    public ClientHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Cria o item
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.client_item, parent, false);
        return new ClientHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientHolder holder, int position) {
        //Adiciona as informações no item
        String name = clientList.get(position).getName();
        holder.clientName.setText(name);//Esta propriedade clienteName é do ClientHolder
        holder.name     = name;
        holder.id       = clientList.get(position).getId();

    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }
}
