package de.beuth.atemapp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.resources.ThemeStyles;
import com.sencha.gxt.core.client.resources.ThemeStyles.Styles;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.button.ToggleButton;

public class MainView extends Composite implements MainPresenter.Display {

	private static MainViewUiBinder uiBinder = GWT
			.create(MainViewUiBinder.class);

	interface MainViewUiBinder extends UiBinder<Widget, MainView> {
	}

	@UiField(provided = true)
	Styles themeStyles = ThemeStyles.getStyle();

	@UiField
	ToggleButton prog_input_1;

	@UiField
	ToggleButton prog_input_2;

	@UiField
	ToggleButton prog_input_3;

	@UiField
	ToggleButton prog_input_4;

	@UiField
	ToggleButton prog_input_5;

	@UiField
	ToggleButton prog_input_6;

	@UiField
	ToggleButton prog_input_black;

	@UiField
	ToggleButton prog_input_bars;

	@UiField
	ToggleButton prog_color_1;

	@UiField
	ToggleButton prog_color_2;

	@UiField
	ToggleButton prog_media_1;

	@UiField
	ToggleButton prog_media_2;

	@UiField
	ToggleButton prev_input_1;

	@UiField
	ToggleButton prev_input_2;

	@UiField
	ToggleButton prev_input_3;

	@UiField
	ToggleButton prev_input_4;

	@UiField
	ToggleButton prev_input_5;

	@UiField
	ToggleButton prev_input_6;

	@UiField
	ToggleButton prev_input_black;

	@UiField
	ToggleButton prev_input_bars;

	@UiField
	ToggleButton prev_color_1;

	@UiField
	ToggleButton prev_color_2;

	@UiField
	ToggleButton prev_media_1;

	@UiField
	ToggleButton prev_media_2;

	@UiField
	InputElement transition_slider;

	@UiField
	ToggleButton trans_ctrl_next_onair_1;

	@UiField
	ToggleButton trans_ctrl_next_onair_2;

	@UiField
	ToggleButton trans_ctrl_next_onair_3;

	@UiField
	ToggleButton trans_ctrl_next_onair_4;

	@UiField
	ToggleButton trans_ctrl_next_bkgd;

	@UiField
	ToggleButton trans_ctrl_next_key_1;

	@UiField
	ToggleButton trans_ctrl_next_key_2;

	@UiField
	ToggleButton trans_ctrl_next_key_3;

	@UiField
	ToggleButton trans_ctrl_next_key_4;

	@UiField
	ToggleButton trans_ctrl_style_mix;

	@UiField
	ToggleButton trans_ctrl_style_dip;

	@UiField
	ToggleButton trans_ctrl_style_wipe;

	@UiField
	ToggleButton trans_ctrl_style_dve;

	@UiField
	ToggleButton trans_ctrl_style_sting;

	@UiField
	ToggleButton trans_ctrl_style_prev_trans;

	@UiField
	ToggleButton trans_ctrl_style_auto;

	@UiField
	ToggleButton trans_ctrl_style_cut;

	@UiField
	ToggleButton downstream_dsk_1_tie;

	@UiField
	TextBox downstream_dsk_1_rate;

	@UiField
	ToggleButton downstream_dsk_1_onair;

	@UiField
	ToggleButton downstream_dsk_1_auto;

	@UiField
	ToggleButton downstream_dsk_2_tie;

	@UiField
	TextBox downstream_dsk_2_rate;

	@UiField
	ToggleButton downstream_dsk_2_onair;

	@UiField
	ToggleButton downstream_dsk_2_auto;

	@UiField
	TextBox ftb_rate;

	@UiField
	ToggleButton ftb;

	public MainView() {
		initWidget(uiBinder.createAndBindUi(this));
		ToggleGroup transitionStyleGroup = new ToggleGroup();
		transitionStyleGroup.add(trans_ctrl_style_mix);
		transitionStyleGroup.add(trans_ctrl_style_dip);
		transitionStyleGroup.add(trans_ctrl_style_wipe);
		transitionStyleGroup.add(trans_ctrl_style_dve);
		transitionStyleGroup.add(trans_ctrl_style_sting);

		// JSONObject options = Slider.getOptions(0, 100, new int[] { 0 });
		// options.put(SliderOption.ORIENTATION.toString(), new JSONString(
		// "vertical"));
		// options.put(SliderOption.STEP.toString(), new JSONNumber(1));
		// transition_slider = new Slider("trans_slider", options);
		// transition_slider.enable();
		// trans_slider_panel.add(transition_slider);
		// trans_slider_panel.
		// this will create a link element at the end of head
		// MGWTStyle.getTheme().getMGWTClientBundle().getMainCss().ensureInjected();

		// append your own css as last thing in the head
		// MGWTStyle.injectStyleSheet("ATEMApp.css");
	}

	@Override
	public ToggleButton getProgramInput1Button() {
		return prog_input_1;
	}

	@Override
	public ToggleButton getProgramInput2Button() {
		return prog_input_2;
	}

	@Override
	public ToggleButton getProgramInput3Button() {
		return prog_input_3;
	}

	@Override
	public ToggleButton getProgramInput4Button() {
		return prog_input_4;
	}

	@Override
	public ToggleButton getProgramInput5Button() {
		return prog_input_5;
	}

	@Override
	public ToggleButton getProgramInput6Button() {
		return prog_input_6;
	}

