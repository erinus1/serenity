package org.example.utils;

import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true, fluent = true)
@Setter
public class Order {
    private int id;
    private int petId;
    private int quantity;
    private String shipData;
    private STATUS status;
    private boolean complete;

    public static enum STATUS {
        PLACED("placed"),
        APPROVED("approved"),
        DELIVERED("delivered");

        private String status;

        STATUS(final String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return status;
        }
    }

    public Order(int id) {
        this.id = id;
        petId = id;
        quantity = 1;
        shipData = "2020-03-18T17:21:13.045Z";
        status = STATUS.PLACED;
        complete = true;
    }

    @Override
    public String toString() {
        return "{\r\n" +
                "  \"id\": " + id + ",\n" +
                "  \"petId\": " + petId + ",\n" +
                "  \"quantity\": " + quantity + ",\n" +
                "  \"shipDate\": \"" + shipData + "\",\n" +
                "  \"status\": \"" + status.toString() + "\",\n" +
                "  \"complete\": " + complete + "\n" +
                "}";
    }
}