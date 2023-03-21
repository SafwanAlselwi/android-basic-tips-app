package com.tipsapp;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.tipsapp.databinding.ActivityTipsCalculationBinding;

public class TipsCalculationActivity extends AppCompatActivity {
    ActivityTipsCalculationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTipsCalculationBinding.inflate(getLayoutInflater());
        View view =  binding.getRoot();
        setContentView(view);

        binding.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s_cost  = binding.editCost.getText().toString();
                double cost =  Double.parseDouble(s_cost);

                double tip;

                int checked_id = binding.rgOptions.getCheckedRadioButtonId();
                if(checked_id == binding.rbtnAmazing.getId()){
                    tip = cost * 0.20d;
                }else if(checked_id == binding.rbtnGood.getId()){
                    tip = cost * 0.10d;
                }else if(checked_id == binding.rbtnOkay.getId()){
                    tip = cost * 0.05d;
                }else{
                    tip = 0d;
                }

                if(binding.switchRound.isChecked()){
                    tip = Math.ceil(tip);
                }

                String msg = "Tip = RM" + tip;
                binding.txtResult.setText(msg);
            }
        });
    }
}