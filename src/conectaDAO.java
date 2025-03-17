
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class conectaDAO {
    
    public Connection connectDB(){
         try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/Leiloes ", // linha de conexao
                    "root", // usuario do mysql
                    "312705"// senha do mysql
         
            );
            JOptionPane.showMessageDialog(null,"MYSQL conectado com sucesso");
            return conn;
           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
    
}
