package com.NikosWorld.Game.Entities.Player;

import com.NikosWorld.Engine.Content.WorldEntity;
import com.NikosWorld.Engine.Managers.EntityManager;

/**
 * Created by Niko on 07.12.2015.
 */
public class Player extends WorldEntity {

    public Player(WorldEntity owner) {
        super(EntityManager.getNewID(), owner);
    }

}
