package game.scenes;

import engine.Controls;
import engine.GameScene;
import engine.audio.Audio;
import engine.objects.Rectangle;
import engine.objects.Text;
import game.Main;
import game.Properties;
import game.scenes.InGameScene;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class MainMenuScene extends GameScene {
    private ArrayList<Text> items;
    int selected = 0;

    public MainMenuScene() {
        super();
        add(new Rectangle(0,0, Properties.width,Properties.height, Color.BLACK));
        items = new ArrayList<>();
        items.add(new Text(Properties.width/2-200, Properties.height/2-180, "PLAY", 50));
        items.add(new Text(Properties.width/2-250, Properties.height/2-100, "SETTINGS", 50));
        items.add(new Text(Properties.width/2-200, Properties.height/2-20, "QUIT", 50));
        items.forEach(i -> add(i));
    }

    private int cooldown=0;
    private int coolup=0;
    @Override
    public void update() {
        if(Controls.getControls().getVertical()==-1) {
            if(cooldown==0) {
                cooldown = 15;
                selected=selected==items.size()-1?0:selected+1;
                Audio.getInstance().playSound(Audio.Sound.CLICK);
            } else cooldown--;
        } else cooldown=0;

        if(Controls.getControls().getVertical()==1) {
            if(coolup==0) {
                coolup = 15;
                selected=selected==0?items.size()-1:selected-1;
                Audio.getInstance().playSound(Audio.Sound.CLICK);
            } else {coolup--;}
        } else coolup=0;

        for(int i = 0; i<items.size(); i++) {
            if(i==selected) {
                items.get(i).setColor(Color.RED);
            } else {
                items.get(i).setColor(Color.WHITE);
            }
        }


        if(Controls.getControls().isKeyPressed(KeyCode.SPACE) || Controls.getControls().isKeyPressed(KeyCode.ENTER)) {
            Audio.getInstance().playSound(Audio.Sound.BING);
            switch (selected) {
                case 0:
                    Main.setScene(new InGameScene());
                    break;
                case 1:
                    Main.setScene(new SettingsScene());
                    break;
                case 2:
                    Platform.exit();
                    break;
            }
        }

        super.update();
    }
}
