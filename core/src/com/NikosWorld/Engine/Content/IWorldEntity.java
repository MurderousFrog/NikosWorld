package com.NikosWorld.Engine.Content;

/**
 * Created by Niko on 07.12.2015.
 */
public interface IWorldEntity {
    public String ID = "";
    public void update(float delta);
    public void render(float delta);
    public void changeOwner(WorldEntity newOwner);
    public void destroy();
}
