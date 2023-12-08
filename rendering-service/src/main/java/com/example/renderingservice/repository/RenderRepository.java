package com.example.renderingservice.repository;

import com.example.renderingservice.model.RenderModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RenderRepository extends ReactiveCrudRepository<RenderModel, Long> {
}
