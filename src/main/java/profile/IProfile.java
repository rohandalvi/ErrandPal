package profile;

import firebase4j.error.FirebaseException;
import firebase4j.error.JacksonUtilityException;
import firebase4j.model.FirebaseResponse;
import firebase4j.service.Firebase;

import java.io.UnsupportedEncodingException;

public interface IProfile {
    FirebaseResponse create(String id, String email) throws JacksonUtilityException, UnsupportedEncodingException, FirebaseException;
    FirebaseResponse delete(String email);
}
