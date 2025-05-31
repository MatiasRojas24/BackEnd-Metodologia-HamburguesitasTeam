package com.trabajofinal.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PreferenceResponse {
    private String preferenceId;
    private String initPoint;
    private String sandboxInitPoint;
}
