package com.example.currencyconverter;

import android.widget.Toast;

import com.prof.rssparser.Article;
import com.prof.rssparser.Parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

    public interface OnConverter {
        public void onSuccess(double result,double exRateToDes, double exRateToSrc);
        public void onError(Exception e);
    }

    private Currency source;
    private Currency destination;
    private double value;

    public CurrencyConverter(Currency source, Currency destination) {
        this.source = source;
        this.destination = destination;
    }

    public CurrencyConverter setValue(double value) {
        this.value = value;
        return this;
    }

    public void convert(OnConverter callback, boolean reverse  ) {
        String urlString = "https://"+source.getIso().toLowerCase()+".fxexchangerate.com/"+destination.getIso().toLowerCase()+".xml";
        Parser parser = new Parser();
        parser.onFinish(new Parser.OnTaskCompleted() {

            @Override
            public void onTaskCompleted(ArrayList<Article> arrayList) {
                //Toast.makeText(MainActivity.this,arrayList.get(0).getDescription(),Toast.LENGTH_SHORT).show();
                String response = arrayList.get(0).getDescription();
                String[] r = response.split("<br/>");
                String exchangeRateToDestination = r[0].trim().substring(11,r[0].trim().length() - 4).trim();
                String exchangeRateToSource = r[1].trim().substring(11,r[1].trim().length() - 4).trim();
                double exRateToDes = Double.parseDouble(exchangeRateToDestination);
                double exRateToSrc = Double.parseDouble(exchangeRateToSource);

                if (exRateToSrc < 1)
                    exRateToSrc = 1D / exRateToDes;
                if (exRateToDes < 1)
                    exRateToDes = 1D / exRateToSrc;

                if (reverse)
                    callback.onSuccess(value * exRateToSrc,exRateToDes,exRateToSrc);
                else
                    callback.onSuccess(value * exRateToDes,exRateToDes,exRateToSrc);

            }

            @Override
            public void onError(Exception e) {
                callback.onError(e);
            }
        });
        parser.execute(urlString);
    }

}
