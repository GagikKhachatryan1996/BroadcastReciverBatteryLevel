package com.aca.broadcastreciverbatterylevel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.BatteryManager;
import android.widget.ImageView;
import android.widget.TextView;

public class BatteryReciver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        TextView ststusLabel = ((MainActivity) context).findViewById(R.id.status_label);
        TextView parcentageLabel = ((MainActivity) context).findViewById(R.id.percentageLabel);
        ImageView battareyImage = ((MainActivity) context).findViewById(R.id.battary_image);

        String action = intent.getAction();


        if (action != null && action.equals(Intent.ACTION_BATTERY_CHANGED)) {


            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            String message = "";

            switch (status) {

                case BatteryManager.BATTERY_STATUS_FULL:
                    message = "Full";
                    break;

                case BatteryManager.BATTERY_STATUS_CHARGING:
                    message = "Charging";
                    break;

                case BatteryManager.BATTERY_STATUS_DISCHARGING:
                    message = "Discharging";
                    break;
                case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                    message = "Not Charging";
                    break;
                case BatteryManager.BATTERY_STATUS_UNKNOWN:
                    message = "Unknown";
                    break;

            }

            ststusLabel.setText(message);

            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int percentrage = level * 100 / scale;
            parcentageLabel.setText(percentrage + " %");


            Resources res = context.getResources();

            if (percentrage >= 90) {
                battareyImage.setImageDrawable(res.getDrawable(R.drawable.b100));


            } else if (90 > percentrage && percentrage >= 65) {
                battareyImage.setImageDrawable(res.getDrawable(R.drawable.b75));


            } else if (65 > percentrage && percentrage >= 40) {

                battareyImage.setImageDrawable(res.getDrawable(R.drawable.b50));


            }else  if (40>percentrage && percentrage>=15){

                battareyImage.setImageDrawable(res.getDrawable(R.drawable.b25));
            }else {

                battareyImage.setImageDrawable(res.getDrawable(R.drawable.b0));
            }


        }


    }
}
