package com.example.cinema.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BillStatus {
    COMPLETE("Đã thanh toán thành công"),
    PENDING("Đang chờ thanh toán"),
    CANCEL("Quá 5p không thanh toán thì bị hủy");

    private final String description;
}
