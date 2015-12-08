package com.NikosWorld.Game.States;

import com.NikosWorld.Engine.Managers.EntityManager;
import com.NikosWorld.Engine.State.GameState;
import com.NikosWorld.Game.Entities.ImmovableObject;
import com.NikosWorld.Game.Entities.Player.Player;
import com.NikosWorld.Game.Entities.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

/**
 * Created by Niko on 07.12.2015.
 */
public class Game extends GameState{

    private World world;
    private Box2DDebugRenderer b2dr;
    private Player player;
    private ImmovableObject platform;
    private SpriteBatch batch;
    private Texture texture;

    public Game(){}

    @Override
    public void create() {
        super.create();

        world = new World(null, new Vector2(0, -9.81f), false);
        b2dr = new Box2DDebugRenderer();

        player = new Player(world);
        platform = new ImmovableObject(world);

        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("assets/droplet.png"));
    }

    @Override
    public void resize() {
        super.resize();
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render() {
        super.render();

       /* Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(texture,player.getPosition().x * PPM - (texture.getWidth() / 2), player.getPosition().y * PPM - (texture.getHeight() / 2));
        batch.end();

        b2dr.render(world,camera.combined.scl(PPM));

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
            Gdx.app.exit();*/
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
