package view;

import enumeration.EnumCase;
import listener.JButtonListener;
import model.*;
import objects.*;
import org.jetbrains.annotations.NotNull;

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
    private static JPopupMenu menuContextuel;


    protected JButton[][] grilleDeBouton;
    private final Grille grille;

    public GrilleGraphique(Grille grille) {

        this.grille = grille;
        this.grilleDeBouton = new JButton[grille.getHauteur()][grille.getLargeur()];


        // Définition de la Frame
        frame = new JFrame("Hello World");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(grille.getHauteur(), grille.getLargeur()));




        frame.setSize(grille.getLargeur() * 120, grille.getHauteur() * 120);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // Placement des Jlabels

        for (int i = 0; i < grille.getHauteur(); i++) {
            for (int j = 0; j < grille.getLargeur(); j++) {

                String sLabel = "";

                JButton btn = this.buttonFactory(this, sLabel, i * 40, j * 40, i, j);
                grilleDeBouton[i][j] = btn;
                panel.add(btn);
            }
        }


        frame.add(panel);

        frame.setVisible(true);

    }

    public void displayGrille() {

        String sLabel;

        for (int i = 0; i < grille.getHauteur(); i++) {
            for (int j = 0; j < grille.getLargeur(); j++) {
                if (this.grille.getTableauDeCases()[j][i] instanceof CaseLettre) {
                    sLabel = ((CaseLettre) this.grille.getTableauDeCases()[j][i]).getLettreString();
                }
                else if (this.grille.getTableauDeCases()[j][i] instanceof CaseDefinition) {
                    sLabel = "Definition";
                }
                else if (this.grille.getTableauDeCases()[j][i] instanceof CaseDefinitionMultiple) {
                    sLabel = "Definition Multiple";
                }
                else if (this.grille.getTableauDeCases()[j][i] instanceof CaseVide) {
                    sLabel = "";
                }
                else {
                    sLabel = "XX";
                }

                grilleDeBouton[i][j].setText(sLabel);

            }
        }
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

    private @NotNull JButton buttonFactory(GrilleGraphique grille, String text, int sizeX, int sizeY, int caseX, int caseY) {

        JButton btn = new JButton(text);
        btn.setAlignmentX(SwingConstants.CENTER);
        btn.setAlignmentY(SwingConstants.CENTER);
        btn.setSize(sizeX, sizeY);
        btn.setBounds(sizeX, sizeY, 35, 35);
        btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        btn.setFocusable(true);
        Case[][] grilleTemp = this.grille.getTableauDeCases();
        btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = caseX;
                int y = caseY;
                JPopupMenu varJPopupMenu;
                System.out.printf("Je suis en " + x + ":" + y);
                Case laCase = grilleTemp[x][y];


                if (laCase instanceof CaseVide) {
                    varJPopupMenu = createContextualMenu(EnumCase.CASE_VIDE, laCase);
                } else if (laCase instanceof CaseLettre) {
                    varJPopupMenu = createContextualMenu(EnumCase.CASE_LETTRE, laCase);
                } else if (laCase instanceof CaseDefinition) {
                    varJPopupMenu = createContextualMenu(EnumCase.CASE_DEFINITION, laCase);
                } else {
                    varJPopupMenu = createContextualMenu(EnumCase.CASE_DEFINITION_MULTIPLE, laCase);
                }

                menuContextuel = varJPopupMenu;
                menuContextuel.show(e.getComponent(), e.getX(), e.getY());



            }
        });

        return btn;
    }

    private JPopupMenu createContextualMenu(EnumCase enumCase, Case uneCase) {
        JPopupMenu jPopupMenu = new JPopupMenu();

        // Action "Ajouter une définition"
        JMenuItem ajouterDef = new JMenuItem("Ajouter une definition");
        ajouterDef.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO supprimerDef de Dylan
                System.out.println("ajouter def");
            }
        });

        JMenuItem supprimerDef = new JMenuItem("Supprimer la definition");
        supprimerDef.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Supprimer def");
            }
        });

        JMenuItem supprimerLettre = new JMenuItem("Supprimer la lettre");
        supprimerDef.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sup case");
            }
        });




        if (enumCase == EnumCase.CASE_VIDE) {
            jPopupMenu.add(ajouterDef);
        } else if (enumCase == EnumCase.CASE_LETTRE) {
            jPopupMenu.add(supprimerLettre);
        } else if (enumCase == EnumCase.CASE_DEFINITION) {
            jPopupMenu.add(supprimerDef);
        } else if (enumCase == EnumCase.CASE_DEFINITION_MULTIPLE) {

        }

        return jPopupMenu;
    }

}
