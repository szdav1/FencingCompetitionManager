package com._4th_dimension_software.support.theme.definitions;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com._4th_dimension_software.support.theme.models.ColorModel;

public final class ColorDefinitions {
	private static boolean initialized = false;
	private static HashMap<String, List<Color>> definitions;

	public static void init() {
		if (initialized)
			throw new RuntimeException("Color definitions have been already initialized.");

		definitions = new HashMap<>();
		initialized = true;
	}

	public static void addDefinition(String definition, String valueString) {
		definitions.put(definition, ColorModel.turnStringToColorList(valueString));
	}

	public static List<Color> get(String definition) {
		if (!initialized)
			throw new RuntimeException("Color definitions haven't been initialized.");

		String key = definition.replace("@", "");

		if (!definitions.containsKey(key))
			return List.of(Color.black);

		return definitions.get(key);
	}
}