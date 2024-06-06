package com.zichengliang.shanghaiisolation;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class SIGame extends ApplicationAdapter {
	ShapeRenderer shape;
	Ball ball;
	Paddle paddle;
	ArrayList<Block> blocks = new ArrayList<>();

	@Override
	public void create(){
		shape = new ShapeRenderer();
		ball = new Ball(50, 50, 10, 12, 5);
		paddle = new Paddle(20, 20, 100, 10);

		int blockWidth = 63;
		int blockHeight = 20;
		for (int y = Gdx.graphics.getHeight() / 2; y < Gdx.graphics.getHeight(); y += blockHeight + 10){
			for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10){
				blocks.add(new Block(x, y, blockWidth, blockHeight));
			}
		}
	}

	@Override
	/** render() runs every frame */
	public void render(){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // set the screen back to black

		ball.update();
		paddle.update();
		ball.checkCollision(paddle);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.draw(shape);
		paddle.draw(shape);

		for (Block block: blocks) {
			block.draw(shape);
			ball.checkCollision(block);
		}
		for (int i = 0; i < blocks.size(); i++){
			Block block = blocks.get(i);
			if(block.destroyed){
				blocks.remove(block);
				i--;
			}
		}
		// in LibGDX, (0, 0) is the bottom left;
		shape.end();
	}
}
