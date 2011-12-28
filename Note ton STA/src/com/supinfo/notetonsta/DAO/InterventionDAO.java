package com.supinfo.notetonsta.DAO;

import com.supinfo.notetonsta.entity.Intervention;

public interface InterventionDAO {
	public void addIntervention(Intervention intervention);
	public void updateIntervention(Intervention intervention);
	public void deleteIntervention(Intervention intervention);
	public Intervention getInterventionById(Long id);
}
