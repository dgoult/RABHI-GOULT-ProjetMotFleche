package view;

import listener.JButtonListener;
import model.*;
import objects.CaseDefinition;
import objects.CaseDefinitionMultiple;
import objects.CaseLettre;
import objects.CaseVide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrilleGraphique{

    private static JFrame frame;
    private static JTextField field;
    private static JPanel contentPanel;
    private static JPanel displayPanel;
    private static JPanel buttonPanel;
    private static boolean start = true;
    private static double result = 0;
    private static String lastCommand = "=";


    protected JLabel[][] grilleDeLabel;
    private Grille grille;

    public GrilleGraphique(Grille grille) {

        this.grille = grille;
        this.grilleDeLabel = new JLabel[grille.getHauteur()][grille.getLargeur()];


        // Définition de la Frame
        frame = new JFrame("Hello World");
        JPanel panel = new JPanel();

        // Définir le menu principal
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("Fichier");
        JMenu edit = new JMenu("Edition");
        JMenu help = new JMenu("Aide");

        // Définir le sous-menu pour Fichier
        JMenuItem newf = new JMenuItem("Nouveau");
        JMenuItem quit = new JMenuItem("Ouvrir");
        JMenuItem save = new JMenuItem("Enregistrer");

        file.add(newf);
        file.add(save);
        file.add(quit);

        menu.add(file);
        menu.add(edit);
        menu.add(help);


        frame.add(menu);
        frame.add(panel);

        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // Placement des Jlabels

        for (int i = 0; i < grille.getHauteur(); i++) {
            for (int j = 0; j < grille.getLargeur(); j++) {

                String sLabel = "";
                if (this.grille.getTableauDeCases()[i][j] instanceof CaseLettre) {
                    sLabel = ((CaseLettre) this.grille.getTableauDeCases()[i][j]).getLettreString();
                }
                else if (this.grille.getTableauDeCases()[i][j] instanceof CaseDefinition) {
                    sLabel = "Definition";
                }
                else if (this.grille.getTableauDeCases()[i][j] instanceof CaseDefinitionMultiple) {
                    sLabel = "Definition Multiple";
                }
                else if (this.grille.getTableauDeCases()[i][j] instanceof CaseVide) {
                    sLabel = "";
                }
                else {
                    sLabel = "XX";
                }

                JButton btn = GrilleGraphique.buttonFactory(sLabel, i * 40, j * 40);
                frame.add(btn);
            }
        }

        frame.setVisible(true);

    }

    public void displayGrille() {

    }


    private static JLabel labelFactory(String text, int x, int y) {

        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setAlignmentX(SwingConstants.CENTER);
        label.setAlignmentY(SwingConstants.CENTER);
        label.setBounds(x, y, 35, 35);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        label.setFocusable(true);

        return label;
    }

    private static JButton buttonFactory(String text, int x, int y) {

        JButton btn = new JButton(text);
        btn.setAlignmentX(SwingConstants.CENTER);
        btn.setAlignmentY(SwingConstants.CENTER);
        btn.setBounds(x, y, 35, 35);
        btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        btn.setFocusable(true);
        btn.setText(x + ":" + y);
        btn.addActionListener(new JButtonListener(x, y));


        return btn;
    }



}
