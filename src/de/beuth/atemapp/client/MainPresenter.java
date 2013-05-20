package de.beuth.atemapp.client;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.atmosphere.gwt.client.AtmosphereClient;
import org.atmosphere.gwt.client.AtmosphereGWTSerializer;
import org.atmosphere.gwt.client.AtmosphereListener;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.StatusCodeException;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextBox;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.Slider;
import com.sencha.gxt.widget.core.client.button.ToggleButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

import de.beuth.atemapp.shared.DisplayConstants;

public class MainPresenter implements Presenter {

	static final Logger logger = Logger.getLogger(MainPresenter.class.getName());

	private HandlerManager eventBus;

	private Display display;

	private AtmosphereClient client;

	private MyCometListener cometListener = new MyCometListener();

	private AtmosphereGWTSerializer serializer = GWT
			.create(EventSerializer.class);

	public boolean blockSlideEvent;

	public <T extends Composite> MainPresenter(HandlerManager eventBus,
			Display display) {
		this.eventBus = eventBus;
		this.display = display;
		bind();
	}

	@Override
	public void bind() {
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
			@Override
			public void execute() {
				client = new AtmosphereClient(GWT.getModuleBaseURL() + "gwtComet/",
						serializer, cometListener);
				client.start();
			}
		});
		display.getProgramInput1Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				// TODO Auto-generated method stub
				ToggleButton progInput1Btn = display.getProgramInput1Button();
				Boolean value = progInput1Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				// progInput1Btn.
				progInput1Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PROGRAM_INPUT_1_BTN_ID,
						value));

			}
		});
		display.getProgramInput2Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton progInput2Btn = display.getProgramInput2Button();
				Boolean value = progInput2Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				progInput2Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PROGRAM_INPUT_2_BTN_ID,
						value));
			}
		});
		display.getProgramInput3Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton progInput3Btn = display.getProgramInput3Button();
				Boolean value = progInput3Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				progInput3Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PROGRAM_INPUT_3_BTN_ID,
						value));
			}
		});

		display.getProgramInput4Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton progInput4Btn = display.getProgramInput4Button();
				Boolean value = progInput4Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				progInput4Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PROGRAM_INPUT_4_BTN_ID,
						value));
			}
		});
		display.getProgramInput5Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton progInput5Btn = display.getProgramInput5Button();
				Boolean value = progInput5Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				progInput5Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PROGRAM_INPUT_5_BTN_ID,
						value));
			}
		});
		display.getProgramInput6Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				// TODO Auto-generated method stub
				ToggleButton progInput6Btn = display.getProgramInput6Button();
				Boolean value = progInput6Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				progInput6Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PROGRAM_INPUT_6_BTN_ID,
						value));

			}
		});
		display.getProgramInput7Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton progInput7Btn = display.getProgramInput7Button();
				Boolean value = progInput7Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				progInput7Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PROGRAM_INPUT_7_BTN_ID,
						value));
			}
		});
		display.getProgramInput8Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton progInput8Btn = display.getProgramInput8Button();
				Boolean value = progInput8Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				progInput8Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PROGRAM_INPUT_8_BTN_ID,
						value));
			}
		});
		display.getProgramInputBlackButton().addSelectHandler(
				new SelectHandler() {

					@Override
					public void onSelect(SelectEvent event) {
						ToggleButton progInputBlackBtn = display
								.getProgramInputBlackButton();
						Boolean value = progInputBlackBtn.getValue();
						// set the toggle button to the state before cause we want to
						// set
						// the button only when the action succeeded on the server
						progInputBlackBtn.setValue(!value, false);
						client.post(new ToggleClickEvent(
								Display.PROGRAM_INPUT_BLACK_BTN_ID, value));
					}
				});
		display.getProgramInputBarsButton().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton progInputBarsBtn = display.getProgramInputBarsButton();
				Boolean value = progInputBarsBtn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				progInputBarsBtn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PROGRAM_INPUT_BARS_BTN_ID,
						value));
			}
		});
		display.getProgramColor1Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton progColor1Btn = display.getProgramColor1Button();
				Boolean value = progColor1Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				progColor1Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PROGRAM_COLOR1_BTN_ID,
						value));
			}
		});
		display.getProgramColor2Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton progColor2Btn = display.getProgramColor2Button();
				Boolean value = progColor2Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				progColor2Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PROGRAM_COLOR2_BTN_ID,
						value));
			}
		});
		display.getProgramMedia1Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton progMedia1Btn = display.getProgramMedia1Button();
				Boolean value = progMedia1Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				progMedia1Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PROGRAM_MEDIA1_BTN_ID,
						value));
			}
		});
		display.getProgramMedia2Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton progMedia2Btn = display.getProgramMedia2Button();
				Boolean value = progMedia2Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				progMedia2Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PROGRAM_MEDIA2_BTN_ID,
						value));
			}
		});
		display.getTransitionBar().addValueChangeHandler(
				new ValueChangeHandler<Integer>() {

					@Override
					public void onValueChange(ValueChangeEvent<Integer> event) {
						client.post(new SliderEvent(client.getConnectionID(),
								DisplayConstants.TRANSITION_CONTROL_SLIDER_ID, display
										.getTransitionBar().getValue()));

					}
				});
		display.getPreviewInput1Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton prevInput1Btn = display.getPreviewInput1Button();
				Boolean value = prevInput1Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				prevInput1Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PREVIEW_INPUT1_BTN_ID,
						value));
			}
		});
		display.getPreviewInput2Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton prevInput2Btn = display.getPreviewInput2Button();
				Boolean value = prevInput2Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				prevInput2Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PREVIEW_INPUT2_BTN_ID,
						value));
			}
		});
		display.getPreviewInput3Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton prevInput3Btn = display.getPreviewInput3Button();
				Boolean value = prevInput3Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				prevInput3Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PREVIEW_INPUT3_BTN_ID,
						value));
			}
		});
		display.getPreviewInput4Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton prevInput4Btn = display.getPreviewInput4Button();
				Boolean value = prevInput4Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				prevInput4Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PREVIEW_INPUT4_BTN_ID,
						value));
			}
		});
		display.getPreviewInput5Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton prevInput5Btn = display.getPreviewInput5Button();
				Boolean value = prevInput5Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				prevInput5Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PREVIEW_INPUT5_BTN_ID,
						value));
			}
		});
		display.getPreviewInput6Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton prevInput6Btn = display.getPreviewInput6Button();
				Boolean value = prevInput6Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				prevInput6Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PREVIEW_INPUT6_BTN_ID,
						value));
			}
		});
		display.getPreviewInput7Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton prevInput7Btn = display.getPreviewInput7Button();
				Boolean value = prevInput7Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				prevInput7Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PREVIEW_INPUT7_BTN_ID,
						value));
			}
		});
		display.getPreviewInput8Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton prevInput8Btn = display.getPreviewInput8Button();
				Boolean value = prevInput8Btn.getValue();
				// set the toggle button to the state before cause we want to
				// set
				// the button only when the action succeeded on the server
				prevInput8Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PREVIEW_INPUT8_BTN_ID,
						value));
			}
		});
	}

	public interface Display extends IsWidget, DisplayConstants {

		ToggleButton getProgramInput1Button();

		ToggleButton getProgramInput2Button();

		ToggleButton getProgramInput3Button();

		ToggleButton getProgramInput4Button();

		ToggleButton getProgramInput5Button();

		ToggleButton getProgramInput6Button();

		ToggleButton getProgramInput7Button();

		ToggleButton getProgramInput8Button();

		ToggleButton getProgramInputBlackButton();

		ToggleButton getProgramInputBarsButton();

		ToggleButton getProgramColor1Button();

		ToggleButton getProgramColor2Button();

		ToggleButton getProgramMedia1Button();

		ToggleButton getProgramMedia2Button();

		ToggleButton getPreviewInput1Button();

		ToggleButton getPreviewInput2Button();

		ToggleButton getPreviewInput3Button();

		ToggleButton getPreviewInput4Button();

		ToggleButton getPreviewInput5Button();

		ToggleButton getPreviewInput6Button();

		ToggleButton getPreviewInput7Button();

		ToggleButton getPreviewInput8Button();

		ToggleButton getPreviewInputBlackButton();

		ToggleButton getPreviewInputBarsButton();

		ToggleButton getPreviewColor1Button();

		ToggleButton getPreviewColor2Button();

		ToggleButton getPreviewMedia1Button();

		ToggleButton getPreviewMedia2Button();

		ToggleButton getTransitionControlNextTransOnAir1Button();

		ToggleButton getTransitionControlNextTransOnAir2Button();

		ToggleButton getTransitionControlNextTransOnAir3Button();

		ToggleButton getTransitionControlNextTransOnAir4Button();

		ToggleButton getTransitionControlNextTransBackgroundButton();

		ToggleButton getTransitionControlNextTransKey1Button();

		ToggleButton getTransitionControlNextTransKey2Button();

		ToggleButton getTransitionControlNextTransKey3Button();

		ToggleButton getTransitionControlNextTransKey4Button();

		ToggleGroup getTransitionControlTransStyleToggleGroup();

		ToggleButton getTransitionContrloTransStylePrevButton();

		ToggleButton getTransitionContrloTransStyleAutoButton();

		ToggleButton getTransitionContrloTransStyleCutButton();

		Slider getTransitionBar();

		ToggleButton getDownstreamDSK1TieButton();

		TextBox getDownstreamDSK1Rate();

		ToggleButton getDownstreamDSK1OnAirButton();

		ToggleButton getDownstreamDSK1AutoButton();

		ToggleButton getDownstreamDSK2TieButton();

		TextBox getDownstreamDSK2Rate();

		ToggleButton getDownstreamDSK2OnAirButton();

		ToggleButton getDownstreamDSK2AutoButton();

		TextBox getFade2BlackRate();

		ToggleButton getFade2BlackButton();
	}

	@Override
	public void go(HasWidgets container) {
		container.add(display.asWidget());
	}

	private class MyCometListener implements AtmosphereListener {

		DateTimeFormat timeFormat = DateTimeFormat
				.getFormat(DateTimeFormat.PredefinedFormat.TIME_MEDIUM);

		@Override
		public void onBeforeDisconnected() {
			logger.log(Level.INFO, "comet.beforeDisconnected");
		}

		@Override
		public void onDisconnected() {
			logger.info("comet.disconnected");
			// addChatLine(MESSAGE_ROOM_DISCONNECTED, COLOR_SYSTEM_MESSAGE);
		}

		@Override
		public void onError(Throwable exception, boolean connected) {
			int statuscode = -1;
			if (exception instanceof StatusCodeException) {
				statuscode = ((StatusCodeException) exception).getStatusCode();
			}
			logger.log(Level.SEVERE, "comet.error [connected=" + connected + "] ("
					+ statuscode + ")", exception);
			// addChatLine(MESSAGE_ROOM_ERROR + exception.getMessage(),
			// COLOR_SYSTEM_MESSAGE);
		}

		@Override
		public void onHeartbeat() {
			logger.info("comet.heartbeat [" + client.getConnectionID() + "]");
			logger.info("Timeout: " + client.getConnectionTimeout());
		}

		@Override
		public void onRefresh() {
			logger.info("comet.refresh [" + client.getConnectionID() + "]");
		}

		@Override
		public void onMessage(List<?> messages) {
			for (Object message : messages) {
				if (message instanceof ToggleClickEvent) {
					ToggleClickEvent e = (ToggleClickEvent) message;

					String pressedBtn = e.getButtonID();
					ToggleButton toggleButton = null;
					if (pressedBtn.equals(Display.PROGRAM_INPUT_1_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInput1Button();
					} else if (pressedBtn.equals(Display.PROGRAM_INPUT_2_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInput2Button();
					} else if (pressedBtn.equals(Display.PROGRAM_INPUT_3_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInput3Button();
					} else if (pressedBtn.equals(Display.PROGRAM_INPUT_4_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInput4Button();
					} else if (pressedBtn.equals(Display.PROGRAM_INPUT_5_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInput5Button();
					} else if (pressedBtn.equals(Display.PROGRAM_INPUT_6_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInput6Button();
					} else if (pressedBtn.equals(Display.PROGRAM_INPUT_7_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInput7Button();
					} else if (pressedBtn.equals(Display.PROGRAM_INPUT_8_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInput8Button();
					} else if (pressedBtn.equals(Display.PROGRAM_INPUT_BLACK_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInputBlackButton();
					} else if (pressedBtn.equals(Display.PROGRAM_INPUT_BARS_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInputBarsButton();
					} else if (pressedBtn.equals(Display.PROGRAM_COLOR1_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramColor1Button();
					} else if (pressedBtn.equals(Display.PROGRAM_COLOR2_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramColor2Button();
					} else if (pressedBtn.equals(Display.PROGRAM_MEDIA1_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramMedia1Button();
					} else if (pressedBtn.equals(Display.PROGRAM_MEDIA2_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramMedia2Button();
					}
					if (toggleButton != null) {
						toggleButton.setValue(true);
					}
				} else if (message instanceof SliderEvent) {
					SliderEvent e = (SliderEvent) message;
					String sliderID = e.getSliderID();
					Slider slider = null;
					if (sliderID.equals(Display.TRANSITION_CONTROL_SLIDER_ID)) {
						slider = MainPresenter.this.display.getTransitionBar();
					}
					if (slider != null
							&& !e.getConnectionID().equals(client.getConnectionID())) {
						blockSlideEvent = true;
						slider.setValue(e.getValue().intValue());
						blockSlideEvent = false;
					}
				}
			}
		}

		@Override
		public void onConnected(int heartbeat, int connectionID) {
			logger.info("comet.connected [" + heartbeat + ", " + connectionID
					+ "]");
			// addChatLine(MESSAGE_ROOM_CONNECTED, COLOR_SYSTEM_MESSAGE);
		}

		@Override
		public void onAfterRefresh() {
			logger.info("comet.afterRefresh [" + client.getConnectionID() + "]");
		}
	}
}
