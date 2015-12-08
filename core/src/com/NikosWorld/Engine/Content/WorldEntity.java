package com.NikosWorld.Engine.Content;

import com.NikosWorld.Engine.Components.AudioComponent;
import com.NikosWorld.Engine.Components.GraphicsComponent;
import com.NikosWorld.Engine.Components.Input.InputComponent;
import com.NikosWorld.Engine.Components.PhysicsComponent;

/**
 * Created by Niko on 07.12.2015.
 */
public class WorldEntity implements IWorldEntity{

    protected InputComponent inputComponent;
    protected AudioComponent audioComponent;
    protected GraphicsComponent graphicsComponent;
    protected PhysicsComponent physicsComponent;
    protected WorldEntity owner;
    public Long ID;


    public WorldEntity(long id, WorldEntity owner){
        this.ID = id;
        this.owner = owner;
        this.inputComponent = new InputComponent();
        this.audioComponent = new AudioComponent();
        this.graphicsComponent = new GraphicsComponent();
        this.physicsComponent = new PhysicsComponent();
    }

    @Override
    public void update(float delta) {
        inputComponent.update();
        physicsComponent.update(delta);
    }

    @Override
    public void render(float delta) {
        graphicsComponent.render(delta);
    }

    @Override
    public void changeOwner(WorldEntity newOwner) {
        this.owner = newOwner;
    }

    @Override
    public void destroy() {

        this.dispose();
    }

    protected void dispose() {

    }
}
