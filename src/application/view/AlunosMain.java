package application.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import application.model.Alunos;
import application.persistence.AlunosDao;

public class AlunosMain {

	public static void main(String[] args) {
		
		int i = 0;
		
		while(i==0){
			int acao = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Criar Aluno\n 2 - Atualizar Aluno\n 3 - Excluir Aluno\n 4 - Listar Alunos\n 5 - Sair"));
			Alunos aluno = new Alunos();
			String nome;
			int id;
			int ra;
			switch(acao){
				case 1:
					nome = JOptionPane.showInputDialog(null, "Qual o nome do aluno?");
					aluno.setNome(nome);
					ra = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o RA do aluno?"));
					aluno.setRa(ra);
					try {
						AlunosDao aDao = new AlunosDao();
						aDao.insereAlunos(aluno);
						JOptionPane.showMessageDialog(null, "Aluno "+nome+" cadastrado!");
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
					break;
				case 2: id = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o Id do aluno?"));
					aluno.setId(id); 
					nome = JOptionPane.showInputDialog(null, "Qual o nome do aluno?");
					aluno.setNome(nome);
					ra = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o RA do aluno?"));
					aluno.setRa(ra);
					try {
						AlunosDao aDao = new AlunosDao();
						aDao.atualizaAlunos(aluno);
						JOptionPane.showMessageDialog(null, "Aluno "+nome+" atualizado!");
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
					break;
				case 3: id = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o Id do aluno?"));	
					try {
						AlunosDao aDao = new AlunosDao();
						aDao.excluiAlunos(id);
						JOptionPane.showMessageDialog(null, "Aluno excluido!");
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
					break;
				case 4:	
					try {
						AlunosDao aDao = new AlunosDao();
						List<Alunos> listaalunos = aDao.consultaAlunos();
						String listaescrita = "";
						if(listaalunos != null){
							for(Alunos a: listaalunos){
								listaescrita = (listaescrita + a.getId()+" 	|	"+a.getNome()+"	 |	"+a.getRa()+"\n");
							}
						}
						JOptionPane.showMessageDialog(null, "Lista de Alunos:\n\n Id	|	Nome	|	RA\n"+listaescrita);
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
					break;
				case 5: i++;
				break;
				default: JOptionPane.showMessageDialog(null, "Opção Inválida");
					break;
			}
		}
		
	}

}
