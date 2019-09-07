package com.cg.fms.service;

import java.util.ArrayList;

import com.cg.fms.dto.ParticipantEnrollment;
import com.cg.fms.exception.FMSException;

public interface ParticipantEnrollmentService {
	public ArrayList<ParticipantEnrollment> getAllParticipantEnrollments()
			throws FMSException;

	public ParticipantEnrollment addParticipantEnrollment(
			ParticipantEnrollment participantEnrollment) throws FMSException;

	public ArrayList<ParticipantEnrollment> getParticipantEnrollmentByParticipantId(
			int id) throws FMSException;

	public ArrayList<ParticipantEnrollment> getParticipantEnrollmentByTrainingId(
			int id) throws FMSException;
}
