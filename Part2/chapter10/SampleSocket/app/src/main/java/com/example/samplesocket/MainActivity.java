package com.example.samplesocket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    TextView textView;
    TextView textView2;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String data = editText.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("123", "button1 clicked");
                        send(data);
                    }
                }).start();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("123", "button2 clicked");
                        startSever();
                    }
                }).start();
            }
        });
    }

    public void printClientLog(final String data) {
        Log.e("MainActivity", data);

        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.append(data + "\n");
            }
        });
    }

    public void printServerLog(final String data) {
        Log.e("MainActivity", data);

        handler.post(new Runnable() {
            @Override
            public void run() {
                textView2.append(data + "\n");
            }
        });
    }

    public void send(String data) {
        Log.e("123", "in send " + data);
        try {
            Log.e("123", "in send2");
            int portNumber = 5001;
            Socket sock = new Socket("localhost", portNumber);
            printClientLog("소켓 연결함");

            ObjectOutputStream outputStream = new ObjectOutputStream(sock.getOutputStream());
            outputStream.writeObject(data);
            outputStream.flush();
            printClientLog("데이터 전송함");

            ObjectInputStream inputStream = new ObjectInputStream(sock.getInputStream());
            printClientLog("서버로 부터 받음 : " + inputStream.readObject());
            sock.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.e("123", "in send123 : " + ex);
        }
    }

    public void startSever() {
        Log.e("123", "in startServer");
        try {
            int portNum = 5001;

            ServerSocket server = new ServerSocket(portNum);
            printServerLog("서버 시작함: " + portNum);

            while (true) {
                Socket socket = server.accept();
                InetAddress clientHost = socket.getLocalAddress();
                int clientPort = socket.getPort();
                printServerLog("클라이언트 연결됨 : " + clientHost + " : " + clientPort);

                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                Object object = inputStream.readObject();
                printServerLog("데이터 받음 : " + object);

                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(object + "from Server.");
                outputStream.flush();
                printServerLog("데이터 보냄.");

                socket.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}