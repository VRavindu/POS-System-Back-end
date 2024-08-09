package lk.ijse.gdse.pos.pos.bo;

public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory(){}
    public static BoFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BoFactory() : boFactory;
    }

    public enum BoTypes {
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL
    }

    public SuperBo getBo(BoTypes boTypes) {
        switch (boTypes) {
            case CUSTOMER:
                return new CustomerBoImpl();
            case ITEM:
                return new ItemBoImpl();
            case ORDER:
                return new OrderBoImpl();
            case ORDER_DETAIL:
                return new OrderDetailBoImpl();
            default:
                return null;
        }
    }

}
