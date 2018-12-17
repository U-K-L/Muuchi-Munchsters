package VisionGoggles;

import Prefabs.Tile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.HashMap;

public class RenderMaps {

    public float tileHeight;
    public float tileWidth;
    public float tileSize = 164f;
    public float tileAxis = 120f;//126.89f;
    public int tileAmount = 8;
    public Scene scene;
    public ArrayList<Tile> tiles = new ArrayList<Tile>();
    public ArrayList<TileNode> nodes = new ArrayList<TileNode>();
    private float[] debugFunction;
    public 	float angle = 0f;
    private boolean GridOn = true;

    public ShapeRenderer shapeRenderer;
    public HashMap<Integer, TileNode> graphMap;

    public RenderMaps(Scene scene){
        float tileAngle = 180-tileAxis;
        tileWidth = tileSize;
        tileHeight = (float)(tileSize*Math.tan(Math.toRadians(tileAngle/2)));
        this.scene = scene;
        graphMap = new HashMap<Integer, TileNode>();
    }


    float[] drawTile(float x, float y, float z, int index){
        x = x*-1;
        y = y*-1;
        //Translational Matrix.
        float[] t = new float[]{
                1f,0f,0,
                0f,1f,0,
                (x-y) * (tileWidth/2), (y+x) * (tileHeight/2), 0f};
        Matrix3 T = new Matrix3(t);
        //Point Matrix, that represents origin to be translated.
        float[] p = new float[]{
                Gdx.graphics.getWidth()/2, 0f, 1f,
                0f,Gdx.graphics.getHeight(), 1f,
                0, 0, 0f};
        Matrix3 point = new Matrix3(p);

        T = T.mul(point);
        //Convert to a 2D vector. Take the x,y identity coordinates.
        Vector2 points = new Vector2(T.getValues()[0], T.getValues()[4]);
        float[] vertexO = new float[]{};

        if(GridOn) {
            float[] vertex = new float[]{
                    0 + points.x, 0 + points.y, //Top center.
                    (tileWidth / 2) + points.x, (tileHeight / 2) + points.y, //Far right corner.
                    (0) + points.x, (tileHeight) + points.y, //Bottom.
                    (-tileWidth / 2) + points.x, (tileHeight / 2) + points.y,//Left corner.
            };
            vertexO = vertex;
        }
        placeBlock(points, x, y, index);
        return vertexO;

    }

    public void placeBlock(Vector2 points, float x, float y, int index){
        if(tiles.size() > index) {
            Tile tile = tiles.get(index);
            TileNode node = new TileNode(index, (int)tile.dimension.Height, tile);
            tile.dimension.drawBlock(points.x, points.y, x, y, tile.dimension.Height);
            graphMap.put(index, node);
            nodes.add(index, node);
        }
    }

    public void addToGraph(int index, TileNode node){

        node.addRightNode(nodes, node);
    }

    public void addAllToGraph(float[][] mapMatrix){
        for(int key : graphMap.keySet()){
            TileNode node = graphMap.get(key);
            node.addRightNode(nodes, node);
            node.addLEFTNode(nodes, node);
            //node.addUPNode(tiles, mapMatrix);
            //node.addDOWNNode(tiles, mapMatrix);
        }

    }

    public void RenderMatrix(float[][] mapMatrix){
        int index = 0;
        for(int i = 0; i < mapMatrix[0].length; i++){
            for(int j = 0; j < mapMatrix[1].length; j++) {
                createBlock(index, (int) mapMatrix[i][j]);
                //if ((int) mapMatrix[i][j] > 0){
                    drawTile((float) j, (float) i, mapMatrix[i][j], index);
                 //}
                index++;
            }
        }
        addAllToGraph(mapMatrix);
    }

    public void createBlock(int i, int h){
        Tile tile = new Tile();
        tile.dimension.Height = h;
        if(h >= 1);
        else
            tile.setShow(false);
        for(int index = 0; index < tile.dimension.Height; index++){
            GameObject obj = new GameObject(tile.x, tile.y, index+2, tile.getTexturePath(), "blocks");
            tile.addBlock(obj, scene);
        }
        tiles.add(tile);
        tile.addSelf(scene);
    }



    public void create(){
        shapeRenderer = new ShapeRenderer();
        for(int x = -tileAmount; x <= tileAmount; x++){
            for(int y = -tileAmount; y <= tileAmount; y++){
                Tile tile = new Tile();
                tile.dimension.Height =(float)Math.floor(Math.random()*4);
                for(int i = 0; i < tile.dimension.Height; i++){
                    tile.addBlock(new GameObject(tile.x, tile.y, i+2, tile.getTexturePath(), "blocks"), scene);
                }
                tiles.add(tile);
                tile.addSelf(scene);
            }
        }
    }


    public void RenderLines(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.BLACK);
        //RenderWaves(shapeRenderer);
        int index = 0;
        for(int x = -tileAmount; x <= tileAmount; x++){
            for(int y = -tileAmount; y <= tileAmount; y++){

                if(GridOn)
                    shapeRenderer.polygon(drawTile((float)x, (float)y, -index, index));
                else
                    drawTile((float)x, (float)y, -index, index);
                index++;
            }

        }
        shapeRenderer.end();
    }

    public void RenderWaves(ShapeRenderer shape){
        angle += 0.1f;
        shapeRenderer.line(-Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2f);
        shapeRenderer.line(0.0f, -Gdx.graphics.getHeight(), 0.0f, Gdx.graphics.getHeight());
        shapeRenderer.polygon(drawTile(20f*(float)Math.cos(angle),0f, 0f, 0));
        shapeRenderer.polygon(drawTile(0f,20f*(float)Math.sin(angle), 0f, 0));
        shapeRenderer.polygon(drawTile(20*(float)Math.cos(angle), 7*(float)Math.sin(angle), 0f, 0));
        shapeRenderer.polygon(drawTile(20*(float)Math.sin(angle), 7*(float)Math.cos(angle), 0f, 0));
        shapeRenderer.polyline(debugFunction);
        shapeRenderer.rect(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 50.3f, 50.8f);
    }
}
