package com.example.asyncpractice.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ReportService {

    @Async
    public CompletableFuture<Integer> generateReport(){
        return CompletableFuture.completedFuture(300);
    }
}
