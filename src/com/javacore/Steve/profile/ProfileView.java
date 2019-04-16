package com.javacore.Steve.profile;

import com.javacore.Steve.common.BaseView;
import com.javacore.Steve.common.Canvas;
import com.javacore.Steve.common.ConsoleCanvas;

/**
 * Prints or draws criminal profile from model.
 */
public class ProfileView extends BaseView {

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText("Criminal profile: ");
        canvas.drawText("ID: " + ((ProfileModel)model).getId());
        canvas.drawText("Name: " + ((ProfileModel)model).getName());
        canvas.drawText("Active: " + ((ProfileModel)model).isActive());
    }
}
