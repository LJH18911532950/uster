package com.example.umeng.utils;

import com.example.umeng.app.MyApp;

import java.io.File;

public class Constants {
    public static final String PATH_DATA = MyApp.app.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_IMGS = PATH_DATA + "/tp/imgs";
}
