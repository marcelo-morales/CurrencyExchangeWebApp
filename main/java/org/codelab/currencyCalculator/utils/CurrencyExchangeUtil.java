package org.codelab.currencyCalculator.utils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.codelab.currencyCalculator.model.CurrencyExchange;
import org.codelab.currencyCalculator.model.CurrencyExchangeDTO;

import com.google.gson.Gson;

public class CurrencyExchangeUtil {

    public static List<CurrencyExchange> fromJson(String fromJson) {
        Gson gson = new Gson();
        CurrencyExchangeDTO dto = gson.fromJson(fromJson, CurrencyExchangeDTO.class);
        return translateFromDTO(dto);
    }

    private static List<CurrencyExchange> translateFromDTO(CurrencyExchangeDTO dto) {
        String baseCurrency = dto.getBase();
        Date timestamp = new Date(Long.parseLong(dto.getTimestamp()) * 1000L);

        return dto.getRates().entrySet().stream().map(entry -> new CurrencyExchange(entry.getKey(), entry.getValue(),  baseCurrency, timestamp)).collect(Collectors.toList());
    }
}
