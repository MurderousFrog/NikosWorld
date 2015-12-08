package com.NikosWorld.Engine.Managers;

import com.NikosWorld.Engine.Utilities.Trace;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Niko on 07.12.2015.
 */
public class EntityManager {
    private static EntityManager ourInstance = new EntityManager();
    public static EntityManager getInstance() {
            return ourInstance;
        }

    private static ArrayList<Long> entities;
    private static Random rnd;

    private EntityManager(){
        entities = new ArrayList<Long>();
        rnd = new Random();
    }

    public static long getNewID(){
        Long id;
        do{
            id = rnd.nextLong();
        }
        while(entities.contains(id));
        entities.add(id);
        Trace.debug("New entity ID issued: " + id);
        return Long.valueOf(id);
    }

    public static int existingEntities(){
        return entities.size();
    }

}
