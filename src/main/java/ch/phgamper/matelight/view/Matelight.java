package ch.phgamper.matelight.view;

import ch.phgamper.matelight.model.Constants;
import ch.phgamper.matelight.model.Point;
import ch.phgamper.matelight.model.Snake;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Observable;
import java.util.Observer;

public class Matelight implements Observer {

    DatagramSocket socket;

    public Matelight() {
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            byte[] buf = new byte[1920];
            if(o instanceof Snake){
                Snake snake = (Snake) o;
                for(Point p :snake.getSnake()){
                    buf[((((p.Y * Constants.xLen) + p.X) * 3) + 1)] = (byte) 255;
                }
                Point food = snake.getFood().getFood();
                buf[(food.Y * Constants.xLen + food.X) * 3] = (byte) 255;
            }

            DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("151.217.38.29"), 1337);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
