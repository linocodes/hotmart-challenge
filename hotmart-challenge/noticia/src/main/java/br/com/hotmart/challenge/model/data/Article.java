package br.com.hotmart.challenge.model.data;

import java.io.Serializable;

import lombok.Data;

@Data
public class Article implements Serializable {

	private static final long serialVersionUID = 4723069757011758558L;

	private String publishedAt;

}
