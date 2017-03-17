/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.scit.jasperserver.client.JasperserverRestClient;
import com.scit.jasperserver.client.Report;
import java.awt.Font;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;


/**
 *
 * @author cuahutli
 */
public class Main {
    public static void ConsumeReport(){
       	File outPutDir;
        outPutDir = new File(System.getProperty("user.dir"));
        String serverUrl = "http://10.20.1.32:8080/jasperserver";
        String serverUser = "joeuser";
        String serverPassword = "joeuser";
        Report report = new Report();
        report.setUrl("/reportes/vencimientos");
        report.setOutputFolder(outPutDir.getAbsolutePath());
        report.addParameter("feini", "2017-03-15");
        report.addParameter("fefin", "2017-03-20");
        report.setFormat(Report.FORMAT_RTF);
        JasperserverRestClient client = JasperserverRestClient.getInstance(serverUrl, serverUser, serverPassword);
        try {
            File reportFile = client.getReportAsFile(report);
            System.out.println(reportFile.getName());
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        UIManager.put("InternalFrame.useTaskBar", Boolean.FALSE);
        UIManager.put("ToolTip.font", new FontUIResource("Tahoma", Font.PLAIN, 12));
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    ConsumeReport();
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}