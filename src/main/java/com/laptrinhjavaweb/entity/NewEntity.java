package com.laptrinhjavaweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="news")
public class NewEntity extends BaseEntity {
@Column(name="title")
private String title;
@Column(name="thumbnail")
private String thumbnail;
@Column(name="shotdescription")
private String shotdescription;
@Column(name="content")
private String content;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getThumbnail() {
	return thumbnail;
}
public void setThumbnail(String thumbnail) {
	this.thumbnail = thumbnail;
}
public String getShotdescription() {
	return shotdescription;
}
public void setShotdescription(String shotdescription) {
	this.shotdescription = shotdescription;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}

}
