package com.store.dto;

import java.util.List;

public class BuyDTO {

  private List<ItemBuyDTO> items;
  private AddressDTO address;

  /**
   * @return the items
   */
  public List<ItemBuyDTO> getItems() {
    return items;
  }

  /**
   * @param items the items to set
   */
  public void setItems(List<ItemBuyDTO> items) {
    this.items = items;
  }


  /**
   * @return the address
   */
  public AddressDTO getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(AddressDTO address) {
    this.address = address;
  }
}
