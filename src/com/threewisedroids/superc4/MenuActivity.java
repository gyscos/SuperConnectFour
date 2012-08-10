package com.threewisedroids.superc4;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.ToggleButton;

public class MenuActivity extends Activity {

    public Dialog makeNewGameDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_new_game);
        dialog.setTitle(R.string.new_game);

        dialog.findViewById(R.id.button_confirm_new_game).setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {
                        boolean useAi = ((ToggleButton) dialog
                                .findViewById(R.id.opponent_toggle))
                                .isChecked();

                        boolean useSize10 = ((RadioButton) dialog
                                .findViewById(R.id.size_10x10)).isChecked();

                        boolean fillCorner = ((CheckBox) dialog
                                .findViewById(R.id.check_fill_corner))
                                .isChecked();

                        newGame(useAi, useSize10, fillCorner);
                    }
                });

        return dialog;
    }

    public void newGame(boolean useAi, boolean useSize10, boolean fillCorner) {
        // Starts a new activity...
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        findViewById(R.id.button_exit).setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(final View v) {
                        // Quit
                        finish();
                    }
                });

        findViewById(R.id.button_new_game).setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(final View v) {
                        // Show a popup
                        showDialog(0);
                    }
                });
    }

    @Override
    @Deprecated
    protected Dialog onCreateDialog(final int id) {
        return makeNewGameDialog();
    }
}