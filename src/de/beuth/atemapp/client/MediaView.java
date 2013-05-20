package de.beuth.atemapp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MediaView extends Composite {

	private static AudioViewUiBinder uiBinder = GWT
			.create(AudioViewUiBinder.class);

	interface AudioViewUiBinder extends UiBinder<Widget, MediaView> {
	}

	public MediaView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
