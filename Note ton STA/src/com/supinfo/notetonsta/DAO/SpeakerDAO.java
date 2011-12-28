package com.supinfo.notetonsta.DAO;

import com.supinfo.notetonsta.entity.Speaker;

public interface SpeakerDAO {
	public void addSpeaker(Speaker speaker);
	public void updateSpeaker(Speaker speaker);
	public void deleteSpeaker(Speaker speaker);
	public Speaker getSpeakerById(Long id);
	public boolean authenticateSpeaker(String username,String password);
}
