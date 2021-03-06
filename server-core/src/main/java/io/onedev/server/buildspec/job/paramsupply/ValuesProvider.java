package io.onedev.server.buildspec.job.paramsupply;

import java.io.Serializable;
import java.util.List;

import io.onedev.server.web.editable.annotation.Editable;

@Editable
public interface ValuesProvider extends Serializable {
	
	List<List<String>> getValues();
	
}
