
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author Efe Özavcı
 * @version 1.0
 * @AngryBulletGame This game shows a ball which is doing a projectile motion and whose angle and velocity can be set using the left-right-up and down keys.
 * Once the ball's velocity and angle is set, it may start moving only if space key is pressed. There is some obstacles and targets. The user
 * will try to shoot the targets and avoid obstacles. In any case, the user can press 'r' to shoot again.
 */

public class Main {

    public static void main(String[] args) {
        //Double buffering
        StdDraw.enableDoubleBuffering();

        //Game parameters
        int width = 1600; //screen width
        int height = 800; // screen height
        double gravity = 9.80665; // gravity
        double x0 = 120; // x and y coordinates of the bullet’s starting position on the platform
        double y0 = 120;
        double bulletVelocity = 200; // initial velocity
        double bulletAngle = 45.0; // initial angle

        // Box coordinates for obstacles and targets
        // Each row stores a box containing the following information:
        // x and y coordinates of the lower left rectangle corner, width, and height

        double[][] obstacleArray = {
                {1230, 110, 30, 110},
                {1030, 80, 30, 80},
                {630, 40, 30, 40},
                {630, 260, 30, 80},
                {280, 90, 60, 90}
        };

        double[][] targetArray = {
                {1175, 15, 15, 15},
                {745, 15, 15, 15},
                {160, 10, 10, 10},
                {1510, 30, 30, 30},
                {370, 95, 30, 15},
                {1530, 630, 30, 30}
        };

        //Setting the canvas
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        //Current positions of x and y
        double xCurrentPosition;
        double yCurrentPosition;

        //Time and pause duration
        double time;

        int pauseDuration = 40;

        boolean isRunning = true;
        boolean gameRunning = true;
        boolean shouldStop = true;
        while (gameRunning) {

            double xPreviousPosition = 120;
            double yPreviousPosition = 120;

            if (shouldStop) {

                StdDraw.setPenColor(StdDraw.DARK_GRAY);
                for (double[] obs : obstacleArray) {
                    StdDraw.filledRectangle(obs[0], obs[1], obs[2], obs[3]);
                }

                StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
                for (double[] tar : targetArray) {

                    StdDraw.filledRectangle(tar[0], tar[1], tar[2], tar[3]);
                }
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledRectangle(60, 60, 60, 60);

                StdDraw.setPenColor(StdDraw.WHITE);

                StdDraw.setFont(new Font("Helvetica", Font.BOLD, 18));
                StdDraw.textLeft(20, 70, "a = " + bulletAngle);
                StdDraw.textLeft(20, 50, "v = " + bulletVelocity);
                StdDraw.show();

                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.setPenRadius(0.01);
                StdDraw.line(120, 120, 120 + bulletVelocity * 2 / 3 * Math.cos(Math.toRadians(bulletAngle)), 120 + bulletVelocity * 2 / 3 * Math.sin(Math.toRadians(bulletAngle)));
                StdDraw.show();
            }

            if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
                bulletVelocity = bulletVelocity - 1.0;
                StdDraw.clear();
                StdDraw.setPenColor(StdDraw.DARK_GRAY);
                for (double[] obs : obstacleArray) {
                    StdDraw.filledRectangle(obs[0], obs[1], obs[2], obs[3]);
                }

                StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
                for (double[] tar : targetArray) {

                    StdDraw.filledRectangle(tar[0], tar[1], tar[2], tar[3]);
                }
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledRectangle(60, 60, 60, 60);

                StdDraw.setPenColor(StdDraw.WHITE);

                StdDraw.setFont(new Font("Helvetica", Font.BOLD, 18));
                StdDraw.textLeft(20, 70, "a = " + bulletAngle);
                StdDraw.textLeft(20, 50, "v = " + bulletVelocity);

                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.setPenRadius(0.01);
                StdDraw.line(120, 120, 120 + bulletVelocity * 2 / 3 * Math.cos(Math.toRadians(bulletAngle)), 120 + bulletVelocity * 2 / 3 * Math.sin(Math.toRadians(bulletAngle)));
                StdDraw.show();

                StdDraw.pause(pauseDuration);

            }

            if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
                bulletVelocity = bulletVelocity + 1.0;
                StdDraw.clear();
                StdDraw.setPenColor(StdDraw.DARK_GRAY);
                for (double[] obs : obstacleArray) {
                    StdDraw.filledRectangle(obs[0], obs[1], obs[2], obs[3]);
                }

                StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
                for (double[] tar : targetArray) {

                    StdDraw.filledRectangle(tar[0], tar[1], tar[2], tar[3]);
                }
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledRectangle(60, 60, 60, 60);

                StdDraw.setPenColor(StdDraw.WHITE);

                StdDraw.setFont(new Font("Helvetica", Font.BOLD, 18));
                StdDraw.textLeft(20, 70, "a = " + bulletAngle);
                StdDraw.textLeft(20, 50, "v = " + bulletVelocity);

                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.setPenRadius(0.01);
                StdDraw.line(120, 120, 120 + bulletVelocity * 2 / 3 * Math.cos(Math.toRadians(bulletAngle)), 120 + bulletVelocity * 2 / 3 * Math.sin(Math.toRadians(bulletAngle)));
                StdDraw.show();

                StdDraw.pause(pauseDuration);

            }

