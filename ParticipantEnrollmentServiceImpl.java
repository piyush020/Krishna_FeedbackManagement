package com.cg.fms.service;

import java.util.ArrayList;

import com.cg.fms.dao.ParticipantEnrollmentDao;
import com.cg.fms.dao.ParticipantEnrollmentDaoImpl;
import com.cg.fms.dto.ParticipantEnrollment;
import com.cg.fms.exception.FMSException;

public class ParticipantEnrollmentServiceImpl implements ParticipantEnrollmentService {
	
	ParticipantEnrollmentDao participantEnrollmentDao;

	public ParticipantEnrollmentServiceImpl() {
		super();
		participantEnrollmentDao = new ParticipantEnrollmentDaoImpl();
	}

	@Override
	public ArrayList<ParticipantEnrollment> getAllParticipantEnrollments()
			throws FMSException {
		return participantEnrollmentDao.getAllParticipantEnrollments();
	}

	@Override
	public ParticipantEnrollment addParticipantEnrollment(
			ParticipantEnrollment participantEnrollment) throws FMSException {
		return participantEnrollmentDao.addParticipantEnrollment(participantEnrollment);
	}

	@Override
	public ArrayList<ParticipantEnrollment> getParticipantEnrollmentByParticipantId(
			int id) throws FMSException {
		return participantEnrollmentDao.getParticipantEnrollmentByParticipantId(id);
	}

	@Override
	public ArrayList<ParticipantEnrollment> getParticipantEnrollmentByTrainingId(
			int id) throws FMSException {
		return participantEnrollmentDao.getParticipantEnrollmentByTrainingId(id);
	}

}
