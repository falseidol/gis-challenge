package com.example.renderingservice.router;

import com.example.renderingservice.model.dto.RenderDto;
import com.example.renderingservice.service.RenderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Контроллер возвращающий полигоны для карты
 */

@RestController
@RequestMapping("/rendering-service")
public class WebFluxController {

    @Autowired
    private RenderingService renderingService;

    /**
     * метод наполняющий БД
     */
    @GetMapping("/save")
    public void getMonoResult() {
        renderingService.savePolygons();
    }

    @GetMapping("/getPolygons")
    public Flux<RenderDto> getPolygons() {
        return renderingService.showPolygons();
    }
}
