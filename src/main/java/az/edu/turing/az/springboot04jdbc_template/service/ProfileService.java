package az.edu.turing.az.springboot04jdbc_template.service;

import az.edu.turing.az.springboot04jdbc_template.model.Profile;

import java.util.List;
import java.util.UUID;

public interface ProfileService {
    void createProfile(Profile profile);
    List<Profile> getProfiles();
    Profile getProfileById(UUID id);
    void updateProfile(Profile profile);
    void deleteAllProfiles();
    int getProfileCount();
}
