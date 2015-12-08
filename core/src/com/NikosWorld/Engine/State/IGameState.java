package com.NikosWorld.Engine.State;

/**
 * Created by Niko on 07.12.2015.
 */
public interface IGameState {
    public void create();
    public void render();
    public void update();
    public void resize();
    public void dispose();
    public void pause();
    public void resume();
}
