package src.Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import src.UlarTanggaThread;
import src.Database.DatabaseHandler;

public class UlarTangga extends JFrame implements ActionListener, GameInterface {
   private int posPlayer1 = 1;
   private int posPlayer2 = 1;
   public static int cekPlayer1 = 1;
   public static int cekPlayer2 = 1;
   String nP1;
   String nP2;
   int turn = 1;
   public static int dc1;
   public static int dc2;
   public static Boolean temp = false;
   public static ImageIcon[] dadu = new ImageIcon[] { new ImageIcon("img/dice1.png"), new ImageIcon("img/dadu2.jpeg"),
         new ImageIcon("img/dice3.png"), new ImageIcon("img/dadu4.jpeg"), new ImageIcon("img/dice5.png"),
         new ImageIcon("img/dadu6.jpeg") };
   ImageIcon[][] PapanKosong = new ImageIcon[10][10];
   ImageIcon[][] PapanP1 = new ImageIcon[10][10];
   ImageIcon[][] PapanP1P2 = new ImageIcon[10][10];
   ImageIcon[][] PapanP2 = new ImageIcon[10][10];
   ImageIcon Player1 = new ImageIcon("img/p1.png");
   ImageIcon Player2 = new ImageIcon("img/p2.png");
   ImageIcon icon1 = new ImageIcon("img/ceklis1.gif");
   ImageIcon icon2 = new ImageIcon("img/ceklis2.gif");
   JButton buttonGo = new JButton("Kocok Dadu");
   JButton buttonStop = new JButton("Berhenti");
   JMenuBar menuBar = new JMenuBar();
   JMenu fileMenu = new JMenu("File");
   JMenu helpMenu = new JMenu("Help");
   JButton buttonLeaderboard = new JButton("Leaderboard");

   JMenuItem menuNew = new JMenuItem("2 Player");
   JMenuItem menuExit = new JMenuItem("Keluar");
   JMenuItem menuHelp = new JMenuItem("Cara Bermain");
   // JMenuItem menuLeaderboard = new JMenuItem("Peringkat Menang");
   Container c = this.getContentPane();
   public static JLabel dice1 = new JLabel();
   public static JLabel dice2 = new JLabel();
   JLabel[][] lArrPapan = new JLabel[10][10];
   JLabel p1;
   JLabel p2;
   JLabel nama1;
   JLabel nama2;
   JLabel h1;
   JLabel h2;
   JLabel title;
   JPanel pUtara;
   JPanel pJudul;
   JPanel pCenter;
   JPanel pPapan;
   JPanel pDadu1;
   JPanel pDadu2;
   JPanel pButton;
   JPanel pInButton;
   JPanel pCeklis1;
   JPanel pCeklis2;
   JPanel pP1name;
   JPanel pP2name;
   JPanel pP1pic;
   JPanel pP2pic;

   @Override
   public void callImage() {
      for (int i = 0; i < 10; ++i) {
         for (int j = 0; j < 10; ++j) {
            this.PapanKosong[i][j] = new ImageIcon("papan/" + i + "-" + j + ".png");
            this.PapanP1[i][j] = new ImageIcon("papanP1/" + i + "-" + j + ".png");
            this.PapanP1P2[i][j] = new ImageIcon("papanP1P2/" + i + "-" + j + ".png");
            this.PapanP2[i][j] = new ImageIcon("papanP2/" + i + "-" + j + ".png");
         }
      }
   }

