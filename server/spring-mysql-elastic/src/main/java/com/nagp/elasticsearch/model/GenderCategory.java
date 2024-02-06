package com.nagp.elasticsearch.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@ToString
@Entity
public class GenderCategory implements Serializable {
    @Id
    private int id;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String type;

    public GenderCategory(int id, String type) {
        this.id = id;
        this.type = type;
    }
    
    public GenderCategory() {
    }
}
