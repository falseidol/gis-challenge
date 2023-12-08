package com.example.renderingservice.service;

import com.example.renderingservice.model.dto.RenderDto;
import reactor.core.publisher.Flux;

public interface RenderingService {

    Flux<RenderDto> showPolygons();

    void savePolygons();

}
