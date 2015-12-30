package ch.phgamper.matelight.view;

import ch.phgamper.matelight.model.Constants;
import ch.phgamper.matelight.model.Food;
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
            int[][] pos = Snake.getInstance().getSnakepositions();
            int[] food = Food.getInstance().getPosition();

            byte[] buf = new byte[1920];
            buf[(food[1] * Constants.xLen + food[0]) * 3] = (byte) 255;

            for (int i = 0; i < pos.length; i++) {
                buf[((((pos[i][1] * Constants.xLen) + pos[i][0]) * 3) + 1)] = (byte) 255;
            }
            DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("151.217.38.29"), 1337);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
