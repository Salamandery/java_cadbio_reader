/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atomicbio;

import CIDBio.CIDBio;
import CIDBio.Image;
import CIDBio.MatchResult;
import CIDBio.RetCode;
import CIDBio.Template;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

/**
 *
 * @author SPron
 */
public class AtomicBioReader implements Runnable {
    	private final long serialVersionUID = 2L;
	private final CIDBio idBio = new CIDBio();
        private Template templateToVerify;
        private final JLabel labelBioImage;
        private final JTextArea txtBioTemplate;
        private final JLabel statusBar;
        private final Boolean verifyMatch;
        private final JProgressBar jProgressBar;
        
        public AtomicBioReader(JLabel labelBioImage, JTextArea txtBioTemplate, JLabel statusBar, Template templateToVerify, JProgressBar jProgressBar) {
            this.labelBioImage = labelBioImage;
            this.txtBioTemplate = txtBioTemplate;
            this.verifyMatch = false;
            this.statusBar = statusBar;
            this.templateToVerify = templateToVerify;
            this.jProgressBar = jProgressBar;
        }
        
        public AtomicBioReader(JLabel labelBioImage, JTextArea txtBioTemplate, JLabel statusBar, Template templateToVerify, JProgressBar jProgressBar, Boolean verifyMatch) {
            this.labelBioImage = labelBioImage;
            this.txtBioTemplate = txtBioTemplate;
            this.verifyMatch = verifyMatch;
            this.statusBar = statusBar;
            this.templateToVerify = templateToVerify;
            this.jProgressBar = jProgressBar;
        }
        
        public void ReadBio() {
            statusBar.setText("Iniciando Leitor Biométrico");
            RetCode ret = CIDBio.Init();
            try {
                if(ret == RetCode.SUCCESS) {
                    System.out.println("Success");
                    Image bio = idBio.CaptureImage();
                    Integer width = bio.getWidth();
                    Integer height = bio.getHeight();
                    System.out.println("heighe: " + height + " width: " + width);

                    byte[] bioImage = bio.getImageBuffer();

                    BufferedImage gray = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
                    gray.getRaster().setDataElements(0, 0, width, height, bioImage);
                    java.awt.Image img = gray.getScaledInstance(180, 200, java.awt.Image.SCALE_SMOOTH);
                    labelBioImage.setIcon(new ImageIcon(img));

                    templateToVerify = idBio.ExtractTemplateFromImage(bio);
                    jfPrincipal.setTemplate(templateToVerify);
                    jfPrincipal.setQuality(templateToVerify.getQuality());
                    System.out.println(templateToVerify.getQuality());
                    
                    txtBioTemplate.append(templateToVerify.getTemplate());
                    
                } 
                CIDBio.Terminate();
                jProgressBar.setIndeterminate(false);
                statusBar.setText("Biometria Capturada");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(CIDBio.GetErrorMessage(ret));
                CIDBio.Terminate();
                jProgressBar.setIndeterminate(false);
                statusBar.setText("Algo deu errado :(");
            }
        }
        
        public void ReadBioAndMatch() {
            statusBar.setText("Iniciando Leitor Biométrico");
            RetCode ret = CIDBio.Init();
            try {
                if(ret == RetCode.SUCCESS) {
                    System.out.println("Success");
                    Image bio = idBio.CaptureImage();
                    Integer width = bio.getWidth();
                    Integer height = bio.getHeight();
                    System.out.println("heighe: " + height + " width: " + width);

                    byte[] bioImage = bio.getImageBuffer();

                    BufferedImage gray = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
                    gray.getRaster().setDataElements(0, 0, width, height, bioImage);
                    java.awt.Image img = gray.getScaledInstance(180, 200, java.awt.Image.SCALE_SMOOTH);
                    labelBioImage.setIcon(new ImageIcon(img));

                    Template bioTemplate = idBio.ExtractTemplateFromImage(bio);
                    
                    MatchResult matched = idBio.MatchTemplates(templateToVerify, bioTemplate);
                    Integer score = matched.getScore();

                    System.out.println("Score: " +score);

                    if (score >= 1000) {
                       statusBar.setText("Digital Válida");
                    } else {
                       statusBar.setText("Digital invalida");
                    }
                } 
                CIDBio.Terminate();
                jProgressBar.setIndeterminate(false);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(CIDBio.GetErrorMessage(ret));
                CIDBio.Terminate();
                jProgressBar.setIndeterminate(false);
                statusBar.setText("Algo deu errado :(");
            }
        }
        
        @Override
        public void run() {
            if (verifyMatch) {
                ReadBioAndMatch();
            } else {
                ReadBio();
            }
        }
}
