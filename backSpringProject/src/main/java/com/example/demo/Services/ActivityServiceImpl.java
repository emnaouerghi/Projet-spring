package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Activity;
import com.example.demo.Repositories.ActivityRepository;
@Service
public class ActivityServiceImpl implements ActivityService {

	public ActivityServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	ActivityRepository actRepository;
	@Override
	public Activity saveActivity(Activity act) {
		// TODO Auto-generated method stub
		return actRepository.save(act);
	}

	@Override
	public Activity updateActivity(Activity act) {
		return actRepository.save(act);
	}

	@Override
	public void deleteActivity(Activity act) {
     actRepository.delete(act);		
	}

	@Override
	public void deleteActivityById(Long id) {
		actRepository.deleteById(id);
		
	}

	@Override
	public Activity getActivity(Long id) {
		return actRepository.findById(id).get();
	}

	@Override
	public List<Activity> getAllActivities() {
		return (List<Activity>) actRepository.findAll();

	}

}
