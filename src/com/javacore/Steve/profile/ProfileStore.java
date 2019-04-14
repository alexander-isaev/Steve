package com.javacore.Steve.profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores criminal profiles via model instances.
 */
public enum ProfileStore {
    INSTANCE;

    Map<Integer, ProfileModel> profiles;

    // Logical block. Executes before any constructor.
    {
        profiles = new HashMap<>();
    }

    // Actually there will be less then numberOfProfiles.
    public void loadRandomGeneratedProfiles(int numberOfProfiles) {
        for (int i = 0; i < numberOfProfiles; i++) {
            ProfileModel model = ProfileModel.randomModel();
            profiles.put(model.getId(), model);
        }
    }

    public void loadProfile(ProfileModel model) { profiles.put(model.getId(), model); }

    public ProfileModel getProfile(int id) { return profiles.get(id); }
}
