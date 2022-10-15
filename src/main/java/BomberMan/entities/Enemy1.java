package BomberMan.entities;

import BomberMan.Map.Map;
import BomberMan.constValue.State;
import BomberMan.constValue.constValue;
import BomberMan.graphics.Sprite;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class Enemy1 extends Entity {
    private int frame = 0;
    private State state;

    private Point2D moveXY = new Point2D(0, 0);

    public Enemy1(){
        super();
        frame = 0;
        state = State.LEFT;
    }

    public void setFrame(int val) {
        frame = val;
    }

    public void update() {
        if (!isAlive) {
            return;
        }
        switch (state) {
            case LEFT:
                this.moveXY = new Point2D(-constValue.ENEMY1_SPEED, 0);
                this.move(moveXY);
                break;
            case RIGHT:
                this.moveXY = new Point2D(constValue.ENEMY1_SPEED, 0);
                this.move(moveXY);
                break;
            case UP:
                this.moveXY = new Point2D(0, -constValue.ENEMY1_SPEED);
                this.move(moveXY);
                break;
            case DOWN:
                moveXY = new Point2D(0, constValue.ENEMY1_SPEED);
                this.move(moveXY);
                break;
            default:
                break;
        }
        calculateState();
//            this.checkToMap();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void drawEnemy1Die(GraphicsContext gc) { // Ve quai luc chet
        frame++;
        if (frame >= 0 && frame < 9) {
            gc.drawImage(Sprite.balloom_dead.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
        } else if (frame >= 9 && frame < 18) {
            gc.drawImage(Sprite.mob_dead1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
        } else if (frame >= 18 && frame < 27) {
            gc.drawImage(Sprite.mob_dead2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
        } else if (frame >= 27 && frame < 36) {
            gc.drawImage(Sprite.mob_dead3.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
        }
    }

    public void drawEnemy1(GraphicsContext gc) {
        frame++;
        if(frame>=12) frame = 0;
        if (!isAlive) {
            return;
        }
        switch (state) {
            case STOP:
                gc.drawImage(Sprite.balloom_left1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                break;
            case UP:
                if (frame >=0 && frame < 4){
                    gc.drawImage(Sprite.balloom_left1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >= 4 && frame <8) {
                    gc.drawImage(Sprite.balloom_left2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >=8 && frame < 12) {
                    gc.drawImage(Sprite.balloom_left3.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                }
                break;
            case DOWN:
                if (frame >=0 && frame < 4){
                    gc.drawImage(Sprite.balloom_right1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >= 4 && frame < 8) {
                    gc.drawImage(Sprite.balloom_right2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >= 8 && frame < 12) {
                    gc.drawImage(Sprite.balloom_right3.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                }
                break;
            case LEFT:
                if (frame >=0 && frame < 4){
                    gc.drawImage(Sprite.balloom_left1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >= 4 && frame < 8) {
                    gc.drawImage(Sprite.balloom_left2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >=8 && frame < 12) {
                    gc.drawImage(Sprite.balloom_left3.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                }
                break;
            case RIGHT:
                if (frame >=0 && frame < 4){
                    gc.drawImage(Sprite.balloom_right1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >= 4 && frame < 8) {
                    gc.drawImage(Sprite.balloom_right2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >= 8 && frame < 12) {
                    gc.drawImage(Sprite.balloom_right3.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                }
                break;
            case DIE:
//                if (frame >=0 && frame < 2){
//                    gc.drawImage(Sprite.balloom_dead.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
//                } else if (frame >= 2 && frame < 4) {
//                    gc.drawImage(Sprite.mob_dead1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
//                } else if (frame >= 4 && frame < 6) {
//                    gc.drawImage(Sprite.mob_dead2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
//                } else if (frame >= 6) {
//                    gc.drawImage(Sprite.mob_dead3.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
//                }
                isAlive = false;
                break;
        }
    }

    public void calculateState() {
        int x1 = (int) ((this.getPosition().getX()) / constValue.ENTITY_SIZE);
        int x2 = (int) ((this.getPosition().getX() + constValue.ENTITY_SIZE - 10) / constValue.ENTITY_SIZE); // Frame_size - 10) / ...
        int y1 = (int) ((this.getPosition().getY()) / constValue.ENTITY_SIZE);
        int y2 = (int) ((this.getPosition().getY() + constValue.ENTITY_SIZE - 5) / constValue.ENTITY_SIZE);
        if (moveXY.getX() > 0) {
            if (Map.mapTitle[y2][x2] != constValue.GLASS || Map.mapTitle[y1][x2] != constValue.GLASS) {
                this.setPosition((float) (x1 * constValue.ENTITY_SIZE + constValue.ENTITY_SIZE - constValue.ENTITY_SIZE + 9), (float) (this.getPosition().getY()));
                moveXY = new Point2D(0, 0);
            }
        } else if (moveXY.getX() < 0) {
            if (Map.mapTitle[y1][x1] != constValue.GLASS || Map.mapTitle[y2][x1] != constValue.GLASS) {
                this.setPosition((float) ((x1 + 1) * constValue.ENTITY_SIZE), (float) (this.getPosition().getY()));
                moveXY = new Point2D(0, 0);
            }
        } else if (moveXY.getY() > 0) {
            if (Map.mapTitle[y2][x1] != constValue.GLASS || Map.mapTitle[y2][x2] != constValue.GLASS) {
                this.setPosition((float) (this.getPosition().getX()), (float) (y1 * constValue.ENTITY_SIZE + constValue.ENTITY_SIZE - constValue.ENTITY_SIZE));
                moveXY = new Point2D(0, 0);
            }
        } else if (moveXY.getY() < 0) {
            if (Map.mapTitle[y1][x1] != constValue.GLASS || Map.mapTitle[y1][x2] != constValue.GLASS) {
                this.setPosition((float) (this.getPosition().getX()), (float) ((y1 + 1) * constValue.ENTITY_SIZE));
                moveXY = new Point2D(0, 0);
            }
        }
        if (moveXY.getX() == 0 && moveXY.getY() == 0) { // Random vi tri di chuyen
            Random generator = new Random();
            int cal = generator.nextInt();
            switch (cal % 4) {
                case 0 -> {
                    state = State.RIGHT;
                    break;
                }
                case 1 -> {
                    state = State.DOWN;
                    break;
                }
                case 2 -> {
                    state = State.LEFT;
                    break;
                }
                case 3 -> {
                    state = State.UP;
                    break;
                }
            }

        }
    }

}