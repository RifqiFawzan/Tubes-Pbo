package src.Game;
import javax.swing.*;

import src.Database.DatabaseHandler;

import java.util.ArrayList;

public class Leaderboard extends JFrame {
    private JScrollPane leaderboardList;
    private JList<String> list;

    public Leaderboard() {
        setTitle("Leaderboard");
        setSize(200, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        list = new JList<>();
        leaderboardList = new JScrollPane(list);
        ArrayList<String> leaderboardData = DatabaseHandler.showLeaderboard();

        list.setModel(new AbstractListModel<String>() {
            public String[] nama = leaderboardData.toArray(new String[0]);

            public int getSize() {
                return nama.length;
            }

            public String getElementAt(int i) {
                return nama[i];
            }
        });

       
        setContentPane(leaderboardList);

        setVisible(true);
    }
}
