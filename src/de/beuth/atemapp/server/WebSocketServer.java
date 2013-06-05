package de.beuth.atemapp.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
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

import de.beuth.atemapp.client.MainPresenter.Display;
import de.beuth.atemapp.client.SliderTransmitEvent;
import de.beuth.atemapp.client.ToggleClickEvent;
import de.beuth.atemapp.shared.DisplayConstants;

public class WebSocketServer extends AtmosphereGwtHandler {

	private DatagramSocket udpSocket;

	private GwtAtmosphereResource lastResource;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
		Logger.getLogger("").setLevel(Level.INFO);
		Logger.getLogger("org.atmosphere.gwt").setLevel(Level.ALL);
		Logger.getLogger("org.atmosphere.samples").setLevel(Level.ALL);
		Logger.getLogger("").getHandlers()[0].setLevel(Level.ALL);
		logger.trace("Updated logging levels");
		try {
			udpSocket = new DatagramSocket(9000, InetAddress.getLocalHost());
			// udpSender = new DatagramSocket(8000,
			// );
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread udpReceiveThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					byte[] buf = new byte[256];
					try {
						DatagramPacket packet = new DatagramPacket(buf, buf.length);
						synchronized (udpSocket) {
							udpSocket.receive(packet);
						}
						String dataStr = new String(packet.getData());
						dataStr = dataStr.substring(0, dataStr.indexOf('#'));
						System.out.println("Received packet: " + dataStr + " from "
								+ packet.getAddress().toString());

						ToggleClickEvent click = null;
						if (dataStr.equals(DisplayConstants.PROGRAM_INPUT_1_BTN_ID)) {
							System.out.println("Instruct ATEM -> Prog Input 1");
							click = new ToggleClickEvent(
									DisplayConstants.PROGRAM_INPUT_1_BTN_ID, true);
						} else if (dataStr
								.equals(DisplayConstants.PROGRAM_INPUT_2_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.PROGRAM_INPUT_2_BTN_ID, true);
							System.out.println("Instruct ATEM -> Prog Input 2");
						} else if (dataStr
								.equals(DisplayConstants.PROGRAM_INPUT_3_BTN_ID)) {
							System.out.println("Instruct ATEM -> Prog Input 3");
							click = new ToggleClickEvent(
									DisplayConstants.PROGRAM_INPUT_3_BTN_ID, true);
						} else if (dataStr
								.equals(DisplayConstants.PROGRAM_INPUT_4_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.PROGRAM_INPUT_4_BTN_ID, true);
							System.out.println("Instruct ATEM -> Prog Input 4");
						} else if (dataStr
								.equals(DisplayConstants.PROGRAM_INPUT_5_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.PROGRAM_INPUT_5_BTN_ID, true);
							System.out.println("Instruct ATEM -> Prog Input 5");
						} else if (dataStr
								.equals(DisplayConstants.PROGRAM_INPUT_6_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.PROGRAM_INPUT_6_BTN_ID, true);
							System.out.println("Instruct ATEM -> Prog Input 6");
						} else if (dataStr.equals(Display.PREVIEW_INPUT1_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.PREVIEW_INPUT1_BTN_ID, true);
							System.out.println("Instruct ATEM -> Preview Input 1");
						} else if (dataStr.equals(Display.PREVIEW_INPUT2_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.PREVIEW_INPUT2_BTN_ID, true);
							System.out.println("Instruct ATEM -> Preview Input 2");
						} else if (dataStr.equals(Display.PREVIEW_INPUT3_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.PREVIEW_INPUT3_BTN_ID, true);
							System.out.println("Instruct ATEM -> Preview Input 3");
						} else if (dataStr.equals(Display.PREVIEW_INPUT4_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.PREVIEW_INPUT4_BTN_ID, true);
							System.out.println("Instruct ATEM -> Preview Input 4");
						} else if (dataStr.equals(Display.PREVIEW_INPUT5_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.PREVIEW_INPUT5_BTN_ID, true);
							System.out.println("Instruct ATEM -> Preview Input 5");
						} else if (dataStr.equals(Display.PREVIEW_INPUT6_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.PREVIEW_INPUT6_BTN_ID, true);
							System.out.println("Instruct ATEM -> Preview Input 6");
						} else if (dataStr.equals(Display.PREVIEW_INPUT_BLACK_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.PREVIEW_INPUT_BLACK_BTN_ID, true);
							System.out.println("Instruct ATEM -> Preview Input Black");
						} else if (dataStr.equals(Display.PREVIEW_INPUT_BARS_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.PREVIEW_INPUT_BARS_BTN_ID, true);
							System.out.println("Instruct ATEM -> Preview Input Bars");
						} else if (dataStr.equals(Display.PREVIEW_COLOR1_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.PREVIEW_COLOR1_BTN_ID, true);
							System.out.println("Instruct ATEM -> Preview Color 1");
						} else if (dataStr.equals(Display.PREVIEW_COLOR2_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.PREVIEW_COLOR2_BTN_ID, true);
							System.out.println("Instruct ATEM -> Preview Color 2");
						} else if (dataStr.equals(Display.PREVIEW_MEDIA1_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.PREVIEW_MEDIA1_BTN_ID, true);
							System.out.println("Instruct ATEM -> Preview Media 1");
						} else if (dataStr.equals(Display.PREVIEW_MEDIA2_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.PREVIEW_MEDIA2_BTN_ID, true);
							System.out.println("Instruct ATEM -> Preview Media 2");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_NEXT_ONAIR1_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_NEXT_ONAIR1_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Control On Air 1");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_NEXT_ONAIR2_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_NEXT_ONAIR2_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Control On Air 2");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_NEXT_ONAIR3_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_NEXT_ONAIR3_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Control On Air 3");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_NEXT_ONAIR4_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_NEXT_ONAIR4_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Control On Air 4");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_NEXT_BKGD_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_NEXT_BKGD_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Control Background");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_NEXT_KEY1_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_NEXT_KEY1_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Control Key 1");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_NEXT_KEY2_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_NEXT_KEY2_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Control Key 2");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_NEXT_KEY3_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_NEXT_KEY3_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Control Key 3");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_NEXT_KEY4_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_NEXT_KEY4_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Control Key 4");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_STYLE_MIX_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_STYLE_MIX_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Style Mix");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_STYLE_DIP_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_STYLE_DIP_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Style Dip");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_STYLE_WIPE_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_STYLE_WIPE_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Style Wipe");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_STYLE_DVE_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_STYLE_DVE_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Style Dve");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_STYLE_STING_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_STYLE_STING_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Style Sting");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_STYLE_PREV_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_STYLE_PREV_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Style Prev");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_STYLE_AUTO_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_STYLE_AUTO_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Style Auto");
						} else if (dataStr
								.equals(Display.TRANS_CTRL_STYLE_CUT_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.TRANS_CTRL_STYLE_CUT_BTN_ID, true);
							System.out
									.println("Instruct ATEM -> Transition Style Cut");
						} else if (dataStr.equals(Display.DOWN_DSK1_TIE_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.DOWN_DSK1_TIE_BTN_ID, true);
							System.out.println("Instruct ATEM -> Downstream DSK1 Tie");
						} else if (dataStr.equals(Display.DOWN_DSK1_ONAIR_BTN_ID)) {
							System.out
									.println("Instruct ATEM -> Downstream DSK1 On Air");
							click = new ToggleClickEvent(
									DisplayConstants.DOWN_DSK1_ONAIR_BTN_ID, true);
						} else if (dataStr.equals(Display.DOWN_DSK1_AUTO_BTN_ID)) {
							System.out
									.println("Instruct ATEM -> Downstream DSK1 Auto");
							click = new ToggleClickEvent(
									DisplayConstants.DOWN_DSK1_AUTO_BTN_ID, true);
						} else if (dataStr.equals(Display.DOWN_DSK2_TIE_BTN_ID)) {
							click = new ToggleClickEvent(
									DisplayConstants.DOWN_DSK2_TIE_BTN_ID, true);
							System.out.println("Instruct ATEM -> Downstream DSK2 Tie");
						} else if (dataStr.equals(Display.DOWN_DSK2_ONAIR_BTN_ID)) {
							System.out
									.println("Instruct ATEM -> Downstream DSK2 On Air");
							click = new ToggleClickEvent(
									DisplayConstants.DOWN_DSK2_ONAIR_BTN_ID, true);
						} else if (dataStr.equals(Display.DOWN_DSK2_AUTO_BTN_ID)) {
							System.out
									.println("Instruct ATEM -> Downstream DSK2 Auto");
							click = new ToggleClickEvent(
									DisplayConstants.DOWN_DSK2_AUTO_BTN_ID, true);
						} else if (dataStr.equals(Display.FADE2BLACK_BTN_ID)) {
							System.out.println("Instruct ATEM -> Fade to Black");
							click = new ToggleClickEvent(
									DisplayConstants.FADE2BLACK_BTN_ID, true);
						}
						List<Object> messages = new ArrayList<Object>();
						if (click != null) {
							messages.add(click);
						}
						broadcast(messages, lastResource);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		udpReceiveThread.start();
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
		lastResource = cometResource;
		String command = null;
		for (Object message : messages) {
			if (message instanceof ToggleClickEvent) {
				ToggleClickEvent e = (ToggleClickEvent) message;
				String buttonID = e.getButtonID();
				command = buttonID + "#";
			} else if (message instanceof SliderTransmitEvent) {
				SliderTransmitEvent e = (SliderTransmitEvent) message;
				String sliderID = e.getSliderID();
				Integer value = e.getValue();
				if (sliderID.equals(DisplayConstants.TRANSITION_CONTROL_SLIDER_ID)) {
					System.out.println("Instruct ATEM -> Transition Slider : "
							+ value);
				}
				command = sliderID + "#n" + (value * 10);
			}
		}
		if (command != null) {
			byte[] data = command.getBytes();
			try {
				InetAddress ia = InetAddress.getByName("141.64.95.78");
				DatagramPacket paket = new DatagramPacket(data, data.length, ia,
						8000);
				synchronized (udpSocket) {
					udpSocket.send(paket);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}
}