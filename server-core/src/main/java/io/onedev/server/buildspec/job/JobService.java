package io.onedev.server.buildspec.job;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import io.onedev.commons.codeassist.InputSuggestion;
import io.onedev.server.util.validation.annotation.DnsName;
import io.onedev.server.web.editable.annotation.Editable;
import io.onedev.server.web.editable.annotation.Interpolative;

@Editable
public class JobService implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String image;
	
	private String arguments;
	
	private List<EnvVar> envVars = new ArrayList<>();
	
	private String readinessCheckCommand;
	
	private String cpuRequirement = "500m";
	
	private String memoryRequirement = "128m";
	
	@Editable(order=100, description="Specify name of the service, which will be used as host name to access "
			+ "the service. <b>Note:</b> Type <tt>@</tt> to <a href='https://code.onedev.io/projects/onedev-manual/blob/master/pages/variable-substitution.md' tabindex='-1'>insert variable</a>, use <tt>\\</tt> to escape normal occurrences of <tt>@</tt> or <tt>\\</tt>")
	@Interpolative(variableSuggester="suggestVariables")
	@DnsName(interpolative = true)
	@NotEmpty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Editable(order=200, description="Specify docker image of the service. "
			+ "<b>Note:</b> Type <tt>@</tt> to <a href='https://code.onedev.io/projects/onedev-manual/blob/master/pages/variable-substitution.md' target='_blank' tabindex='-1'>insert variable</a>, use <tt>\\</tt> to escape normal occurrences of <tt>@</tt> or <tt>\\</tt>")
	@Interpolative(variableSuggester="suggestVariables")
	@NotEmpty
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Editable(order=220, description="Optionally specify arguments to run above image. "
			+ "<b>Note:</b> Type <tt>@</tt> to <a href='https://code.onedev.io/projects/onedev-manual/blob/master/pages/variable-substitution.md' target='_blank' tabindex='-1'>insert variable</a>, use <tt>\\</tt> to escape normal occurrences of <tt>@</tt> or <tt>\\</tt>")
	@Interpolative(variableSuggester="suggestVariables")
	public String getArguments() {
		return arguments;
	}

	public void setArguments(String arguments) {
		this.arguments = arguments;
	}

	@Editable(order=300, name="Environment Variables", description="Optionally specify environment variables of "
			+ "the service")
	public List<EnvVar> getEnvVars() {
		return envVars;
	}

	public void setEnvVars(List<EnvVar> envVars) {
		this.envVars = envVars;
	}

	@Editable(order=400, description="Specify command to check readiness of the service. This command will "
			+ "be interpretated by cmd.exe on Windows images, and by shell on Linux images. It will be "
			+ "executed repeatedly until a zero code is returned to indicate service ready. "
			+ "<b>Note:</b> Type <tt>@</tt> to <a href='https://code.onedev.io/projects/onedev-manual/blob/master/pages/variable-substitution.md' target='_blank' tabindex='-1'>insert variable</a>, use <tt>\\</tt> to escape normal occurrences of <tt>@</tt> or <tt>\\</tt>")
	@Interpolative(variableSuggester="suggestVariables")
	@NotEmpty
	public String getReadinessCheckCommand() {
		return readinessCheckCommand;
	}

	public void setReadinessCheckCommand(String readinessCheckCommand) {
		this.readinessCheckCommand = readinessCheckCommand;
	}
	
	@Editable(order=10000, name="CPU Requirement", group="More Settings", description="Specify CPU requirement of the job. "
			+ "Refer to <a href='https://kubernetes.io/docs/concepts/configuration/manage-compute-resources-container/#meaning-of-cpu' target='_blank'>kubernetes documentation</a> for details. "
			+ "<b>Note:</b> Type <tt>@</tt> to <a href='https://code.onedev.io/projects/onedev-manual/blob/master/pages/variable-substitution.md' target='_blank' tabindex='-1'>insert variable</a>, use <tt>\\</tt> to escape normal occurrences of <tt>@</tt> or <tt>\\</tt>")
	@Interpolative(variableSuggester="suggestVariables")
	@NotEmpty
	public String getCpuRequirement() {
		return cpuRequirement;
	}

	public void setCpuRequirement(String cpuRequirement) {
		this.cpuRequirement = cpuRequirement;
	}

	@Editable(order=10100, group="More Settings", description="Specify memory requirement of the job. "
			+ "Refer to <a href='https://kubernetes.io/docs/concepts/configuration/manage-compute-resources-container/#meaning-of-memory' target='_blank'>kubernetes documentation</a> for details. "
			+ "<b>Note:</b> Type <tt>@</tt> to <a href='https://code.onedev.io/projects/onedev-manual/blob/master/pages/variable-substitution.md' target='_blank' tabindex='-1'>insert variable</a>, use <tt>\\</tt> to escape normal occurrences of <tt>@</tt> or <tt>\\</tt>")
	@Interpolative(variableSuggester="suggestVariables")
	@NotEmpty
	public String getMemoryRequirement() {
		return memoryRequirement;
	}

	public void setMemoryRequirement(String memoryRequirement) {
		this.memoryRequirement = memoryRequirement;
	}
	
	@SuppressWarnings("unused")
	private static List<InputSuggestion> suggestVariables(String matchWith) {
		return Job.suggestVariables(matchWith);
	}
	
}
