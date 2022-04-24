package com.example.demo.Services;

import java.util.List;

import com.example.demo.Models.Activity;

public interface ActivityService {
	  Activity saveActivity(Activity act);
		Activity updateActivity(Activity act);
		void deleteActivity(Activity act);
		void deleteActivityById(Long id);
	    Activity getActivity(Long id);
		List<Activity> getAllActivities();
}
