package de.beuth.atemapp.client;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.atmosphere.gwt.client.AtmosphereClient;
import org.atmosphere.gwt.client.AtmosphereGWTSerializer;
import org.atmosphere.gwt.client.AtmosphereListener;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.rpc.StatusCodeException;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.core.client.util.ToggleGroup;

import de.beuth.atemapp.shared.DisplayConstants;

/**
 * {@link Presenter} of the main view. Communicates with the WebSocket-Server
 * and updates the GUI if server answers.
 * 
 * @author S. Buder
 * 
 */
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
		display.getProgramInput1Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						// get the value first (what the user wants to do)
						final Boolean value = event.getValue();
						// set the toggle button back to the initial state after the
						// browser event loop has returned because we want to set the
						// button only when the action succeeded on the server
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getProgramInput1Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PROGRAM_INPUT_1_BTN_ID, value));
					}
				});
		display.getProgramInput2Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getProgramInput2Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PROGRAM_INPUT_2_BTN_ID, value));
					}
				});
		display.getProgramInput3Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getProgramInput3Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PROGRAM_INPUT_3_BTN_ID, value));
					}
				});

		display.getProgramInput4Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getProgramInput4Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PROGRAM_INPUT_4_BTN_ID, value));
					}
				});
		display.getProgramInput5Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getProgramInput5Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PROGRAM_INPUT_5_BTN_ID, value));
					}
				});
		display.getProgramInput6Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getProgramInput6Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PROGRAM_INPUT_6_BTN_ID, value));
					}
				});
		display.getProgramInputBlackButton().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getProgramInputBlackButton().setValue(!value,
										false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PROGRAM_INPUT_BLACK_BTN_ID, value));
					}
				});
		display.getProgramInputBarsButton().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getProgramInputBarsButton().setValue(!value,
										false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PROGRAM_INPUT_BARS_BTN_ID, value));
					}
				});
		display.getProgramColor1Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getProgramColor1Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PROGRAM_COLOR1_BTN_ID, value));
					}
				});
		display.getProgramColor2Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getProgramColor2Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PROGRAM_COLOR2_BTN_ID, value));
					}
				});
		display.getProgramMedia1Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getProgramMedia1Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PROGRAM_MEDIA1_BTN_ID, value));
					}
				});
		display.getProgramMedia2Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getProgramMedia2Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PROGRAM_MEDIA2_BTN_ID, value));
					}
				});

		display.getPreviewInput1Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getPreviewInput1Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PREVIEW_INPUT1_BTN_ID, value));
					}
				});
		display.getPreviewInput2Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getPreviewInput2Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PREVIEW_INPUT2_BTN_ID, value));
					}
				});
		display.getPreviewInput3Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getPreviewInput3Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PREVIEW_INPUT3_BTN_ID, value));
					}
				});
		display.getPreviewInput4Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getPreviewInput4Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PREVIEW_INPUT4_BTN_ID, value));
					}
				});
		display.getPreviewInput5Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getPreviewInput5Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PREVIEW_INPUT5_BTN_ID, value));
					}
				});
		display.getPreviewInput6Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getPreviewInput6Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PREVIEW_INPUT6_BTN_ID, value));
					}
				});
		display.getPreviewInputBlackButton().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getPreviewInputBlackButton().setValue(!value,
										false);

							}
						});
						client.post(new ToggleClickEvent(
								Display.PREVIEW_INPUT_BLACK_BTN_ID, value));
					}
				});
		display.getPreviewInputBarsButton().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getPreviewInputBarsButton().setValue(!value,
										false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PREVIEW_INPUT_BARS_BTN_ID, value));
					}
				});
		display.getPreviewColor1Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getPreviewColor1Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PREVIEW_COLOR1_BTN_ID, value));
					}
				});
		display.getPreviewColor2Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getPreviewColor2Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PREVIEW_COLOR2_BTN_ID, value));
					}
				});
		display.getPreviewMedia1Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getPreviewMedia1Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PREVIEW_MEDIA1_BTN_ID, value));
					}
				});
		display.getPreviewMedia2Button().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getPreviewMedia2Button()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.PREVIEW_MEDIA2_BTN_ID, value));
					}
				});

		display.getTransitionControlTransStyleAutoButton().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getTransitionControlTransStyleAutoButton()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.TRANS_CTRL_STYLE_AUTO_BTN_ID, value));
					}
				});
		display.getTransitionControlTransStyleCutButton().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						final Boolean value = event.getValue();
						Scheduler.get().scheduleDeferred(new ScheduledCommand() {

							@Override
							public void execute() {
								display.getTransitionControlTransStyleCutButton()
										.setValue(!value, false);
							}
						});
						client.post(new ToggleClickEvent(
								Display.TRANS_CTRL_STYLE_CUT_BTN_ID, value));
					}
				});
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

		// TODO ToggleGroup sollte entfernt werden, da dies die Abhängigkeit von
		// GXT bedeutet. Eigene ToggelGroup-Routine verwenden!
		ToggleGroup getProgramGroup();

		ToggleGroup getPreviewGroup();

		HasValue<Boolean> getProgramInput1Button();

		HasValue<Boolean> getProgramInput2Button();

		HasValue<Boolean> getProgramInput3Button();

		HasValue<Boolean> getProgramInput4Button();

		HasValue<Boolean> getProgramInput5Button();

		HasValue<Boolean> getProgramInput6Button();

		HasValue<Boolean> getProgramInputBlackButton();

		HasValue<Boolean> getProgramInputBarsButton();

		HasValue<Boolean> getProgramColor1Button();

		HasValue<Boolean> getProgramColor2Button();

		HasValue<Boolean> getProgramMedia1Button();

		HasValue<Boolean> getProgramMedia2Button();

		HasValue<Boolean> getPreviewInput1Button();

		HasValue<Boolean> getPreviewInput2Button();

		HasValue<Boolean> getPreviewInput3Button();

		HasValue<Boolean> getPreviewInput4Button();

		HasValue<Boolean> getPreviewInput5Button();

		HasValue<Boolean> getPreviewInput6Button();

		HasValue<Boolean> getPreviewInputBlackButton();

		HasValue<Boolean> getPreviewInputBarsButton();

		HasValue<Boolean> getPreviewColor1Button();

		HasValue<Boolean> getPreviewColor2Button();

		HasValue<Boolean> getPreviewMedia1Button();

		HasValue<Boolean> getPreviewMedia2Button();

		HasValue<Boolean> getTransitionControlTransStyleAutoButton();

		HasValue<Boolean> getTransitionControlTransStyleCutButton();

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
		}

		@Override
		public void onError(Throwable exception, boolean connected) {
			int statuscode = -1;
			if (exception instanceof StatusCodeException) {
				statuscode = ((StatusCodeException) exception).getStatusCode();
			}
			logger.log(Level.SEVERE, "comet.error [connected=" + connected + "] ("
					+ statuscode + ")", exception);
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
					// toggle event on server occured;
					// could be triggered by someone else or this client
					ToggleClickEvent e = (ToggleClickEvent) message;
					String pressedBtn = e.getButtonID();
					HasValue<Boolean> toggleButton = null;
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
					} else if (sliderID.equals(Display.AUDIO_MASTER_VOL_SLIDER_ID)) {
						slider = MainPresenter.this.display.getMasterVolumeSlider();
					} else if (sliderID.equals(Display.AUDIO_INPUT1_VOL_SLIDER_ID)) {
						slider = MainPresenter.this.display.getAudioInput1Slider();
					} else if (sliderID.equals(Display.AUDIO_INPUT2_VOL_SLIDER_ID)) {
						slider = MainPresenter.this.display.getAudioInput2Slider();
					} else if (sliderID.equals(Display.AUDIO_INPUT3_VOL_SLIDER_ID)) {
						slider = MainPresenter.this.display.getAudioInput3Slider();
					} else if (sliderID.equals(Display.AUDIO_INPUT4_VOL_SLIDER_ID)) {
						slider = MainPresenter.this.display.getAudioInput4Slider();
					} else if (sliderID.equals(Display.AUDIO_INPUT5_VOL_SLIDER_ID)) {
						slider = MainPresenter.this.display.getAudioInput5Slider();
					} else if (sliderID.equals(Display.AUDIO_INPUT6_VOL_SLIDER_ID)) {
						slider = MainPresenter.this.display.getAudioInput6Slider();
					}
					if (slider != null
							&& !e.getConnectionID().equals(client.getConnectionID())) {
						// slider action succeeded on the server;
						// someone else used the slider so update gui
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
		}

		@Override
		public void onAfterRefresh() {
			logger.info("comet.afterRefresh [" + client.getConnectionID() + "]");
		}
	}

}
