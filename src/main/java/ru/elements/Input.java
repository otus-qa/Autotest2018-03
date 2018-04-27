package ru.elements;

import org.openqa.selenium.By;

public class Input {

    By by;

    public Input(By by) {
        if (by == null) {
            throw new IllegalArgumentException("");
        }
        this.by = by;
    }

    public void sendKeys(String text) {

    }
}
