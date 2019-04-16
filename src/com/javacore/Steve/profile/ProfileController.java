package com.javacore.Steve.profile;

import com.javacore.Steve.common.Canvas;
import com.javacore.Steve.common.ConsoleCanvas;

public class ProfileController {

    //private ProfileModel model;
    private ProfileView view;
    private Canvas canvas;

    // Static block will be executed before any logical blocks or constructors.
    static {
        ProfileStore.INSTANCE.loadRandomGeneratedProfiles(100);
    }

    {
        // ConsoleCanvas by default.
        //canvas = new ConsoleCanvas();
        view = new ProfileView();
    }

    public void showProfile(int id) {
        ProfileModel profileModel = ProfileStore.INSTANCE.getProfile(id);
        if (profileModel == null) {
            System.out.println("No record with ID " + id);
        } else {
            view.setModel(profileModel);
            view.draw(canvas);
        }
    }

//        public ProfileModel getModel() {
//        return model;
//    }

//    public void setModel(ProfileModel model) {
//        this.model = model;
//    }

//    public ProfileView getView() {
//        return view;
//    }

//    public void setView(ProfileView view) {
//        this.view = view;
//    }
}
