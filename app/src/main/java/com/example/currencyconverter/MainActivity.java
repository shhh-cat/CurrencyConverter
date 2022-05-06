package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.currencyconverter.databinding.ActivityMainBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


import java.text.NumberFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AutoCompleteTextView currencySrc, currencyDes;
    private TextInputEditText source;
    private TextInputLayout sourceLayout;
    private MaterialButton convert,reverse;
    private List<Currency> currencyList;
    private CircularProgressIndicator loading;
    private MaterialCardView resultPanel;
    private TextView resultTextView,exRate;

    private Currency currentCurrencySrc = null,currentCurrencyDes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        currencyList = Currency.getCurrenciesList();

        initViews();



//        TextView hello = findViewById(R.id.hello);
//
//        Currency src = null,des = null;
//        for (int i = 0; i < currencyList.size(); i++) {
//            if (currencyList.get(i).getIso().equals("VND"))
//                src = currencyList.get(i);
//            if (currencyList.get(i).getIso().equals("USD"))
//                des = currencyList.get(i);
//        }



    }



    public void initViews() {
        currencySrc = binding.currencySrc;
        currencyDes = binding.currencyDes;
        source = binding.source;
        convert = binding.convert;
        reverse = binding.reverse;
        sourceLayout = binding.sourceLayout;
        loading = binding.loading;
        resultPanel = binding.resultPanel;
        resultTextView = binding.result;
        exRate = binding.exRate;

        List<String> currenciesName = currencyList.stream().map(Currency::getName).collect(Collectors.toList());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.currency_item,currenciesName);
        currencySrc.setAdapter(adapter);
        currencyDes.setAdapter(adapter);

        currencySrc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                currentCurrencySrc = currencyList.get(i);
                changeSymbolSuffix(currentCurrencySrc.getIso());
            }
        });

        currencyDes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                currentCurrencyDes = currencyList.get(i);
            }
        });


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    doConvert(false);
                }
            }
        });

        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doReverse();
            }
        });

    }

    private void changeSymbolSuffix(String iso) {
        java.util.Currency currency = java.util.Currency.getInstance(iso);
        sourceLayout.setSuffixText(currency.getSymbol());
    }

    private void doConvert(boolean reverse) {
        loading.setVisibility(View.VISIBLE);
        resultPanel.setVisibility(View.GONE);
        CurrencyConverter currencyConverter = new CurrencyConverter(currentCurrencySrc,currentCurrencyDes);
        currencyConverter.setValue(Double.parseDouble(source.getText().toString())).convert(new CurrencyConverter.OnConverter() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSuccess(double result,double exRateToDes,double exRateToSrc) {
                loading.setVisibility(View.GONE);
                resultPanel.setVisibility(View.VISIBLE);
                NumberFormat resultFormat = NumberFormat.getCurrencyInstance();
                java.util.Currency resultCurrencyFormat = java.util.Currency.getInstance(currentCurrencyDes.getIso());
                java.util.Currency srcCurrencyFormat = java.util.Currency.getInstance(currentCurrencySrc.getIso());
                resultFormat.setMaximumFractionDigits(2);
                resultFormat.setCurrency(resultCurrencyFormat);

                resultTextView.setText(resultFormat.format(result));
                NumberFormat numberFormat = NumberFormat.getNumberInstance();
                numberFormat.setMaximumFractionDigits(8);
                exRate.setText("1.00 " + srcCurrencyFormat.getSymbol() + " = " + numberFormat.format(exRateToDes) + " " + resultCurrencyFormat.getSymbol() +
                        "\n" + "1.00 " + resultCurrencyFormat.getSymbol() + " = " + numberFormat.format(exRateToSrc) + " " + resultCurrencyFormat.getSymbol() );
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                loading.setVisibility(View.GONE);
            }
        },reverse);
    }

    private void doReverse() {
        if (currentCurrencySrc != null && currentCurrencyDes != null) {
            changeSymbolSuffix(currentCurrencyDes.getIso());
            currencySrc.setText(currentCurrencyDes.getName(),false);
            currencyDes.setText(currentCurrencySrc.getName(),false);
            Currency temp = currentCurrencySrc;
            currentCurrencySrc = currentCurrencyDes;
            currentCurrencyDes = temp;
        }
    }

    public boolean validate() {

        if (currentCurrencySrc == null) {
            Toast.makeText(this,"Vui lòng chọn đơn vị tiền tệ nguồn",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (currentCurrencyDes == null) {
            Toast.makeText(this,"Vui lòng chọn đơn vị tiền tệ đích",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (source.getText().toString().isEmpty()) {
            Toast.makeText(this,"Số tiền không được để trống",Toast.LENGTH_SHORT).show();
            return false;
        }

        try {
            Double.parseDouble(source.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this,"Số tiền không hợp lệ",Toast.LENGTH_SHORT).show();
            return false;
            //e.printStackTrace();
        }

        if (Double.parseDouble(source.getText().toString()) < 0) {
            Toast.makeText(this,"Số tiền không được âm",Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }
}