package view;

import enumeration.Dir;
import enumeration.EnumCase;
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

        JFrame.setDefaultLookAndFeelDecorated(true);

        this.grille = grille;
        this.grilleDeBouton = new JButton[grille.getHauteur()][grille.getLargeur()];


        // Définition de la Frame
        frame = new JFrame("Mot fleches");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(grille.getHauteur(), grille.getLargeur()));


        frame.setSize(grille.getLargeur() * 120, grille.getHauteur() * 120);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // Placement des Jlabels

        for (int largeur = 0; largeur < grille.getLargeur(); largeur++) {
            for (int hauteur = 0; hauteur < grille.getHauteur(); hauteur++) {

                String sLabel = "";

                JButton btn = this.buttonFactory(this, sLabel, largeur * 40, hauteur * 40, largeur, hauteur);
                grilleDeBouton[hauteur][largeur] = btn;
                panel.add(btn);
            }
        }


        frame.add(panel);

        frame.setVisible(true);

    }

    public void displayGrille() {

        String sLabel;

        JLabel arrowLabel;
        JButton jButtonTemp;
        Dir directionDefTemp = null;
        Dir directionDefTemp_1 = null;
        Dir directionDefTemp_2 = null;
        String imageName = "";

        for (int largeur = 0; largeur < grille.getLargeur(); largeur++) {
            for (int hauteur = 0; hauteur < grille.getHauteur(); hauteur++) {
                jButtonTemp = grilleDeBouton[largeur][hauteur];
                if (this.grille.getTableauDeCases()[largeur][hauteur] instanceof CaseLettre) {
                    sLabel = ((CaseLettre) this.grille.getTableauDeCases()[largeur][hauteur]).getLettreString();
                    jButtonTemp.setBorderPainted(true);
                    jButtonTemp.setFocusPainted(true);
                    jButtonTemp.setContentAreaFilled(true);
                    grilleDeBouton[largeur][hauteur] = jButtonTemp;
                }
                else if (this.grille.getTableauDeCases()[largeur][hauteur] instanceof CaseDefinition caseDefinition) {
                    sLabel = caseDefinition.definition;
                    directionDefTemp = caseDefinition.direction;

                    switch (directionDefTemp) {
                        case VERTICALDIRECT -> {
                            imageName = "arrow_straight_down.png";
                        }
                        case HORIZONTALDIRECT -> {
                            imageName = "arrow_straight_right.png";
                        }
                        case VERTICALINDIRECT -> {
                            imageName = "arrow_right_downward.png";
                        }
                        case HORIZONTALINDIRECT -> {
                            imageName = "arrow_bottom_right";
                        }
                    }

                    jButtonTemp = grilleDeBouton[largeur][hauteur];


                    ImageIcon imageIcon = new ImageIcon("images/" + imageName);

                    Image scaledImage = null;

                    switch (directionDefTemp) {
                        case VERTICALDIRECT, HORIZONTALDIRECT -> {
                            scaledImage = imageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH) ;
                        }
                        case VERTICALINDIRECT, HORIZONTALINDIRECT -> {
                            scaledImage = imageIcon.getImage().getScaledInstance(70, 30, Image.SCALE_SMOOTH) ;
                        }
                    }

                    imageIcon = new ImageIcon(scaledImage);
                    arrowLabel = new JLabel(imageIcon);
                    arrowLabel.setLocation(largeur*40 + 500, hauteur* 40);
                    jButtonTemp.add(arrowLabel);
                    jButtonTemp.setBorderPainted(false);
                    jButtonTemp.setFocusPainted(false);
                    jButtonTemp.setContentAreaFilled(false);
                    grilleDeBouton[largeur][hauteur] = jButtonTemp;

                }
                else if (this.grille.getTableauDeCases()[largeur][hauteur] instanceof CaseDefinitionMultiple caseDefinitionMultiple) {
                    sLabel = "<html>" + caseDefinitionMultiple.definition_1 + "<br /><br />" + caseDefinitionMultiple.definition_2 + "</html>";
                    directionDefTemp_1 = caseDefinitionMultiple.direction_1;
                    directionDefTemp_2 = caseDefinitionMultiple.direction_2;

                    // première icone
                    switch (directionDefTemp_1) {
                        case VERTICALDIRECT -> {
                            imageName = "arrow_straight_down.png";
                        }
                        case HORIZONTALDIRECT -> {
                            imageName = "arrow_straight_right.png";
                        }
                        case VERTICALINDIRECT -> {
                            imageName = "arrow_right_downward.png";
                        }
                        case HORIZONTALINDIRECT -> {
                            imageName = "arrow_bottom_right";
                        }
                    }
                    jButtonTemp = grilleDeBouton[largeur][hauteur];
                    ImageIcon imageIcon = new ImageIcon("images/" + imageName);
                    Image scaledImage = null;
                    switch (directionDefTemp_1) {
                        case VERTICALDIRECT, HORIZONTALDIRECT -> {
                            scaledImage = imageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH) ;
                        }
                        case VERTICALINDIRECT, HORIZONTALINDIRECT -> {
                            scaledImage = imageIcon.getImage().getScaledInstance(70, 30, Image.SCALE_SMOOTH) ;
                        }
                    }
                    imageIcon = new ImageIcon(scaledImage);
                    arrowLabel = new JLabel(imageIcon);

                    jButtonTemp.setBorderPainted(false);
                    jButtonTemp.setFocusPainted(false);
                    jButtonTemp.setContentAreaFilled(false);
                    jButtonTemp.add(arrowLabel);


                    // Deuxième icone
                    switch (directionDefTemp_2) {
                        case VERTICALDIRECT -> {
                            imageName = "arrow_straight_down.png";
                        }
                        case HORIZONTALDIRECT -> {
                            imageName = "arrow_straight_right.png";
                        }
                        case VERTICALINDIRECT -> {
                            imageName = "arrow_right_downward.png";
                        }
                        case HORIZONTALINDIRECT -> {
                            imageName = "arrow_bottom_right";
                        }
                    }
                    jButtonTemp = grilleDeBouton[largeur][hauteur];
                    imageIcon = new ImageIcon("images/" + imageName);
                    scaledImage = null;
                    switch (directionDefTemp_2) {
                        case VERTICALDIRECT, HORIZONTALDIRECT -> {
                            scaledImage = imageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH) ;
                        }
                        case VERTICALINDIRECT, HORIZONTALINDIRECT -> {
                            scaledImage = imageIcon.getImage().getScaledInstance(70, 30, Image.SCALE_SMOOTH) ;
                        }
                    }
                    imageIcon = new ImageIcon(scaledImage);
                    arrowLabel = new JLabel(imageIcon);

                    jButtonTemp.setBorderPainted(false);
                    jButtonTemp.setFocusPainted(false);
                    jButtonTemp.setContentAreaFilled(false);
                    jButtonTemp.add(arrowLabel);
                    arrowLabel.setLocation(largeur*40, hauteur* 40);

                    grilleDeBouton[largeur][hauteur] = jButtonTemp;

                }
                else if (this.grille.getTableauDeCases()[largeur][hauteur] instanceof CaseVide) {
                    sLabel = "";
                    jButtonTemp.setBorderPainted(true);
                    jButtonTemp.setFocusPainted(true);
                    jButtonTemp.setContentAreaFilled(true);
                    grilleDeBouton[largeur][hauteur] = jButtonTemp;
                }
                else {
                    sLabel = "XX";
                    jButtonTemp.setBorderPainted(true);
                    jButtonTemp.setFocusPainted(true);
                    jButtonTemp.setContentAreaFilled(true);
                    grilleDeBouton[largeur][hauteur] = jButtonTemp;
                }

                grilleDeBouton[largeur][hauteur].setText(sLabel);

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
        btn.setFocusable(false);
        Case[][] grilleTemp = this.grille.getTableauDeCases();
        btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JPopupMenu varJPopupMenu = new JPopupMenu();
                System.out.printf("Je suis en " + caseX + ":" + caseY);
                Case laCase = grilleTemp[caseY][caseX];

                if (e.getButton() == MouseEvent.BUTTON1 && laCase instanceof CaseVide caseTemp) {
                    String lettreTemp = null;
                    boolean inputIsCorrect = false;
                    while (!inputIsCorrect) {
                        lettreTemp = JOptionPane.showInputDialog("Saisissez une lettre");
                        if (lettreTemp.length() == 1) {
                            inputIsCorrect = true;
                        }
                    }
                    grille.grille.setCaseAt(new CaseLettre(new Coordonnee(caseY, caseX), lettreTemp.charAt(0)), new Coordonnee(caseY, caseX));
                    displayGrille();


                } else {
                    if (laCase instanceof CaseVide) {
                        varJPopupMenu = createContextualMenu(EnumCase.CASE_VIDE, laCase, caseX, caseY);
                    } else if (laCase instanceof CaseLettre) {
                        varJPopupMenu = createContextualMenu(EnumCase.CASE_LETTRE, laCase, caseX, caseY);
                    } else if (laCase instanceof CaseDefinition) {
                        varJPopupMenu = createContextualMenu(EnumCase.CASE_DEFINITION, laCase, caseX, caseY);
                    } else {
                        varJPopupMenu = createContextualMenu(EnumCase.CASE_DEFINITION_MULTIPLE, laCase, caseX, caseY);
                    }
                }



                menuContextuel = varJPopupMenu;
                menuContextuel.show(e.getComponent(), e.getX(), e.getY());



            }
        });

        return btn;
    }

    private JPopupMenu createContextualMenu(EnumCase enumCase, Case uneCase, int x, int y) {
        JPopupMenu jPopupMenu = new JPopupMenu();
        Coordonnee coordonneeCase = new Coordonnee(y, x);

        // Action "Ajouter une définition"
        JMenuItem ajouterDef = new JMenuItem("Ajouter une definition");
        ajouterDef.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String definitionTemp = JOptionPane.showInputDialog(frame, "Saisissez votre définition");

                Dir direction = showDialogDirection();
                grille.setCaseAt(new CaseDefinition(coordonneeCase, definitionTemp, direction), coordonneeCase);
                System.out.println("ajouter def");
                displayGrille();
            }
        });

        // Action "Ajouter une deuxième définition"
        JMenuItem ajouterDefMultiple = new JMenuItem("Ajouter une deuxième definition");
        ajouterDefMultiple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String definitionTemp = JOptionPane.showInputDialog(frame, "Saisissez votre definition");
                CaseDefinition uneCaseDefTemp = (CaseDefinition)uneCase;

                Dir direction = showDialogDirection();

                grille.fromSimpleToDoubleDefinition(uneCaseDefTemp, coordonneeCase, definitionTemp, direction);


