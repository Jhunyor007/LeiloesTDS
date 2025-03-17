

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDAO {
    conectaDAO conectaDAO;
    Connection conn;
    
public ProdutosDAO(){
    this.conectaDAO = new conectaDAO();
     this.conn = this.conectaDAO.connectDB();
}
   
    
    public void cadastrarProduto (ProdutosDTO produtos){
      
        String sql = "insert into produtos (nome, valor, status) values "+ "(?, ?, ?)"; 
            try {
                    PreparedStatement stmt = this.conn.prepareStatement(sql);
                    
                    stmt.setString(1, produtos.getNome());
                    stmt.setInt(2, produtos.getValor());
                    stmt.setString(3, produtos.getStatus());
                    stmt.execute();  
                    
              JOptionPane.showMessageDialog(null,"Produto salvo com sucesso" );
                } 
            
            catch (Exception e) {
                   System.out.println("Erro ao inserir Produto: " + e.getMessage());
                }
                
            }
    
    
   
     public List<ProdutosDTO> listarProdutos(){
    String sql = "select * from produtos  ";
    
    try
    {
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        List<ProdutosDTO> listagem = new ArrayList<>();
        
            while(rs.next()){
            ProdutosDTO p = new ProdutosDTO();
                                   
                        p.setId(rs.getInt("id"));
                        p.setNome(rs.getString("nome"));
                        p.setValor(rs.getInt("valor"));
                        p.setStatus(rs.getString("status"));
                        
                        listagem.add(p);
                    }
                    
                    return listagem;
       
        
    }
    catch (Exception e){
        return null;
    }
    
  
     }
    
        
}

