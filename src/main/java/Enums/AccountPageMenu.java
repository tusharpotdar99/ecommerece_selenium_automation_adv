package Enums;

public enum AccountPageMenu {

    EDIT_YOUR_ACCOUNT_INFORMATION("Edit your account information"),
    CHANGE_YOUR_PASSWORD("Change your password"),
    STORED_PAYMENT_METHODS("Stored payment methods"),
    MODIFY_YOUR_ADDRESS_BOOK_ENTRIES("Modify your address book entries"),
    MODIFY_YOUR_WISH_LIST("Modify your wish list"),
    VIEW_YOUR_ORDER_HISTORY("View your order history"),
    SUBSCRIPTIONS("Subscriptions"),
    DOWNLOADS("Downloads"),
    YOUR_REWARD_POINTS("Your Reward Points"),
    VIEW_YOUR_RETURN_REQUESTS("View your return requests"),
    YOUR_TRANSACTIONS("Your Transactions"),
    REGISTER_FOR_AN_AFFILIATE_ACCOUNT("Register for an affiliate account"),
    SUBSCRIBE_UNSUBSCRIBE_NEWSLETTER("Subscribe / unsubscribe to newsletter");

    private final String value;

    AccountPageMenu(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
    }
