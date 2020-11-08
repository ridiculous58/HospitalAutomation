package com.skywalk.hospitalAutomation;

import com.skywalk.hospitalAutomation.UI.NewJFrame;
import java.awt.Dimension;
import javax.swing.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalAutomationApplication {

	public static void main(String[] args) {
            NewJFrame frame = new NewJFrame();
            frame.show();
            SpringApplication.run(HospitalAutomationApplication.class, args);

	}
    

}
