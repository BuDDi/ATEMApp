package de.beuth.atemapp.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

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
				// presenter = new EditContactPresenter(rpcService, eventBus,
				// new EditContactView());
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
		// TODO Auto-generated method stub
		History.addValueChangeHandler(this);
	}

}
