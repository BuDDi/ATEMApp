package de.beuth.atemapp.client;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Base interface for any concrete presenter.
 * 
 * @author S. Buder
 * 
 */
public interface Presenter {

	/**
	 * Should be used for initialisation; e.g. bind to some eventbus (see
	 * {@link HandlerManager}) or add listeners to view's elements.
	 */
	public void bind();

	/**
	 * Called when this <code>Presenter</code> should display it's view. Usually
	 * the {@link AppController} should trigger that function. But any other
	 * <code>Presenter</code> could do this as well.
	 * 
	 * @param container
	 *           the container to add the display to
	 */
	public void go(final HasWidgets container);

}
