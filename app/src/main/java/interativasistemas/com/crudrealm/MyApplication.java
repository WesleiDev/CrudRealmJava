package interativasistemas.com.crudrealm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration
                                    .Builder()
                                    .name("clientes.realm")
                                    .build();

//        Realm.deleteRealm(config);
        Realm.setDefaultConfiguration(config);
    }
}
