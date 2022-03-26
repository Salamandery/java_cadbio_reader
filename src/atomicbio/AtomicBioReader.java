/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atomicbio;

import CIDBio.CIDBio;
import CIDBio.IdentifyResult;
import CIDBio.Image;
import CIDBio.ImageAndTemplate;
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
        private Boolean verifyMatch = false;
        private final JProgressBar jProgressBar;
        
        public AtomicBioReader(JLabel labelBioImage, JTextArea txtBioTemplate, JLabel statusBar, Template templateToVerify, JProgressBar jProgressBar) {
            this.labelBioImage = labelBioImage;
            this.txtBioTemplate = txtBioTemplate;
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
        
        public void ChebioId() {
            statusBar.setText("Iniciando Leitor Biométrico");
            RetCode ret = CIDBio.Init();
            
            try {
                if(ret == RetCode.SUCCESS) {
                    IdentifyResult iResult = idBio.CaptureAndIdentify();
                    ret = iResult.getRetCode();
                    
                    if (ret == RetCode.SUCCESS) {
                        statusBar.setText("Pessoa encontrada com Id: " + iResult.getId() + 
                                " Score: " + iResult.getScore() + 
                                " Qualidade: " + iResult.getQuality()
                        );
                    }
                }
                
                jProgressBar.setIndeterminate(false);
                CIDBio.Terminate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(CIDBio.GetErrorMessage(ret));
                CIDBio.Terminate();
                jProgressBar.setIndeterminate(false);
                statusBar.setText("Algo deu errado :(");
            }   
        }
        
        public void WriteBio() {
            statusBar.setText("Iniciando Leitor Biométrico");
            RetCode ret = CIDBio.Init();
            Image bio;
            Integer width;
            Integer height;
            Integer quality;
            BufferedImage gray;
            byte[] bioImage;
            java.awt.Image img;
            MatchResult matched;
            
            try {
                if(ret == RetCode.SUCCESS) {
                    ImageAndTemplate pT1 = idBio.CaptureImageAndTemplate();
                    bio = pT1.getImage();
                    width = pT1.getWidth();
                    height = pT1.getHeight();
                    quality = pT1.getQuality();
                    System.out.println("heighe: " + height + " width: " + width);

                    bioImage = bio.getImageBuffer();

                    gray = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
                    gray.getRaster().setDataElements(0, 0, width, height, bioImage);
                    img = gray.getScaledInstance(180, 200, java.awt.Image.SCALE_SMOOTH);
                    labelBioImage.setIcon(new ImageIcon(img));
                    
                    ImageAndTemplate pT2 = idBio.CaptureImageAndTemplate();
                    bio = pT2.getImage();
                    width = pT2.getWidth();
                    height = pT2.getHeight();
                    quality = pT2.getQuality();
                    System.out.println("heighe: " + height + " width: " + width);

                    bioImage = bio.getImageBuffer();

                    gray = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
                    gray.getRaster().setDataElements(0, 0, width, height, bioImage);
                    img = gray.getScaledInstance(180, 200, java.awt.Image.SCALE_SMOOTH);
                    labelBioImage.setIcon(new ImageIcon(img));
                    
                    ImageAndTemplate pT3 = idBio.CaptureImageAndTemplate();
                    bio = pT3.getImage();
                    width = pT3.getWidth();
                    height = pT3.getHeight();
                    quality = pT3.getQuality();
                    System.out.println("heighe: " + height + " width: " + width);

                    bioImage = bio.getImageBuffer();

                    gray = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
                    gray.getRaster().setDataElements(0, 0, width, height, bioImage);
                    img = gray.getScaledInstance(180, 200, java.awt.Image.SCALE_SMOOTH);
                    labelBioImage.setIcon(new ImageIcon(img));
                    
                    matched = idBio.MatchTemplates(pT1.getTemplate(), pT2.getTemplate());
                    ret = matched.getRetCode();
                    
                    if (ret != RetCode.SUCCESS) {
                       CIDBio.Terminate();
                       throw new Exception(ret.toString());
                    }
                    
                    statusBar.setText(ret.toString());
                    
                    matched = idBio.MatchTemplates(pT2.getTemplate(), pT3.getTemplate());
                    ret = matched.getRetCode();
                    
                    if (ret != RetCode.SUCCESS) {
                       CIDBio.Terminate();
                       throw new Exception(ret.toString());
                    }
                    
                    statusBar.setText(ret.toString());
                    
                    matched = idBio.MatchTemplates(pT1.getTemplate(), pT3.getTemplate());
                    ret = matched.getRetCode();
                    
                    if (ret != RetCode.SUCCESS) {
                       CIDBio.Terminate();
                       throw new Exception(ret.toString());
                    }
                    
                    statusBar.setText(ret.toString());
                    
                    Template template = idBio.MergeTemplates(pT1.getTemplate(), pT2.getTemplate(), pT3.getTemplate());
                    ret = idBio.SaveTemplate(5831, template);
                    
                    CIDBio.Terminate();
                    jProgressBar.setIndeterminate(false);
                }
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
