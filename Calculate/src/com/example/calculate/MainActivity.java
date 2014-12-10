package com.example.calculate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnClickListener {

	private EditText _amountEdtTxt = null;
	private EditText _rateEdtTxt = null;
	private EditText _futureAmountEdtTxt = null;
	private Spinner _yearsSpinner = null;
	private Button _calculateBtn = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		_amountEdtTxt       = (EditText)findViewById(R.id.investAmountEdtTxt);
		_rateEdtTxt         = (EditText)findViewById(R.id.rateEdtTxt);
		_futureAmountEdtTxt = (EditText)findViewById(R.id.futureValueEdtTxt);
		_yearsSpinner       = (Spinner)findViewById(R.id.yearsSpinner);
		_calculateBtn       = (Button)findViewById(R.id.calculateBtn);

		_calculateBtn.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.calculateBtn:
			double investmentAmount = Double.valueOf(_amountEdtTxt.getText().toString().trim());
			double monthlyInterestRate = Double.valueOf(_rateEdtTxt.getText().toString().trim());
			int numberOfYears = 3;
			int duration = Integer.parseInt(_yearsSpinner.getSelectedItem().toString());

			calculateFutureValue(investmentAmount,monthlyInterestRate,duration);

			break;

		}		
	}

	private void calculateFutureValue(double investmentAmount, double monthlyInterestRate, int duration) {
		double futureInvestmentValue = investmentAmount * Math.pow((1 + monthlyInterestRate/100), duration);
		_futureAmountEdtTxt.setText(String.format("%.2f", futureInvestmentValue));
	}

}
