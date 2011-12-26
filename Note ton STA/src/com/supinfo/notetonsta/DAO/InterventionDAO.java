package com.supinfo.notetonsta.DAO;

import java.util.List;

import com.supinfo.notetonsta.entity.Campus;
import com.supinfo.notetonsta.entity.Intervention;
import com.supinfo.notetonsta.entity.Speaker;

public interface InterventionDAO {
	public void addIntervention(Intervention intervention);
	public void updateIntervention(Intervention intervention);
	public void deleteIntervention(Intervention intervention);
	public List<Intervention> listInterventionsByCampus(Campus campus);
	public List<Intervention> listInterventionsBySpeaker(Speaker speaker);
	public Intervention getInterventionById(int id);
}
