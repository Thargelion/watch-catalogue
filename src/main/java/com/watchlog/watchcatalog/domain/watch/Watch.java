package com.watchlog.watchcatalog.domain.watch;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Watch {
    long id;
    String name;
    long unitPrice;
}
