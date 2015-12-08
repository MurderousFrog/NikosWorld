package com.NikosWorld.Engine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;

public class Main extends ApplicationAdapter {
	private boolean DEBUG = false;
	private OrthographicCamera camera;

	private Box2DDebugRenderer b2dr;

	private World world;
	private Body player;
	private Body platform;

	private SpriteBatch batch;
	private Texture texture;

	private static final float PPM = 32f;
	private static final float SCALE = 2f;
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, w / SCALE, h / SCALE);

		world = new World(new Vector2(0, -9.81f), false);
		b2dr = new Box2DDebugRenderer();

		player = createBody(8,10,32,32,false);
		platform = createBody(0,0,64,32,true);

		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("assets/droplet.png"));
	}

	@Override
	public void render () {
		update(Gdx.graphics.getDeltaTime());

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(texture,player.getPosition().x * PPM - (texture.getWidth() / 2), player.getPosition().y * PPM - (texture.getHeight() / 2));
		batch.end();

		b2dr.render(world,camera.combined.scl(PPM));

		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
			Gdx.app.exit();
	}

	private void update(float deltaTime) {
		world.step(1 / 60f, 6, 2);

		inputUpdate(deltaTime);
		cameraUpdate(deltaTime);
		batch.setProjectionMatrix(camera.combined);
	}

	private void inputUpdate(float deltaTime) {
		float horizontalForce = 0;
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			horizontalForce -= 1f;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			horizontalForce += 1f;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
			player.applyForceToCenter(0,50,false);
		}
		player.setLinearVelocity(horizontalForce * 5, player.getLinearVelocity().y);
	}

	private void cameraUpdate(float delta){
		Vector3 position = camera.position;
		position.x = player.getPosition().x * PPM;
		position.y = player.getPosition().y * PPM;
		camera.position.set(position);

		camera.update();

	}

	@Override
	public void resize(int width, int height){
		camera.setToOrtho(false, width / 2, height / 2);
	}

	@Override
	public void dispose(){
		world.dispose();
		b2dr.dispose();
		batch.dispose();
	}

	public Body createBody(int x, int y, int width, int height, boolean isStatic){
		Body pBody;

		BodyDef def = new BodyDef();
		if(isStatic){
			def.type = BodyDef.BodyType.StaticBody;
		}else{
			def.type = BodyDef.BodyType.DynamicBody;
		}

		def.position.set(x / PPM,y / PPM);
		def.fixedRotation = true;
		pBody = world.createBody(def);


		PolygonShape shape = new PolygonShape();
		shape.setAsBox(width / 2 / PPM, height / 2 / PPM);

		pBody.createFixture(shape, 1.0f);
		shape.dispose();

		return pBody;

	}
}
