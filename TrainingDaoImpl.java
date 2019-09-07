package com.cg.fms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.fms.dto.Training;
import com.cg.fms.exception.FMSException;
import com.cg.fms.util.DBUtil;

public class TrainingDaoImpl implements TrainingDao {

	Connection con;

	public TrainingDaoImpl() {
		super();
		con = DBUtil.getConnection();
	}

	@Override
	public Training getTrainingById(int id) throws FMSException {
		String query = "SELECT * FROM training_master WHERE training_code=?";
		Training training = null;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				training = new Training(rs.getInt(1), rs.getInt(2),
						rs.getInt(3), rs.getDate(4).toLocalDate(), rs
								.getDate(5).toLocalDate());
			}
		} catch (SQLException e) {
			throw new FMSException(e.getMessage());
		}
		return training;
	}

	@Override
	public ArrayList<Training> getAllTrainings() throws FMSException {
		ArrayList<Training> trainingList = new ArrayList<Training>();
		String query = "SELECT * FROM training_master";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				trainingList.add(new Training(rs.getInt(1), rs.getInt(2), rs
						.getInt(3), rs.getDate(4).toLocalDate(), rs.getDate(5)
						.toLocalDate()));
			}
		} catch (SQLException e) {
			throw new FMSException(e.getMessage());
		}

		return trainingList;
	}

	@Override
	public Training addTraining(Training training) throws FMSException {
		String query = "INSERT INTO training_master values(seq_training.nextval,?,?,?,?)";
		Training ref = null;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, training.getCourseCode());
			ps.setInt(2, training.getFacultyCode());
			ps.setDate(3, Date.valueOf(training.getStartDate()));
			ps.setDate(4, Date.valueOf(training.getEndDate()));
			int updatedRows = ps.executeUpdate();
			if (updatedRows > 0) {
				ref = training;
			}
		} catch (SQLException e) {
			throw new FMSException(e.getMessage());
		}
		return ref;
	}

	@Override
	public Training updateTraining(Training training) throws FMSException {
		String query = "UPDATE training_master SET course_code=?,faculty_code=?,start_date=?,end_date=? WHERE training_code=?";
		Training ref = null;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, training.getCourseCode());
			ps.setInt(2, training.getFacultyCode());
			ps.setDate(3, Date.valueOf(training.getStartDate()));
			ps.setDate(4, Date.valueOf(training.getEndDate()));
			int updatedRows = ps.executeUpdate();
			if (updatedRows > 0) {
				ref = training;
			}
		} catch (SQLException e) {
			throw new FMSException(e.getMessage());
		}
		return ref;
	}

	@Override
	public boolean deleteTraining(int id) throws FMSException {
		String query = "DELETE FROM training_master WHERE training_code=?";
		boolean deleted = false;
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int updatedRows = ps.executeUpdate();
			if (updatedRows > 0) {
				deleted = true;
			}
		}catch(SQLException e){
			throw new FMSException(e.getMessage());
		}
		return deleted;
	}

}
