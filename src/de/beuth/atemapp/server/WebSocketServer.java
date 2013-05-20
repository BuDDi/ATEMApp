package de.beuth.atemapp.server;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterFactory;
import org.atmosphere.gwt.server.AtmosphereGwtHandler;
import org.atmosphere.gwt.server.GwtAtmosphereResource;

import de.beuth.atemapp.client.SliderEvent;
import de.beuth.atemapp.client.ToggleClickEvent;
import de.beuth.atemapp.shared.DisplayConstants;

public class WebSocketServer extends AtmosphereGwtHandler {

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
		Logger.getLogger("").setLevel(Level.INFO);
		Logger.getLogger("org.atmosphere.gwt").setLevel(Level.ALL);
		Logger.getLogger("org.atmosphere.samples").setLevel(Level.ALL);
		Logger.getLogger("").getHandlers()[0].setLevel(Level.ALL);
		logger.trace("Updated logging levels");
	}

	@Override
	public int doComet(GwtAtmosphereResource resource) throws ServletException,
			IOException {
		String room = resource.getRequest().getPathInfo();
		Broadcaster broadcaster = BroadcasterFactory.getDefault().lookup(room,
				true);
		resource.getAtmosphereResource().setBroadcaster(broadcaster);
		return 300000;
	}

	@Override
	public void cometTerminated(GwtAtmosphereResource cometResponse,
			boolean serverInitiated) {
		super.cometTerminated(cometResponse, serverInitiated);
		logger.info("Comet disconnected");
	}

	@Override
	public void doPost(HttpServletRequest postRequest,
			HttpServletResponse postResponse, List<?> messages,
			GwtAtmosphereResource cometResource) {
		for (Object message : messages) {
			if (message instanceof ToggleClickEvent) {
				ToggleClickEvent e = (ToggleClickEvent) message;
				String buttonID = e.getButtonID();
				if (buttonID.equals(DisplayConstants.PROGRAM_INPUT_1_BTN_ID)) {
					System.out.println("Instruct ATEM -> Prog Input 1");
				} else if (buttonID.equals(DisplayConstants.PROGRAM_INPUT_2_BTN_ID)) {
					System.out.println("Instruct ATEM -> Prog Input 2");
				} else if (buttonID.equals(DisplayConstants.PROGRAM_INPUT_3_BTN_ID)) {
					System.out.println("Instruct ATEM -> Prog Input 3");
				} else if (buttonID.equals(DisplayConstants.PROGRAM_INPUT_4_BTN_ID)) {
					System.out.println("Instruct ATEM -> Prog Input 4");
				} else if (buttonID.equals(DisplayConstants.PROGRAM_INPUT_5_BTN_ID)) {
					System.out.println("Instruct ATEM -> Prog Input 5");
				} else if (buttonID.equals(DisplayConstants.PROGRAM_INPUT_6_BTN_ID)) {
					System.out.println("Instruct ATEM -> Prog Input 6");
				} else if (buttonID.equals(DisplayConstants.PROGRAM_INPUT_7_BTN_ID)) {
					System.out.println("Instruct ATEM -> Prog Input 7");
				} else if (buttonID.equals(DisplayConstants.PROGRAM_INPUT_8_BTN_ID)) {
					System.out.println("Instruct ATEM -> Prog Input 8");
				}
			} else if (message instanceof SliderEvent) {
				SliderEvent e = (SliderEvent) message;
				String sliderID = e.getSliderID();
				Integer value = e.getValue();
				if (sliderID.equals(DisplayConstants.TRANSITION_CONTROL_SLIDER_ID)) {
					System.out.println("Instruct ATEM -> Transition Slider : "
							+ value);
				}
			}
		}
		broadcast(messages, cometResource);
	}

}