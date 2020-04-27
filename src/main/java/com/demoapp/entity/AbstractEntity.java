package com.demoapp.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class AbstractEntity<T> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	T id;

	@Column(name = "created_at", nullable = false, insertable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false, insertable = false)
	private LocalDateTime updatedAt;

	private boolean deleted;
	
	public T getId() {
		return id;
	}

	public AbstractEntity<T> setId(T id) {
		this.id = id;
		return this;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public AbstractEntity<T> setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public AbstractEntity<T> setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

	@Column(name = "deleted", columnDefinition = "boolean default false")
	public boolean isDeleted() {
		return deleted;
	}

	public AbstractEntity<T> setDeleted(boolean deleted) {
		this.deleted = deleted;
		return this;
	}

	@PrePersist
	protected void onCreate() {
		this.updatedAt = this.createdAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

}
