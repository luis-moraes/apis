package br.edu.devmedia.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.devmedia.exception.ApiException;
import br.edu.devmedia.orm.Database;

public class LembreteRepository {
	
	public static final int PAGE_LENGTH = 5;
	
	public List<Lembrete> getByRange(int page) throws ApiException {

		List<Lembrete> lista = new ArrayList<>();

		try {
			Connection conexao = Database.getConnection();
			
			page = (page - 1) * PAGE_LENGTH;
			
			PreparedStatement statement = conexao.prepareStatement(
					"SELECT * FROM lembrete LIMIT ?,?");
			statement.setInt(1, page);
			statement.setInt(2, PAGE_LENGTH);
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Lembrete lembrete = new Lembrete(
						rs.getInt("IDLembrete"), 
						rs.getString("StTitulo"), 
						rs.getString("TxDescricao"));
				lista.add(lembrete);
			}
		} catch(Exception e){
			throw new ApiException(500, 
					"Erro ao paginar os dados do banco de dados. " + e.getMessage());
		}			

		return lista;
	}

	public List<Lembrete> getAll() throws ApiException {

		List<Lembrete> lista = new ArrayList<>();

		try {
			Connection conexao = Database.getConnection();
			PreparedStatement statement = conexao.prepareStatement(
					"SELECT * FROM lembrete LIMIT " + PAGE_LENGTH);

			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Lembrete lembrete = new Lembrete(
						rs.getInt("IDLembrete"), 
						rs.getString("StTitulo"), 
						rs.getString("TxDescricao"));
				lista.add(lembrete);
			}
		} catch(Exception e){
			throw new ApiException(500, 
					"Erro ao buscar os dados no banco de dados. " + e.getMessage());
		}

		return lista;
	}
}
