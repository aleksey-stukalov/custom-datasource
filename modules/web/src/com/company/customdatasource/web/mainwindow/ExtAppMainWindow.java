package com.company.customdatasource.web.mainwindow;

import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.web.app.mainwindow.AppMainWindow;

public class ExtAppMainWindow extends AppMainWindow {

    @Override
    public void ready() {
        super.ready();
        openWindow("currency-screen", WindowManager.OpenType.NEW_TAB);
    }
}
