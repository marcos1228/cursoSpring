package com.springcourse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.springcourse.domain.enums.RequestState;


@Entity(name="Resquet")
public class Request implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 75, nullable = false)
	private String subject;
	@Column(columnDefinition = "text")
	private String description;
	@Column(name="creation_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	@Column(length = 12, nullable = false)
	@Enumerated(EnumType.STRING)
	private RequestState state;
	@ManyToOne
	@JoinColumn(name="owner_id", nullable = false)
	private User owner;
	@OneToMany(mappedBy = "request")
	private List<RequestStage> stages = new ArrayList<RequestStage>();
	public Request() {
		super();
	}
	
	
	public Request(Long id, String subject, String description, Date creationDate, RequestState state, User owner,
			List<RequestStage> stages) {
		super();
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.creationDate = creationDate;
		this.state = state;
		this.owner = owner;
		this.stages = stages;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public RequestState getState() {
		return state;
	}
	public void setState(RequestState state) {
		this.state = state;
	}
	public User getUser() {
		return owner;
	}
	public void setUser(User user) {
		this.owner = owner;
	}
	public List<RequestStage> getStages() {
		return stages;
	}
	public void setStages(List<RequestStage> stages) {
		this.stages = stages;
	}

	
}