//                framePopUp.add(new Container());
//                framePopUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//                //Create and set up the content pane.
//                comboDirection.setOpaque(true); //content panes must be opaque
//                framePopUp.setContentPane(comboDirection);
//                framePopUp.pack();
//                framePopUp.setVisible(true);

                System.out.println("ajouter deuxième def");
                displayGrille();
            }
        });

        // Action supprimer définition
        JMenuItem supprimerDef = new JMenuItem("Supprimer la definition");
        supprimerDef.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grille.deleteCaseAt(coordonneeCase);
                System.out.println("Supprimer def");
                displayGrille();
            }
        });

        // Action supprimer la lettre
        JMenuItem supprimerLettre = new JMenuItem("Supprimer la lettre");
        supprimerLettre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grille.deleteCaseAt(coordonneeCase);
                displayGrille();
                System.out.println("Sup case");
            }
        });


        if (enumCase == EnumCase.CASE_VIDE) {
            jPopupMenu.add(ajouterDef);
        } else if (enumCase == EnumCase.CASE_LETTRE) {
            jPopupMenu.add(supprimerLettre);
        } else if (enumCase == EnumCase.CASE_DEFINITION) {
            jPopupMenu.add(supprimerDef);
            jPopupMenu.add(ajouterDefMultiple);
        } else if (enumCase == EnumCase.CASE_DEFINITION_MULTIPLE) {
            jPopupMenu.add(supprimerDef);
        }

        return jPopupMenu;
    }


    public Dir showDialogDirection() {

        Dir direction = null;
        ImageIcon[] images;
        String[] imageName = new String[] {"arrow_bottom_right.png", "arrow_straight_down.png", "arrow_straight_right.png", "arrow_right_downward.png"};
        String[] descriptions = new String[] {"HI", "VD","HD","VI"};


        JComboBox comboDirection = new JComboBox();


        // Charge les images dans la combobox
        images = new ImageIcon[descriptions.length];
        for (int i = 0; i < imageName.length; i++) {
            ImageIcon imageIcon = new ImageIcon("images/" + imageName[i]);
            Image scaledImage = imageIcon.getImage().getScaledInstance(50, 100, Image.SCALE_SMOOTH) ;

            imageIcon = new ImageIcon(scaledImage);
            images[i] = imageIcon;

            if (images[i] != null) {
                images[i].setDescription(descriptions[i]);
            }

            comboDirection.addItem(images[i]);
        }
        comboDirection.setMaximumRowCount(4);

        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame framePopUp = new JFrame("CustomComboBoxDemo");

        String[] options = {"Ok", "Cancel"};

        int selection = JOptionPane.showOptionDialog(frame, comboDirection, "Direction", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
                options[0]);

        if (selection > 0) {
            System.out.println("selection is: " + options[selection]);
        }

        Object directionSelected = comboDirection.getSelectedItem();

        if ("VD".equals(directionSelected.toString())) {
            return Dir.VERTICALDIRECT;
        } else if ("VI".equals(directionSelected.toString())) {
            return Dir.VERTICALINDIRECT;
        } else if ("HD".equals(directionSelected.toString())) {
            return Dir.HORIZONTALDIRECT;
        } else if ("HI".equals(directionSelected.toString())) {
            return Dir.HORIZONTALINDIRECT;
        }
        System.out.println("marche po");
        
        return direction;
    }


}
