package com.safein.backend.utilities;

/**
 * CountrySituation
 * Classifies the situation the country is in
 * 
 * @author Elena, Aitor, Francisco Parra
 */
public enum CountrySituation {
	TENSION("Tension between countries"),
	WAR_RISK("Risk of war"),
	WAR("War"),
	CRIME("High crime"),
	POLITICAL_INSTABILITY("Political instability"),
	NATURAL_DISASTER("Natural disaster");

	public final String label;

	private CountrySituation(String label) {
		this.label = label;
	}

}
