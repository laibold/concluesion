package com.laibold.concluesion.app;

import com.laibold.concluesion.App;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {

    //CardType.getTranslationString
    @Test
    public void getAppResources_isCorrect() {
        assertNotNull(App.getAppResources());
    }

    @Test
    public void getAppPackageName_isCorrect() {
        assertNotNull(App.getAppPackageName());
        assertNotSame(App.getAppPackageName(), "");
    }

}