   UlarTangga(int t, String player1, String player2, int posisiP1, int posisiP2, Boolean sign, int jalan) {

      super("Permainan Ular Tangga");
      this.p1 = new JLabel(this.Player1);
      this.p2 = new JLabel(this.Player2);
      this.h1 = new JLabel();
      this.h2 = new JLabel();
      this.title = new JLabel("====== Ular Tangga ======");
      this.pUtara = new JPanel();
      this.pJudul = new JPanel();
      this.pCenter = new JPanel();
      this.pPapan = new JPanel();
      this.pDadu1 = new JPanel();
      this.pDadu2 = new JPanel();
      this.pButton = new JPanel();
      this.pInButton = new JPanel();
      this.pCeklis1 = new JPanel();
      this.pCeklis2 = new JPanel();
      this.pP1name = new JPanel();
      this.pP2name = new JPanel();
      this.pP1pic = new JPanel();
      this.pP2pic = new JPanel();
      this.c.setLayout((LayoutManager) null);
      this.setJMenuBar(this.menuBar);
      this.menuBar.add(this.fileMenu);
      this.menuBar.add(this.helpMenu);
      buttonLeaderboard.setContentAreaFilled(false);
      this.menuBar.add(buttonLeaderboard);
      this.fileMenu.add(this.menuNew);
      this.fileMenu.add(this.menuExit);
      this.helpMenu.add(this.menuHelp);

      this.menuNew.setAccelerator(KeyStroke.getKeyStroke(80, 128));
      this.menuExit.setAccelerator(KeyStroke.getKeyStroke(81, 128));
      this.menuNew.addActionListener(this);
      this.menuExit.addActionListener(this);
      this.menuHelp.addActionListener(this);
      this.buttonGo.addActionListener(this);
      this.buttonStop.addActionListener(this);
      buttonLeaderboard.addActionListener(this);

      this.pCenter.setBounds(10, 70, 460, 470);
      this.pCenter.add(this.pPapan);
      this.pPapan.setLayout(new GridLayout(10, 10));
      this.callImage();

      for (int i = 0; i < 10; ++i) {
         for (int j = 0; j < 10; ++j) {
            Dimension imgSize = new Dimension(45, 45);
            this.lArrPapan[i][j] = new JLabel(this.PapanKosong[i][j]);
            this.lArrPapan[i][j].setPreferredSize(imgSize);
            this.pPapan.add(this.lArrPapan[i][j]);
         }
      }

      if (sign) {
         this.lArrPapan[9][0].setIcon(this.PapanP1P2[9][0]);
      }

      this.c.add(this.pCenter, "Utara");
      Dimension diceSize = new Dimension(45, 45);
      this.pDadu1.setBounds(490, 190, 58, 58);
      dice1.setIcon(dadu[0]);
      dice1.setPreferredSize(diceSize);
      this.pDadu1.add(dice1);
      this.c.add(this.pDadu1, "Utara");
      this.pDadu2.setBounds(570, 190, 58, 58);
      dice2.setIcon(dadu[0]);
      dice2.setPreferredSize(diceSize);
      this.pDadu2.add(dice2);
      this.c.add(this.pDadu2, "Utara");
      this.pP1pic.setBounds(490, 80, 38, 38);
      this.pP1pic.add(this.p1);
      this.c.add(this.pP1pic, "Utara");
      this.pP2pic.setBounds(480, 120, 50, 50);
      this.pP2pic.add(this.p2);
      this.c.add(this.pP2pic, "Utara");
      this.pCeklis1.setBounds(600, 90, 38, 38);
      this.h1.setIcon(this.icon1);
      this.pCeklis1.add(this.h1);
      this.c.add(this.pCeklis1, "Utara");
      this.pCeklis2.setBounds(600, 140, 50, 50);
      this.h2.setIcon(this.icon2);
      this.pCeklis2.add(this.h2);
      this.c.add(this.pCeklis2, "Utara");
      this.nama1 = new JLabel(player1);
      this.pP1name.setBounds(525, 90, 65, 38);
      this.pP1name.add(this.nama1);
      this.c.add(this.pP1name, "Timur");
      this.nama2 = new JLabel(player2);
      this.pP2name.setBounds(525, 140, 65, 50);
      this.pP2name.add(this.nama2);
      this.c.add(this.pP2name, "Timur");
      this.nP1 = player1;
      this.nP2 = player2;
      this.pButton.setBounds(498, 280, 125, 125);
      this.pButton.add(this.pInButton);
      GridBagLayout gridbag = new GridBagLayout();
      GridBagConstraints constraints = new GridBagConstraints();
      this.pInButton.setLayout(gridbag);
      constraints.ipadx = 70;
      constraints.gridwidth = 2;
      constraints.gridheight = 2;
      gridbag.setConstraints(this.buttonGo, constraints);
      this.pInButton.add(this.buttonGo);
      constraints.ipadx = 60;
      constraints.gridx = 1;
      constraints.gridy = 1;
      constraints.gridwidth = 2;
      constraints.gridheight = 2;
      gridbag.setConstraints(this.buttonStop, constraints);
      this.pInButton.add(this.buttonStop);
      this.c.add(this.pButton, "Utara");
      if (t == 0) {
         this.buttonGo.setEnabled(false);
         this.buttonStop.setVisible(false);
      }

      this.pUtara.setBounds(3, 0, 650, 200);
      this.pUtara.add(this.pJudul);
      this.title.setFont(new Font("Helvatica", 1, 35));
      this.title.setForeground(Color.blue);
      this.pJudul.add(this.title);
      this.c.add(this.pUtara, "Utara");
      this.setSize(650, 600);
      this.setResizable(false);
      this.setVisible(true);
      this.setLocationRelativeTo((Component) null);
      this.setDefaultCloseOperation(3);
   }

