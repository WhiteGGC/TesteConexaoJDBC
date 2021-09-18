package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Alunos;

public class AlunosDao{

	private Connection c;
	
	public AlunosDao() throws ClassNotFoundException, SQLException{
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}
	
	public void insereAlunos(Alunos aluno) throws SQLException{
		String sql = "INSERT INTO alunos (nome, ra) VALUES (?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, aluno.getNome());
		ps.setInt(2, aluno.getRa());
		ps.execute();
		ps.close();
	}
	
	public void atualizaAlunos(Alunos aluno) throws SQLException {
		String sql = "UPDATE alunos SET nome = ?, ra = ? WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, aluno.getNome());
		ps.setInt(2, aluno.getRa());
		ps.setInt(3, aluno.getId());
		ps.execute();
		ps.close();
	}
	
	public void excluiAlunos(int id) throws SQLException {
		String sql = "DELETE alunos WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		ps.close();
	}
	
	public Alunos consultaAluno(int id) throws SQLException {
		String sql = "SELECT id, nome, ra FROM alunos WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Alunos aluno = new Alunos();
		if (rs.next()){
			aluno.setId(rs.getInt("id"));
			aluno.setNome(rs.getString("nome"));
			aluno.setRa(rs.getInt("ra"));
		}
		rs.close();
		ps.close();
		return aluno;
	}
	
	public List<Alunos> consultaAlunos() throws SQLException {
		List<Alunos> listaAlunos = new ArrayList<Alunos>();
		String sql = "SELECT id, nome, ra FROM alunos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Alunos aluno = new Alunos();
			aluno.setId(rs.getInt("id"));
			aluno.setNome(rs.getString("nome"));
			aluno.setRa(rs.getInt("ra"));
			listaAlunos.add(aluno);
		}
		rs.close();
		ps.close();
		return listaAlunos;
	}
	
	public int proximoId() throws SQLException {
		String sql = "SELECT MAX(id) + 1 AS proximo_id FROM alunos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			return rs.getInt("proximo_id");
		} else {
			return 1;
		}
	}
}
