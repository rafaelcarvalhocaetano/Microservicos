package com.store.dto;

public class AddressDTO {

  private String street;
  private int number_hose;
  private String state;


  /**
   * @return the street
   */
  public String getStreet() {
    return street;
  }

  /**
   * @param street the street to set
   */
  public void setStreet(String street) {
    this.street = street;
  }

  /**
   * @return the number_hose
   */
  public int getNumber_hose() {
    return number_hose;
  }

  /**
   * @param number_hose the number_hose to set
   */
  public void setNumber_hose(int number_hose) {
    this.number_hose = number_hose;
  }

  /**
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * @param state the state to set
   */
  public void setState(String state) {
    this.state = state;
  }
}
