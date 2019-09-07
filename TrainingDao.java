package com.cg.fms.dao;

import java.util.ArrayList;

import com.cg.fms.dto.Training;
import com.cg.fms.exception.FMSException;

public interface TrainingDao {
	
	public Training getTrainingById(int id) throws FMSException;  
	public ArrayList<Training> getAllTrainings() throws FMSException;
	public Training addTraining(Training training) throws FMSException;
	public Training updateTraining(Training training) throws FMSException;
	public boolean deleteTraining(int id) throws FMSException;
	
}
