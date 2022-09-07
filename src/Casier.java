import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class Casier extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox delits;
    private JTextField nom;
    private JTextField prenom;
    private JLabel LPrenom;
    private JLabel LNom;
    private JLabel Jdel;
    private JPanel Paneldelits;
    private JLabel Ldate;
    private JTextField date;
    private JButton ajout;
    private JTextArea areaDelit;
    private JTextArea textFinal;
    private JLabel erreur;
    private JComboBox listCDLR;
    private JLabel LcodeDLR;
    private JButton btnCDLR;
    private JTextArea textAmAutre;
    private JButton effacer;
    int amendefinal=0;
    int am=0;

    boolean prison = false;
    int annéeMin = 0;
    int annéeMax = 0;
    int gav = 0;
    String annéePrisontext;
    String aut="";
    CodePenal cp = new CodePenal("",0,false,0,0,"");
    //JScrollPane sp = new JScrollPane(areaDelit, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    public Casier() {

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        listCode();
        listCroute();


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                syntax();
                if(syntax()==true) {
                    onOK();
                    areaDelit.setVisible(false);
                    if (prison == false){
                        erreur.setText("attention pas de casier juste GAV");
                    }
                    textAmAutre.setText("amende : "+ amendefinal +" $ "+annéePrisontext+"\n autre "+aut);

                }
                else{
                    erreur.setText("remplir toute les case correctement");
                }
            }
        });

        ajout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaDelit.setText(areaDelit.getText()+"\n- "+delits.getSelectedItem().toString());

                amendefinal = amende(delits.getSelectedItem().toString());
                prisonGav(delits.getSelectedItem().toString());
            }
        });


        btnCDLR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                     areaDelit.setText(areaDelit.getText() + "\n- " + listCDLR.getSelectedItem().toString());
                     amendefinal = amende(listCDLR.getSelectedItem().toString());
                     prisonGav(listCDLR.getSelectedItem().toString());

            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
        effacer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               nom.setText("");
               prenom.setText("");
               date.setText("");
               textAmAutre.setText("");
               erreur.setText("");
               textFinal.setText("");
               areaDelit.setText("");
                 amendefinal=0;
                 am=0;
                areaDelit.setVisible(true);
                 prison = false;
                 annéeMin = 0;
                 annéeMax = 0;
                 gav = 0;
                 annéePrisontext="";
                 aut="";
            }
        });


        // call onCancel() when cross is clicked
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

    private void onOK() {
        // add your code here
        String str = prenom.getText().substring(0, 1).toUpperCase() + prenom.getText().substring(1);
        textFinal.setText("Casier judiciaire de "+nom.getText().toUpperCase()+" "+str+"\n\n[b][u]NOM (MAJUSCULE) Prénom (Minuscule) : [/b][/u]"+nom.getText().toUpperCase()+" "+str+"\n\n[b][u]Délits : \n[/b][/u]"+ areaDelit.getText()+" le "+date.getText()+"\n\n [b][u]Photo de Face : [/b][/u]\n \n[b][u]Photo de Profil :[/b][/u]");

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void listCode(){
        cp.listCode();
        for (CodePenal cp: cp.codePenal ) {
            delits.addItem(cp.getDef());
        }

    }

    public void listCroute(){
        cp.codePenal.clear();
        cp.listCodeDelaroute();

        for (CodePenal cp: cp.codePenal ) {
            listCDLR.addItem(cp.getDef());
        }
    }

    public boolean syntax(){
        boolean verif= false;
        if (Pattern.matches("^([0-2][0-9]|3[0-1])/(0[0-9]|1[0-2])/[0-9][0-9]$", date.getText()) && !nom.getText().equals("") && !prenom.getText().equals("") && !areaDelit.getText().equals("")) {
            verif = true;
        }
        else{
            verif = false;
        }
        return verif;


    }

    int amende(String t){

        cp.codePenal.clear();
        cp.listCode();
        cp.listCodeDelaroute();
        for (CodePenal cp : cp.codePenal){
            if (t == cp.getDef() ){
                am = am + cp.getAmande();
            }
        }

        return am;
    }

    void prisonGav(String t){

        cp.codePenal.clear();
        cp.listCode();
        cp.listCodeDelaroute();
        for (CodePenal cp : cp.codePenal){
            if (t == cp.getDef()){
                if(cp.getGav()==false){
                    prison = true;
                    annéeMin = annéeMin + cp.getMinEmprisonnement();
                    annéeMax = annéeMax + cp.getMaxEmprisonnement();
                    aut = aut + cp.getAutre();
                    annéePrisontext = "\n année prison minimum: "+ annéeMin +" \n année prison maximum: "+annéeMax ;

                }
                else{
                    if(prison==true){
                        prison = true;
                        aut = aut + cp.getAutre();


                    }
                    else{
                        prison = false;
                        aut = aut + cp.getAutre();
                        gav = gav + cp.getMinEmprisonnement();

                        annéePrisontext = "\n heure gav: "+ gav ;

                    }
                }
            }
        }
    }
}
