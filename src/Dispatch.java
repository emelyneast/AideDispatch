import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Dispatch extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel Titre;
    private JTextField central;
    private JLabel PersoCentral;
    private JLabel DebDisp;
    private JList list1;
    private JTextField DebuDisp;
    private JLabel LEffectif;
    private JLabel LPatrouille;
    private JButton plusPatrouille;
    private JPanel PanelPatrouille;
    private JLabel LAgent;
    private JLabel LSecteur;
    private JButton OKButton;
    private JButton retour;
    private JLabel Lpatrouille;
    private JTextField textAgent;
    private JList listSecteur;
    private JLabel nomSp;
    private JButton btnEntrer;
    private JPanel panelPatrouille;
    private JPanel panelDebut;
    private JPanel panelRapport;
    private JLabel hDispatch;
    private JTextField heureDisp;
    private JLabel Lrapport;
    private JTextField rapport;
    private JList listSp;
    private JButton entrerRapport;
    private JLabel Lerreur;
    private JButton selectBtn;
    private JPanel PajoutPat;
    private JList listAgentSelct;
    private JPanel Peffeectif;
    int nbSP=0;
    DefaultListModel listSP = new DefaultListModel<>();
    Agent ag = new Agent("","");
    public Dispatch() {
        setContentPane(contentPane);
        setModal(true);
        PanelPatrouille.setVisible(false);
        panelRapport.setVisible(false);
        PajoutPat.setVisible(false);
        listAgent();

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        plusPatrouille.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nbSP = nbSP +1;
                PanelPatrouille.setVisible(true);
            }
        });

        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });

        selectBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PajoutPat.setVisible(true);
                List<String> indices = list1.getSelectedValuesList();
                DefaultListModel lAgentSelect = new DefaultListModel<>();
                for (String i: indices ) {
                    lAgentSelect.addElement(i);
                }
                listAgentSelct.setModel(lAgentSelect);
                Peffeectif.setVisible(false);

            }
        });

        btnEntrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (syntax() == true) {
                    panelRapport.setVisible(true);
                    panelDebut.setVisible(false);
                    PanelPatrouille.setVisible(false);
                    btnEntrer.setVisible(false);
                }
                else{
                    Lerreur.setText("erreur syntaxe");
                }
            }
        });

        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sp();
                listSP.addElement(nomSp.getText());
                listSp.setModel(listSP);
                DefaultListModel model = (DefaultListModel) listAgentSelct.getModel();
                for (int i=0; i<10; i++) {
                    int selectedIndex = listAgentSelct.getSelectedIndex();
                    if (selectedIndex != -1) {
                        model.remove(selectedIndex);
                    }
                }
                PanelPatrouille.setVisible(false);
            }
        });

        plusPatrouille.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                plusPat();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void plusPat() {
        PanelPatrouille.setVisible(true);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    void sp(){
        List<String> indicesAg = listAgentSelct.getSelectedValuesList();
        List<String> indicesSect = listSecteur.getSelectedValuesList();

        nomSp.setText( "SP"+nbSP+" Agent: ");
        for (String i: indicesAg ) {
            nomSp.setText( nomSp.getText()+i + ", ");
        }

        nomSp.setText( nomSp.getText() +" Secteur: ");
        for (String i: indicesSect ) {
            nomSp.setText( nomSp.getText() +i);
        }
    }
    boolean syntax(){
        boolean test = false;

        if(!central.getText().equals("")){
            if (Pattern.matches("^([0-1][0-9]|2[0-3])h[0-5][0-9]$", DebuDisp.getText()) == true && DebuDisp.getText()!= "") {
               // if(listAgentSelct.getSelectedValue()!=null){
                    test = true;

            }
        }
        else {
            test = false;
        }
        return test;
    }

    private void listAgent(){
        ag.listAgent();
        DefaultListModel listAg = new DefaultListModel<>();
        for (Agent a: ag.agents ) {
            listAg.addElement(a.getNomAgent()+" "+a.getGrade());
        }
        list1.setModel(listAg);


    }
    private void back() {
        onCancel();
        Menu dialog = new Menu();
        dialog.pack();
        dialog.setSize(700,700);
        dialog.setVisible(true);

    }

}
