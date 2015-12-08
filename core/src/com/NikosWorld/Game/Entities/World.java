package com.NikosWorld.Game.Entities;

import com.NikosWorld.Engine.Content.WorldEntity;
import com.NikosWorld.Engine.Managers.EntityManager;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Niko on 07.12.2015.
 */
public class World extends WorldEntity {
    private com.badlogic.gdx.physics.box2d.World box2dworld;

    public World(WorldEntity owner, Vector2 gravity,Boolean bool) {
        super( EntityManager.getNewID(), owner);
        this.box2dworld = new com.badlogic.gdx.physics.box2d.World(gravity,bool);
    }
}
