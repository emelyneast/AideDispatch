import javax.swing.*;
import java.awt.event.*;

public class Menu extends JDialog {
    private JPanel contentPane;

    private JButton buttonCancel;
    private JLabel TitreM;
    private JButton LHG;
    private JButton LSSD;
    private JPasswordField passwordField1;
    private JButton entrerBtn;
    private JPanel Ppdw;
    private JLabel mauvais;
    private JButton casierBtn;
    private JPanel panelBtn;
    private JPanel panelEntier;
    private JButton button1;
    private JLabel photo;
    private JLabel photo1;
    private JLabel photo2;
    private int nb = 1;

    int p = 0;
    public Menu() {
        setContentPane(contentPane);
        setModal(true);
        Ppdw.setVisible(false);
        panelBtn.setVisible(true);
        photo.setVisible(false);
        photo1.setVisible(false);
        photo2.setVisible(false);

        LHG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    onLSSD();
                    nb = 2;
            }
        });
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (p == 3){
                    photo2.setVisible(false);
                    p = 0;
                }else {
                    p = p+1;
                }

                if(p == 1) {
                    photo.setVisible(true);
                } else if (p == 2) {
                    photo.setVisible(false);
                    photo1.setVisible(true);
                }
                else if (p == 3) {
                    photo1.setVisible(false);
                    photo2.setVisible(true);
                }
            }
        });

        entrerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOk();
            }
        });


        LSSD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLSSD();
                nb = 1;
            }

        });

        casierBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Casier cs = new Casier();
                    onCancel();
                    cs.pack();
                    cs.setSize(1500,1000);
                    cs.setVisible(true);
            }

        });
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
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

    private void onLSSD() {
        Ppdw.setVisible(true);
        nb = 1;
    }

    private void onHG() {
        Ppdw.setVisible(true);
        nb = 2;
    }

    private void onOk(){
        Mdp mdp = new Mdp();
        String pass = new String(passwordField1.getPassword());
        String bonMdp;
        if (nb==1){
            bonMdp = mdp.mdpLSSD;
            Dispatch dialog = new Dispatch();
            if( pass.equals(bonMdp)){
                onCancel();
                dialog.pack();
                dialog.setSize(1500,1000);
                dialog.setVisible(true);
            }
            else {
                mauvais.setText("Euh non");
                System.out.println("nique ta mere");
            }
        }
         if (nb==2){
            bonMdp = mdp.mdpHautGrade;
            HautGrade dialog = new HautGrade();
            if( pass.equals(bonMdp)){
                onCancel();
                dialog.pack();
                dialog.setSize(1500,1000);
                dialog.setVisible(true);
            }
            else {
                mauvais.setText("ta cru t'était haut gradé ?");
                System.out.println("nique ta mere");
            }
        }

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