            if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
                bulletAngle = bulletAngle + 1.0;
                StdDraw.clear();
                StdDraw.setPenColor(StdDraw.DARK_GRAY);
                for (double[] obs : obstacleArray) {
                    StdDraw.filledRectangle(obs[0], obs[1], obs[2], obs[3]);
                }

                StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
                for (double[] tar : targetArray) {

                    StdDraw.filledRectangle(tar[0], tar[1], tar[2], tar[3]);
                }
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledRectangle(60, 60, 60, 60);

                StdDraw.setPenColor(StdDraw.WHITE);

                StdDraw.setFont(new Font("Helvetica", Font.BOLD, 18));
                StdDraw.textLeft(20, 70, "a = " + bulletAngle);
                StdDraw.textLeft(20, 50, "v = " + bulletVelocity);

                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.setPenRadius(0.01);
                StdDraw.line(120, 120, 120 + bulletVelocity * 2 / 3 * Math.cos(Math.toRadians(bulletAngle)), 120 + bulletVelocity * 2 / 3 * Math.sin(Math.toRadians(bulletAngle)));
                StdDraw.show();

                StdDraw.pause(pauseDuration);

            }

            if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
                bulletAngle = bulletAngle - 1.0;
                StdDraw.clear();
                StdDraw.setPenColor(StdDraw.DARK_GRAY);
                for (double[] obs : obstacleArray) {
                    StdDraw.filledRectangle(obs[0], obs[1], obs[2], obs[3]);
                }

                StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
                for (double[] tar : targetArray) {

                    StdDraw.filledRectangle(tar[0], tar[1], tar[2], tar[3]);
                }
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledRectangle(60, 60, 60, 60);

                StdDraw.setPenColor(StdDraw.WHITE);

                StdDraw.setFont(new Font("Helvetica", Font.BOLD, 18));
                StdDraw.textLeft(20, 70, "a = " + bulletAngle);
                StdDraw.textLeft(20, 50, "v = " + bulletVelocity);

                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.setPenRadius(0.01);
                StdDraw.line(120, 120, 120 + bulletVelocity * 2 / 3 * Math.cos(Math.toRadians(bulletAngle)), 120 + bulletVelocity * 2 / 3 * Math.sin(Math.toRadians(bulletAngle)));
                StdDraw.show();

                StdDraw.pause(pauseDuration);
            }

            if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {

                double startingTime = System.currentTimeMillis() / 330.0;

                while (isRunning) {
                    double currentTime = System.currentTimeMillis() / 330.0;
                    time = currentTime - startingTime;
                    xCurrentPosition = x0 + bulletVelocity * time * Math.cos(Math.toRadians(bulletAngle));
                    yCurrentPosition = y0 + bulletVelocity * time * Math.sin(Math.toRadians(bulletAngle)) - gravity * 3 * time * time * 0.5;

                    StdDraw.filledCircle(xCurrentPosition, yCurrentPosition, 5.0);
                    StdDraw.pause(pauseDuration);
                    StdDraw.show();

                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.setPenRadius(0.003);
                    StdDraw.line(xPreviousPosition, yPreviousPosition, xCurrentPosition, yCurrentPosition);
                    xPreviousPosition = xCurrentPosition;
                    yPreviousPosition = yCurrentPosition;


                    if (1200.0 < xCurrentPosition && xCurrentPosition < 1260.0 && 0.0 < yCurrentPosition && yCurrentPosition < 220.0 ||
                            1000.0 < xCurrentPosition && xCurrentPosition < 1060.0 && 0.0 < yCurrentPosition && yCurrentPosition < 160.0 ||
                            600.0 < xCurrentPosition && xCurrentPosition < 660.0 && 0.0 < yCurrentPosition && yCurrentPosition < 80.0 ||
                            600.0 < xCurrentPosition && xCurrentPosition < 660.0 && 180.0 < yCurrentPosition && yCurrentPosition < 340.0 ||
                            220.0 < xCurrentPosition && xCurrentPosition < 340.0 && 0.0 < yCurrentPosition && yCurrentPosition < 180.0) {
                        isRunning = false;
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.setFont(new Font("Helvetica", Font.BOLD, 20));
                        StdDraw.textLeft(50, 750, "Hit an obstacle. Press 'r' to shoot again");
                        StdDraw.show();
                        shouldStop = false;
                        break;
                    }

                    if (1160.0 < xCurrentPosition && xCurrentPosition < 1190.0 && 0.0 < yCurrentPosition && yCurrentPosition < 30.0 ||
                            730.0 < xCurrentPosition && xCurrentPosition < 760.0 && 0.0 < yCurrentPosition && yCurrentPosition < 30.0 ||
                            150.0 < xCurrentPosition && xCurrentPosition < 170.0 && 0.0 < yCurrentPosition && yCurrentPosition < 20.0 ||
                            1480.0 < xCurrentPosition && xCurrentPosition < 1540.0 && 0.0 < yCurrentPosition && yCurrentPosition < 60.0 ||
                            340.0 < xCurrentPosition && xCurrentPosition < 400.0 && 80.0 < yCurrentPosition && yCurrentPosition < 110.0 ||
                            1500.0 < xCurrentPosition && xCurrentPosition < 1560.0 && 600.0 < yCurrentPosition && yCurrentPosition < 660.0) {
                        isRunning = false;
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.setFont(new Font("Helvetica", Font.BOLD, 20));
                        StdDraw.textLeft(50, 750, "Congratulations: You hit the target!");
                        StdDraw.show();
                        shouldStop = false;
                        break;
                    }

                    if (xCurrentPosition > 1600) {
                        isRunning = false;
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.setFont(new Font("Helvetica", Font.BOLD, 20));
                        StdDraw.textLeft(50, 750, "Max X reached. Press 'r' to shoot again.");
                        StdDraw.show();
                        shouldStop = false;
                        break;
                    }

                    if (yCurrentPosition < 0) {
                        isRunning = false;
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.setFont(new Font("Helvetica", Font.BOLD, 20));
                        StdDraw.textLeft(50, 750, "Hit the ground. Press 'r' to shoot again.");
                        StdDraw.show();
                        shouldStop = false;
                        break;

                    }
                }
            }

            if (isRunning == false) {
                if (StdDraw.isKeyPressed(KeyEvent.VK_R)) {
                    bulletVelocity = 180.0;
                    bulletAngle = 45.0;
                    isRunning = true;
                    shouldStop = true;
                    StdDraw.pause(pauseDuration);
                    StdDraw.clear();
                }
            }
        }
    }
}







