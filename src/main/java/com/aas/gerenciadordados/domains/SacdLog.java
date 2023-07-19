package com.aas.gerenciadordados.domains;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sacd_log")
public class SacdLog implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long log_id;
	
	private String uuid;
	private String log_type;
	private String tag;
	private Timestamp creation_date;
	private String data;
	
	
	public SacdLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SacdLog(Integer id, Long log_id, String uuid, String log_type, String tag, Timestamp creation_date, String data) {
		super();
		//this.id = id;
		this.log_id = log_id;
		this.uuid = uuid;
		this.log_type = log_type;
		this.tag = tag;
		this.creation_date = creation_date;
		this.data = data;
	}


//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
	public Long getLog_id() {
		return log_id;
	}
	public void setLog_id(Long log_id) {
		this.log_id = log_id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getLog_type() {
		return log_type;
	}
	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Timestamp getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Timestamp creation_date) {
		this.creation_date = creation_date;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}


	@Override
	public int hashCode() {
		return Objects.hash(creation_date, data, log_id, log_type, tag, uuid);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SacdLog other = (SacdLog) obj;
		return Objects.equals(creation_date, other.creation_date) && Objects.equals(data, other.data)
				&& Objects.equals(log_id, other.log_id) && Objects.equals(log_type, other.log_type)
				&& Objects.equals(tag, other.tag) && Objects.equals(uuid, other.uuid);
	}


	


	
	
	
}
