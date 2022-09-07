import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.regex.*;


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
    private JLabel Lrapport;
    private JTextField rapport;
    private JList listSp;
    private JButton entrerRapport;
    private JLabel Lerreur;
    private JButton selectBtn;
    private JPanel PajoutPat;
    private JList listAgentSelct;
    private JPanel Peffeectif;
    private JLabel Lveh;
    private JList listVeh;
    private JTextField HeureRap;
    int nbSP=0;
    DefaultListModel listSP = new DefaultListModel<>();
    DefaultListModel listSPEntiere = new DefaultListModel<>();
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
                listvehAgent();
            }
        });

        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });



        selectBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                List<String> indices = list1.getSelectedValuesList();
                DefaultListModel lAgentSelect = new DefaultListModel<>();
                for (String i: indices ) {
                    lAgentSelect.addElement(i);
                }
                listAgentSelct.setModel(lAgentSelect);
                if (listAgentSelct.getModel().getSize()!=0) {
                    Lerreur.setText("");
                    PajoutPat.setVisible(true);
                    Peffeectif.setVisible(false);
                }
                else{
                    Lerreur.setText("pas d'agent selectionner");
                }

            }
        });

        btnEntrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (syntax() == true) {
                    listSPEntiere = (listSP);
                    System.out.println(listSPEntiere);
                    panelRapport.setVisible(true);
                    panelDebut.setVisible(false);
                    PanelPatrouille.setVisible(false);
                    btnEntrer.setVisible(false);
                }
                else{
                    Lerreur.setText("erreur syntaxe ou reste des agents a sélectionner");
                }
            }
        });

        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(listAgentSelct.getSelectedValue()==null || listSecteur.getSelectedValue()==null || listVeh.getSelectedValue()==null){
                    Lerreur.setText("erreur pas de secteur, véhicule ou agent selectionner");
                }
                else {
                    Lerreur.setText("");
                    sp();
                    listSP.addElement(nomSp.getText());

                    listSp.setModel(listSP);
                    DefaultListModel model = (DefaultListModel) listAgentSelct.getModel();
                    for (int i = 0; i < 10; i++) {
                        int selectedIndex = listAgentSelct.getSelectedIndex();
                        if (selectedIndex != -1) {
                            model.remove(selectedIndex);
                        }
                    }
                    PanelPatrouille.setVisible(false);
                }
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

    public void listvehAgent(){
       //verifier si y a sgt, sheriff, mini 2 ranger, chaque fois appuie plus refais list veh
       //verifier quand Sheriff pas mettre granger 2021 sans sheriff
        listVeh.removeAll();
        DefaultListModel listveh = new DefaultListModel<>();
        int nb = 0 ;

        for (int i = nb; i<ag.listeVeh().length; i++) {
            listveh.addElement(ag.listeVeh()[i]);
        }
        listVeh.setModel(listveh);

    }

    void sp(){
        List<String> indicesAg = listAgentSelct.getSelectedValuesList();
        List<String> indicesSect = listSecteur.getSelectedValuesList();
        List<String> indicesVeh = listVeh.getSelectedValuesList();

        nomSp.setText( "SP"+nbSP+" Agent: ");
        for (String i: indicesAg ) {
            nomSp.setText( nomSp.getText()+i + ", ");
        }

        nomSp.setText( nomSp.getText() +" Secteur: ");
        for (String i: indicesSect ) {
            nomSp.setText( nomSp.getText() +i);
        }

        nomSp.setText( nomSp.getText() +" Véhicule: ");
        for (String i: indicesVeh ) {
            nomSp.setText( nomSp.getText() +i);
        }
    }
    boolean syntax(){
        boolean test = false;

        if(!central.getText().equals("")){
            if (Pattern.matches("^([0-1][0-9]|2[0-3])h[0-5][0-9]$", DebuDisp.getText()) == true && DebuDisp.getText()!= "") {
               if(listAgentSelct.getModel().getSize()==0) {
                   test = true;
               }
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

    void heureRapport(){

    }
    private void back() {
        onCancel();
        Menu dialog = new Menu();
        dialog.pack();
        dialog.setSize(1500,1000);
        dialog.setVisible(true);

    }

}
