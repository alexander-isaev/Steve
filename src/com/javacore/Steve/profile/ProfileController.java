package com.javacore.Steve.profile;

import com.javacore.Steve.common.Canvas;
import com.javacore.Steve.common.ConsoleCanvas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfileController {

    //private ProfileModel model;
    private ProfileView view;
    private Canvas canvas;

    // Static block will be executed before any logical blocks or constructors.
    static {
        //ProfileStore.INSTANCE.loadRandomGeneratedProfiles(100);
        // JUST FOR TEST:
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            ProfileStore.INSTANCE.loadProfile(new ProfileModel(1, "Dante", "Calabresi-Jr", null,1, simpleDateFormat.parse("01.01.1975"), null, true, simpleDateFormat.parse("16.10.2012"), "Highly dangerous. Was killed in 2012 by officer McKinzy."));
        } catch (Exception e) {

        }
    }

    {
        canvas = new ConsoleCanvas(60, 80);
        view = new ProfileView();
    }

    public void showProfile(int id) {
        ProfileModel profileModel = ProfileStore.INSTANCE.getProfile(id);
        if (profileModel == null) {
            System.out.println("No record with ID " + id);
        } else {
            view.setModel(profileModel);
            view.drawProfile((ConsoleCanvas)canvas);
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
