package ci553.happyshop.utility;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

/*
As some of the buttons were quite boring, made the program feel quite barebones,
I made buttonStyles to incorporate button animations. Parts of UI style that are overridden by this
are kept as a backup in case the animation fails
*/


public class ButtonStyles extends ButtonSkin {
    public ButtonStyles(Button control) {
        super(control);
        control.setBackground(new Background(new BackgroundFill(Color.color(0, 0, 0,0), CornerRadii.EMPTY, Insets.EMPTY))); //defailt transparent background
        control.setBorder(Border.stroke(Paint.valueOf("BLACK")));
        control.setTextFill(Color.BLACK);
        control.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;"); //setting details of font size and weight
        
        final Animation enterAnimation = new Transition() {
            {
                setCycleDuration(Duration.millis(100)); //transition duration
            }

            @Override
            protected void interpolate(double progress) {
                final double total = control.getWidth() / 2.0; //half of button width as working from middle
                final double current = (1.0 - progress) * total;
                control.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, CornerRadii.EMPTY, new Insets(current, current, current, current))));

            }
        };
        control.setOnMouseEntered(e -> enterAnimation.playFromStart());//play animation when hovered on button



        final Animation exitAnimation = new Transition() {
            {
                setCycleDuration(Duration.millis(300));//transition duration
            }
            @Override
            protected void interpolate(double progress) {
                final double total =  control.getWidth() / 2.0; //half of button width as working from middle
                final double current = (1.0 - progress) * total;
                control.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, CornerRadii.EMPTY, new Insets(current, current, current, current))));

            }
            
        };
        exitAnimation.setRate(-1); //reverse the animation

        control.setOnMouseExited(e -> exitAnimation.playFrom(Duration.millis(300)));//play animation BACKWARDS when hovered on button
        
    }   
    

}
