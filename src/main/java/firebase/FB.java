package firebase;

import auth.firebase.Init;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthException;
import firebase4j.error.FirebaseException;
import firebase4j.service.Firebase;
import lombok.Getter;

import javax.inject.Singleton;
import java.io.IOException;

@Singleton
@Getter
public class FB {

    private static final String BASE_URL = "https://errandpal-d0592.firebaseio.com/";

    Firebase firebase;
    Init init;
    public FB() throws FirebaseException, IOException, FirebaseAuthException {
        init = new Init();
        firebase = new Firebase(BASE_URL, init.getFirebaseToken());
    }
}
