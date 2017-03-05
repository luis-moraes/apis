package br.edu.devmedia.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.edu.devmedia.domain.Lembrete;
import br.edu.devmedia.exception.ApiException;

public class LembreteMapper {

	public Lembrete select(Lembrete lembrete) throws ApiException {
		try {
			Connection conexao = Database.getConnection();
			PreparedStatement statement = conexao.prepareStatement(
					"SELECT * FROM lembrete WHERE IDLembrete = ?");
			statement.setInt(1, lembrete.getId());
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				lembrete = new Lembrete(
						rs.getInt("IDLembrete"), 
						rs.getString("StTitulo"), 
						rs.getString("TxDescricao"));
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new ApiException(500, e.getMessage());
		}

		return lembrete;
	}

	public Lembrete insert(Lembrete lembrete) throws ApiException {
		try {
			Connection conexao = Database.getConnection();
			PreparedStatement statement = conexao.prepareStatement(
					"INSERT INTO lembrete(StTitulo, TxDescricao) VALUES(?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, lembrete.getTitulo());
			statement.setString(2, lembrete.getDescricao());
			statement.execute();

			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				lembrete.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			throw new ApiException(500, e.getMessage());
		}

		return this.select(lembrete);
	}

	public Lembrete update(Lembrete lembrete) throws ApiException {

		try {
			Connection conexao = Database.getConnection();
			PreparedStatement statement = conexao
					.prepareStatement(
							"UPDATE lembrete SET StTitulo = ?, TxDescricao = ? WHERE IDLembrete = ?");
			statement.setString(1, lembrete.getTitulo());
			statement.setString(2, lembrete.getDescricao());
			statement.setInt(3, lembrete.getId());
			statement.execute();

			if (statement.getUpdateCount() == 0) {
				throw new ApiException(404, "O lembrete informado não existe.");
			}
		} catch (ApiException ae) {
			throw ae;
		} catch (Exception e) {
			throw new ApiException(500, "Erro não especificado: " + e.getMessage());
		}

		return this.select(lembrete);
	}

	public Lembrete delete(Lembrete lembrete) throws ApiException {
		try {
			Connection conexao = Database.getConnection();
			PreparedStatement statement = conexao.prepareStatement(
					"DELETE FROM lembrete WHERE IDLembrete = ?");
			statement.setInt(1, lembrete.getId());
			statement.execute();

			if (statement.getUpdateCount() == 0) {
				throw new ApiException(404, "O lembrete informado não existe.");
			}
		} catch (ApiException ae) {
			throw ae;
		} catch (Exception e) {
			throw new ApiException(500, "Erro não especificado: " + e.getMessage());
		}

		return null;
	}
}
