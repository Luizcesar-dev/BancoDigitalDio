package com.dio.utilities;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
    static NumberFormat formataValor = new DecimalFormat("R$ #,##0.00");

    public static String doubleToString(double valor){
        return formataValor.format(valor);
    }
}
