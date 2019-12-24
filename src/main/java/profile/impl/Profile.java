package profile.impl;

import com.google.firebase.auth.FirebaseAuthException;
import firebase.FB;
import firebase4j.error.FirebaseException;
import firebase4j.error.JacksonUtilityException;
import firebase4j.model.FirebaseResponse;
import firebase4j.service.Firebase;
import org.apache.commons.lang3.RandomStringUtils;
import profile.IProfile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Profile implements IProfile {
    FB fb;
    public Profile() throws FirebaseException, IOException, FirebaseAuthException {
        fb = new FB();
    }
    @Override
    public FirebaseResponse create(String id, String email) throws JacksonUtilityException, UnsupportedEncodingException, FirebaseException {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("email", email);
        return fb.getFirebase().put("/user/"+ RandomStringUtils.randomAlphabetic(5), map);

    }

    @Override
    public FirebaseResponse delete(String email) {
        //todo - implement this
        return null;
    }
}
