package com.example.services;

import com.example.domain.*;
import com.example.hibernate.HibernateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class InventoryServices {

    HibernateUtil hibernateUtil = new HibernateUtil();

    private Map<Integer, Item> db = new HashMap<>();

	/*public InventoryServices()
	{
		db.put(1, new Item(101, "Laptop", 1347.55f, new ItemInfo(101, "Apple", "13' MacBook Pro")));
		db.put(2, new Item(102, "Phone", 1465.75f, new ItemInfo(102, "Samsung", "Galaxy S20 Ultra 5G")));
		db.put(3, new Item(103, "Laptop", 1050.00f, new ItemInfo(103, "Samsung", "Galaxy S Book")));
		db.put(4, new Item(104, "Speaker", 385.99f, new ItemInfo(104, "BOSE", "Sound Revolve Portable Bluetooth Speaker")));
	}*/

    public ResponseEntity<ListAllItemsResponse> listAll()
    {
        hibernateUtil.getSession();
        List<Item> itemList = hibernateUtil.allItems();
        Status status = Status.SUCCESS;
        ListAllItemsResponse listAll = new ListAllItemsResponse(itemList, status);
//        hibernateUtil.getSession().flush();
//        hibernateUtil.getSession().close();
        return new ResponseEntity<ListAllItemsResponse>(listAll, HttpStatus.OK);
    }

    public ResponseEntity<?> findByName(FindByNameRequest request) {
        List<Item> result = new ArrayList<>();
        Status status = Status.NO_NAME_MATCH;
        String name = StringUtils.trimAllWhitespace(request.getName());
        if (name != null)
        {
            for (Item item: db.values())
            {
                if (StringUtils.startsWithIgnoreCase(item.getName(), name))
                {
                    result.add(item);
                    status = Status.SUCCESS;
                }
            }
        }
        FindByNameResponse response = new FindByNameResponse(result, status);
        return new ResponseEntity<FindByNameResponse>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> findById(int itemId) {
        List<Item> result = new ArrayList<>();
        Status status = Status.NO_NAME_MATCH;
        if (db.containsValue(db.get(itemId))) {
            result.add(db.get(itemId));
            status = Status.SUCCESS;
        }
        FindByIdResponse response = new FindByIdResponse(result, status);
        return new ResponseEntity<FindByIdResponse>(response, HttpStatus.OK);
    }

//	public ResponseEntity<?> addItem(InventoryAddItemRequest request) {
//		List<Item> result = new ArrayList<>();
//		Status status = Status.CANNOT_ADD_ITEM_ALREADY_EXIST;
//
//	}
}
