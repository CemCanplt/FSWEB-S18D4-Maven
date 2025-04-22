package com.workintech.s18d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Not: HttpStatus kodları hakkında:
  200: Başarılı | 201: Başarıyla oluşturuldu
  400: Geçersiz istek | 401: Yetkisiz | 403: Yasaklı | 404: Bulunamadı
  500: Sunucu hatası | 502: Geçersiz yanıt | 503: Hizmet dışı | 504: Zaman aşımı
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BurgerErrorResponse {
    private int statusCode;
    private String message;
    private long timestamp;

    public BurgerErrorResponse(String message) {
        this.message = message;
    }
}