   @Override
   public void jalan(int posisiP1, int posisiP2, int giliran) {
      GameManager.Jalan(this, posisiP1, posisiP2, giliran);
   }
   
   public static int getCekPlayer1() {
      return cekPlayer1;
   }
   
   public static int getCekPlayer2() {
      return cekPlayer2;
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == this.menuNew) {
         temp = true;
         this.nP1 = JOptionPane.showInputDialog((Component)null, "Masukkan nama Player 1 :");
         this.nP2 = JOptionPane.showInputDialog((Component)null, "Masukkan nama Player 2 :");
         String N1;
         String N2;
         if (!this.nP1.equals(" ") && !this.nP2.equals(" ")) {
            if (!this.nP1.equals("") && !this.nP2.equals("")) {
               if (this.nP1.equals(this.nP2)) {
                  JOptionPane.showMessageDialog(this, "Nama Player 1 dan Player 2 Tidak Boleh Sama");
                  N1 = "";
                  N2 = "";
                  new UlarTangga(0, N1, N2, 1, 1, false, 1);
               } else if (!this.nP1.equals(this.nP2)) {
                  this.buttonGo.setEnabled(true);
                  this.buttonGo.setVisible(true);
                  this.buttonStop.setVisible(false);
                  this.buttonStop.setEnabled(false);
                  this.turn = 1;
                  this.posPlayer1 = 1;
                  this.posPlayer2 = 1;
                  new UlarTangga(1, this.nP1, this.nP2, this.posPlayer1, this.posPlayer2, true, this.turn);
               }
            } else {
               JOptionPane.showMessageDialog(this, "Nama Player Harus Diisi Terlebih Dahulu ");
               N1 = "";
               N2 = "";
               new UlarTangga(0, N1, N2, 1, 1, false, 1);
            }
         } else {
            JOptionPane.showMessageDialog(this, "Nama Player Harus Diisi Terlebih Dahulu");
            N1 = "";
            N2 = "";
            new UlarTangga(0, N1, N2, 1, 1, false, 1);
         }
      } else if (e.getSource() == this.menuHelp) {
         JOptionPane.showMessageDialog((Component)null, "1. Klik Menu File");
         JOptionPane.showMessageDialog((Component)null, "2. Kemudian pilih 2 Player");
         JOptionPane.showMessageDialog((Component)null, "3. Lalu isi Nama dan kocok dadu");
      }else if (e.getSource() == buttonLeaderboard) {
         DatabaseHandler.showLeaderboard();
         new Leaderboard();
      }else if (e.getSource() == this.menuExit) {
         System.exit(0);
      } else if (e.getSource() == this.buttonGo) {
         this.buttonStop.setVisible(true);
         this.buttonStop.setEnabled(true);
         this.buttonGo.setEnabled(false);
         this.buttonGo.setVisible(false);
         temp = false;
     
         UlarTanggaThread runnable = new UlarTanggaThread(); //MULTITHREAD
         Thread thread = new Thread(runnable);
         thread.start();
      } else if (e.getSource() == this.buttonStop) {
         temp = true;
         cekPlayer1 = this.posPlayer1;
         cekPlayer2 = this.posPlayer2;
         String namaPemenang = ""; // Tambahkan variabel untuk menyimpan nama pemain yang menang
         if (this.turn == 1) {
            this.posPlayer1 = this.posPlayer1 + dc1 + dc2 + 2;
            if (this.posPlayer1 > 100) {
               this.posPlayer1 = 100 - (this.posPlayer1 - 100);
            } else if (this.posPlayer1 == 100) {
               this.lArrPapan[0][0].setIcon(this.PapanP1[0][0]);
               namaPemenang = this.nP1; // Simpan nama pemain yang menang
               JOptionPane.showMessageDialog(this, "Horeeee! " + namaPemenang + " menang yeayyyyy!");
            }
         } else if (this.turn == 2) {
            this.posPlayer2 = this.posPlayer2 + dc1 + dc2 + 2;
            if (this.posPlayer2 > 100) {
               this.posPlayer2 = 100 - (this.posPlayer2 - 100);
            } else if (this.posPlayer2 == 100) {
               this.lArrPapan[0][0].setIcon(this.PapanP2[0][0]);
               namaPemenang = this.nP2; // Simpan nama pemain yang menang
               JOptionPane.showMessageDialog(this, "Horeeee! " + namaPemenang + " menang yeayyyyy!");
            }
         }
         if (this.posPlayer1 == 100 || this.posPlayer2 == 100) {
            if (this.turn == 1) {
               DatabaseHandler.simpanDataPemain(this.nP1, 1); // Menyimpan data pemain 1
            } else {
               DatabaseHandler.simpanDataPemain(this.nP2, 1); // Menyimpan data pemain 2
            }
        }
        //buat ular ular 
         switch(this.posPlayer1) {
         case 3:
            this.posPlayer1 = 23;
            break;
         case 33:
            this.posPlayer1 = 15;
            break;
         case 50:
            this.posPlayer1 = 69;
            break;
         case 59:
            this.posPlayer1 = 39;
            break;
         case 65:
            this.posPlayer1 = 95;
            break;
         case 89:
            this.posPlayer1 = 67;
            break;
         case 98:
            this.posPlayer1 = 56;
         }

         switch(this.posPlayer2) {
         case 3:
            this.posPlayer2 = 23;
            break;
         case 33:
            this.posPlayer2 = 15;
            break;
         case 50:
            this.posPlayer2 = 69;
            break;
         case 59:
            this.posPlayer2 = 39;
            break;
         case 65:
            this.posPlayer2 = 95;
            break;
         case 89:
            this.posPlayer2 = 67;
            break;
         case 98:
            this.posPlayer2 = 56;
         }

         this.jalan(this.posPlayer1, this.posPlayer2, this.turn);
         if (this.turn == 1) {
            this.h1.setIcon(this.icon2);
            this.h2.setIcon(this.icon1);
            this.turn = 2;
         } else {
            this.h1.setIcon(this.icon1);
            this.h2.setIcon(this.icon2);
            this.turn = 1;
         }

         if (this.posPlayer1 != 100 && this.posPlayer2 != 100) {
            this.buttonGo.setEnabled(true);
            this.buttonGo.setVisible(true);
            this.buttonStop.setVisible(false);
            this.buttonStop.setEnabled(false);
         } else {
            this.buttonStop.setVisible(false);
            this.buttonStop.setEnabled(false);
            this.buttonGo.setVisible(true);
            this.buttonGo.setEnabled(false);
         }
      }
   }
}