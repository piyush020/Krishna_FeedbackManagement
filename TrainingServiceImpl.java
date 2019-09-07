package com.cg.fms.service;

import java.util.ArrayList;

import com.cg.fms.dao.TrainingDao;
import com.cg.fms.dao.TrainingDaoImpl;
import com.cg.fms.dto.Training;
import com.cg.fms.exception.FMSException;

public class TrainingServiceImpl implements TrainingService {

	TrainingDao trainingDao;
	
	
	public TrainingServiceImpl() {
		super();
		trainingDao = new TrainingDaoImpl();
	}

	@Override
	public Training getTrainingById(int id) throws FMSException {
		return trainingDao.getTrainingById(id);
	}

	@Override
	public ArrayList<Training> getAllTrainings() throws FMSException {
		return trainingDao.getAllTrainings();
	}

	@Override
	public Training addTraining(Training training) throws FMSException {
		return trainingDao.addTraining(training);
	}

	@Override
	public Training updateTraining(Training training) throws FMSException {
		return trainingDao.updateTraining(training);
	}

	@Override
	public boolean deleteTraining(int id) throws FMSException {
		return trainingDao.deleteTraining(id);
	}

}