	@Override
	public ToggleButton getProgramInputBlackButton() {
		return prog_input_black;
	}

	@Override
	public ToggleButton getProgramInputBarsButton() {
		return prog_input_bars;
	}

	@Override
	public ToggleButton getProgramColor1Button() {
		return prog_color_1;
	}

	@Override
	public ToggleButton getProgramColor2Button() {
		return prog_color_2;
	}

	@Override
	public ToggleButton getProgramMedia1Button() {
		return prog_media_1;
	}

	@Override
	public ToggleButton getProgramMedia2Button() {
		return prog_media_2;
	}

	@Override
	public InputElement getTransitionBar() {
		return transition_slider;
	}

	@Override
	public ToggleButton getPreviewInput1Button() {
		return prev_input_1;
	}

	@Override
	public ToggleButton getPreviewInput2Button() {
		return prev_input_2;
	}

	@Override
	public ToggleButton getPreviewInput3Button() {
		return prev_input_3;
	}

	@Override
	public ToggleButton getPreviewInput4Button() {
		return prev_input_4;
	}

	@Override
	public ToggleButton getPreviewInput5Button() {
		return prev_input_5;
	}

	@Override
	public ToggleButton getPreviewInput6Button() {
		return prev_input_6;
	}

	@Override
	public ToggleButton getPreviewInputBlackButton() {
		return prev_input_black;
	}

	@Override
	public ToggleButton getPreviewInputBarsButton() {
		return prev_input_bars;
	}

	@Override
	public ToggleButton getPreviewColor1Button() {
		return prev_color_1;
	}

	@Override
	public ToggleButton getPreviewColor2Button() {
		return prev_color_2;
	}

	@Override
	public ToggleButton getPreviewMedia1Button() {
		return prev_media_1;
	}

	@Override
	public ToggleButton getPreviewMedia2Button() {
		return prev_media_2;
	}

	@Override
	public ToggleButton getTransitionControlNextTransOnAir1Button() {
		return trans_ctrl_next_onair_1;
	}

	@Override
	public ToggleButton getTransitionControlNextTransOnAir2Button() {
		return trans_ctrl_next_onair_2;
	}

	@Override
	public ToggleButton getTransitionControlNextTransOnAir3Button() {
		return trans_ctrl_next_onair_3;
	}

	@Override
	public ToggleButton getTransitionControlNextTransOnAir4Button() {
		return trans_ctrl_next_onair_4;
	}

	@Override
	public ToggleButton getTransitionControlNextTransBackgroundButton() {
		return trans_ctrl_next_bkgd;
	}

	@Override
	public ToggleButton getTransitionControlNextTransKey1Button() {
		return trans_ctrl_next_key_1;
	}

	@Override
	public ToggleButton getTransitionControlNextTransKey2Button() {
		return trans_ctrl_next_key_2;
	}

	@Override
	public ToggleButton getTransitionControlNextTransKey3Button() {
		return trans_ctrl_next_key_3;
	}

	@Override
	public ToggleButton getTransitionControlNextTransKey4Button() {
		return trans_ctrl_next_key_4;
	}

	@Override
	public ToggleButton getTransitionControlTransStyleMixButton() {
		return trans_ctrl_style_mix;
	}

	@Override
	public ToggleButton getTransitionControlTransStyleDipButton() {
		return trans_ctrl_style_dip;
	}

	@Override
	public ToggleButton getTransitionControlTransStyleWipeButton() {
		return trans_ctrl_style_wipe;
	}

	@Override
	public ToggleButton getTransitionControlTransStyleDveButton() {
		return trans_ctrl_style_dve;
	}

	@Override
	public ToggleButton getTransitionControlTransStyleStingButton() {
		return trans_ctrl_style_sting;
	}

	@Override
	public ToggleButton getTransitionControlTransStylePrevButton() {
		return trans_ctrl_style_prev_trans;
	}

	@Override
	public ToggleButton getTransitionControlTransStyleAutoButton() {
		return trans_ctrl_style_auto;
	}

	@Override
	public ToggleButton getTransitionControlTransStyleCutButton() {
		return trans_ctrl_style_cut;
	}

	@Override
	public ToggleButton getDownstreamDSK1TieButton() {
		return downstream_dsk_1_tie;
	}

	@Override
	public TextBox getDownstreamDSK1Rate() {
		return downstream_dsk_1_rate;
	}

	@Override
	public ToggleButton getDownstreamDSK1OnAirButton() {
		return downstream_dsk_1_onair;
	}

	@Override
	public ToggleButton getDownstreamDSK1AutoButton() {
		return downstream_dsk_1_auto;
	}

	@Override
	public ToggleButton getDownstreamDSK2TieButton() {
		return downstream_dsk_2_tie;
	}

	@Override
	public TextBox getDownstreamDSK2Rate() {
		return downstream_dsk_2_rate;
	}

	@Override
	public ToggleButton getDownstreamDSK2OnAirButton() {
		return downstream_dsk_2_onair;
	}

	@Override
	public ToggleButton getDownstreamDSK2AutoButton() {
		return downstream_dsk_2_auto;
	}

	@Override
	public TextBox getFade2BlackRate() {
		return ftb_rate;
	}

	@Override
	public ToggleButton getFade2BlackButton() {
		return ftb;
	}

}
