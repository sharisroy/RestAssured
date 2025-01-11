package org.example.haris;

import MockData.Mock_response;
import Utiles.UtileMethods;
import io.restassured.path.json.JsonPath;

import java.util.List;


public class JsonPathArrayPractice {
    public static void main(String[] args) {
        JsonPath js = UtileMethods.rawToJson(Mock_response.complexJson());
        System.out.println(js.prettify());

        // Extract values
        String data = js.getString("data");
        String users = js.getString("data.users");
        String user1 = js.getString("data.users[0]");
        String user1_id = js.getString("data.users[0].id");
        String name = js.getString("data.users[0].name.first") + " " + js.getString("data.users[0].name.last");
        String age = js.getString("data.users[0].age");
        String email = js.getString("data.users[0].email");
        String role = js.getString("data.users[0].roles");
        String role_first = js.getString("data.users[0].roles[0]");
        String address = js.getString("data.users[0].address");
        String street = js.getString("data.users[0].address.street");
        String country = js.getString("data.users[0].address.country");
        String orders = js.getString("data.users[0].orders");
        String first_orderID = js.getString("data.users[0].orders[0].orderId");
        String first_order_items = js.getString("data.users[0].orders[0].items");
        String first_order_items_item1 = js.getString("data.users[0].orders[0].items[0]");
        String first_order_items_item2 = js.getString("data.users[0].orders[0].items[1]");
        String first_order_items_item2_itemID = js.getString("data.users[0].orders[0].items[1].itemId");
        String first_order_items_item2_name = js.getString("data.users[0].orders[0].items[1].name");


        System.out.println(data);
        System.out.println(users);
        System.out.println(user1);
        System.out.println("ID: \t\t\t" + user1_id);
        System.out.println("Name: \t\t\t" + name);
        System.out.println("Age: \t\t\t" + age);
        System.out.println("Email: \t\t\t" + email);
        System.out.println("Roles: \t\t\t" + role);
        System.out.println("Role First: \t" + role_first);
        System.out.println("Address: \t\t" + address);
        System.out.println("Street: \t\t" + street);
        System.out.println("Country: \t\t" + country);
        System.out.println("Orders: \t\t" + orders);
        System.out.println("First Order ID: " + first_orderID);
        System.out.println("First Order Items: " + first_order_items);
        System.out.println("First Order Item 1: " + first_order_items_item1);
        System.out.println("First Order Item 2: " + first_order_items_item2);
        System.out.println("First Order Item 2 Item ID: " + first_order_items_item2_itemID);
        System.out.println("First Order Item 2 Item Name: " + first_order_items_item2_name);


        // Extract values using flatten method
        List<String> allRoles = js.getList("data.users.roles.flatten()");
        List<String> allItems = js.getList("data.users.orders.items.name.flatten()");
        List<String> allICountry = js.getList("data.users.address.country.flatten()");
        System.out.println();
        System.out.println("All Roles: " + allRoles);
        System.out.println("All Country: " + allICountry);
        System.out.println("All Items: " + allItems);

        // Extract values using Loop and List
        System.out.println();

        int count = js.getList("data.users[0].orders[0].items").size();
        System.out.println("Number of item on Frist Order : " + count);

        for (int i = 0; i<count; i++){
            System.out.println("Item: " + (i+1) + " - " +js.getList("data.users[0].orders[0].items.name").get(i));
        }


    }
}
