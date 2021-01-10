package br.com.vtspp;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import br.com.vtspp.world.World;

public class RunGame extends ApplicationAdapter {

	public SpriteBatch batch;
	protected OrthographicCamera orthographicCamera;
	protected Viewport viewport;
	public static final boolean DEBUG = true;
	public static RunGame instance;

	protected World world;

	public RunGame getInstance(){
		return instance = this;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		orthographicCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		orthographicCamera.setToOrtho(false);
		viewport = new FillViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), orthographicCamera);

		world = new World();
		world.regenerate();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		world.render(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
