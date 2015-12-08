package com.NikosWorld.Game.Entities;

import com.NikosWorld.Engine.Content.WorldEntity;
import com.NikosWorld.Engine.Managers.EntityManager;

/**
 * Created by Niko on 08.12.2015.
 */
public class ImmovableObject extends WorldEntity {
    public ImmovableObject(WorldEntity owner) {
        super(EntityManager.getNewID(), owner);
    }
}
