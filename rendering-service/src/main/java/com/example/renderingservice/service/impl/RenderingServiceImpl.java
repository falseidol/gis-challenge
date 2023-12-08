package com.example.renderingservice.service.impl;

import com.example.renderingservice.model.RenderModel;
import com.example.renderingservice.model.dto.RenderDto;
import com.example.renderingservice.repository.RenderRepository;
import com.example.renderingservice.service.RenderingService;
import lombok.AllArgsConstructor;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class RenderingServiceImpl implements RenderingService {

    private final RenderRepository renderRepository;

    @Override
    public void savePolygons() {
        Point pointx1 = new Point(10.0, 20.0);
        Point pointx2 = new Point(30.0, 20.0);
        Point pointx3 = new Point(30.0, 20.0);
        Point pointy1 = new Point(20.0, 40.0);
        Point pointy2 = new Point(30.0, 20.0);
        Point pointy3 = new Point(50.0, 10.0);
        Point pointz1 = new Point(40.0, 20.0);
        Point pointz2 = new Point(10.0, 90.0);
        Point pointz3 = new Point(50.0, 70.0);
        Polygon polygon1 = new Polygon(pointx1, pointx2, pointx3);
        Polygon polygon2 = new Polygon(pointy1, pointy2, pointy3);
        Polygon polygon3 = new Polygon(pointz1, pointz2, pointz3);
        RenderModel renderModel1 = new RenderModel(null, polygon1, "black");
        RenderModel renderModel2 = new RenderModel(null, polygon2, "red");
        RenderModel renderModel3 = new RenderModel(null, polygon3, "white");
        renderRepository.save(renderModel1);
        renderRepository.save(renderModel2);
        renderRepository.save(renderModel3);
    }

    @Override
    public Flux<RenderDto> showPolygons() {
        Flux<RenderModel> flux = renderRepository.findAll();
        return toRenderDto(flux);
    }

    private Flux<RenderDto> toRenderDto(Flux<RenderModel> renderModelFlux) {
        return renderRepository.findAll().map(model -> {
            return mapperToDto(model.getPolygon(), model.getColor());
        });
    }

    private RenderDto mapperToDto(Polygon polygon, String color) {
        return new RenderDto(polygon, color);
    }
}
