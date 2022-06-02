
package devj130_chat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimpleChat extends JFrame implements ISimpleChat{
    
    public ServerSocket serverSocket;
    public Socket socket;
    public JButton send;
    public JButton exit;
    public JTextField inMsg;
    public JTextArea outMsg;
    
    public SimpleChat() {
        
        init();
            
        int i = mode();
        if (i == 0) {
            setTitle("Server");
            new Thread(() -> {
                try {
                    server();
                } catch (ChatException e) {
                    System.out.println("Error1: " + e.getMessage());
                }
            }).start();
        } else {
            setTitle("Client");
            new Thread(() -> {
                try {
                    client();
                } catch (ChatException e) {
                    System.out.println("Error2: " + e.getMessage());
                }
            }).start();
        }
        setVisible(true);
    }
    
        private void init() {
        setSize(400, 300);
        setLocation(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        send = new JButton("Send Message");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sendMessage(inMsg.getText());
                } catch (ChatException ex) {
                    System.out.println("Error3: " + ex.getMessage());
                }
            }
        });
        
        exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });

        inMsg = new JTextField(20);

        outMsg = new JTextArea();
        outMsg.setEditable(false);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
        southPanel.add(inMsg);
        southPanel.add(send);


        add(southPanel, BorderLayout.NORTH);
        add(outMsg, BorderLayout.CENTER);
        add(exit, BorderLayout.SOUTH);
    }
        
    public int mode() {
        int mode = 0;
        Object[] modeVariant = {"Server", "Client"};
        String s = "Choise your mode";
        mode = JOptionPane.showOptionDialog(this, s,null, JOptionPane.YES_NO_OPTION,
                                 JOptionPane.PLAIN_MESSAGE, null, modeVariant, null);
        return mode;
    }     
        
    @Override
    public void client() throws ChatException {
        String address = setAddress();
        int port = setPort();
        try {
            socket = new Socket(address, port);
            System.out.println("Client is conected");
            getMessage();
        } catch (IOException e) {
            JOptionPane.showInputDialog(this, 
                        new String[] {"Uncorrected address or port", "Repeat "}, 
                        null, JOptionPane.YES_NO_CANCEL_OPTION);
            System.out.println("!!!!!!!");
            client();
            System.out.println("After");
        }
    }

    @Override
    public void server() throws ChatException {
        try {
            serverSocket = new ServerSocket(ISimpleChat.SERVER_PORT);
            socket = serverSocket.accept();
            System.out.println("Server is conected");
            getMessage();
        } catch (IOException e) {
            throw new ChatException(e.getMessage());
        }
    }

    @Override
    public void getMessage() throws ChatException {
        try (Scanner scanner = new Scanner(socket.getInputStream())) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                outMsg.append(socket.getInetAddress() + ": " + socket.getPort() + " msg: " + line + "\n");
            }
        } catch (IOException e) {
            throw new ChatException(e.getMessage());
        }
    }

    @Override
    public void sendMessage(String message) throws ChatException {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(message);
            outMsg.append("Message: " + message + "\n");
            inMsg.setText(null);
        } catch (IOException e) {
            throw new ChatException(e.getMessage());
        }
    }

    @Override
    public void close() throws ChatException {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.getOutputStream().close();
                socket.getInputStream().close();
                socket.close();
            }
            if (serverSocket != null && !serverSocket.isClosed()) serverSocket.close();
        } catch (IOException e) {
            throw new ChatException(e.getMessage());
        }
    }

    private int setPort() {
        String portString = "";
        int portInt = 0;
        while (true) {
            portString = JOptionPane.showInputDialog("Enter port of server: ");
            if (portString == null) {
                dispose();
                System.exit(0);
            }
            if (portString.trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Error: empty string!");
                continue;
            }
            try {
                portInt = Integer.parseInt(portString);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: ucorrected port!");
                continue;
            }
            break;
        }
        return portInt;
    }

    private String setAddress() {
        String adress = "";
        while (true) {
            adress = JOptionPane.showInputDialog("Enter address of server: ");
            if (adress == null) {
                dispose();
                System.exit(0);
            }
            if (adress.trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Error, empty string!");
                continue;
            }
            break;
        }
        return adress;
    }
}
