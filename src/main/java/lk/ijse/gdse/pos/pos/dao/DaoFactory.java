package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.bo.*;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){}
    public static DaoFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DaoTypes {
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL
    }

    public SuperDao getDao(DaoTypes daoTypes) {
        switch (daoTypes) {
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
            case ORDER:
                return new OrderDaoImpl();
            case ORDER_DETAIL:
                return new OrderDetailDaoImpl();
            default:
                return null;
        }
    }
}
