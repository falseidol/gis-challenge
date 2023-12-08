package com.example.renderingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Polygon;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Модель для сохранения
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reactive")
@Accessors(chain = true)
public class RenderModel {
    @Id
    @Column("id")
    private Long id;
    @Column("line")
    private Polygon polygon;
    @Column("color")
    private String color;
}
