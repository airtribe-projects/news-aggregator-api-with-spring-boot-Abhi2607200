package com.airtribe.aggregatorApi.Controller;

import com.airtribe.aggregatorApi.DTO.PreferenceRequest;
import com.airtribe.aggregatorApi.DTO.PreferenceResponse;
import com.airtribe.aggregatorApi.Entity.NewsPreference;
import com.airtribe.aggregatorApi.Entity.User;
import com.airtribe.aggregatorApi.Entity.user;
import com.airtribe.aggregatorApi.Security.JwtUtil;
import com.airtribe.aggregatorApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/preferences")
public class PreferenceController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public PreferenceResponse getPreferences(@RequestHeader("Authorization") String token) {
        String username = jwtUtil.extractUsername(token.substring(7));
        user user = userRepository.findByUsername(username).orElseThrow();
        NewsPreference pref = user.getPreferences();
        return new PreferenceResponse(pref.getCategory(), pref.getLanguage(), pref.getCountry());
    }

    @PutMapping
    public ResponseEntity<?> updatePreferences(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody PreferenceRequest preferenceRequest) {

        String username = jwtUtil.extractUsername(token.substring(7));
        user user = userRepository.findByUsername(username).orElseThrow();

        NewsPreference newPrefs = new NewsPreference(preferenceRequest.getCategory(), preferenceRequest.getLanguage(), preferenceRequest.getCountry());
        user.setPreferences(newPrefs);
        userRepository.save(user);

        return ResponseEntity.ok("Preferences updated");
    }
}
