package com.nila.profiles.controller;

import com.nila.profiles.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    private Environment env;

    @Value("${spring.profiles.active:}")
    private String activeProfiles;

    @Autowired
    AppProperties appProperties;

    @GetMapping("/env")
    public String getActiveProfile() {
        StringBuilder profiles = new StringBuilder();
        for (String profile : env.getActiveProfiles()) {
            profiles.append(profile);
            profiles.append(" ");
        }
        profiles.append("through Environment");
        return profiles.toString();
    }

    @GetMapping("/val")
    public String getActiveProfiles() {
        StringBuilder profiles = new StringBuilder();
        for (String profile : activeProfiles.split(",")) {
            profiles.append(profile);
            profiles.append(" ");
        }
        profiles.append("through @Value");
        return profiles.toString();
    }

    @GetMapping("/app")
    public String getAppDetails() {
        StringBuilder details = new StringBuilder();
        details.append(appProperties.getName());
        details.append(appProperties.getPort());
        return details.toString();
    }
}
