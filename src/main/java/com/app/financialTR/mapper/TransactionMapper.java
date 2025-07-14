package com.app.financialTR.mapper;

import com.app.financialTR.DTO.TransactionDTO;
import com.app.financialTR.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(target = "cdTypeValue", source = "cdTypeValue.cdTypeValue")
    TransactionDTO toDto(Transaction transaction);

    @Mapping(target = "cdTypeValue", ignore = true)
    @Mapping(target = "cdTransaction", ignore = true)
    @Mapping(target = "dateTime", ignore = true)
    Transaction toEntity(TransactionDTO transactionDTO);
}
