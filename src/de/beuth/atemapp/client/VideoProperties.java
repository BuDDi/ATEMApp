package de.beuth.atemapp.client;

import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface VideoProperties extends PropertyAccess<Video> {

	@Path("id")
	ModelKeyProvider<Video> key();

	@Path("name")
	LabelProvider<Video> nameLabel();

	ValueProvider<Video, String> name();

	ValueProvider<Video, Integer> id();
}
