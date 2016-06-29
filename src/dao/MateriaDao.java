package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.EstadoMateria;
import model.Materia;

public class MateriaDao {
	private static DaoHelper daoHelper;
	
	public MateriaDao() {
		MateriaDao.daoHelper = new DaoHelper();
	}
	
	public static void inserirMateria(Materia materia) {
		
		Connection conn = daoHelper.getConnection();
		String sql = "INSERT INTO materia(idCurso, nomeMateria, periodoAssociado, cargaHoraria) VALUES(?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, materia.getIdCurso());
			stmt.setString(2, materia.getNomeMateria());
			stmt.setInt(3, materia.getPeriodoAssociado());
			stmt.setInt(4, materia.getCargaHoraria());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			materia.setIdMateria(rs.getInt(1));
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static Materia getMateria(int idMateria) {
		Materia materia = null;
		Connection conn = daoHelper.getConnection();
		String sql = "SELECT * FROM materia WHERE materia.idMateria = " + idMateria;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			materia = new Materia(rs.getInt("idMateria"), rs.getString("nomeProfessor"), rs.getInt("idCurso"), rs.getString("nomeMateria"), rs.getInt("periodoAssociado"), rs.getInt("cargaHoraria"));
			daoHelper.releaseAll(rs, stmt, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return materia;
	}
	
	public static void atualizaEstadoUltimaMatricula(Materia materia) {
		
	}
	
	public static ArrayList<Materia> materiasEstado(EstadoMateria estado) {

		ArrayList<Materia> listaMaterias = null;
		daoHelper = new DaoHelper();
		Connection conn = daoHelper.getConnection();
		String sql = "select m.idMateria, m.nomeProfessor, m.idCurso, m.nomeMateria, m.periodoAssociado, m.cargaHoraria from materia m, materiaPeriodo mp where m.idMateria = mp.idMateria and mp.estadoMateria ='" + estado.getNomeEstado()+"'";
		try {
			listaMaterias = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				listaMaterias.add(new Materia(rs.getInt("idMateria"), rs.getString("nomeProfessor"), rs.getInt("idCurso"), rs.getString("nomeMateria"), rs.getInt("periodoAssociado"), rs.getInt("cargaHoraria")));
			}
			for(Materia m : listaMaterias) {
				sql = "select p.nomePeriodo from periodo p where p.idPeriodo in (select mp.idPeriodo from materiaPeriodo mp, materia m where mp.idMateria =" + m.getIdMateria();
				PreparedStatement stmt2 = conn.prepareStatement(sql);
				ResultSet rs2 = stmt2.executeQuery();
				rs2.next();
				m.setCursadaUltimaVez(rs.getString("nomePeriodo"));
				m.setEstado(estado);
				daoHelper.release(rs2);
				daoHelper.release(stmt2);
			}
			
			daoHelper.releaseAll(rs, stmt, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaMaterias;
	}
	
	public static ArrayList<Materia>  getMateriasPeriodo(int idPeriodo) {
		ArrayList<Materia> listaMaterias = null;
		daoHelper = new DaoHelper();
		Connection conn = daoHelper.getConnection();
		
		String sql = "select m.idMateria, m.nomeProfessor, m.idCurso, m.nomeMateria, m.periodoAssociado, m.cargahoraria, mp.estadomateria from materia m, materiaPeriodo mp where m.idMateria = mp.idMateria and mp.idPeriodo =" + idPeriodo;
		
		try {
			listaMaterias = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				listaMaterias.add(new Materia(
						rs.getInt("idMateria"), 
						rs.getString("nomeProfessor"), 
						rs.getInt("idCurso"), 
						rs.getString("nomeMateria"), 
						//EstadoMateria.valueOf(rs.getString("estadoMateria").toUpperCase()), 
						rs.getInt("periodoAssociado"), 
						rs.getInt("cargaHoraria")));
			}
			String sql2 = "";
			PreparedStatement stmt2 = null;
			ResultSet rs2 = null;
			for(Materia m : listaMaterias) {
				sql2 = "select mp. estadoMateria from materiaPeriodo mp where mp.idmateria = " +  m.getIdMateria() + " and idPeriodo = " + idPeriodo ;
				stmt2 = conn.prepareStatement(sql2);
				rs2 = stmt2.executeQuery();
				rs2.next();
				m.setEstado(EstadoMateria.valueOf(rs2.getString("estadoMateria")));
			}
			daoHelper.release(rs2);
			daoHelper.release(stmt2);
			daoHelper.releaseAll(rs, stmt, conn); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaMaterias;
	}
	
	public static ArrayList<Materia> getAll(){
		return getBy("1", 1); 
	}
	
	public static <T1> ArrayList<Materia> getBy(String nomeCampo, T1 valorCampo ) {
		ArrayList<Materia> lista = new ArrayList<>();
		daoHelper = new DaoHelper();
		Connection c = daoHelper.getConnection();
		String sql = "SELECT * FROM materia where "+nomeCampo+" = '"+valorCampo+"'";
		
		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				Materia usr = new Materia(
						rs.getInt("idMateria"), 
						rs.getString("nomeProfessor"), 
						rs.getInt("idCurso"), 
						rs.getString("nomeMateria"),
						rs.getInt("periodoAssociado"), 
						rs.getInt("cargaHoraria")
						);
				lista.add(usr);
			}
			String sql2 = "";
			PreparedStatement stmt2 = null;
			ResultSet rs2 = null;
			for(Materia m : lista) {
				sql2 = "select mp. estadoMateria from materiaPeriodo mp where mp.idmateria = " +  m.getIdMateria() + " and idPeriodo = " + 1 ;
				stmt2 = c.prepareStatement(sql2);
				rs2 = stmt2.executeQuery();
				rs2.next();
				m.setEstado(EstadoMateria.valueOf(rs2.getString("estadoMateria")));
			}
			daoHelper.release(rs2);
			daoHelper.release(stmt2);
			daoHelper.releaseAll(rs, ps, c); 
			daoHelper.releaseAll(rs, ps, c);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return lista;
	}
}
