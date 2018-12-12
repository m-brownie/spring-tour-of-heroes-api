package com.boot.hero.model;

public class HeroDto {
	
	private Integer id;
    private String name;
    private String description;
    private String avatar_url;
    private String img_background_url;
    
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAvatar_url() {
		return avatar_url;
	}
	
	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}
	
	public String getImg_background_url() {
		return img_background_url;
	}
	
	public void setImg_background_url(String img_background_url) {
		this.img_background_url = img_background_url;
	}
}
