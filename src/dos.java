import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dos extends JFrame{
    private JComboBox nombresCB;
    private JComboBox passwordCB;
    private JPanel ComboBox;
    private JComboBox idCB;
    private JComboBox emailCB;
    private JComboBox direccionCB;
    Connection con;
    Statement st;
    ResultSet rs;


    public static void main(String[] args) {
        JFrame frame = new JFrame("dos");
        frame.setContentPane(new dos().ComboBox);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public dos() {
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost/mitienda?serverTimezone=UTC","csjurado","12345");
            st=con.createStatement();
            String s="select * from user";
            rs=st.executeQuery(s);
            while(rs.next()){

                idCB.addItem(rs.getString(1));
                emailCB.addItem(rs.getString(2));
                nombresCB.addItem(rs.getString(3));
                direccionCB.addItem(rs.getString(4));
                passwordCB.addItem(rs.getString(5));
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error");
        }finally {
            try{
                st.close();
                rs.close();
                con.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error cierre");
            }
        }


    }
}
