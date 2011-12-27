package com.supinfo.notetonsta.DAO;

import java.util.List;

import com.supinfo.notetonsta.entity.Campus;

public interface CampusDAO {
	public void addCampus(Campus campus);
	public void updateCampus(Campus campus);
	public void deleteCampus(Campus campus);
	public List<Campus> listAllCampuses();
	public Campus getCampusById(Long id);
}
