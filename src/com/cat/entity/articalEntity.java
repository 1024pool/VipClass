package com.cat.entity;

public class articalEntity
{
	int id;
	String video_url;
	String title;
	String descrition;
	String vide_image;
	
	public articalEntity(String id2, String title2, String descrition2,
			String video_url2, String vide_image2) {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public String getVide_image() {
		return vide_image;
	}
	public void setVide_image(String vide_image) {
		this.vide_image = vide_image;
	}
	@Override
	public String toString() {
		return "articalEntity [id=" + id + ", video_url=" + video_url
				+ ", title=" + title + ", descrition=" + descrition
				+ ", vide_image=" + vide_image + "]";
	}
}
