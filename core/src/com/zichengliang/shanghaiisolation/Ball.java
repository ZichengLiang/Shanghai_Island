package com.zichengliang.shanghaiisolation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;
    Color color = Color.WHITE;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update(){
        x += xSpeed;
        y += ySpeed;
        if ( x - size < 0 || x + size > Gdx.graphics.getWidth()){
            xSpeed = -xSpeed;
        }

        if ( y - size < 0 || y + size > Gdx.graphics.getHeight()){
            ySpeed = -ySpeed;
        }
    }

    public void draw(ShapeRenderer shape){
        shape.setColor(color);
        shape.circle(x, y, size);
    }

    public void checkCollision(Paddle paddle){
        if(collidesWith(paddle)){
            ySpeed = -ySpeed;
        }
    }
    public void checkCollision(Block block){
        if (collidesWith(block)){
            ySpeed = -ySpeed;
            block.destroyed = true;
        }
    }

    private boolean collidesWith(Paddle paddle){
        return (paddle.y + paddle.height >= y - size && paddle.y <= y + size)
                && (x + size >= paddle.x && x - size <= paddle.x + paddle.width);
    }
    private boolean collidesWith(Block block){
        return (block.y + block.height >= y - size && block.y <= y + size)
                && (x + size >= block.x && x - size <= block.x + block.width);
    }
}
