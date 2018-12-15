package VisionGoggles;

import Prefabs.Tile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class RenderMaps {

    public float tileHeight;
    public float tileWidth;
    public float tileSize = 128f;
    public float tileAxis = 120f;//126.89f;
    public int tileAmount = 1;
    public Scene scene;
    public ArrayList<Tile> tiles = new ArrayList<Tile>();
    private float[] debugFunction;
    public 	float angle = 0f;

    public ShapeRenderer shapeRenderer;

    public RenderMaps(Scene scene){
        float tileAngle = 180-tileAxis;
        tileWidth = tileSize;
        tileHeight = (float)(tileSize*Math.tan(Math.toRadians(tileAngle/2)));
        this.scene = scene;
    }

    public void create(){
        shapeRenderer = new ShapeRenderer();
        for(int x = -tileAmount; x < tileAmount; x++){
            for(int y = -tileAmount; y < tileAmount; y++){
                Tile tile = new Tile();
                tiles.add(tile);
                scene.addObjects(tile);
            }
        }
    }


    public void RenderLines(){
        angle += 0.1f;
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.BLACK);
        //shapeRenderer.line(-Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2f);
        //shapeRenderer.line(0.0f, -Gdx.graphics.getHeight(), 0.0f, Gdx.graphics.getHeight());
        //shapeRenderer.polygon(drawTile(20*(float)Math.cos(angle),0));
        //shapeRenderer.polygon(drawTile(0,20*(float)Math.sin(angle)));
        //shapeRenderer.polygon(drawTile(20*(float)Math.cos(angle), 7*(float)Math.sin(angle)));
        //shapeRenderer.polygon(drawTile(20*(float)Math.sin(angle), 7*(float)Math.cos(angle)));
        int index = 0;
        for(int x = -tileAmount; x < tileAmount; x++){
            for(int y = -tileAmount; y < tileAmount; y++){

                shapeRenderer.polygon(drawTile((float)x, (float)y, index));
                index++;
            }
        }
        //shapeRenderer.polyline(debugFunction);
        //shapeRenderer.rect(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 50.3f, 50.8f);
        shapeRenderer.end();
    }


    float[] drawTile(float x, float y, int index){
        //Translational Matrix.
        float[] t = new float[]{
                1f,0f,0,
                0f,1f,0,
                (x-y) * (tileWidth/2), (y+x) * (tileHeight/2), 0f};
        Matrix3 T = new Matrix3(t);
        //Point Matrix, that represents origin to be translated.
        float[] p = new float[]{
                Gdx.graphics.getWidth()/2, 0f, 1f,
                0f,Gdx.graphics.getHeight()/2, 1f,
                0, 0, 0f};
        Matrix3 point = new Matrix3(p);

        T = T.mul(point);
        //Convert to a 2D vector. Take the x,y identity coordinates.
        Vector2 points = new Vector2(T.getValues()[0], T.getValues()[4]);

        float[] vertex = new float[]{
                0+ points.x , 0 + points.y, //Top center.
                (tileWidth/2) + points.x, (tileHeight/2) + points.y, //Far right corner.
                (0) + points.x, (tileHeight) + points.y, //Bottom.
                (-tileWidth/2) + points.x, (tileHeight/2) + points.y,//Left corner.
        };

        if(tiles.size() > index) {
          //  tiles.get(index).dimension.drawTile((points.x + ((x-y) * (tiles.get(index).getwidth()/8)))-(tiles.get(index).getwidth()/2),
           //         (points.y + ((x+y) * (tiles.get(index).getheight()/8))));

            tiles.get(index).dimension.drawTile(points.x, points.y, x, y);
        }
        return vertex;

    }
}
