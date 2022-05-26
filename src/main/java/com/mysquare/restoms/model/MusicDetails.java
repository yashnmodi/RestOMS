package com.mysquare.restoms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="music_details",schema="restro")
public class MusicDetails {
	private int musicId;
	private String musicName;
	private String musicPath;
	public MusicDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public MusicDetails(int musicId, String musicName, String musicPath) {
		super();
		this.musicId = musicId;
		this.musicName = musicName;
		this.musicPath = musicPath;
	}


	public MusicDetails(String musicName, String musicPath) {
		super();
		this.musicName = musicName;
		this.musicPath = musicPath;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="music_id",length=4)
	public int getMusicId() {
		return musicId;
	}
	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}
	@Column(name="music_name",length=40)
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	@Column(name="music_path",length=40)
	public String getMusicPath() {
		return musicPath;
	}
	public void setMusicPath(String musicPath) {
		this.musicPath = musicPath;
	}
	
	@Override
	public String toString() {
		return "MusicDetails [musicId=" + musicId + ", musicName=" + musicName + ", musicPath=" + musicPath + "]";
	}

}
