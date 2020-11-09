package org.restAssuredBDD.utils.ApiObjects;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.Objects;

@Accessors(chain = true, fluent = true)
@Getter
@Setter
public class Order {
    private int id;
    private int petId;
    private int quantity;
    private String shipData;
    private STATUS status;
    private boolean complete;

    public enum STATUS {
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
        shipData = "2020-03-18T17:21:13.045+0000";
        status = STATUS.PLACED;
        complete = true;
    }

    public Order(int id, int quantity, String shipData, Order.STATUS status, boolean isComplete) {
        this.id = id;
        petId = id;
        this.quantity = quantity;
        this.shipData = shipData;
        this.status = status;
        complete = isComplete;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order that = (Order) o;
        return id == that.id &&
                petId == that.petId &&
                quantity == that.quantity &&
                complete == that.complete &&
                shipData.equals(that.shipData) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, petId, quantity, shipData, status, complete);
    }
}