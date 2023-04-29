import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;

import com.dexcom.cgm.library.DexcomCGM;
import com.dexcom.cgm.library.models.GlucoseReading;

public class DexcomLocationBasedGame extends UnityPlayerActivity {

    private GoogleFitAPI fitbitAPI;
    private DexcomCGM dexcomCGM;
    private GameEngine gameEngine;
    private SpriteBatch spriteBatch;
    private OrthographicCamera camera;
    private User user;
    private List<GameObject> gameObjects = new ArrayList<>();

    @Override
    public void create() {
        fitbitAPI = new GoogleFitAPI();
        dexcomCGM = new DexcomCGM();
        gameEngine = new GameEngine();
        spriteBatch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        camera.update();

        user = fitbitAPI.getUser();
        Location location = fitbitAPI.getLocation(user);
        gameObjects.add(new GameObject(location.getLatitude(), location.getLongitude()));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);

        gameEngine.update(gameObjects);
        gameEngine.render(spriteBatch);
    }

    @Override
