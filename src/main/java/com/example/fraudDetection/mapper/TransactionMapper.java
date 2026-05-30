package com.example.fraudDetection.mapper;

import com.example.fraudDetection.model.TransactionEntity;
import com.example.fraudDetection.model.dto.TransactionRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "timestamp", ignore = true)
    @Mapping(target = "status", ignore = true)
    TransactionEntity toEntity(TransactionRequestDTO requestDTO);
}