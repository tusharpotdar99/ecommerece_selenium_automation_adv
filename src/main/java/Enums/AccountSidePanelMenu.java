package Enums;

import Components.AccountSidePanelComponent;

public enum AccountSidePanelMenu {

//    LOGIN("Login"),
    MY_ACCOUNT("My Account"),
    EDIT_ACCOUNT("Edit Account"),
    PASSWORD("Password"),
    PAYMENT_METHODS("Payment Methods"),
    ADDRESS_BOOK("Address Book"),
    WISH_LIST("Wish List"),
    ORDER_HISTORY("Order History"),
    DOWNLOADS("Downloads"),
    SUBSCRIPTIONS("Subscriptions"),
    REWARD_POINTS("Reward Points"),
    RETURNS("Returns"),
    TRANSACTIONS("Transactions"),
    NEWSLETTER("Newsletter"),
    LOGOUT("Logout");

    private final String value;

    AccountSidePanelMenu(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
