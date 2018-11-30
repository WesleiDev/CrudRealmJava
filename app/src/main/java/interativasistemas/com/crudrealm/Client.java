package interativasistemas.com.crudrealm;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Client extends RealmObject {

    @PrimaryKey
    @Required
    private String id = UUID.randomUUID().toString();

    @Required
    private String name;
    @Required
    private String email;
    private String cpf;

    public Client(){};

    public Client(String name, String email, String cpf){
        this.name  = name;
        this.email = email;
        this.cpf   = cpf;
    }

    public Client(String id, String name, String email, String cpf){
        this.id    = id;
        this.name  = name;
        this.email = email;
        this.cpf   = cpf;
    }

    public void save(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        realm.copyToRealm(this);

        realm.commitTransaction();
        realm.close();

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getId(){
        return this.id;
    }
}
