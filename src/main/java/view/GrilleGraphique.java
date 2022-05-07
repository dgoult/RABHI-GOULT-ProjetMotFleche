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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventListener;

public class GrilleGraphique{

    private static JFrame frame;
    private static JTextField field;
    private static JPanel contentPanel;
    private static JPanel displayPanel;
    private static JPanel buttonPanel;
    private static boolean start = true;
    private static double result = 0;
    private static String lastCommand = "=";
    private final JPopupMenu menuContextuel;


    protected JLabel[][] grilleDeLabel;
    private Grille grille;

    public GrilleGraphique(Grille grille) {

        this.grille = grille;
        this.grilleDeLabel = new JLabel[grille.getHauteur()][grille.getLargeur()];


        // Définition de la Frame
        frame = new JFrame("Hello World");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(grille.getHauteur(), grille.getLargeur()));


        this.menuContextuel = new JPopupMenu("Menu");
        JMenuItem ajouterDef = new JMenuItem("Ajouter une definition");
        ajouterDef.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("yoo");
            }
        });

        this.menuContextuel.add(ajouterDef);






        frame.setSize(grille.getLargeur() * 120, grille.getHauteur() * 120);
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

                JButton btn = this.buttonFactory(this, sLabel, i * 40, j * 40, i, j);
                panel.add(btn);
            }
        }


        frame.add(panel);

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

    private JButton buttonFactory(GrilleGraphique grille, String text, int sizeX, int sizeY, int caseX, int caseY) {

        JButton btn = new JButton(text);
        btn.setAlignmentX(SwingConstants.CENTER);
        btn.setAlignmentY(SwingConstants.CENTER);
        btn.setSize(sizeX, sizeY);
        btn.setBounds(sizeX, sizeY, 35, 35);
        btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        btn.setFocusable(true);
        btn.setText(sizeX + ":" + sizeY);
        btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = caseX;
                int y = caseY;
                System.out.printf("Je suis en " + x + ":" + y);
                grille.menuContextuel.show(e.getComponent(), e.getX(), e.getY());

            }
        });

        return btn;
    }




}
