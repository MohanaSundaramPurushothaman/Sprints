package com.cg.customerManagement.items.util;
import org.springframework.stereotype.Component;
import com.cg.customerManagement.items.dto.ItemDetail;
import com.cg.customerManagement.items.entity.Item;

import java.util.Set;

@Component
public class ItemUtil {
    public ItemDetail toDetail(Item item) {

        return new ItemDetail(item.getId(),item.getPrice(),item.getDescription(),item.getBoughtBy().getId(), item.getBoughtBy().getName());

    }

    public Set<ItemDetail> toDetailSet(Set<Item> set) {
        return null;
    }
    }