package com.example.renderingservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Polygon;

/**
 * Модель для возврата
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RenderDto {
    private Polygon polygon;
    private String color;
}
