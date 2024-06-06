package com.zichengliang.shanghaiisolation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int x;
    int y;
    int width;
    int height;
    /** the paddle is drawn from the bottom left */
    public Paddle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update(){
        x = Gdx.input.getX() - width / 2;
    }

    public void draw(ShapeRenderer shape){
        shape.rect(x, y, width, height);
    }
}
