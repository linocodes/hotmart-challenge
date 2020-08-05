package br.com.hotmart.challenge.model.response;

import java.io.Serializable;
import java.util.List;

import br.com.hotmart.challenge.model.data.Sources;
import lombok.Data;

@Data
public class SourcesResponse implements Serializable {

	private static final long serialVersionUID = 8024552526985097995L;

	private String status;
	private List<Sources> sources;

}
