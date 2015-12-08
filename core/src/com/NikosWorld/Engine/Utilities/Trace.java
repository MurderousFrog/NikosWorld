package com.NikosWorld.Engine.Utilities;

import com.badlogic.gdx.Gdx;

/**
 * Created by Niko on 07.12.2015.
 */
public class Trace {
    private static Trace ourInstance = new Trace();

    public static Trace getInstance() {
        return ourInstance;
    }

    private Trace() {
    }

    public static void setLogLevel(int loglevel){
        Gdx.app.setLogLevel(loglevel);
    }

    public static void log(String message){
        Gdx.app.log("",message);
    }
    public static void error(String message){
        Gdx.app.error("",message);
    }
    public static void debug(String message){
        Gdx.app.debug("",message);
    }
}
