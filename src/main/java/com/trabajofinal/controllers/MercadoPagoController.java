package com.trabajofinal.controllers;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import com.trabajofinal.models.entities.OrdenCompra;
import com.trabajofinal.models.entities.OrdenCompraDetalle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MercadoPagoController {
    @Value("${mercadopago.token}")
    private String mpToken;

    @PostMapping("/mp")
    public String getList(@RequestBody OrdenCompraDetalle ordenCompraDetalle){
        if (ordenCompraDetalle == null) {return "Error recibiendo orden compra";};

        String title = "Orden de Compra nro: "+ ordenCompraDetalle.getOrdenCompra().getId();
        int quantity = 1;

        try{
            MercadoPagoConfig.setAccessToken(mpToken);
            List<PreferenceItemRequest> items = new ArrayList<>();

            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                    .id(ordenCompraDetalle.getOrdenCompra().getId())
                    .title("Orden compra: "+ ordenCompraDetalle.getOrdenCompra().getId())
                    .unitPrice(new BigDecimal(ordenCompraDetalle.getOrdenCompra().getTotal()))
                    .quantity(1)
                    .categoryId("ARS")
                    .build();
            items.add(itemRequest);

            //Control de sucesos
            PreferenceBackUrlsRequest backUrlsRequest = PreferenceBackUrlsRequest.builder()
                    .success("/success")
                    .pending("/pending")
                    .failure("/failure")
                    .build();


            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items)
                    .backUrls(backUrlsRequest)
                    .build();

            PreferenceClient client = new PreferenceClient();

            Preference preference = client.create(preferenceRequest);

            return preference.getId();
        } catch (MPException | MPApiException mpE) {
            return mpE.getMessage();
        }

    }


}
