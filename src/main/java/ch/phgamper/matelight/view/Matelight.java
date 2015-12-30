package ch.phgamper.matelight.view;

import ch.phgamper.matelight.model.Constants;
import ch.phgamper.matelight.model.Point;
import ch.phgamper.matelight.model.Snake;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Observable;
import java.util.Observer;

public class Matelight implements Observer {

    private DatagramSocket socket;
    private String host;
    private int port;

    public Matelight(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            if(o instanceof Snake && !((Snake) o).isGameOver()){
                byte[] buf = new byte[1920];
                Snake snake = (Snake) o;
                for(Point p :snake.getSnake()){
                    buf[((((p.Y * Constants.xLen) + p.X) * 3) + 1)] = (byte) 255;
                }
                Point food = snake.getFood().getFood();
                buf[(food.Y * Constants.xLen + food.X) * 3] = (byte) 255;
                DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(host), port);
                socket.send(packet);
            }else{
                Integer score = arg instanceof Integer ? (Integer) arg : 0;
                Socket tcp = new Socket(InetAddress.getByName(host), port);
                DataOutputStream out = new DataOutputStream(tcp.getOutputStream());
                out.writeBytes("Your Score: " + score + " - https://github.com/phgamper/matelight_snake\n");
                tcp.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
