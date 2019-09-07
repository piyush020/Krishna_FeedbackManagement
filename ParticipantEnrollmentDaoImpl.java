package com.cg.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.fms.dto.ParticipantEnrollment;
import com.cg.fms.exception.FMSException;
import com.cg.fms.util.DBUtil;

public class ParticipantEnrollmentDaoImpl implements ParticipantEnrollmentDao {

	Connection con;

	public ParticipantEnrollmentDaoImpl() {
		super();
		con = DBUtil.getConnection();
	}

	@Override
	public ArrayList<ParticipantEnrollment> getAllParticipantEnrollments()
			throws FMSException {
		ArrayList<ParticipantEnrollment> participantEnrollmentList = new ArrayList<ParticipantEnrollment>();
		String query = "SELECT * FROM participant_enrollment";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				participantEnrollmentList.add(new ParticipantEnrollment(rs
						.getInt(1), rs.getInt(2)));
			}
		} catch (SQLException e) {
			throw new FMSException(e.getMessage());
		}

		return participantEnrollmentList;
	}

	@Override
	public ParticipantEnrollment addParticipantEnrollment(
			ParticipantEnrollment participantEnrollment) throws FMSException {
		String query = "INSERT INTO participant_enrollment values(?,?)";
		ParticipantEnrollment ref = null;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, participantEnrollment.getTrainingCode());
			ps.setInt(2, participantEnrollment.getParticipantId());
			int updatedRows = ps.executeUpdate();
			if (updatedRows > 0) {
				ref = participantEnrollment;
			}
		} catch (SQLException e) {
			throw new FMSException(e.getMessage());
		}
		return ref;
	}

	@Override
	public ArrayList<ParticipantEnrollment> getParticipantEnrollmentByParticipantId(
			int id) throws FMSException {
		ArrayList<ParticipantEnrollment> participantEnrollmentList = new ArrayList<ParticipantEnrollment>();
		String query = "SELECT * FROM participant_enrollment where participant_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				participantEnrollmentList.add(new ParticipantEnrollment(rs
						.getInt(1), rs.getInt(2)));
			}
		} catch (SQLException e) {
			throw new FMSException(e.getMessage());
		}

		return participantEnrollmentList;
	}

	@Override
	public ArrayList<ParticipantEnrollment> getParticipantEnrollmentByTrainingId(
			int id) throws FMSException {
		ArrayList<ParticipantEnrollment> participantEnrollmentList = new ArrayList<ParticipantEnrollment>();
		String query = "SELECT * FROM participant_enrollment where training_code=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				participantEnrollmentList.add(new ParticipantEnrollment(rs
						.getInt(1), rs.getInt(2)));
			}
		} catch (SQLException e) {
			throw new FMSException(e.getMessage());
		}

		return participantEnrollmentList;
	}

}
