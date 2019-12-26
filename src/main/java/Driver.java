import com.google.firebase.auth.FirebaseAuthException;
import firebase4j.error.FirebaseException;
import firebase4j.error.JacksonUtilityException;
import firebase4j.model.FirebaseResponse;
import org.apache.commons.lang3.RandomStringUtils;
import profile.IProfile;
import profile.impl.Profile;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws FirebaseException, IOException, JacksonUtilityException, FirebaseAuthException {
        int power = 0;
        IProfile profile = new Profile();
        for(int i = 0;i<Math.pow(10,power);i++) {
            FirebaseResponse firebaseResponse = profile.create(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(5)+i+"@gmail.com");
            System.out.println(firebaseResponse.getBody());
            System.out.println(firebaseResponse.getCode());
        }

    }
}
