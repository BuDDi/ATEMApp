package de.beuth.atemapp.client;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.atmosphere.gwt.client.AtmosphereClient;
import org.atmosphere.gwt.client.AtmosphereGWTSerializer;
import org.atmosphere.gwt.client.AtmosphereListener;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.rpc.StatusCodeException;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.core.client.util.ToggleGroup;
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
		// display.getTransitionBar().addValueChangeHandler(
		// new ValueChangeHandler<Integer>() {
		//
		// @Override
		// public void onValueChange(ValueChangeEvent<Integer> event) {
		// client.post(new SliderEvent(client.getConnectionID(),
		// DisplayConstants.TRANSITION_CONTROL_SLIDER_ID, display
		// .getTransitionBar().getValue()));
		//
		// }
		// });
		// display.getTransitionBar().addValueChangeHandler(
		// new ValueChangeHandler<Integer>() {
		//
		// @Override
		// public void onValueChange(ValueChangeEvent<Integer> event) {
		// System.out.println("Slider changed: " + event.getValue());
		// client.post(new SliderTransmitEvent(client.getConnectionID(),
		// Display.TRANSITION_CONTROL_SLIDER_ID, event.getValue()));
		// }
		// });

		Element sliderElem = display.getTransitionBar().cast();
		DOM.sinkEvents(sliderElem, Event.ONCHANGE);
		DOM.setEventListener(sliderElem, new EventListener() {

			@Override
			public void onBrowserEvent(Event event) {
				// TODO Auto-generated method stub
				String value = display.getTransitionBar().getValue();
				System.out.println("Event from slider " + value);
				if (!blockSlideEvent) {
					client.post(new SliderTransmitEvent(client.getConnectionID(),
							Display.TRANSITION_CONTROL_SLIDER_ID, Integer
									.parseInt(value)));
				}
				blockSlideEvent = false;
			}
		});
		// display.getTransitionBar().
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
		display.getPreviewInputBlackButton().addSelectHandler(
				new SelectHandler() {

					@Override
					public void onSelect(SelectEvent event) {
						ToggleButton prevInputBlackBtn = display
								.getPreviewInputBlackButton();
						Boolean value = prevInputBlackBtn.getValue();
						prevInputBlackBtn.setValue(!value, false);
						client.post(new ToggleClickEvent(
								Display.PREVIEW_INPUT_BLACK_BTN_ID, value));
					}
				});
		display.getPreviewInputBarsButton().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton prevInputBarsBtn = display.getPreviewInputBarsButton();
				Boolean value = prevInputBarsBtn.getValue();
				prevInputBarsBtn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PREVIEW_INPUT_BARS_BTN_ID,
						value));
			}
		});
		display.getPreviewColor1Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton prevColor1Btn = display.getPreviewColor1Button();
				Boolean value = prevColor1Btn.getValue();
				prevColor1Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PREVIEW_COLOR1_BTN_ID,
						value));
			}
		});
		display.getPreviewColor2Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton prevColor2Btn = display.getPreviewColor2Button();
				Boolean value = prevColor2Btn.getValue();
				prevColor2Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PREVIEW_COLOR2_BTN_ID,
						value));
			}
		});
		display.getPreviewMedia1Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton prevMedia1Btn = display.getPreviewMedia1Button();
				Boolean value = prevMedia1Btn.getValue();
				prevMedia1Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PREVIEW_MEDIA1_BTN_ID,
						value));
			}
		});
		display.getPreviewMedia2Button().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ToggleButton prevMedia2Btn = display.getPreviewMedia2Button();
				Boolean value = prevMedia2Btn.getValue();
				prevMedia2Btn.setValue(!value, false);
				client.post(new ToggleClickEvent(Display.PREVIEW_MEDIA2_BTN_ID,
						value));
			}
		});

		display.getTransitionControlTransStyleAutoButton().addSelectHandler(
				new SelectHandler() {

					@Override
					public void onSelect(SelectEvent event) {
						ToggleButton transCtrlStyleAutoBtn = display
								.getTransitionControlTransStyleAutoButton();
						Boolean value = transCtrlStyleAutoBtn.getValue();
						transCtrlStyleAutoBtn.setValue(!value, false);
						client.post(new ToggleClickEvent(
								Display.TRANS_CTRL_STYLE_AUTO_BTN_ID, value));
					}
				});
		display.getTransitionControlTransStyleCutButton().addSelectHandler(
				new SelectHandler() {

					@Override
					public void onSelect(SelectEvent event) {
						ToggleButton transCtrlStyleCutBtn = display
								.getTransitionControlTransStyleCutButton();
						Boolean value = transCtrlStyleCutBtn.getValue();
						transCtrlStyleCutBtn.setValue(!value, false);
						client.post(new ToggleClickEvent(
								Display.TRANS_CTRL_STYLE_CUT_BTN_ID, value));
					}
				});

		Element masterSliderElem = display.getMasterVolumeSlider().cast();
		DOM.sinkEvents(masterSliderElem, Event.ONCHANGE);
		DOM.setEventListener(masterSliderElem, new EventListener() {

			@Override
			public void onBrowserEvent(Event event) {
				String value = display.getMasterVolumeSlider().getValue();
				client.post(new SliderTransmitEvent(client.getConnectionID(),
						Display.AUDIO_MASTER_VOL_SLIDER_ID, Integer.parseInt(value)));
			}
		});
		Element audiInput1SliderElem = display.getAudioInput1Slider().cast();
		DOM.sinkEvents(audiInput1SliderElem, Event.ONCHANGE);
		DOM.setEventListener(audiInput1SliderElem, new EventListener() {

			@Override
			public void onBrowserEvent(Event event) {
				String value = display.getAudioInput1Slider().getValue();
				client.post(new SliderTransmitEvent(client.getConnectionID(),
						Display.AUDIO_INPUT1_VOL_SLIDER_ID, Integer.parseInt(value)));
			}
		});
		Element audiInput2SliderElem = display.getAudioInput2Slider().cast();
		DOM.sinkEvents(audiInput2SliderElem, Event.ONCHANGE);
		DOM.setEventListener(audiInput2SliderElem, new EventListener() {

			@Override
			public void onBrowserEvent(Event event) {
				String value = display.getAudioInput2Slider().getValue();
				client.post(new SliderTransmitEvent(client.getConnectionID(),
						Display.AUDIO_INPUT2_VOL_SLIDER_ID, Integer.parseInt(value)));
			}
		});
		Element audiInput3SliderElem = display.getAudioInput3Slider().cast();
		DOM.sinkEvents(audiInput3SliderElem, Event.ONCHANGE);
		DOM.setEventListener(audiInput3SliderElem, new EventListener() {

			@Override
			public void onBrowserEvent(Event event) {
				String value = display.getAudioInput3Slider().getValue();
				client.post(new SliderTransmitEvent(client.getConnectionID(),
						Display.AUDIO_INPUT3_VOL_SLIDER_ID, Integer.parseInt(value)));
			}
		});
		Element audiInput4SliderElem = display.getAudioInput4Slider().cast();
		DOM.sinkEvents(audiInput4SliderElem, Event.ONCHANGE);
		DOM.setEventListener(audiInput4SliderElem, new EventListener() {

			@Override
			public void onBrowserEvent(Event event) {
				String value = display.getAudioInput4Slider().getValue();
				client.post(new SliderTransmitEvent(client.getConnectionID(),
						Display.AUDIO_INPUT4_VOL_SLIDER_ID, Integer.parseInt(value)));
			}
		});
		Element audiInput5SliderElem = display.getAudioInput5Slider().cast();
		DOM.sinkEvents(audiInput5SliderElem, Event.ONCHANGE);
		DOM.setEventListener(audiInput5SliderElem, new EventListener() {

			@Override
			public void onBrowserEvent(Event event) {
				String value = display.getAudioInput5Slider().getValue();
				client.post(new SliderTransmitEvent(client.getConnectionID(),
						Display.AUDIO_INPUT5_VOL_SLIDER_ID, Integer.parseInt(value)));
			}
		});
		Element audiInput6SliderElem = display.getAudioInput6Slider().cast();
		DOM.sinkEvents(audiInput6SliderElem, Event.ONCHANGE);
		DOM.setEventListener(audiInput6SliderElem, new EventListener() {

			@Override
			public void onBrowserEvent(Event event) {
				String value = display.getAudioInput6Slider().getValue();
				client.post(new SliderTransmitEvent(client.getConnectionID(),
						Display.AUDIO_INPUT6_VOL_SLIDER_ID, Integer.parseInt(value)));
			}
		});

	}

	public interface Display extends IsWidget, DisplayConstants {

		ToggleGroup getProgramGroup();

		ToggleGroup getPreviewGroup();

		ToggleButton getProgramInput1Button();

		ToggleButton getProgramInput2Button();

		ToggleButton getProgramInput3Button();

		ToggleButton getProgramInput4Button();

		ToggleButton getProgramInput5Button();

		ToggleButton getProgramInput6Button();

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

		ToggleButton getPreviewInputBlackButton();

		ToggleButton getPreviewInputBarsButton();

		ToggleButton getPreviewColor1Button();

		ToggleButton getPreviewColor2Button();

		ToggleButton getPreviewMedia1Button();

		ToggleButton getPreviewMedia2Button();

		ToggleButton getTransitionControlTransStyleAutoButton();

		ToggleButton getTransitionControlTransStyleCutButton();

		InputElement getTransitionBar();

		InputElement getMasterVolumeSlider();

		InputElement getAudioInput1Slider();

		InputElement getAudioInput2Slider();

		InputElement getAudioInput3Slider();

		InputElement getAudioInput4Slider();

		InputElement getAudioInput5Slider();

		InputElement getAudioInput6Slider();

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
					ToggleGroup group = null;
					if (pressedBtn.equals(Display.PROGRAM_INPUT_1_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInput1Button();
						group = MainPresenter.this.display.getProgramGroup();
					} else if (pressedBtn.equals(Display.PROGRAM_INPUT_2_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInput2Button();
						group = MainPresenter.this.display.getProgramGroup();
					} else if (pressedBtn.equals(Display.PROGRAM_INPUT_3_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInput3Button();
						group = MainPresenter.this.display.getProgramGroup();
					} else if (pressedBtn.equals(Display.PROGRAM_INPUT_4_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInput4Button();
						group = MainPresenter.this.display.getProgramGroup();
					} else if (pressedBtn.equals(Display.PROGRAM_INPUT_5_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInput5Button();
						group = MainPresenter.this.display.getProgramGroup();
					} else if (pressedBtn.equals(Display.PROGRAM_INPUT_6_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInput6Button();
						group = MainPresenter.this.display.getProgramGroup();
					} else if (pressedBtn.equals(Display.PROGRAM_INPUT_BLACK_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInputBlackButton();
						group = MainPresenter.this.display.getProgramGroup();
					} else if (pressedBtn.equals(Display.PROGRAM_INPUT_BARS_BTN_ID)) {
						toggleButton = MainPresenter.this.display
								.getProgramInputBarsButton();
						group = MainPresenter.this.display.getProgramGroup();
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
					} else if (pressedBtn.equals(Display.PREVIEW_INPUT1_BTN_ID)) {
						toggleButton = display.getPreviewInput1Button();
						group = display.getPreviewGroup();
					} else if (pressedBtn.equals(Display.PREVIEW_INPUT2_BTN_ID)) {
						toggleButton = display.getPreviewInput2Button();
						group = display.getPreviewGroup();
					} else if (pressedBtn.equals(Display.PREVIEW_INPUT3_BTN_ID)) {
						toggleButton = display.getPreviewInput3Button();
						group = display.getPreviewGroup();
					} else if (pressedBtn.equals(Display.PREVIEW_INPUT4_BTN_ID)) {
						toggleButton = display.getPreviewInput4Button();
						group = display.getPreviewGroup();
					} else if (pressedBtn.equals(Display.PREVIEW_INPUT5_BTN_ID)) {
						toggleButton = display.getPreviewInput5Button();
						group = display.getPreviewGroup();
					} else if (pressedBtn.equals(Display.PREVIEW_INPUT6_BTN_ID)) {
						toggleButton = display.getPreviewInput6Button();
						group = display.getPreviewGroup();
					} else if (pressedBtn.equals(Display.PREVIEW_INPUT_BLACK_BTN_ID)) {
						toggleButton = display.getPreviewInputBlackButton();
						group = display.getPreviewGroup();
					} else if (pressedBtn.equals(Display.PREVIEW_INPUT_BARS_BTN_ID)) {
						toggleButton = display.getPreviewInputBarsButton();
						group = display.getPreviewGroup();
					} else if (pressedBtn.equals(Display.PREVIEW_COLOR1_BTN_ID)) {
						toggleButton = display.getPreviewColor1Button();
					} else if (pressedBtn.equals(Display.PREVIEW_COLOR2_BTN_ID)) {
						toggleButton = display.getPreviewColor2Button();
					} else if (pressedBtn.equals(Display.PREVIEW_MEDIA1_BTN_ID)) {
						toggleButton = display.getPreviewMedia1Button();
					} else if (pressedBtn.equals(Display.PREVIEW_MEDIA2_BTN_ID)) {
						toggleButton = display.getPreviewMedia2Button();

					} else if (pressedBtn
							.equals(Display.TRANS_CTRL_STYLE_AUTO_BTN_ID)) {
						toggleButton = display
								.getTransitionControlTransStyleAutoButton();
					} else if (pressedBtn
							.equals(Display.TRANS_CTRL_STYLE_CUT_BTN_ID)) {
						toggleButton = display
								.getTransitionControlTransStyleCutButton();
					}
					if (toggleButton != null && group != null) {
						group.setValue(toggleButton);
					}
				} else if (message instanceof SliderTransmitEvent) {
					SliderTransmitEvent e = (SliderTransmitEvent) message;
					String sliderID = e.getSliderID();
					InputElement slider = null;
					if (sliderID.equals(Display.TRANSITION_CONTROL_SLIDER_ID)) {
						slider = MainPresenter.this.display.getTransitionBar();
					}
					if (slider != null
							&& !e.getConnectionID().equals(client.getConnectionID())) {
						blockSlideEvent = true;
						slider.setValue(e.getValue().toString());
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
