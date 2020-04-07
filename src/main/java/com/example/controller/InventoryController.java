package com.example.controller;

import com.example.domain.*;
import com.example.services.InventoryServices;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.net.HttpURLConnection.*;
import static java.net.HttpURLConnection.HTTP_INTERNAL_ERROR;

@RestController
@RequestMapping("/inventory/services")
@Api(value = "/inventory/services", tags = ("Inventory Management"))
@CrossOrigin(maxAge = 3600)
public class InventoryController {

    private static final String CLIENT_ID = "client-id";
    private InventoryServices inventoryServices;

    @Autowired
    public InventoryController(InventoryServices inventoryServices) {
        this.inventoryServices = inventoryServices;
    }

    @RequestMapping(value = "listAllItems", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "List All Items", nickname = "All Items", notes = "List of all the items.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ListAllItemsResponse.class)})
    public ResponseEntity<?> listAllItems(@RequestHeader(value = CLIENT_ID) String clientId)
    {
        return inventoryServices.listAll();
    }

    @RequestMapping(value = "all/{itemId}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Find By ID", nickname = "all/{id}", notes = "Find inventory items by ID.")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Missing / Invalid parameter", response = ServiceErrorResponse.class),
            @ApiResponse(code = HTTP_OK, message = "Success", response = FindByIdResponse.class),
            @ApiResponse(code = HTTP_BAD_REQUEST, message = "Invalid Request", response = ServiceErrorResponse.class),
            @ApiResponse(code = HTTP_NO_CONTENT, message = "No Data Found", response = ServiceErrorResponse.class),
            @ApiResponse(code = HTTP_INTERNAL_ERROR, message = "Internal Server Error", response = ServiceErrorResponse.class)})
    public ResponseEntity<?> findById(@RequestHeader(value = CLIENT_ID) String clientId,
                                      @ApiParam(value = "My Id", required = true, example = "3") @PathVariable("itemId") final int itemId) {
        return inventoryServices.findById(itemId);
    }

    @RequestMapping(value = "findByName", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Find By Name", notes = "Find by name in Inventory Items", nickname = "findByName")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Missing / Invalid Parameter", response = ServiceErrorResponse.class),
            @ApiResponse(code = 200, message = "Success", response = FindByNameResponse.class)})
    public ResponseEntity<?> findByName(@RequestHeader(value = CLIENT_ID) String clientId,
                                        @Valid @RequestBody FindByNameRequest request) {
        return inventoryServices.findByName(request);
    }

//	public ResponseEntity<?> addItem(String clientId, InventoryAddItemRequest request)
//	{
//		return inventoryServices.addItem();
//	}
}
