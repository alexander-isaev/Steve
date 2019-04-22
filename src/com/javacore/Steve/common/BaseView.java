package com.javacore.Steve.common;

/**
 * Base class for View classes which should drawProfile (or write in console) everything from Model.
 */
public abstract class BaseView {

    protected BaseModel model;

    public void drawProfile(Canvas canvas) {
        System.out.println("Drawing on canvas should be implemented!");
    }

    public void setModel(BaseModel model) {
        this.model = model;
    }
}
