package com.example.SimpleInvest.Client.dto;

import java.util.List;

public record BrapiResponseDto(List<StockDto> results) {
}