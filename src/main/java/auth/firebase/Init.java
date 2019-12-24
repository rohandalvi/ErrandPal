package auth.firebase;


import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import firebase4j.service.Firebase;
import org.apache.commons.lang3.RandomStringUtils;

import javax.inject.Singleton;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

@Singleton
public class Init {

    GoogleCredentials scoped;
    public Init() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
        System.out.println(serviceAccount.available());
        GoogleCredentials googleCred = GoogleCredentials.fromStream(serviceAccount);
        System.out.println(googleCred.getAccessToken()+" access token");
        scoped = googleCred.createScoped(
                Arrays.asList(
                        "https://www.googleapis.com/auth/firebase.database",
                        "https://www.googleapis.com/auth/userinfo.email"
                )
        );
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(googleCred)
                .setDatabaseUrl("https://errandpal-d0592.firebaseio.com")
                .build();

        if(FirebaseApp.getApps().isEmpty())
            FirebaseApp.initializeApp(options);

    }

    public String getFirebaseToken() throws FirebaseAuthException, IOException {
        // Authenticate a Google credential with the service account


        // Add the required scopes to the Google credential

        scoped.refresh();
        System.out.println(scoped.getAccessToken());
        return scoped.getAccessToken().getTokenValue();
    }

}
