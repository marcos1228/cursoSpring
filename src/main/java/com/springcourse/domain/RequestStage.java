package com.springcourse.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.springcourse.domain.enums.RequestState;
@Entity(name="resquest_stage")
public class RequestStage implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "text")
	private String description;
	@Column(name = "realization_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date realizationDate;
	@Column(length = 12, nullable = false)
	@Enumerated(EnumType.STRING)
	private RequestState state;
	@ManyToOne
	@JoinColumn(name = "request_id", nullable = false)
	private Request request;
	@ManyToOne
	@JoinColumn(name = "owner_id", nullable = false)
	private User owner;

	public RequestStage() {
		super();
	}

	public RequestStage(Long id, String description, Date realizationDate, RequestState state, Request request,
			User owner) {
		super();
		this.id = id;
		this.description = description;
		this.realizationDate = realizationDate;
		this.state = state;
		this.request = request;
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRealizationDate() {
		return realizationDate;
	}

	public void setRealizationDate(Date realizationDate) {
		this.realizationDate = realizationDate;
	}

	public RequestState getState() {
		return state;
	}

	public void setState(RequestState state) {
		this.state = state;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public User getUser() {
		return owner;
	}

	public void setUser(User owner) {
		this.owner = owner;
	}

}
