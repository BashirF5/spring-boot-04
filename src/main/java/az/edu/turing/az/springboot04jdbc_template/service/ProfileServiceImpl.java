package az.edu.turing.az.springboot04jdbc_template.service;

import az.edu.turing.az.springboot04jdbc_template.dao.ProfileDao;
import az.edu.turing.az.springboot04jdbc_template.model.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileDao profileDao;

    public ProfileServiceImpl(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @Override
    public void createProfile(Profile profile) {
        profileDao.createProfile(profile);
    }

    @Override
    public List<Profile> getProfiles() {
        return profileDao.getProfiles();
    }

    @Override
    public Profile getProfileById(UUID id) {
        return profileDao.getProfileById(id);
    }

    @Override
    public void updateProfile(Profile profile) {
        profileDao.updateProfile(profile);
    }

    @Override
    public void deleteAllProfiles() {
        profileDao.deleteAllProfiles();
    }

    @Override
    public int getProfileCount() {
        return profileDao.getProfileCount();
    }
}
