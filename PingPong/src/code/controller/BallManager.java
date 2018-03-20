package code.controller;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import code.PingPongMainFrame;
import code.model.Constant;
import code.model.Ball;


public class BallManager implements ActionListener, KeyListener{

    private Graphics2D graphics;
    private Ball ball;

    public BallManager(){
        ball = new Ball()
    }
}
