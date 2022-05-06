package com.example.currencyconverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Currency {

    public static List<Currency> getCurrenciesList() {
        List<Currency> cl = new ArrayList<>();
        cl.add(new Currency("Australian Dollar",	"AUD"));
        cl.add(new Currency("Albanian Lek",	"ALL"));
        cl.add(new Currency("Algerian Dinar",	"DZD"));
        cl.add(new Currency("Argentine Peso",	"ARS"));
        cl.add(new Currency("Afghan afghani",	"AFN"));
        cl.add(new Currency("Angolan kwanza",	"AOA"));
        cl.add(new Currency("Armenian dram",	"AMD"));
        cl.add(new Currency("Azerbaijani manat",	"AZN"));
        cl.add(new Currency("British Pound",	"GBP"));
        cl.add(new Currency("Bahamian Dollar",	"BSD"));
        cl.add(new Currency("Bahraini Dinar",	"BHD"));
        cl.add(new Currency("Bangladesh Taka",	"BDT"));
        cl.add(new Currency("Barbados Dollar",	"BBD"));
        cl.add(new Currency("Belize Dollar",	"BZD"));
        cl.add(new Currency("Bhutan Ngultrum",	"BTN"));
        cl.add(new Currency("Bolivian Boliviano",	"BOB"));
        cl.add(new Currency("Botswana Pula",	"BWP"));
        cl.add(new Currency("Brazilian Real",	"BRL"));
        cl.add(new Currency("Brunei Dollar",	"BND"));
        cl.add(new Currency("Bulgarian Lev",	"BGN"));
        cl.add(new Currency("Burundi Franc",	"BIF"));
        cl.add(new Currency("Belarusian ruble",	"BYN"));
        cl.add(new Currency("Convertible mark",	"BAM"));
        cl.add(new Currency("Canadian Dollar",	"CAD"));
        cl.add(new Currency("Chinese Yuan",	"CNY"));
        cl.add(new Currency("Cambodia Riel",	"KHR"));
        cl.add(new Currency("Cape Verde Escudo",	"CVE"));
        cl.add(new Currency("CFA Franc (BCEAO)",	"XOF"));
        cl.add(new Currency("CFA Franc (BEAC)",	"XAF"));
        cl.add(new Currency("Chilean Peso",	"CLP"));
        cl.add(new Currency("Colombian Peso",	"COP"));
        cl.add(new Currency("Comoros Franc",	"KMF"));
        cl.add(new Currency("Costa Rica Colon",	"CRC"));
        cl.add(new Currency("Croatian Kuna",	"HRK"));
        cl.add(new Currency("Cuban Peso",	"CUP"));
        cl.add(new Currency("Czech Koruna",	"CZK"));
        cl.add(new Currency("Congolese franc",	"CDF"));
        cl.add(new Currency("Danish Krone",	"DKK"));
        cl.add(new Currency("Djibouti Franc",	"DJF"));
        cl.add(new Currency("Dominican Peso",	"DOP"));
        cl.add(new Currency("Euro",	"EUR"));
        cl.add(new Currency("East Caribbean Dollar",	"XCD"));
        cl.add(new Currency("Egyptian Pound",	"EGP"));
        cl.add(new Currency("Ethiopian Birr",	"ETB"));
        cl.add(new Currency("Eritrean nakfa",	"ERN"));
        cl.add(new Currency("Fiji Dollar",	"FJD"));
        cl.add(new Currency("Gambian Dalasi",	"GMD"));
        cl.add(new Currency("Guatemala Quetzal",	"GTQ"));
        cl.add(new Currency("Guinea Franc",	"GNF"));
        cl.add(new Currency("Guyana Dollar",	"GYD"));
        cl.add(new Currency("Ghanaian Cedi",	"GHS"));
        cl.add(new Currency("Georgian lari",	"GEL"));
        cl.add(new Currency("Hong Kong Dollar",	"HKD"));
        cl.add(new Currency("Haiti Gourde",	"HTG"));
        cl.add(new Currency("Honduras Lempira",	"HNL"));
        cl.add(new Currency("Hungarian Forint",	"HUF"));
        cl.add(new Currency("Indonesian Rupiah",	"IDR"));
        cl.add(new Currency("Indian Rupee",	"INR"));
        cl.add(new Currency("Iceland Krona",	"ISK"));
        cl.add(new Currency("Iran Rial",	"IRR"));
        cl.add(new Currency("Iraqi Dinar",	"IQD"));
        cl.add(new Currency("Israeli Shekel",	"ILS"));
        cl.add(new Currency("Japanese Yen",	"JPY"));
        cl.add(new Currency("Jamaican Dollar",	"JMD"));
        cl.add(new Currency("Jordanian Dinar",	"JOD"));
        cl.add(new Currency("Kazakhstan Tenge",	"KZT"));
        cl.add(new Currency("Kenyan Shilling",	"KES"));
        cl.add(new Currency("Korean Won",	"KRW"));
        cl.add(new Currency("Kuwaiti Dinar",	"KWD"));
        cl.add(new Currency("Kyrgyzstan Som",	"KGS"));
        cl.add(new Currency("Macau Pataca",	"MOP"));
        cl.add(new Currency("Macedonian Denar",	"MKD"));
        cl.add(new Currency("Malawi Kwacha",	"MWK"));
        cl.add(new Currency("Malaysian Ringgit",	"MYR"));
        cl.add(new Currency("Maldives Rufiyaa",	"MVR"));
        cl.add(new Currency("Mauritania Ougulya",	"MRO"));
        cl.add(new Currency("Mauritius Rupee",	"MUR"));
        cl.add(new Currency("Mexican Peso",	"MXN"));
        cl.add(new Currency("Moldovan Leu",	"MDL"));
        cl.add(new Currency("Mongolian Tugrik",	"MNT"));
        cl.add(new Currency("Moroccan Dirham",	"MAD"));
        cl.add(new Currency("Myanmar Kyat",	"MMK"));
        cl.add(new Currency("Malagasy ariary",	"MGA"));
        cl.add(new Currency("Mozambican metical",	"MZN"));
        cl.add(new Currency("Namibian Dollar",	"NAD"));
        cl.add(new Currency("Nepalese Rupee",	"NPR"));
        cl.add(new Currency("New Zealand Dollar",	"NZD"));
        cl.add(new Currency("Nicaragua Cordoba",	"NIO"));
        cl.add(new Currency("Nigerian Naira",	"NGN"));
        cl.add(new Currency("North Korean Won",	"KPW"));
        cl.add(new Currency("Norwegian Krone",	"NOK"));
        cl.add(new Currency("Omani Rial",	"OMR"));
        cl.add(new Currency("Pakistani Rupee",	"PKR"));
        cl.add(new Currency("Papua New Guinea Kina",	"PGK"));
        cl.add(new Currency("Paraguayan Guarani",	"PYG"));
        cl.add(new Currency("Peruvian Nuevo Sol",	"PEN"));
        cl.add(new Currency("Philippine Peso",	"PHP"));
        cl.add(new Currency("Polish Zloty",	"PLN"));
        cl.add(new Currency("Qatar Rial",	"QAR"));
        cl.add(new Currency("Romanian New Leu",	"RON"));
        cl.add(new Currency("Russian Rouble",	"RUB"));
        cl.add(new Currency("Rwanda Franc",	"RWF"));
        cl.add(new Currency("Swiss Franc",	"CHF"));
        cl.add(new Currency("Samoa Tala",	"WST"));
        cl.add(new Currency("Saudi Arabian Riyal",	"SAR"));
        cl.add(new Currency("Seychelles Rupee",	"SCR"));
        cl.add(new Currency("Sierra Leone Leone",	"SLL"));
        cl.add(new Currency("Singapore Dollar",	"SGD"));
        cl.add(new Currency("Solomon Islands Dollar",	"SBD"));
        cl.add(new Currency("Somali Shilling",	"SOS"));
        cl.add(new Currency("South African Rand",	"ZAR"));
        cl.add(new Currency("Sri Lanka Rupee",	"LKR"));
        cl.add(new Currency("Sudanese Pound",	"SDG"));
        cl.add(new Currency("Swaziland Lilageni",	"SZL"));
        cl.add(new Currency("Swedish Krona",	"SEK"));
        cl.add(new Currency("Syrian Pound",	"SYP"));
        cl.add(new Currency("Serbian dinar",	"RSD"));
        cl.add(new Currency("Surinamese dollar",	"SRD"));
        cl.add(new Currency("Thai Baht",	"THB"));
        cl.add(new Currency("Turkish Lira",	"TRY"));
        cl.add(new Currency("Taiwan Dollar",	"TWD"));
        cl.add(new Currency("Tanzanian Shilling",	"TZS"));
        cl.add(new Currency("Tongan paʻanga",	"TOP"));
        cl.add(new Currency("Trinidad Tobago Dollar",	"TTD"));
        cl.add(new Currency("Tunisian Dinar",	"TND"));
        cl.add(new Currency("Tajikistani somoni",	"TJS"));
        cl.add(new Currency("Turkmenistan manat",	"TMT"));
        cl.add(new Currency("United States Dollar",	"USD"));
        cl.add(new Currency("UAE Dirham",	"AED"));
        cl.add(new Currency("Ugandan Shilling",	"UGX"));
        cl.add(new Currency("Ukraine Hryvnia",	"UAH"));
        cl.add(new Currency("Uruguayan New Peso",	"UYU"));
        cl.add(new Currency("Uzbekistan Sum",	"UZS"));
        cl.add(new Currency("Vanuatu Vatu",	"VUV"));
        cl.add(new Currency("Vietnam Dong",	"VND"));
        cl.add(new Currency("Yemen Riyal",	"YER"));
        cl.add(new Currency("Zambian kwacha",	"ZMW"));

        return cl;
    }
    
    private String name;
    private String iso;

    public Currency(String name, String iso) {
        this.name = name;
        this.iso = iso;
    }

    public String getName() {
        return name;
    }

    public String getIso() {
        return iso;
    }
}
