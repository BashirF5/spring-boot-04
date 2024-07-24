package az.edu.turing.az.springboot04jdbc_template.controller;

import az.edu.turing.az.springboot04jdbc_template.model.Profile;
import az.edu.turing.az.springboot04jdbc_template.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/create-profile")
    public ResponseEntity<Void> createProfile(@RequestBody Profile profile) {
        profileService.createProfile(profile);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-profiles")
    public ResponseEntity<List<Profile>> getProfiles() {
        List<Profile> profiles = profileService.getProfiles();
        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/get-profile/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable UUID id) {
        Profile profile = profileService.getProfileById(id);
        return ResponseEntity.ok(profile);
    }

    @PutMapping("/update-profile")
    public ResponseEntity<Void> updateProfile(@RequestBody Profile profile) {
        profileService.updateProfile(profile);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-all-profiles")
    public ResponseEntity<Void> deleteAllProfiles() {
        profileService.deleteAllProfiles();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-profile-count")
    public ResponseEntity<Integer> getProfileCount() {
        int count = profileService.getProfileCount();
        return ResponseEntity.ok(count);
    }
}
