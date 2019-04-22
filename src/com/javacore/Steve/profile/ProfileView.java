package com.javacore.Steve.profile;

import com.javacore.Steve.common.BaseView;
import com.javacore.Steve.common.Canvas;
import com.javacore.Steve.common.ConsoleCanvas;

/**
 * Prints or draws criminal profile from model.
 */
public class ProfileView extends BaseView {

    @Override
    public void drawProfile(Canvas canvas) {
//        canvas.drawText("Criminal profile: ");
//        canvas.drawText("ID: " + ((ProfileModel)model).getId());
//        canvas.drawText("Name: " + ((ProfileModel)model).getName());
//        canvas.drawText("Active: " + ((ProfileModel)model).isActive());
    }

    public void drawProfile(ConsoleCanvas consoleCanvas) {
        int leftSpace = 2;
        Integer currentTextString = 2;

        int photoXCoordinate = consoleCanvas.getWidth()/2 + leftSpace;
        consoleCanvas.setSquareAt(photoXCoordinate, 2, 24);
        consoleCanvas.setCircleAt(photoXCoordinate + 7, 4, 5);
        consoleCanvas.setSquareAt(photoXCoordinate + 5, 9, 14);

        currentTextString = consoleCanvas.setTextAt(
                leftSpace,
                currentTextString,
                ((ProfileModel)model).getName()
        ) + 2;

        currentTextString = consoleCanvas.setTextAt(
                leftSpace,
                currentTextString,
                "Born: " + ((ProfileModel)model).getDateOfBirth() + " " + ((ProfileModel)model).getPlaceOfBirth()
        ) + 2;

        currentTextString = consoleCanvas.setTextAt(
                leftSpace,
                currentTextString,
                "Died: " + ((ProfileModel)model).getDateOfDeath() + " " + ((ProfileModel)model).getPlaceOfDeath()
        ) + 2;

        currentTextString = consoleCanvas.setTextAt(
                leftSpace,
                currentTextString,
                "Nickname: " + ((ProfileModel)model).getNickname()
        ) + 2;

        // TODO: Make OtherMembers.
        currentTextString = consoleCanvas.setTextAt(
                leftSpace,
                currentTextString,
                "Criminal family: " + ((ProfileModel)model).getCriminalFamily()
        ) + 2;

        currentTextString = consoleCanvas.setTextAt(
                leftSpace,
                currentTextString,
                "DNA Sample: " + ((ProfileModel)model).getdNA()
        ) + 2;

        currentTextString = consoleCanvas.setTextAt(
                leftSpace,
                currentTextString,
                "What we know about him: " + ((ProfileModel)model).getDescription()
        ) + 2;

        consoleCanvas.draw();
    }
}
