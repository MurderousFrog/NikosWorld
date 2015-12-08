package com.NikosWorld.Engine.Managers;

/**
 * Created by Niko on 07.12.2015.
 */
public class EventManager {
    private static EventManager ourInstance = new EventManager();
    public static EventManager getInstance() {
        return ourInstance;
    }
    private EventManager(){

    }
}
