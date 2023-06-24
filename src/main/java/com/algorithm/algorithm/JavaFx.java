package com.algorithm.algorithm;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.springframework.util.StringUtils;

import java.awt.event.MouseEvent;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/5/29 20:51
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/5/29 20:51
 * @updateRemark : 说明本次修改内容
 */

public class JavaFx extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    StackPane stackPane = new StackPane();
    Rectangle rectangle = new Rectangle();
    rectangle.setFill(Paint.valueOf("#FFC0CB"));
    rectangle.setX(200);
    rectangle.setY(50);
    rectangle.setWidth(100);
    rectangle.setHeight(100);
    stackPane.getChildren().add(rectangle);

    primaryStage.setTitle("xxxx");
    primaryStage.setScene(new Scene(stackPane,500,500));
    primaryStage.show();

  }


  public static void main(String[] args) {
    launch(args);
  }
}
