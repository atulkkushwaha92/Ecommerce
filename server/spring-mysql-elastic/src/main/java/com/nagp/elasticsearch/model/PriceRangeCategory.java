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
public class PriceRangeCategory implements Serializable {
    @Id
    private int id;

    private String type;

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

	public PriceRangeCategory(int id, String type) {
        this.id = id;
        this.type = type;
    }
    
    public PriceRangeCategory() {
    }
}
