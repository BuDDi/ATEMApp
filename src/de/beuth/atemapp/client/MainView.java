package de.beuth.atemapp.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.resources.ThemeStyles;
import com.sencha.gxt.core.client.resources.ThemeStyles.Styles;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.button.ToggleButton;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridView;

public class MainView extends Composite implements MainPresenter.Display {

	private static MainViewUiBinder uiBinder = GWT
			.create(MainViewUiBinder.class);

	interface MainViewUiBinder extends UiBinder<Widget, MainView> {
	}

	// Instantiate the grid properties.
	private static final VideoProperties gridProperties = GWT
			.create(VideoProperties.class);

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
	ToggleButton trans_ctrl_auto;

	@UiField
	ToggleButton trans_ctrl_cut;

	@UiField
	ToggleButton trans_ctrl_ftb;

	@UiField
	InputElement audio_master_volume;

	@UiField
	Label audio_master_output_volume;

	@UiField
	ToggleButton audio_master_mute;

	@UiField
	InputElement audio_input_1_volume;

	@UiField
	Label audio_input_1_output_volume;

	@UiField
	ToggleButton audio_input_1_mute;

	@UiField
	InputElement audio_input_2_volume;

	@UiField
	Label audio_input_2_output_volume;

	@UiField
	ToggleButton audio_input_2_mute;

	@UiField
	InputElement audio_input_3_volume;

	@UiField
	Label audio_input_3_output_volume;

	@UiField
	ToggleButton audio_input_3_mute;

	@UiField
	InputElement audio_input_4_volume;

	@UiField
	Label audio_input_4_output_volume;

	@UiField
	ToggleButton audio_input_4_mute;

	@UiField
	InputElement audio_input_5_volume;

	@UiField
	Label audio_input_5_output_volume;

	@UiField
	ToggleButton audio_input_5_mute;

	@UiField
	InputElement audio_input_6_volume;

	@UiField
	Label audio_input_6_output_volume;

	@UiField
	ToggleButton audio_input_6_mute;

	@UiField(provided = true)
	ColumnModel<Video> columnModel1;

	@UiField(provided = true)
	ListStore<Video> listStore1;

	@UiField
	GridView<Video> gridView1;

	@UiField
	Grid<Video> vlc_grid1;

	@UiField(provided = true)
	ColumnModel<Video> columnModel2;

	@UiField(provided = true)
	ListStore<Video> listStore2;

	@UiField
	GridView<Video> gridView2;

	@UiField
	Grid<Video> vlc_grid2;

	@UiField(provided = true)
	ColumnModel<Video> columnModel3;

	@UiField(provided = true)
	ListStore<Video> listStore3;

	@UiField
	GridView<Video> gridView3;

	@UiField
	Grid<Video> vlc_grid3;

	@UiField
	TextButton vlc_1_play;

	@UiField
	TextButton vlc_1_resume;

	@UiField
	TextButton vlc_1_pause;

	@UiField
	TextButton vlc_2_play;

	@UiField
	TextButton vlc_2_resume;

	@UiField
	TextButton vlc_2_pause;

	@UiField
	TextButton vlc_3_play;

	@UiField
	TextButton vlc_3_resume;

	@UiField
	TextButton vlc_3_pause;

	private ToggleGroup progInputGroup;

	private ToggleGroup prevInputGroup;

	private ListStore<Video> initListStore() {
		return new ListStore<Video>(gridProperties.key());
	}

	private ColumnModel<Video> initColumnModel() {
		ColumnConfig<Video, String> nameCol = new ColumnConfig<Video, String>(
				gridProperties.name(), 100, "Name");
		List<ColumnConfig<Video, ?>> columns = new ArrayList<ColumnConfig<Video, ?>>();
		columns.add(nameCol);
		return new ColumnModel<Video>(columns);
	}

	public MainView() {
		listStore1 = initListStore();
		listStore2 = initListStore();
		listStore3 = initListStore();
		columnModel1 = initColumnModel();
		columnModel2 = initColumnModel();
		columnModel3 = initColumnModel();
		vlc_grid1 = new Grid<Video>(listStore1, columnModel1);
		vlc_grid2 = new Grid<Video>(listStore2, columnModel2);
		vlc_grid3 = new Grid<Video>(listStore3, columnModel3);

		initWidget(uiBinder.createAndBindUi(this));
		progInputGroup = new ToggleGroup();
		progInputGroup.add(prog_input_black);
		progInputGroup.add(prog_input_bars);
		progInputGroup.add(prog_input_1);
		progInputGroup.add(prog_input_2);
		progInputGroup.add(prog_input_3);
		progInputGroup.add(prog_input_4);
		progInputGroup.add(prog_input_5);
		progInputGroup.add(prog_input_6);

		prevInputGroup = new ToggleGroup();
		prevInputGroup.add(prev_input_black);
		prevInputGroup.add(prev_input_bars);
		prevInputGroup.add(prev_input_1);
		prevInputGroup.add(prev_input_2);
		prevInputGroup.add(prev_input_3);
		prevInputGroup.add(prev_input_4);
		prevInputGroup.add(prev_input_5);
		prevInputGroup.add(prev_input_6);
		// transitionStyleGroup.add(trans_ctrl_style_mix);
		// transitionStyleGroup.add(trans_ctrl_style_dip);
		// transitionStyleGroup.add(trans_ctrl_style_wipe);
		// transitionStyleGroup.add(trans_ctrl_style_dve);
		// transitionStyleGroup.add(trans_ctrl_style_sting);

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
	public ToggleButton getTransitionControlTransStyleAutoButton() {
		return trans_ctrl_auto;
	}

	@Override
	public ToggleButton getTransitionControlTransStyleCutButton() {
		return trans_ctrl_cut;
	}

	@Override
	public InputElement getMasterVolumeSlider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputElement getAudioInput1Slider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputElement getAudioInput2Slider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputElement getAudioInput3Slider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputElement getAudioInput4Slider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputElement getAudioInput5Slider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputElement getAudioInput6Slider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToggleGroup getProgramGroup() {
		return progInputGroup;
	}

	@Override
	public ToggleGroup getPreviewGroup() {
		return prevInputGroup;
	}

}
