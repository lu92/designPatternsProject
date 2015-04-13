package DesignPatternsProject.entities.orders;

import DesignPatternsProject.entities.actors.Client;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;

import java.util.Date;
import java.util.List;

/**
 * Created by lucjan on 10.03.15.
 */
public class OrderDetails {
    Long order_id;
    Client client;
    Date date;
    Mark mark;
    List<BaseProduct> order;

    public OrderDetails() {
    }

    public OrderDetails(Client client, Date date) {
        this.client = client;
        this.date = date;
    }

    public OrderDetails(Client client, Date date, List<BaseProduct> order) {
        this.client = client;
        this.date = date;
        this.order = order;
    }

    public OrderDetails(Client client, Date date, Mark mark, List<BaseProduct> order) {
        this.client = client;
        this.date = date;
        this.mark = mark;
        this.order = order;
    }

    public OrderDetails(Long order_id, Client client, Date date, Mark mark, List<BaseProduct> order) {
        this.order_id = order_id;
        this.client = client;
        this.date = date;
        this.mark = mark;
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetails that = (OrderDetails) o;

        if (!client.equals(that.client)) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (mark != null ? !mark.equals(that.mark) : that.mark != null) return false;
        if (!order.equals(that.order)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = client.hashCode();
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        result = 31 * result + order.hashCode();
        return result;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public List<BaseProduct> getOrder() {
        return order;
    }

    public void setOrder(List<BaseProduct> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "order_id=" + order_id +
                ", client=" + client +
                ", date=" + date +
                ", mark=" + mark +
                ", order=" + order +
                '}';
    }
}
