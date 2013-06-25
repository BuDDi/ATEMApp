package de.beuth.atemapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Start of the Application (called by the {@link EntryPoint}) see
 * {@link ATEMApp}
 * 
 * @author S. Buder
 * 
 */
public class AppController implements ValueChangeHandler<String>, Presenter {

	private HandlerManager eventBus;

	private HasWidgets container;

	public AppController(HandlerManager eventBus) {
		this.eventBus = eventBus;
		bind();
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token != null) {
			Presenter presenter = null;

			if (token.equals("main")) {
				presenter = new MainPresenter(eventBus, new MainView());
			} else {
				// additional views could be presented here just check for another
				// history token
				throw new RuntimeException("Unknown/not supported history token '"
						+ token + "'");
			}

			if (presenter != null) {
				presenter.go(container);
			}
		}
	}

	@Override
	public void go(HasWidgets container) {
		this.container = container;
		if ("".equals(History.getToken())) {
			History.newItem("main");
		} else {
			History.fireCurrentHistoryState();
		}
	}

	@Override
	public void bind() {
		// add to the history and listen for events (forward and backward buttons
		// in browser)
		History.addValueChangeHandler(this);
	}

}
