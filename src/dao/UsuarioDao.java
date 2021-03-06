package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Usuario;

public class UsuarioDao {
	private static DaoHelper daoHelper;
	
	public UsuarioDao() {
		UsuarioDao.daoHelper = new DaoHelper();
	}
	
	public static void cadastrarUsuario(Usuario usuario) {
		daoHelper = new DaoHelper();
		Connection conn = daoHelper.getConnection();
		String sql = "INSERT INTO usuario(nomeUsuario, registro, dataNascimento) VALUES(?, ?, ?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, usuario.getNome());
			stmt.setInt(2, usuario.getRegistro());
			stmt.setDate(3, (Date) usuario.getNascimento());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			usuario.setId(rs.getInt("idUsuario"));
			stmt.close();
			
			daoHelper.releaseAll(rs, stmt, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Usuario recuperaUsuario(String nomeUsuario) {
		daoHelper = new DaoHelper();
		Usuario usuario = null;
		Connection conn = daoHelper.getConnection();
		String sql = "SELECT * FROM usuario WHERE usuario.nomeUsuario = " + "'" + nomeUsuario + "'";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			usuario = new Usuario(rs.getInt("idUsuario"), rs.getString("nomeUsuario"), rs.getInt("registro"), rs.getDate("dataNascimento"));
			
			daoHelper.releaseAll(rs, stmt, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	public static ArrayList<Usuario> getAll(){
		return getBy("1",1);
	}
	public static <T> ArrayList<Usuario> getBy(String nomeCampo, T valorCampo )
	{
		daoHelper = new DaoHelper();
		ArrayList<Usuario> lista = new ArrayList<>();
		Connection c = daoHelper.getConnection();
		String sql = "SELECT * FROM usuario where "+nomeCampo+" = '"+valorCampo+"'";
		
		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() )
			{
				Usuario usr = new Usuario(rs.getInt		("idUsuario")	,
										  rs.getString	("nomeUsuario")	,
										  rs.getInt		("registro")	,
										  rs.getDate	("dataNascimento")
										  );
				lista.add(usr);
			}
			daoHelper.releaseAll(rs, ps, c);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return lista;
	}
	
	public static <T> int updateBy( String campo, T novoValor, String campoComparacao, T valorComparacao){
		daoHelper = new DaoHelper();
		Connection c = daoHelper.getConnection();
		String sql = "UPDATE usuario set "+campo+"="+novoValor+" where "+campoComparacao+" = "+valorComparacao+";";
		int nAlteracoes = 0;
		try{
			PreparedStatement ps = c.prepareStatement(sql);
			nAlteracoes = ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return nAlteracoes;
	}
}
